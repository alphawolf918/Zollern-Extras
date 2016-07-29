package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ZollernItems;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernModInfo;

public class AzuriteSword extends ItemSword {
	
	public AzuriteSword() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_azuritesword");
		this.setTextureName(ZollernModInfo.MODID + ":" + "azuritesword");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ZollernItems.amaranthShovel, 1);
		amaranthAxe.addEnchantment(Enchantment.sharpness, 2);
		amaranthAxe.addEnchantment(Enchantment.smite, 1);
		items.add(amaranthAxe);
	}
}