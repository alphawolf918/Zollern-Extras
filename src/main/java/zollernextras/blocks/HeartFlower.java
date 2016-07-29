package zollernextras.blocks;

import java.util.Random;
import net.minecraft.item.Item;
import zollernextras.items.ZollernItems;

public class HeartFlower extends FlowerBlock {
	
	public HeartFlower() {
		super("heartflower");
		this.setHardness(0.1F);
	}
	
	@Override
	public boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ZollernItems.heart;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		int r = par1Random.nextInt(100);
		if (r <= 5) {
			return 1;
		} else {
			return 0;
		}
	}
}