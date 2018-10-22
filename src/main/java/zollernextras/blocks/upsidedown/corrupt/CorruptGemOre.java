package zollernextras.blocks.upsidedown.corrupt;

import net.minecraft.item.Item;
import zollernextras.blocks.ZollernGemOre;

public class CorruptGemOre extends ZollernGemOre implements ICorruptBlock {
	
	public CorruptGemOre(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist, gemItem);
	}
	
	@Override
	public boolean canCorrupt() {
		return true;
	}
	
}