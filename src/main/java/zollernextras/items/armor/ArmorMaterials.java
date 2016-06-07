package zollernextras.items.armor;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
	public static ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial(
			"Amaranth", 44, new int[] { 3, 8, 6, 3 }, 34);
	public static ArmorMaterial ZOLLERNIUM = EnumHelper.addArmorMaterial(
			"Zollernium", 55, new int[] { 4, 8, 6, 2 }, 68);
	public static ArmorMaterial AZURITE = EnumHelper.addArmorMaterial(
			"Azurite", 55, new int[] { 5, 7, 5, 3 }, 82);
	public static ArmorMaterial POWER = EnumHelper.addArmorMaterial("Power",
			55, new int[] { 5, 5, 5, 5 }, 100);
}