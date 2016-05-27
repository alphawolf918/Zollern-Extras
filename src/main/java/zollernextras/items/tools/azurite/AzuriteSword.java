package zollernextras.items.tools.azurite;

import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteSword extends ItemSword {
	
	public AzuriteSword() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritesword");
		this.setTextureName(ModInfo.MODID + ":" + "azuritesword");
	}
}