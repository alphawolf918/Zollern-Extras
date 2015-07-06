package zollernextras.items.dust;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZollerniumDust extends Item {
	public ZollerniumDust() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zollerniumdust");
		this.setTextureName(Reference.MODID + ":" + "zollerniumdust");
	}
}