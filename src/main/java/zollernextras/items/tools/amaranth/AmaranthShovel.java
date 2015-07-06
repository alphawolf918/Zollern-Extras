package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemSpade;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthShovel extends ItemSpade {
	
	public AmaranthShovel(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthshovel");
		this.setTextureName(Reference.MODID + ":" + "amaranthshovel");
	}
}