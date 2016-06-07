package zollernextras.items.tools.amaranth;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ModInfo;

public class AmaranthSword extends ItemSword {
	
	public AmaranthSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_amaranthsword");
		this.setTextureName(ModInfo.MODID + ":" + "amaranthsword");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthSword = new ItemStack(ItemList.amaranthSword, 1);
		amaranthSword.addEnchantment(Enchantment.sharpness, 2);
		items.add(amaranthSword);
	}
}