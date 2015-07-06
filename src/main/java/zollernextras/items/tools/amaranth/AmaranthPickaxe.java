package zollernextras.items.tools.amaranth;

import net.minecraft.item.ItemPickaxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthPickaxe extends ItemPickaxe {
	
	public AmaranthPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthpickaxe");
		this.setTextureName(Reference.MODID + ":" + "amaranthpickaxe");
		this.setHarvestLevel("pickaxe", 4);
	}
}