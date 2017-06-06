package zollernextras.blocks.trees;

import zollernextras.blocks.GenericBlock;

public class ZollernPlanks extends GenericBlock {
	
	public ZollernPlanks(String planksTexture) {
		super(planksTexture, 1.5F);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 0);
	}
}