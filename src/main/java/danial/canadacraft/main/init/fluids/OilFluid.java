package danial.canadacraft.main.init.fluids;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.blocks.CanadaBlocks;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class OilFluid extends FlowingFluid {

	@Override
	public Fluid getFlowingFluid() {
		
		return CanadaFluids.flowing_oil;
		
	}

	@Override
	public Fluid getStillFluid() {
		
		return CanadaFluids.oil;
		
	}

	@Override
	protected boolean canSourcesMultiply() { 
		
		return false;
		
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {	
		
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		
		return 4;
	
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		
		return 2;
	
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {

		return BlockRenderLayer.SOLID;
		
	}

	@Override
	public Item getFilledBucket() {
		
		return CanadaItems.oil_bucket;
	
	}

	@Override
	protected boolean canDisplace(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {

		return direction == Direction.DOWN && !fluid.isIn(CanadaFluids.Tags.OIL);

	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		
		return 20;
	
	}

	@Override
	protected float getExplosionResistance() {
		
		return 100;
		
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {

		return CanadaBlocks.oil_fluid.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));

	}
	
	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		
		return fluidIn == CanadaFluids.oil || fluidIn == CanadaFluids.flowing_oil;
		
	}
	
	@Override
	protected FluidAttributes createAttributes() {

		return FluidAttributes.builder(Main.location("blocks/oil_still"), Main.location("blocks/oil_flow")).translationKey("block.canadacraft.oil").gaseous().sound(SoundEvents.BLOCK_WATER_AMBIENT).build(this);
		
	}

	public static class OilFlowing extends OilFluid {

		@Override
		protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {

			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
			
		}
		
		@Override
		public boolean isSource(IFluidState state) {

			return false;
			
		}

		@Override
		public int getLevel(IFluidState state) {

			return state.get(OilFluid.LEVEL_1_8);

		}
	
	}
	
	public static class OilSource extends OilFluid {

		@Override
		public boolean isSource(IFluidState state) {

			return true;
			
		}

		@Override
		public int getLevel(IFluidState state) {

			return 8;
			
		}
		
	}

}
