package zollernextras.items.tools.azurite;

import net.minecraft.item.ItemSpade;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteShovel extends ItemSpade {
	
	public AzuriteShovel() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuriteshovel");
		this.setTextureName(ModInfo.MODID + ":" + "azuriteshovel");
	}
}
