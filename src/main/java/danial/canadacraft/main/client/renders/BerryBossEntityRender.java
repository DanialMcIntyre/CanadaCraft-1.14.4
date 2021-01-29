package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.BerryBossEntityModel;
import danial.canadacraft.main.init.entities.BerryBossEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BerryBossEntityRender extends MobRenderer<BerryBossEntity, BerryBossEntityModel> {

	public BerryBossEntityRender(EntityRendererManager manager) {
		
		super(manager, new BerryBossEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(BerryBossEntity entity) {
		
		return Main.location("textures/entities/berry_boss_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<BerryBossEntity> {
		
		@Override
		public EntityRenderer<? super BerryBossEntity> createRenderFor(EntityRendererManager manager) {
			
			return new BerryBossEntityRender(manager);
			
		}
		
	}

}