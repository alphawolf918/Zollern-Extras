package zollernextras.items.crops;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import zollernextras.lib.MainHelper;

public class Seed extends ItemSeeds {
	public Seed(String strTexture, Block cropBlock) {
		super(cropBlock, Blocks.farmland);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
}