package zollernextras.items.armor;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
	
	public static ArmorMaterial WOOD = EnumHelper.addArmorMaterial("wood", 10,
			new int[] { 1, 1, 1, 1 }, 4);
	public static ArmorMaterial STONE = EnumHelper.addArmorMaterial("stone",
			20, new int[] { 4, 4, 4, 4 }, 8);
	public static ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial(
			"Amaranth", 44, new int[] { 3, 8, 6, 3 }, 34);
	public static ArmorMaterial AZURITE = EnumHelper.addArmorMaterial(
			"Azurite", 50, new int[] { 4, 7, 5, 4 }, 68);
	public static ArmorMaterial ZOLLERNIUM = EnumHelper.addArmorMaterial(
			"Zollernium", 55, new int[] { 4, 8, 6, 2 }, 82);
	public static ArmorMaterial POWER = EnumHelper.addArmorMaterial("Power",
			75, new int[] { 5, 5, 5, 5 }, 100);
	public static ArmorMaterial RADIANT = EnumHelper.addArmorMaterial(
			"Radiant", 105, new int[] { 5, 5, 5, 5 }, 100);
	
}