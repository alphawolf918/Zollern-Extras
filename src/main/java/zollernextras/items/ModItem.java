package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ModItem extends Item {
	public ModItem(String strTexture) {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_" + strTexture);
		this.setTextureName(Reference.MODID + ":" + strTexture);
	}
}