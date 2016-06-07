package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteShovel extends ItemSpade {
	
	public AzuriteShovel() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuriteshovel");
		this.setTextureName(ModInfo.MODID + ":" + "azuriteshovel");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.azuriteShovel, 1);
		amaranthAxe.addEnchantment(Enchantment.efficiency, 2);
		amaranthAxe.addEnchantment(Enchantment.power, 1);
		items.add(amaranthAxe);
	}
}
