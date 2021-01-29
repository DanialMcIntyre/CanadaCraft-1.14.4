package danial.canadacraft.main.init.blocks.crops;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class CornGrass extends BushBlock implements IGrowable, net.minecraftforge.common.IShearable {

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public CornGrass(Block.Properties properties) {

		super(properties);

	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		return SHAPE;

	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

		return true;

	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {

		return true;

	}

	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {

		DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == Blocks.FERN ? Blocks.LARGE_FERN : Blocks.TALL_GRASS);

		if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.isAirBlock(pos.up())) {

			doubleplantblock.placeAt(worldIn, pos, 2);

		}

	}

	public Block.OffsetType getOffsetType() {

		return Block.OffsetType.XYZ;

	}

}