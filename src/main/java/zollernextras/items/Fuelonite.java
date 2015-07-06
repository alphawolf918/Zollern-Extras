package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class Fuelonite extends Item {
	public Fuelonite() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_fuelonite");
		this.setTextureName(Reference.MODID + ":" + "fuelonite");
	}
}