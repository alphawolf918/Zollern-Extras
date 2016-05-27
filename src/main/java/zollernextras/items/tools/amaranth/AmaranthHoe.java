package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemHoe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class AmaranthHoe extends ItemHoe {
	
	public AmaranthHoe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_amaranthhoe");
		this.setTextureName(ModInfo.MODID + ":" + "amaranthhoe");
	}
}