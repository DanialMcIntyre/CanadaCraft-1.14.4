package danial.canadacraft.main.client.renders;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.BerryBlobEntityModel;
import danial.canadacraft.main.init.entities.BerryBlobSalmonEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BerryBlobSalmonEntityRender extends MobRenderer<BerryBlobSalmonEntity, BerryBlobEntityModel<BerryBlobSalmonEntity>> {

	public BerryBlobSalmonEntityRender(EntityRendererManager renderManagerIn) {
		
		super(renderManagerIn, new BerryBlobEntityModel<>(16), 0.25F);
		this.addLayer(new BerryBlobGelLayer<>(this));
		
	}

	public void doRender(BerryBlobSalmonEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
		this.shadowSize = 0.25F * (float) entity.getSlimeSize();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		
	}

	protected void preRenderCallback(BerryBlobSalmonEntity entitylivingbaseIn, float partialTickTime) {
		
		GlStateManager.scalef(0.999F, 0.999F, 0.999F);
		float f1 = (float) entitylivingbaseIn.getSlimeSize();
		float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		GlStateManager.scalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
		
	}

	public static class RenderFactory implements IRenderFactory<BerryBlobSalmonEntity> {

		@Override
		public EntityRenderer<? super BerryBlobSalmonEntity> createRenderFor(EntityRendererManager manager) {

			return new BerryBlobSalmonEntityRender(manager);

		}

	}

	@Override
	protected ResourceLocation getEntityTexture(BerryBlobSalmonEntity entity) {

		return Main.location("textures/entities/berry_blob_salmon_entity.png");

	}

}