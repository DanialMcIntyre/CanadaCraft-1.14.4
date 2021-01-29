package danial.canadacraft.main.init.blocks.deco;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CanadaWoodFenceGate extends FenceGateBlock {

	public CanadaWoodFenceGate(Properties properties) {
		
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(OPEN, Boolean.valueOf(false)).with(POWERED, Boolean.valueOf(false)).with(IN_WALL, Boolean.valueOf(false)));
	
	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		
		return 60;
		
	}
	
}
