package zollernextras.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import zollernextras.lib.ZollernModInfo;

public class ZollernArmorMaterials {
	
	public static ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial(
			"Amaranth", ZollernModInfo.modId + ":amaranth", 60, new int[] { 4,
					9, 6, 3 }, 31, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F);
	public static ArmorMaterial AZURITE = EnumHelper.addArmorMaterial(
			"Azurite", ZollernModInfo.modId + ":azurite", 70, new int[] { 5, 9,
					6, 4 }, 41, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.8F);
	public static ArmorMaterial ZOLLERNIUM = EnumHelper.addArmorMaterial(
			"Zollernium", ZollernModInfo.modId + ":zollernium", 80, new int[] {
					7, 9, 8, 6 }, 61, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			4.2F);
	public static ArmorMaterial RADIUM = EnumHelper.addArmorMaterial("Radium",
			ZollernModInfo.modId + ":radium", 90, new int[] { 9, 9, 9, 8 }, 71,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.6F);
}