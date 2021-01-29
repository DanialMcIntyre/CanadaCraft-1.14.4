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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SiltstoneGolemEntity extends MonsterEntity {
	
	protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.createKey(SiltstoneGolemEntity.class, DataSerializers.BYTE);

	public SiltstoneGolemEntity(EntityType<? extends SiltstoneGolemEntity> type, World worldIn) {

		super(type, worldIn);

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
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, GypsumGolemEntity.class, true));

	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.215d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);

	}

	public boolean attackEntityAsMob(Entity entityIn) {

		if (!super.attackEntityAsMob(entityIn)) {

			return false;

		} else {

			if (entityIn instanceof LivingEntity) {

				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 40, 0));
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 100, 1));

			}

			return true;

		}
		
	}

	protected SoundEvent getAmbientSound() {

		return SoundsHandler.ENTITY_SILT_STONE_GOLEM_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundsHandler.ENTITY_SILT_STONE_GOLEM_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundsHandler.ENTITY_SILT_STONE_GOLEM_DEATH;

	}

}