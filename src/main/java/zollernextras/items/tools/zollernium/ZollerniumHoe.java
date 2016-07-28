package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemHoe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernModInfo;

public class ZollerniumHoe extends ItemHoe {
	
	public ZollerniumHoe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_zollerniumhoe");
		this.setTextureName(ZollernModInfo.MODID + ":" + "zollerniumhoe");
	}
}