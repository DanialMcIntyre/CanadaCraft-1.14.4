package danial.canadacraft.main.init.fluids;

import java.util.function.Supplier;

import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BerryFluidBlock extends FlowingFluidBlock {

    public BerryFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
    	
        super(supplier, properties);
        
    }

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {

		if(this.getFluid().isIn(CanadaFluids.Tags.BERRY)) {
			
			if (entityIn instanceof LivingEntity && entityIn.getType() != CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_SALMON_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY && entityIn.getType() != CanadaEntities.BERRY_BOSS_ENTITY && !((LivingEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.berry_boots)) {
				
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effect.get(20), 10, 4, false, false));
				entityIn.setMotionMultiplier(state, new Vec3d((double) 0.8F, 0.75D, (double) 0.8F));
				
			}
			
		}
	
	}
	
}
