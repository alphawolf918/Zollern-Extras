package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZollerniumSword extends ItemSword {
	
	public ZollerniumSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zollerniumsword");
		this.setTextureName(Reference.MODID + ":" + "zollerniumsword");
	}
}