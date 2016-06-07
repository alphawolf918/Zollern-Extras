package zollernextras.items.tools.amaranth;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ModInfo;

public class AmaranthPickaxe extends ItemPickaxe {
	
	public AmaranthPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_amaranthpickaxe");
		this.setTextureName(ModInfo.MODID + ":" + "amaranthpickaxe");
		this.setHarvestLevel("pickaxe", 4);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthPickaxe = new ItemStack(ItemList.amaranthPickaxe, 1);
		amaranthPickaxe.addEnchantment(Enchantment.fortune, 2);
		items.add(amaranthPickaxe);
	}
}