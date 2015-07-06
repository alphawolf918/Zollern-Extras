package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemAxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthAxe extends ItemAxe {
	
	public AmaranthAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthaxe");
		this.setTextureName(Reference.MODID + ":" + "amaranth_axe");
	}
}