package zollernextras.items.tools.amaranth;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthSword extends ItemSword {
	
	public AmaranthSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthsword");
		this.setTextureName(Reference.MODID + ":" + "amaranthsword");
	}
}