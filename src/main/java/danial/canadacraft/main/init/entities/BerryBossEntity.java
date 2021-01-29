package danial.canadacraft.main.init.entities;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.World;

public class BerryBossEntity extends MonsterEntity {

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public BerryBossEntity(EntityType<? extends BerryBossEntity> type, World worldIn) {

		super(type, worldIn);
		this.experienceValue = 500;

	}

	@Override
	protected void registerGoals() {

		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0d, false));
		this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		
		this.applyEntityAI();

	}

	protected void applyEntityAI() {

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, GypsumGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WoodRunnerEntity.class, true));
		
	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(0.5D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);

	}
	
	public void tick() {

		super.tick();

		int i = MathHelper.floor(this.posX);
		int j = MathHelper.floor(this.posY);
		int k = MathHelper.floor(this.posZ);

		BlockState blockstate = CanadaBlocks.berry_mush.getDefaultState();

		for (int l = 0; l < 4; ++l) {
			
			i = MathHelper.floor(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
			j = MathHelper.floor(this.posY);
			k = MathHelper.floor(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
			BlockPos blockpos = new BlockPos(i, j, k);
			
			if (this.world.isAirBlock(blockpos) && blockstate.isValidPosition(this.world, blockpos)) {
				
				this.world.setBlockState(blockpos, blockstate);
				
			}
		}
		
		if (this.getHealth() < this.getMaxHealth() / 2) {
			
			this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 60, 1, false, false));
			this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 60, 0, false, false));
			
		}
		
		this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 0, false, false));
		
	}

	public boolean attackEntityAsMob(Entity entityIn) {

		if (!super.attackEntityAsMob(entityIn)) {

			return false;

		} else {

			if (entityIn instanceof LivingEntity) {
				
				if (this.getHealth() > this.getMaxHealth() - this.getMaxHealth() / 3) {

					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 100, 0));

				} else if (this.getHealth() > this.getMaxHealth() / 3) {
					
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 100, 2));
					
				} else {
						
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 100, 4));
					
				}
				
			}

			return true;

		}
	}

	protected void updateAITasks() {
        
        if (this.ticksExisted % 300 == 0) {
        	
            this.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 1, false, false));
            
         } 
        
        if (this.ticksExisted % 30 == 0) {
        	 
        	 this.heal(1.0F);

         }

		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}

	protected SoundEvent getAmbientSound() {

		return SoundEvents.ENTITY_ZOMBIE_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundEvents.ENTITY_ZOMBIE_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_ZOMBIE_DEATH;

	}

	public void readAdditional(CompoundNBT compound) {
		
		super.readAdditional(compound);
		
		if (this.hasCustomName()) {
			
			this.bossInfo.setName(this.getDisplayName());
			
		}

	}

	public void setCustomName(@Nullable ITextComponent name) {
		
		super.setCustomName(name);
		this.bossInfo.setName(this.getDisplayName());
		
	}

	public void addTrackingPlayer(ServerPlayerEntity player) {
		
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
		
	}

	public void removeTrackingPlayer(ServerPlayerEntity player) {
		
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
		
	}

	protected void checkDespawn() {
		
		this.idleTime = 0;
		
	}
	
	public boolean isNonBoss() {

		return false;

	}

}