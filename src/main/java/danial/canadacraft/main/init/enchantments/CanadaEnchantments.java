package danial.canadacraft.main.init.enchantments;

import danial.canadacraft.main.Main;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CanadaEnchantments {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, Main.MODID);

	public static final RegistryObject<SiltstoneBoostEnchantment> SILTSTONEBOOST = ENCHANTMENTS.register("siltstone_boost", () -> new SiltstoneBoostEnchantment(Rarity.COMMON, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND }));
	public static final RegistryObject<SiltstonePowerEnchantment> SILTSTONEPOWER = ENCHANTMENTS.register("siltstone_power", () -> new SiltstonePowerEnchantment(Rarity.UNCOMMON, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND }));

	public static final RegistryObject<BolsterEnchantment> BOLSTER = ENCHANTMENTS.register("bolster", () -> new BolsterEnchantment(Rarity.RARE, new EquipmentSlotType[] { EquipmentSlotType.HEAD}));
	
}