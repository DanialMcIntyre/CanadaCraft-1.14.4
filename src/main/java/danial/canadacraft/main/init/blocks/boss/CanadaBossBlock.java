package danial.canadacraft.main.init.blocks.boss;

import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CanadaBossBlock extends Block {
	   
	public CanadaBossBlock(Properties properties) {
		
		super(properties);
		
	}
	
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

		if (!(player.getHeldItem(handIn).getItem() == CanadaItems.canada_key)) {

			return false;

		} else {

			player.getHeldItem(handIn).shrink(1);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			
	        Explosion.Mode explosion$mode = Explosion.Mode.NONE;
	        worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 5.0F, false, explosion$mode);
			
			Entity canadabossentity = CanadaEntities.CANADA_BOSS_ENTITY.create(worldIn);
			canadabossentity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
			worldIn.addEntity(canadabossentity);
			
			return true;

		}

	}
	
}