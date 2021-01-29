package danial.canadacraft.main.init.paintings;

import danial.canadacraft.main.Main;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CanadaPaintings {
	
	public static final DeferredRegister<PaintingType> PAINTING_TYPES = new DeferredRegister<PaintingType>(ForgeRegistries.PAINTING_TYPES, Main.MODID);

	public static final RegistryObject<PaintingType> CANADA = PAINTING_TYPES.register("canadaflag", () -> new PaintingType(64, 48));
	public static final RegistryObject<PaintingType> MOOSE = PAINTING_TYPES.register("moose", () -> new PaintingType(64, 48));
	public static final RegistryObject<PaintingType> BEAVER = PAINTING_TYPES.register("beaver", () -> new PaintingType(64, 48));
	public static final RegistryObject<PaintingType> LAKE = PAINTING_TYPES.register("lake", () -> new PaintingType(64, 48));
	public static final RegistryObject<PaintingType> MAP = PAINTING_TYPES.register("canadamap", () -> new PaintingType(160, 80));

	
}
