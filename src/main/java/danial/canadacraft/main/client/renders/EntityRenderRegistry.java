package danial.canadacraft.main.client.renders;

import danial.canadacraft.main.init.entities.BeaverEntity;
import danial.canadacraft.main.init.entities.BerryBlobHuckleEntity;
import danial.canadacraft.main.init.entities.BerryBlobSalmonEntity;
import danial.canadacraft.main.init.entities.BerryBlobThimbleEntity;
import danial.canadacraft.main.init.entities.BerryBossEntity;
import danial.canadacraft.main.init.entities.CanadaBossEntity;
import danial.canadacraft.main.init.entities.GrizzlyBearEntity;
import danial.canadacraft.main.init.entities.GypsumGolemEntity;
import danial.canadacraft.main.init.entities.MapleBossEntity;
import danial.canadacraft.main.init.entities.MapleMonsterEntity;
import danial.canadacraft.main.init.entities.MinerEntity;
import danial.canadacraft.main.init.entities.MooseEntity;
import danial.canadacraft.main.init.entities.SiltstoneBossEntity;
import danial.canadacraft.main.init.entities.SiltstoneGolemEntity;
import danial.canadacraft.main.init.entities.WoodRunnerEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegistry {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(BeaverEntity.class, new BeaverEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MooseEntity.class, new MooseEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MapleMonsterEntity.class, new MapleMonsterEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MinerEntity.class, new MinerEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(GrizzlyBearEntity.class, new GrizzlyBearEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(SiltstoneGolemEntity.class, new SiltstoneGolemEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(GypsumGolemEntity.class, new GypsumGolemEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MapleBossEntity.class, new MapleBossEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(WoodRunnerEntity.class, new WoodRunnerEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BerryBlobHuckleEntity.class, new BerryBlobHuckleEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BerryBlobSalmonEntity.class, new BerryBlobSalmonEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BerryBlobThimbleEntity.class, new BerryBlobThimbleEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BerryBossEntity.class, new BerryBossEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(SiltstoneBossEntity.class, new SiltstoneBossEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(CanadaBossEntity.class, new CanadaBossEntityRender.RenderFactory());
		
	}

}