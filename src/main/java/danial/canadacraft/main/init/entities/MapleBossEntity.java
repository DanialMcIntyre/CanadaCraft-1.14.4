package danial.canadacraft.main.init.entities;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.sounds.SoundsHandler;
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.World;

public class MapleBossEntity extends MonsterEntity {

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public MapleBossEntity(EntityType<? extends MapleBossEntity> type, World worldIn) {

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
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WoodRunnerEntity.class, true));
		
	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3875d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2.5D);

	}

	public boolean attackEntityAsMob(Entity entityIn) {

		if (!super.attackEntityAsMob(entityIn)) {

			return false;

		} else {

			if (entityIn instanceof LivingEntity) {

				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 200, 4));

			}

			return true;

		}
	}

	protected void updateAITasks() {
        
        if (this.ticksExisted % 300 == 0) {
        	
            this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 255));
            this.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0));
            
         } else if (this.ticksExisted % 20 == 0) {
        	 
        	 this.heal(1.F);

         }
        
        if (this.ticksExisted % 300 == 0) {
        	
        	long rand = Math.round(Math.random() * 2);
        	
        	if (rand == 1) {
        	
        		Entity maplemonsterentity = CanadaEntities.MAPLE_MONSTER.create(this.world);
        		maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
        		this.world.addEntity(maplemonsterentity);
        		
        	} 
        	
        }

		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}

	protected SoundEvent getAmbientSound() {

		return SoundsHandler.ENTITY_MAPLE_MONSTER_BOSS_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundsHandler.ENTITY_MAPLE_MONSTER_BOSS_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundsHandler.ENTITY_MAPLE_MONSTER_BOSS_DEATH;

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