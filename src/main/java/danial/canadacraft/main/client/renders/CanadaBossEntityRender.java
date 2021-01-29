package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.CanadaBossEntityModel;
import danial.canadacraft.main.init.entities.CanadaBossEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CanadaBossEntityRender extends MobRenderer<CanadaBossEntity, CanadaBossEntityModel> {

	public CanadaBossEntityRender(EntityRendererManager manager) {
		
		super(manager, new CanadaBossEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(CanadaBossEntity entity) {
		
		return Main.location("textures/entities/canada_boss_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<CanadaBossEntity> {
		
		@Override
		public EntityRenderer<? super CanadaBossEntity> createRenderFor(EntityRendererManager manager) {
			
			return new CanadaBossEntityRender(manager);
			
		}
		
	}

}