package danial.canadacraft.main.init.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GypsumGolemEntity extends GolemEntity {

	protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.createKey(GypsumGolemEntity.class, DataSerializers.BYTE);
	public int attackTimer;
	   
	public GypsumGolemEntity(EntityType<? extends GypsumGolemEntity> type, World worldIn) {

		super(type, worldIn);

	}

	protected void registerGoals() {

		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {

					return p_213619_0_ instanceof IMob && !(p_213619_0_ instanceof CreeperEntity);

				}));
	}

	protected void applyEntityAI() {

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MapleMonsterEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));

	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.217d);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(14.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);

	}

	public void livingTick() {
		
		super.livingTick();
		
		if (this.attackTimer > 0) {
			
			--this.attackTimer;
			
		}
	}

	protected int decreaseAirSupply(int air) {
		
		return air;
		
	}

	protected void collideWithEntity(Entity entityIn) {
		
		if (entityIn instanceof IMob && !(entityIn instanceof CreeperEntity) && this.getRNG().nextInt(20) == 0) {
			
			this.setAttackTarget((LivingEntity) entityIn);
			
		}

		super.collideWithEntity(entityIn);
		
	}

	public boolean canAttack(EntityType<?> typeIn) {
		
		if (typeIn == EntityType.PLAYER) {
			
			return false;
			
		} else {
			
			return typeIn == EntityType.CREEPER ? false : super.canAttack(typeIn);
			
		}
		
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		
	      this.attackTimer = 10;
	      this.world.setEntityState(this, (byte)4);
	      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
	      
	      if (flag) {
	    	  
	         entityIn.setMotion(entityIn.getMotion().add(1.0D, (double)0.4F, 1.0D));
	         this.applyEnchantments(this, entityIn);
	         
	      }

	      this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
	      return flag;
		
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {

		if (id == 4) {

			this.attackTimer = 10;
			this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);

		} else {

			super.handleStatusUpdate(id);

		}

	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {

		return this.attackTimer;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundEvents.ENTITY_IRON_GOLEM_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_IRON_GOLEM_DEATH;

	}

}