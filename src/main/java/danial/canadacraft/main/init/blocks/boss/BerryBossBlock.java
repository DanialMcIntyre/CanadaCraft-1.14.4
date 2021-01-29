package danial.canadacraft.main.init.blocks.boss;

import danial.canadacraft.main.init.entities.CanadaEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BerryBossBlock extends Block {
		   
	public BerryBossBlock(Properties properties) {
		
		super(properties);
		
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        Explosion.Mode explosion$mode = Explosion.Mode.NONE;
        worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 5.0F, false, explosion$mode);
		
		Entity maplebossentity = CanadaEntities.BERRY_BOSS_ENTITY.create(worldIn);
		maplebossentity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
		worldIn.addEntity(maplebossentity);
		
	}
	
}
