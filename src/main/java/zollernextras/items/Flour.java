package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class Flour extends Item {
	public Flour() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_flour");
		this.setTextureName(Reference.MODID + ":" + "flour");
	}
}