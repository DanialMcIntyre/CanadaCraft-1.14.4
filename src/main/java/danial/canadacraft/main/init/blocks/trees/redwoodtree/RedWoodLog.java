package danial.canadacraft.main.init.blocks.trees.redwoodtree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class RedWoodLog extends RotatedPillarBlock {

	private final MaterialColor verticalColor;

	public RedWoodLog(MaterialColor p_i48367_1_, Block.Properties p_i48367_2_) {

		super(p_i48367_2_);
		this.verticalColor = p_i48367_1_;

	}

	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {

		return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;

	}

	public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack) {

		if (!worldIn.isRemote && !stack.isEmpty() && worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && !worldIn.restoringBlockSnapshots) {

			double d0 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			double d1 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			double d2 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, stack);
			itementity.setDefaultPickupDelay();
			worldIn.addEntity(itementity);

		}

	}

}