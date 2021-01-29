package danial.canadacraft.main.init.blocks.trees.mapletree;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MapleLog extends RotatedPillarBlock {

	private final MaterialColor verticalColor;

	public MapleLog(MaterialColor p_i48367_1_, Block.Properties p_i48367_2_) {

		super(p_i48367_2_);
		this.verticalColor = p_i48367_1_;

	}

	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {

		return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;

	}

	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

		if (!(player.getHeldItem(handIn).getItem() == Items.GLASS_BOTTLE)) {

			return false;

		} else {

			player.inventory.addItemStackToInventory(new ItemStack(CanadaItems.maple_sap));
			player.getHeldItem(handIn).shrink(1);
			worldIn.setBlockState(pos, CanadaBlocks.maple_wood_log_empty.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
			return true;

		}

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