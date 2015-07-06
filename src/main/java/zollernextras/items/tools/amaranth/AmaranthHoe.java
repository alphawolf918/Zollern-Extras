package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemHoe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthHoe extends ItemHoe {
	
	public AmaranthHoe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthhoe");
		this.setTextureName(Reference.MODID + ":" + "amaranthhoe");
	}
}