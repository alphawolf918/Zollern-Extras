package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZincIngot extends Item {
	public ZincIngot() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zincingot");
		this.setTextureName(Reference.MODID + ":" + "zincingot");
	}
}