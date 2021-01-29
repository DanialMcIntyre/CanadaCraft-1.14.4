package danial.canadacraft.main.init.blocks.foods;

import danial.canadacraft.main.DimensionTeleportFix;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MeatBlock extends Block implements DimensionTeleportFix {
		   
	public MeatBlock(Properties properties) {
		
		super(properties);
		
	}
  
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		    
		if (entityIn instanceof PlayerEntity) {
		    
			PlayerEntity player = (PlayerEntity) entityIn;

			player.addPotionEffect(new EffectInstance(Effect.get(23), 1, 0, false, false));	
			player.addPotionEffect(new EffectInstance(Effect.get(2), 1, 5, false, false));	
			worldIn.playSound(player, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1.0F, 1.0F);	
			
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
			  
	}
	
}
