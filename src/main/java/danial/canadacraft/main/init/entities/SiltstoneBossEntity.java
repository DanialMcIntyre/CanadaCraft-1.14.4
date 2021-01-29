package danial.canadacraft.main.init.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Explosion;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.World;


public class SiltstoneBossEntity extends MonsterEntity {

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	private static final DataParameter<Integer> STATE = EntityDataManager.createKey(SiltstoneBossEntity.class, 	DataSerializers.VARINT);

	private int explosionRadius = 3;

	public SiltstoneBossEntity(EntityType<? extends SiltstoneBossEntity> type, World worldIn) {

		super(type, worldIn);
		this.experienceValue = 500;

	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0d, false));
		this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, GypsumGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WoodRunnerEntity.class, true));
		
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6D);
	}
	
	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return !super.isPotionApplicable(new EffectInstance(Effects.SLOWNESS));
	}


	protected void registerData() {
		super.registerData();
		this.dataManager.register(STATE, -1);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putByte("ExplosionRadius", (byte) this.explosionRadius);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);

		if (compound.contains("ExplosionRadius", 99)) {
			this.explosionRadius = compound.getByte("ExplosionRadius");
		}

		
		if (this.hasCustomName()) {

			this.bossInfo.setName(this.getDisplayName());

		}

	}
	
	protected void updateAITasks() {
		
		if(this.getHealth() > this.getMaxHealth() / 2 ) {
        
        if (this.ticksExisted % 100 == 0) {
        	
        	this.explode();
            
         } 
        
		} else if (this.getHealth() > this.getMaxHealth() / 6) {
			
	        if (this.ticksExisted % 50 == 0) {
	        	
	        	this.explode();
	            
	         } 
			
		} else if (this.getHealth() <= this.getMaxHealth() / 6) {
			
	        if (this.ticksExisted % 20 == 0) {
	        	
	        	this.explode();
				this.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 10, 0));
	            
	         } 
			
		}
        
        if (this.ticksExisted % 20 == 0) {
        	 
        	 this.heal(1.0F);

         }
        
        if (this.ticksExisted % 500 == 0) {
       	 
        	long rand = Math.round(Math.random() * 2);
        	
        	if (rand == 1) {
        	
        		Entity minerentity = CanadaEntities.MINER.create(this.world);
        		minerentity.setLocationAndAngles((double)this.posX + 0.5D, (double)this.posY, (double)this.posZ + 0.5D, 0.0F, 0.0F);
        		this.world.addEntity(minerentity);
        		
        	} 

        }

		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_CREEPER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CREEPER_DEATH;
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}

	public int getCreeperState() {
		return this.dataManager.get(STATE);
	}

	public void setCreeperState(int state) {
		this.dataManager.set(STATE, state);
	}

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

			areaeffectcloudentity.addEffect(new EffectInstance(Effects.MINING_FATIGUE, 500, 2));
			areaeffectcloudentity.addEffect(new EffectInstance(Effects.SLOWNESS, 500, 2));

			this.world.addEntity(areaeffectcloudentity);

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
