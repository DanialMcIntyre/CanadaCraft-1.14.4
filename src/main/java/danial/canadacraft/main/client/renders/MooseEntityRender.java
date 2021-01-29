package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.MooseEntityModel;
import danial.canadacraft.main.init.entities.MooseEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MooseEntityRender extends MobRenderer<MooseEntity, MooseEntityModel> {

	public MooseEntityRender(EntityRendererManager manager) {
		
		super(manager, new MooseEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(MooseEntity entity) {
		
		return Main.location("textures/entities/moose_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<MooseEntity> {

		@Override
		public EntityRenderer<? super MooseEntity> createRenderFor(EntityRendererManager manager) {

			return new MooseEntityRender(manager);
			
		}
		
	}

}
