package danial.canadacraft.main.init.blocks.other;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class OilOre extends Block {

	public OilOre(Properties properties) {
		
		super(properties);
		
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

		BlockState blockstate = CanadaBlocks.oil_fluid.getDefaultState();
		
		int i = MathHelper.floor(pos.getX());
		int j = MathHelper.floor(pos.getY());
		int k = MathHelper.floor(pos.getZ());
		
		BlockPos blockpos = new BlockPos(i, j, k);
		
		player.world.setBlockState(blockpos, blockstate);
		
		super.onBlockHarvested(worldIn, pos, state, player);
		
	}

}
