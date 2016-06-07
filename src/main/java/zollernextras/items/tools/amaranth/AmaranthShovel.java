package zollernextras.items.tools.amaranth;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ModInfo;

public class AmaranthShovel extends ItemSpade {
	
	public AmaranthShovel(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_amaranthshovel");
		this.setTextureName(ModInfo.MODID + ":" + "amaranthshovel");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthShovel = new ItemStack(ItemList.amaranthShovel, 1);
		amaranthShovel.addEnchantment(Enchantment.silkTouch, 1);
		items.add(amaranthShovel);
	}
}