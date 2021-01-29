package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.SiltstoneBossEntityModel;
import danial.canadacraft.main.init.entities.SiltstoneBossEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SiltstoneBossEntityRender extends MobRenderer<SiltstoneBossEntity, SiltstoneBossEntityModel> {

	public SiltstoneBossEntityRender(EntityRendererManager manager) {
		
		super(manager, new SiltstoneBossEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(SiltstoneBossEntity entity) {
		
		return Main.location("textures/entities/silt_stone_boss_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<SiltstoneBossEntity> {
		
		@Override
		public EntityRenderer<? super SiltstoneBossEntity> createRenderFor(EntityRendererManager manager) {
			
			return new SiltstoneBossEntityRender(manager);
			
		}
		
	}

}