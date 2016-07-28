package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernModInfo;

public class ModItem extends Item {
	public ModItem(String strTexture) {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_" + strTexture);
		this.setTextureName(ZollernModInfo.MODID + ":" + strTexture);
	}
}