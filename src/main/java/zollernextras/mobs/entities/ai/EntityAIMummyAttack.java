package zollernextras.mobs.entities.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import zollernextras.mobs.entities.EntityMummy;

public class EntityAIMummyAttack extends EntityAIAttackMelee {
	
	private final EntityMummy mummy;
	private int raiseArmTicks;
	
	public EntityAIMummyAttack(EntityMummy mummyIn, double speedIn,
			boolean longMemoryIn) {
		super(mummyIn, speedIn, longMemoryIn);
		this.mummy = mummyIn;
	}
	
	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}
	
	/**
	 * Resets the task
	 */
	@Override
	public void resetTask() {
		super.resetTask();
		this.mummy.setArmsRaised(false);
	}
	
	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {
		super.updateTask();
		++this.raiseArmTicks;
		
		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.mummy.setArmsRaised(true);
		} else {
			this.mummy.setArmsRaised(false);
		}
	}
}