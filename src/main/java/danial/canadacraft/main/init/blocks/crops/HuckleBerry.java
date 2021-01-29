package danial.canadacraft.main.init.blocks.crops;

import java.util.Random;

import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class HuckleBerry extends BushBlock implements IGrowable {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public HuckleBerry(Block.Properties p_i49971_1_) {
		
		super(p_i49971_1_);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
		
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		return SHAPE;
		
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		
		return new ItemStack(CanadaItems.huckle_berries);
		
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		
		super.tick(state, worldIn, pos, random);
		int i = state.get(AGE);
		
		if (i < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
		
		}

	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {

		builder.add(AGE);

	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

		return state.get(AGE) < 3;

	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {

		return true;

	}

	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {

		int i = Math.min(3, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);

	}

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		
		if (entityIn instanceof LivingEntity && entityIn.getType() != CanadaEntities.GRIZZLY_BEAR && entityIn.getType() != CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_SALMON_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BOSS_ENTITY) {
			
			entityIn.setMotionMultiplier(state, new Vec3d((double) 0.8F, 0.75D, (double) 0.8F));

			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effect.get(20), 10, 4, false, false));

		}
		
	}
	
}