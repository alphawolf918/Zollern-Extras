package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class SuperChargedCoal extends Item {
	public SuperChargedCoal() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_superchargedcoal");
		this.setTextureName(Reference.MODID + ":" + "superchargedcoal");
	}
}