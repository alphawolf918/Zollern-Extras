package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ModInfo;

public class AzuritePickaxe extends ItemPickaxe {
	
	public AzuritePickaxe() {
		super(ToolMaterials.AZURITE);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_azuritepickaxe");
		this.setTextureName(ModInfo.MODID + ":" + "azuritepickaxe");
		this.setHarvestLevel("pickaxe", 5);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.azuritePickaxe, 1);
		amaranthAxe.addEnchantment(Enchantment.fortune, 2);
		amaranthAxe.addEnchantment(Enchantment.unbreaking, 1);
		items.add(amaranthAxe);
	}
}