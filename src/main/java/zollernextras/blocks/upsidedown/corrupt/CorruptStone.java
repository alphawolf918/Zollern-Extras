package zollernextras.blocks.upsidedown.corrupt;

import java.util.Random;
import net.minecraft.item.Item;
import zollernextras.blocks.ZollernBlocks;

public class CorruptStone extends CorruptBlock {
	
	public CorruptStone() {
		super("corruptstone", 1.4F);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(ZollernBlocks.corruptCobblestone);
	}
	
}