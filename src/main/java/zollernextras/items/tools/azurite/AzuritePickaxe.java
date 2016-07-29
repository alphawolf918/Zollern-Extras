package zollernextras.items.tools.azurite;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import zollernextras.items.tools.ItemZEPickaxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class AzuritePickaxe extends ItemZEPickaxe {
	
	public AzuritePickaxe() {
		super(ToolMaterials.AZURITE);
		ZollernHelper.setNameAndTexture(this, "azuritepickaxe");
		this.setHarvestLevel("pickaxe", ToolMaterials.AZURITE.getHarvestLevel());
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ZollernItems.azuritePickaxe, 1);
		amaranthAxe.addEnchantment(Enchantment.fortune, 2);
		amaranthAxe.addEnchantment(Enchantment.unbreaking, 1);
		items.add(amaranthAxe);
	}
}