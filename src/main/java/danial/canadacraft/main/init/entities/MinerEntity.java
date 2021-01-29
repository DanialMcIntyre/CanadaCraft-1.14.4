package danial.canadacraft.main.init.entities;

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
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MinerEntity extends MonsterEntity {

	public MinerEntity(EntityType<? extends MinerEntity> type, World worldIn) {

		super(type, worldIn);
		this.addPotionEffect(new EffectInstance(Effect.get(28), 200, 0, false, false));

	}

	@Override
	public void registerGoals() {

		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0d, false));
		this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.applyEntityAI();

	}

	public void applyEntityAI() {

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, GypsumGolemEntity.class, true));	

	}
	
	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return !super.isPotionApplicable(new EffectInstance(Effects.SLOWNESS));
	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);

	}
	
	@Override
	public boolean isImmuneToExplosions() {
		
		return true;
		
	}

	public boolean attackEntityAsMob(Entity entityIn) {

		if (!super.attackEntityAsMob(entityIn)) {

			return false;

		} else {

			if (entityIn instanceof LivingEntity) {

				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 100, 2));

			}

			return true;

		}
		
	}

	protected SoundEvent getAmbientSound() {

		return SoundsHandler.ENTITY_MINER_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundsHandler.ENTITY_MINER_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundsHandler.ENTITY_MINER_DEATH;

	}

}
