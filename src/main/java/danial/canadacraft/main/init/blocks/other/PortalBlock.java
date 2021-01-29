package danial.canadacraft.main.init.blocks.other;

import danial.canadacraft.main.DimensionTeleportFix;
import danial.canadacraft.main.init.world.dimensions.CanadaModDimension;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class PortalBlock extends Block implements DimensionTeleportFix {

	public PortalBlock(Block.Properties properties) {
		
		super(properties);
		
	}

	public BlockRenderLayer getRenderLayer() {
		
		return BlockRenderLayer.TRANSLUCENT;
		
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		
		return ItemStack.EMPTY;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity entityIn, Hand handIn, BlockRayTraceResult hit) {

		DimensionType type = CanadaModDimension.getDimensionType();

		this.teleportToCanadaDimension(worldIn.dimension.getType() == type ? DimensionType.OVERWORLD : type, entityIn);

		return super.onBlockActivated(state, worldIn, pos, entityIn, handIn, hit);
		
	}

}
