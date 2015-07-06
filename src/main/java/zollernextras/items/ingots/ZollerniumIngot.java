package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZollerniumIngot extends Item {
	public ZollerniumIngot() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zollerniumingot");
		this.setTextureName(Reference.MODID + ":" + "zollerniumingot");
	}
}