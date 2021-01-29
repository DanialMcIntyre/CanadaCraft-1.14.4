package danial.canadacraft.main.init.entities;

import danial.canadacraft.main.init.items.CanadaItems;
import danial.canadacraft.main.init.sounds.SoundsHandler;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class GrizzlyBearEntity extends AnimalEntity {

	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(CanadaItems.huckle_berries, CanadaItems.thimble_berries, CanadaItems.salmon_berries);

	public GrizzlyBearEntity(EntityType<? extends GrizzlyBearEntity> type, World worldIn) {

		super(type, worldIn);

	}

	@Override
	protected void registerGoals() {

		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0d, false));
		this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();

	}

	protected void applyEntityAI() {

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BerryBlobHuckleEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BerryBlobSalmonEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BerryBlobThimbleEntity.class, true));

	}

	@Override

	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.5D);

	}

	public AgeableEntity createChild(AgeableEntity ageable) {

		return (AgeableEntity) CanadaEntities.GRIZZLY_BEAR.create(this.world);

	}

	public boolean isBreedingItem(ItemStack stack) {

		return TEMPTATION_ITEMS.test(stack);

	}

	protected SoundEvent getAmbientSound() {

		return SoundsHandler.ENTITY_GRIZZLY_BEAR_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundsHandler.ENTITY_GRIZZLY_BEAR_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundsHandler.ENTITY_GRIZZLY_BEAR_DEATH;

	}

}
