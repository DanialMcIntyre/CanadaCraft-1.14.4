package danial.canadacraft.main.init.entities.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SnowballStaffEntity extends ThrowableEntity {

	public SnowballStaffEntity(EntityType<? extends SnowballEntity> p_i50159_1_, World p_i50159_2_) {

		super(p_i50159_1_, p_i50159_2_);

	}

	public SnowballStaffEntity(World worldIn, LivingEntity throwerIn) {

		super(EntityType.SNOWBALL, throwerIn, worldIn);

	}

	public SnowballStaffEntity(World worldIn, double x, double y, double z) {

		super(EntityType.SNOWBALL, x, y, z, worldIn);

	}

	@Override
	protected void onImpact(RayTraceResult result) {
		
		if (!this.world.isRemote) {
			
			this.remove();

			if (result.getType() == RayTraceResult.Type.ENTITY) {

				Entity entity = ((EntityRayTraceResult) result).getEntity();
				entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2f);
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effect.get(2), 100, 2, true, true));
				
			}
			
		}
		
	}

	@Override
	protected void registerData() {
		
	}

}
