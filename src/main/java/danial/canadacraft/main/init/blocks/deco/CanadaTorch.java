package danial.canadacraft.main.init.blocks.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CanadaTorch extends Block {

	public static final VoxelShape SHAPE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);

	public CanadaTorch(Block.Properties properties) {

		super(properties);

	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		return SHAPE;

	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {

		return facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);

	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {

		return func_220055_a(worldIn, pos.down(), Direction.UP);

	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;
		worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);

	}

	public BlockRenderLayer getRenderLayer() {

		return BlockRenderLayer.CUTOUT;

	}

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {

		if (entityIn instanceof LivingEntity) {

			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effect.get(3), 1, 0, false, false));

		}
		
	}
	
}