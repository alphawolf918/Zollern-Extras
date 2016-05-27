package zollernextras.items.tools.azurite;

import net.minecraft.item.ItemHoe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteHoe extends ItemHoe {
	
	public AzuriteHoe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritehoe");
		this.setTextureName(ModInfo.MODID + ":" + "azuritehoe");
	}
	
}