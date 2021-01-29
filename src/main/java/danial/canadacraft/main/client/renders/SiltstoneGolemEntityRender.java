package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.SiltstoneGolemEntityModel;
import danial.canadacraft.main.init.entities.SiltstoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SiltstoneGolemEntityRender extends MobRenderer<SiltstoneGolemEntity, SiltstoneGolemEntityModel> {

	public SiltstoneGolemEntityRender(EntityRendererManager manager) {
		
		super(manager, new SiltstoneGolemEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(SiltstoneGolemEntity entity) {
		
		return Main.location("textures/entities/siltstone_golem_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<SiltstoneGolemEntity> {
		
		@Override
		public EntityRenderer<? super SiltstoneGolemEntity> createRenderFor(EntityRendererManager manager) {
			
			return new SiltstoneGolemEntityRender(manager);
			
		}
		
	}

}