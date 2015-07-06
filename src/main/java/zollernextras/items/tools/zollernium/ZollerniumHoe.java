package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemHoe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZollerniumHoe extends ItemHoe {
	
	public ZollerniumHoe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zollerniumhoe");
		this.setTextureName(Reference.MODID + ":" + "zollerniumhoe");
	}
}