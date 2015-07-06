package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthIngot extends Item {
	public AmaranthIngot() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthingot");
		this.setTextureName(Reference.MODID + ":" + "amaranthingot");
	}
}