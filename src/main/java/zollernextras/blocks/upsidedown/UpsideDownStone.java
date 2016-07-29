/**
 * 
 */
package zollernextras.blocks.upsidedown;

import java.util.Random;
import net.minecraft.item.Item;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.blocks.GenericBlock;

public class UpsideDownStone extends GenericBlock {
	
	public UpsideDownStone() {
		super("ud_stone", 1.0F);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(ZollernBlocks.upsideDownCobble);
	}
	
}