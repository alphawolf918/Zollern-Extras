package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemSpade;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernModInfo;

public class ZollerniumShovel extends ItemSpade {
	
	public ZollerniumShovel(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_zollerniumshovel");
		this.setTextureName(ZollernModInfo.MODID + ":" + "zollerniumshovel");
	}
}