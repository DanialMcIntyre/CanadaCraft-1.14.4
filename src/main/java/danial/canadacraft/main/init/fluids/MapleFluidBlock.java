package danial.canadacraft.main.init.fluids;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MapleFluidBlock extends FlowingFluidBlock {

    public MapleFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
    	
        super(supplier, properties);
        
    }

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {

		if(this.getFluid().isIn(CanadaFluids.Tags.MAPLE)) {
			
			if(entityIn instanceof LivingEntity) {
				
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SATURATION, 1, 1, false, false));
				entityIn.setMotionMultiplier(state, new Vec3d((double) 0.5F, 0.5D, (double) 0.5F));
				
			}
			
		}
	
	}
	
}
