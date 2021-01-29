package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.MinerEntityModel;
import danial.canadacraft.main.init.entities.MinerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MinerEntityRender extends MobRenderer<MinerEntity, MinerEntityModel> {

	public MinerEntityRender(EntityRendererManager manager) {
		
		super(manager, new MinerEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(MinerEntity entity) {
		
		return Main.location("textures/entities/miner_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<MinerEntity> {
		
		@Override
		public EntityRenderer<? super MinerEntity> createRenderFor(EntityRendererManager manager) {
			
			return new MinerEntityRender(manager);
			
		}
		
	}

}
