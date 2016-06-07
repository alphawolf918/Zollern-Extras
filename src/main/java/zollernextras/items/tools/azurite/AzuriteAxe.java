package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuriteAxe extends ItemAxe {
	
	public AzuriteAxe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuriteaxe");
		this.setTextureName(ModInfo.MODID + ":azuriteaxe");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.azuriteAxe, 1);
		amaranthAxe.addEnchantment(Enchantment.efficiency, 3);
		items.add(amaranthAxe);
	}
}