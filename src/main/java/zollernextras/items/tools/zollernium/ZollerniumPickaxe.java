package zollernextras.items.tools.zollernium;

import net.minecraft.item.ItemPickaxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernModInfo;

public class ZollerniumPickaxe extends ItemPickaxe {
	
	public ZollerniumPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_zollerniumpickaxe");
		this.setTextureName(ZollernModInfo.MODID + ":" + "zollerniumpickaxe");
		this.setHarvestLevel("pickaxe",
				ToolMaterials.ZOLLERNIUM.getHarvestLevel());
	}
}