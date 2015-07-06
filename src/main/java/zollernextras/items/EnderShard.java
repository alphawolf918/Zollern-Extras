package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class EnderShard extends Item {
	public EnderShard() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_endershard");
		this.setTextureName(Reference.MODID + ":" + "endershard");
	}
}