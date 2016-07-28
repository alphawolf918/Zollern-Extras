package zollernextras.items.tools.amaranth;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ZollernModInfo;

public class AmaranthAxe extends ItemAxe {
	
	public AmaranthAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_amaranthaxe");
		this.setTextureName(ZollernModInfo.MODID + ":" + "amaranth_axe");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthAxe = new ItemStack(ItemList.amaranthAxe, 1);
		amaranthAxe.addEnchantment(Enchantment.efficiency, 2);
		items.add(amaranthAxe);
	}
}