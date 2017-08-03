package zollernextras.items.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernArmor extends ItemArmor {
	
	public ZollernArmor(ArmorMaterial materialIn, int renderIndexIn,
			EntityEquipmentSlot equipmentSlotIn, String itemName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		ZollernHelper.setName(this, itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
}
