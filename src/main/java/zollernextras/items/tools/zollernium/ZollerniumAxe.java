package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemAxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernModInfo;

public class ZollerniumAxe extends ItemAxe {
	
	public ZollerniumAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_zollerniumaxe");
		this.setTextureName(ZollernModInfo.MODID + ":" + "zollerniumaxe");
	}
}