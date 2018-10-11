package zollernextras.blocks.upsidedown.corrupt;

import java.util.Random;
import zollernextras.blocks.ICorruptBlock;
import zollernextras.blocks.ZollernBlockBase;

public class CorruptBlock extends ZollernBlockBase implements ICorruptBlock {
	
	private static CorruptBlock instance;
	Random rand = new Random();
	
	public CorruptBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setHarvestLevel("pickaxe", 3);
		this.instance = this;
	}
	
	@Override
	public boolean isCorrupt() {
		return true;
	}
	
}