package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.MapleBossEntityModel;
import danial.canadacraft.main.init.entities.MapleBossEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MapleBossEntityRender extends MobRenderer<MapleBossEntity, MapleBossEntityModel> {

	public MapleBossEntityRender(EntityRendererManager manager) {
		
		super(manager, new MapleBossEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(MapleBossEntity entity) {
		
		return Main.location("textures/entities/maple_boss_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<MapleBossEntity> {
		
		@Override
		public EntityRenderer<? super MapleBossEntity> createRenderFor(EntityRendererManager manager) {
			
			return new MapleBossEntityRender(manager);
			
		}
		
	}

}