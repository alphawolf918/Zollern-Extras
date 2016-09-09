package zollernextras.api.helpers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHelper {
	
	public static void setName(Item item, String modId, String name) {
		item.setUnlocalizedName(modId + "_" + name);
	}
	
	public static void setTexture(Item item, String modId, String name) {
		item.setTextureName(modId + ":" + name);
	}
	
	public static void setNameAndTexture(Item item, String modId, String name) {
		ItemHelper.setName(item, modId, name);
		ItemHelper.setTexture(item, modId, name);
	}
	
	public static void setTab(Item item, CreativeTabs tab) {
		item.setCreativeTab(tab);
	}
	
}