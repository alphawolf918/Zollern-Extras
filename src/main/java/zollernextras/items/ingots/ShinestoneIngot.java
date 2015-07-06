package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ShinestoneIngot extends Item {
	public ShinestoneIngot() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_" + "shinestoneingot");
		this.setTextureName(Reference.MODID + ":" + "shinestoneingot");
	}
}