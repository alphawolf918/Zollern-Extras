package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class ModItem extends Item {
	public ModItem(String strTexture) {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_" + strTexture);
		this.setTextureName(ModInfo.MODID + ":" + strTexture);
	}
}