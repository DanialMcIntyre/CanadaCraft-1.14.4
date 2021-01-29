package danial.canadacraft.main.init.world.dimensions;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class CanadaBiomeProviderSettings implements IBiomeProviderSettings {

	private WorldInfo worldInfo;
	private CanadaGenSettings generatorSettings;

	public CanadaBiomeProviderSettings setWorldInfo(WorldInfo info) {

		this.worldInfo = info;
		return this;

	}

	public CanadaBiomeProviderSettings setGeneratorSettings(CanadaGenSettings p_205441_1_) {

		this.generatorSettings = p_205441_1_;
		return this;

	}

	public WorldInfo getWorldInfo() {

		return this.worldInfo;

	}

	public CanadaGenSettings getGeneratorSettings() {

		return this.generatorSettings;

	}

}
