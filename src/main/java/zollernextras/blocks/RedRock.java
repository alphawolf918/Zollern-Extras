package zollernextras.blocks;

import java.util.Random;
import net.minecraft.item.Item;

public class RedRock extends GenericBlock {
	
	public RedRock() {
		super("redrock", 1.4F);
		this.setHardResist(1.4F, 10F);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(ZollernBlocks.redRockCobble);
	}
}