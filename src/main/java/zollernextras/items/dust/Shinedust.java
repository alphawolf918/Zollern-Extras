package zollernextras.items.dust;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class Shinedust extends Item {
	public Shinedust() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_shinedust");
		this.setTextureName(Reference.MODID + ":" + "shinedust");
	}
}