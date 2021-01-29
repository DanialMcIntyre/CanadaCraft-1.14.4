package danial.canadacraft.main.init.entities.villager;

import java.util.EnumSet;

import danial.canadacraft.main.init.entities.WoodRunnerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

public class TradeWithPlayerGoal extends Goal {
	
	private WoodRunnerEntity entity;

	public TradeWithPlayerGoal(WoodRunnerEntity entity) {
		
		this.entity = entity;
		this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		
	}

	@Override
	public boolean shouldExecute() {
		
		if (!this.entity.isAlive()) {
			
			return false;
			
		} else if (this.entity.isInWater()) {
			
			return false;
			
		} else if (!this.entity.onGround) {
			
			return false;
			
		} else if (this.entity.velocityChanged) {
			
			return false;
			
		} else {
			
			PlayerEntity playerEntity = this.entity.getCustomer();
			
			if (playerEntity == null) {
				
				return false;
				
			} else if (this.entity.getDistanceSq(playerEntity) > 16.0D) {
				
				return false;
				
			}
			
			return playerEntity.openContainer != null;
			
		}
		
	}

	@Override
	public void startExecuting() {
		
		this.entity.getNavigator().clearPath();
		
	}

	@Override
	public void resetTask() {
		
		this.entity.setCustomer(null);
		
	}
	
}
