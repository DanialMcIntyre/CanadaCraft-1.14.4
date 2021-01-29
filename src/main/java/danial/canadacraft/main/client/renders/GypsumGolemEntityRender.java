package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.GypsumGolemEntityModel;
import danial.canadacraft.main.init.entities.GypsumGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GypsumGolemEntityRender extends MobRenderer<GypsumGolemEntity, GypsumGolemEntityModel> {

	public GypsumGolemEntityRender(EntityRendererManager manager) {
		
		super(manager, new GypsumGolemEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(GypsumGolemEntity entity) {
		
		return Main.location("textures/entities/gypsum_golem_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<GypsumGolemEntity> {
		
		@Override
		public EntityRenderer<? super GypsumGolemEntity> createRenderFor(EntityRendererManager manager) {
			
			return new GypsumGolemEntityRender(manager);
			
		}
		
	}

}