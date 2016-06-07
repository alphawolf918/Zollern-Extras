package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteSword extends ItemSword {
	
	public AzuriteSword() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritesword");
		this.setTextureName(ModInfo.MODID + ":" + "azuritesword");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.amaranthShovel, 1);
		amaranthAxe.addEnchantment(Enchantment.sharpness, 2);
		amaranthAxe.addEnchantment(Enchantment.smite, 1);
		items.add(amaranthAxe);
	}
}