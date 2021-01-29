package danial.canadacraft.main.init.entities;

import danial.canadacraft.main.init.sounds.SoundsHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MooseEntity extends AnimalEntity {

	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT, Blocks.HAY_BLOCK);

	@SuppressWarnings("unchecked")
	public MooseEntity(EntityType<? extends CreatureEntity> type, World worldIn) {

		super((EntityType<? extends AnimalEntity>) CanadaEntities.MOOSE, worldIn);

	}

	@Override
	protected void registerGoals() {

		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.2d));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new EatGrassGoal(this));

	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1d);

	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {

		return (AgeableEntity) CanadaEntities.MOOSE.create(this.world);

	}

	public boolean isBreedingItem(ItemStack stack) {

		return TEMPTATION_ITEMS.test(stack);

	}

	protected SoundEvent getAmbientSound() {

		return SoundsHandler.ENTITY_MOOSE_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundsHandler.ENTITY_MOOSE_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundsHandler.ENTITY_MOOSE_DEATH;

	}

}