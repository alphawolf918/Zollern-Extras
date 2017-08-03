package zollernextras.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import zollernextras.lib.ZollernModInfo;

public class ZollernArmorMaterials {
	
	public static ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial(
			"Amaranth", ZollernModInfo.modId + ":amaranth", 60, new int[] { 4,
					9, 6, 3 }, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F);
	public static ArmorMaterial AZURITE = EnumHelper.addArmorMaterial(
			"Amaranth", ZollernModInfo.modId + ":amaranth", 70, new int[] { 5,
					9, 6, 4 }, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.6F);
}
