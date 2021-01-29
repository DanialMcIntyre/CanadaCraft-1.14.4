package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.BeaverEntityModel;
import danial.canadacraft.main.init.entities.BeaverEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BeaverEntityRender extends MobRenderer<BeaverEntity, BeaverEntityModel> {

	public BeaverEntityRender(EntityRendererManager manager) {
		
		super(manager, new BeaverEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(BeaverEntity entity) {
		
		return Main.location("textures/entities/beaver_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<BeaverEntity> {
		
		@Override
		public EntityRenderer<? super BeaverEntity> createRenderFor(EntityRendererManager manager) {
			
			return new BeaverEntityRender(manager);
			
		}
		
	}

}