package zollernextras.blocks.upsidedown.corrupt;

import zollernextras.blocks.ICorruptBlock;
import zollernextras.blocks.ZollernGemOre;
import net.minecraft.item.Item;

public class CorruptGemOre extends ZollernGemOre implements ICorruptBlock {
	
	public CorruptGemOre(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist, gemItem);
	}
	
	@Override
	public boolean isCorrupt() {
		return true;
	}
	
}