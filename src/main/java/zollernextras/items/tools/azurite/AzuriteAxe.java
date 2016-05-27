package zollernextras.items.tools.azurite;

import net.minecraft.item.ItemAxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteAxe extends ItemAxe {
	
	public AzuriteAxe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuriteaxe");
		this.setTextureName(ModInfo.MODID + ":azuriteaxe");
	}
	
}