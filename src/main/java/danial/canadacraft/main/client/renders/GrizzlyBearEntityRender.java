package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.GrizzlyBearEntityModel;
import danial.canadacraft.main.init.entities.GrizzlyBearEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GrizzlyBearEntityRender extends MobRenderer<GrizzlyBearEntity, GrizzlyBearEntityModel> {

	public GrizzlyBearEntityRender(EntityRendererManager manager) {
		
		super(manager, new GrizzlyBearEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(GrizzlyBearEntity entity) {
		
		return Main.location("textures/entities/grizzly_bear_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<GrizzlyBearEntity> {
		
		@Override
		public EntityRenderer<? super GrizzlyBearEntity> createRenderFor(EntityRendererManager manager) {
			
			return new GrizzlyBearEntityRender(manager);
			
		}
		
	}

}