package danial.canadacraft.main.init.blocks.crops;

import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CornCrop extends CropsBlock {
	  
	private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 18.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 21.0D, 16.0D)};
   
	public CornCrop(Block.Properties properties) {
	 
		super(properties);
	  
	}   
	  
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		
		return state.getBlock() == Blocks.GRASS && state.getBlock() == Blocks.DIRT && state.getBlock() == Blocks.FARMLAND;
	
	}
	
	protected IItemProvider getSeedsItem() {
	 
		return CanadaItems.corn_seeds;
	
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	 
		return SHAPES[state.get(this.getAgeProperty())];
	 
	}
	   
}