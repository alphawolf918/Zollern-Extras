package zollernextras.blocks.upsidedown.corrupt;

import zollernextras.blocks.ZollernBlockOre;

public class CorruptOre extends ZollernBlockOre implements ICorruptBlock {
	
	public CorruptOre(String strName, float hardResist) {
		super(strName, hardResist);
	}
	
	@Override
	public boolean canCorrupt() {
		return true;
	}
	
}