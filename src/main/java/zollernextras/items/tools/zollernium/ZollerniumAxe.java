package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemAxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ZollerniumAxe extends ItemAxe {
	
	public ZollerniumAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_zollerniumaxe");
		this.setTextureName(Reference.MODID + ":" + "zollerniumaxe");
	}
}