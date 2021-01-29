package danial.canadacraft.main.init.tools.staffs;

import danial.canadacraft.main.init.entities.projectiles.SnowballStaffEntity;
import danial.canadacraft.main.init.tools.ToolMaterials;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SnowStaff extends SwordItem {

	public SnowStaff(ToolMaterials snow, int i, int j, Properties properties) {

		super(snow, i, j, properties);

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		ItemStack stack = playerIn.getHeldItem(handIn);

		if (!worldIn.isRemote) {

			SnowballStaffEntity snowballentity = new SnowballStaffEntity(worldIn, playerIn);
			snowballentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			worldIn.addEntity(snowballentity);
			stack.damageItem(1, playerIn, (p_220039_0_) -> {
				
				p_220039_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
				
			});

		}

		return new ActionResult<>(ActionResultType.SUCCESS, stack);

	}

}
