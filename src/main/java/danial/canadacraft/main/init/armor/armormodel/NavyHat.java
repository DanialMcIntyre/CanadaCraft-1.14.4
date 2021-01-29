package danial.canadacraft.main.init.armor.armormodel;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.armor.ArmorBuff;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NavyHat extends ArmorBuff {
	
	public NavyHat(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		
		super(materialIn, slot, builder);
		
	}
	
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings({ "unchecked" })
	public <ArmorModel extends BipedModel<?>> ArmorModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, ArmorModel _default) {
		
        NavyHatModel model = new NavyHatModel();
        model.bipedHeadwear.showModel = armorSlot == EquipmentSlotType.HEAD;
        return (ArmorModel) model;
        
	}

	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
	
		return "canadacraft:textures/models/armor/navy_hat_model.png";
	
	}

}
