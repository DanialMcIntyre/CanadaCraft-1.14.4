package danial.canadacraft.main.init.blocks.deco;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class CanadaStoneButton extends AbstractButtonBlock {

	public CanadaStoneButton(Block.Properties properties) {

		super(false, properties);

	}

	public SoundEvent getSoundEvent(boolean p_196369_1_) {

		return p_196369_1_ ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;

	}
	
}