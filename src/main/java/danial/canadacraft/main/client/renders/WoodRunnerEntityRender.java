package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.WoodRunnerEntityModel;
import danial.canadacraft.main.init.entities.WoodRunnerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WoodRunnerEntityRender extends MobRenderer<WoodRunnerEntity, WoodRunnerEntityModel> {

	public WoodRunnerEntityRender(EntityRendererManager manager) {
		
		super(manager, new WoodRunnerEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(WoodRunnerEntity entity) {
		
		return Main.location("textures/entities/wood_runner_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<WoodRunnerEntity> {
		
		@Override
		public EntityRenderer<? super WoodRunnerEntity> createRenderFor(EntityRendererManager manager) {
			
			return new WoodRunnerEntityRender(manager);
			
		}
		
	}

}