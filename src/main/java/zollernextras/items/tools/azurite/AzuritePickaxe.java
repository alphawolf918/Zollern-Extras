package zollernextras.items.tools.azurite;

import net.minecraft.item.ItemPickaxe;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuritePickaxe extends ItemPickaxe {
	
	public AzuritePickaxe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritepickaxe");
		this.setTextureName(ModInfo.MODID + ":" + "azuritepickaxe");
		this.setHarvestLevel("pickaxe", 5);
	}
	
}