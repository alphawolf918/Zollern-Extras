package zollernextras.blocks.upsidedown.corrupt;

import zollernextras.blocks.ICorruptBlock;
import zollernextras.blocks.ZollernDirt;

public class CorruptDirt extends ZollernDirt implements ICorruptBlock {
	
	public CorruptDirt(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setBlockHarvestLevel("shovel", 3);
	}
	
	@Override
	public boolean canCorrupt() {
		return true;
	}
	
}