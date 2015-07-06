package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class SwampClayBall extends Item {
	public SwampClayBall() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_swampclayball");
		this.setTextureName(Reference.MODID + ":" + "swampclayball");
	}
}
