package zollernextras.items.dust;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZincDust extends Item {
	public ZincDust() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zincdust");
		this.setTextureName(Reference.MODID + ":" + "zincdust");
	}
}