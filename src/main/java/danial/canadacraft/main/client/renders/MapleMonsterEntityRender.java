package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.client.models.MapleMonsterEntityModel;
import danial.canadacraft.main.init.entities.MapleMonsterEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MapleMonsterEntityRender extends MobRenderer<MapleMonsterEntity, MapleMonsterEntityModel> {

	public MapleMonsterEntityRender(EntityRendererManager manager) {
		
		super(manager, new MapleMonsterEntityModel(), 0f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(MapleMonsterEntity entity) {
		
		return Main.location("textures/entities/maple_monster_entity.png");
		
	}
	
	public static class RenderFactory implements IRenderFactory<MapleMonsterEntity> {
		
		@Override
		public EntityRenderer<? super MapleMonsterEntity> createRenderFor(EntityRendererManager manager) {
			
			return new MapleMonsterEntityRender(manager);
			
		}
		
	}

}