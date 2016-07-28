package zollernextras.items.tools.amaranth;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ZollernModInfo;

public class AmaranthHoe extends ItemHoe {
	
	public AmaranthHoe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_amaranthhoe");
		this.setTextureName(ZollernModInfo.MODID + ":" + "amaranthhoe");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List items) {
		ItemStack amaranthHoe = new ItemStack(ItemList.amaranthHoe, 1);
		amaranthHoe.addEnchantment(Enchantment.unbreaking, 2);
		items.add(amaranthHoe);
	}
}