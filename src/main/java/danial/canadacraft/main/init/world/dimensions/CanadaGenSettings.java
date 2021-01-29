package danial.canadacraft.main.init.world.dimensions;

import net.minecraft.world.gen.OverworldGenSettings;

public class CanadaGenSettings extends OverworldGenSettings {

	public int getBiomeSize() {
		
		return 16;
		
	}

	public int getRiverSize() {
		
		return 5;
		
	}

	public int getBiomeId() {
		
		return -1;
		
	}

	@Override
	public int getBedrockFloorHeight() {
		
		return 0;
		
	}

}
