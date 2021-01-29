package danial.canadacraft.main.init.entities;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
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
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Explosion;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.World;

public class CanadaBossEntity extends MonsterEntity {

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	int mode = 0;
	int berrymushon = 0;
	int halfhealth = 1;
	
	public CanadaBossEntity(EntityType<? extends CanadaBossEntity> type, World worldIn) {

		super(type, worldIn);
		this.experienceValue = 2500;

	}

	public int getmode() {

		return this.mode;

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
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.345d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(7.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2.5D);

	}

	protected void updateAITasks() {

		if (this.ticksExisted % 20 == 0) {

			this.heal(1.0F);

		}
		
		if (this.getHealth() < this.getMaxHealth() / 2) {
			
			this.halfhealth = 2;
			
		} else {
			
			this.halfhealth = 1;
			
		}
		
		if (this.ticksExisted % (300 / halfhealth) == 0) {
			
			long rand = Math.round(Math.random() * 2);
			
			if (rand == 0) {
				
				this.berrymushon = 0;
			
				Entity maplemonsterentity = CanadaEntities.MAPLE_MONSTER.create(this.world);
        		maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
        		this.world.addEntity(maplemonsterentity);
        		
                this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 255));
                this.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0));
			
			} else if (rand == 1) {
				
				this.berrymushon = 0;
				
				Entity maplemonsterentity = CanadaEntities.MINER.create(this.world);
        		maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
        		this.world.addEntity(maplemonsterentity);
        		
        		this.explode();
				
			} else {
				
				long rand2 = Math.round(Math.random() * 2);
				this.berrymushon = 1;
				
				if (rand2 == 0) {
				
					Entity maplemonsterentity = CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY.create(this.world);
					maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
					this.world.addEntity(maplemonsterentity);
        		
				} else if (rand2 == 1) {
				
					Entity maplemonsterentity = CanadaEntities.BERRY_BLOB_SALMON_ENTITY.create(this.world);
					maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
					this.world.addEntity(maplemonsterentity);
        		
				} else {
				
					Entity maplemonsterentity = CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY.create(this.world);
					maplemonsterentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
					this.world.addEntity(maplemonsterentity);
        		
				}
				
			}
			
		}

		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}
	
	public void tick() {

			super.tick();
			
			if (this.berrymushon == 1) {

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
			
			}
		
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
		
		if (!super.attackEntityAsMob(entityIn)) {
			
			return false;
			
		} else {
			
			if (entityIn instanceof LivingEntity) {
				
				long rand = Math.round(Math.random() * 2);
				
				if (rand == 0) {
				
					((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 100));
				
				} else if (rand == 1) {
					
					((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 100));
					
				} else {
					
					((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 100));
					
				}
				
			}

			return true;
			
		}
		
	}
	
	//protected SoundEvent getAmbientSound() {

		//return SoundEvents.player;

	//}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundEvents.ENTITY_PLAYER_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_PLAYER_DEATH;

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
	
	private int explosionRadius = 3;
	
	private void explode() {
		
		if (!this.world.isRemote) {
			
			int f = 1;
			
			Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.NONE : Explosion.Mode.NONE;
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius * f, explosion$mode);
			this.spawnLingeringCloud();
			
		}

	}
	
	private void spawnLingeringCloud() {
		
		AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.posX, this.posY, this.posZ);
		areaeffectcloudentity.setRadius(7F);
		areaeffectcloudentity.setRadiusOnUse(-0.5F);
		areaeffectcloudentity.setWaitTime(10);
		areaeffectcloudentity.setDuration(areaeffectcloudentity.getDuration() / 2);
		areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float) areaeffectcloudentity.getDuration());

		areaeffectcloudentity.addEffect(new EffectInstance(Effects.MINING_FATIGUE, 100, 1));
		areaeffectcloudentity.addEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));

		this.world.addEntity(areaeffectcloudentity);

}

}