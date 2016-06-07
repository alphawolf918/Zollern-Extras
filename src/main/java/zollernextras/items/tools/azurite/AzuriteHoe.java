package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteHoe extends ItemHoe {
	
	public AzuriteHoe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritehoe");
		this.setTextureName(ModInfo.MODID + ":" + "azuritehoe");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.azuriteHoe, 1);
		amaranthAxe.addEnchantment(Enchantment.unbreaking, 3);
		items.add(amaranthAxe);
	}
}