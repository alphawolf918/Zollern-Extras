package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemAxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class AmaranthAxe extends ItemAxe {
	
	public AmaranthAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_amaranthaxe");
		this.setTextureName(ModInfo.MODID + ":" + "amaranth_axe");
	}
}