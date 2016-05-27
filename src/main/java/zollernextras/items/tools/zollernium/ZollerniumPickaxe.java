package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemPickaxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class ZollerniumPickaxe extends ItemPickaxe {
	
	public ZollerniumPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_zollerniumpickaxe");
		this.setTextureName(ModInfo.MODID + ":" + "zollerniumpickaxe");
		this.setHarvestLevel("pickaxe", 5);
	}
}