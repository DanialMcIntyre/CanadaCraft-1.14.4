package danial.canadacraft.main.init.blocks.other;

import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CanadaMush extends Block {
	
	public static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

	public CanadaMush(Block.Properties properties) {
		
		super(properties);
		
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		return SHAPE;
	
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		

	      BlockPos blockpos = pos.down();
	      return func_220064_c(worldIn, blockpos) || func_220055_a(worldIn, blockpos, Direction.UP);
		
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	    
		if (entityIn instanceof LivingEntity && entityIn.getType() != CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_SALMON_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BOSS_ENTITY && entityIn.getType() != CanadaEntities.CANADA_BOSS_ENTITY && !((LivingEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.berry_boots)) {

			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effect.get(20), 10, 2, false, false));
			entityIn.setMotionMultiplier(state, new Vec3d((double) 0.8F, 0.75D, (double) 0.8F));
			
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
			  
	}
	
}