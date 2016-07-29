package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ZollernItems;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernModInfo;

public class AzuriteAxe extends ItemAxe {
	
	public AzuriteAxe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_azuriteaxe");
		this.setTextureName(ZollernModInfo.MODID + ":azuriteaxe");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ZollernItems.azuriteAxe, 1);
		amaranthAxe.addEnchantment(Enchantment.efficiency, 3);
		items.add(amaranthAxe);
	}
}