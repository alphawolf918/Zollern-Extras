package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class FueltoniumIngot extends Item {
	public FueltoniumIngot() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_fueltoniumingot");
		this.setTextureName(Reference.MODID + ":" + "fueltonium_ingot");
	}
}