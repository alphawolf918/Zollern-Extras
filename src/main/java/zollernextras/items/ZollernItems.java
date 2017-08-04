package zollernextras.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import zollernextras.items.armor.ZollernArmor;
import zollernextras.items.armor.ZollernArmorMaterials;
import zollernextras.items.tools.ZollernAxe;
import zollernextras.items.tools.ZollernHoe;
import zollernextras.items.tools.ZollernPickaxe;
import zollernextras.items.tools.ZollernShovel;
import zollernextras.items.tools.ZollernSword;
import zollernextras.items.tools.ZollernToolMaterials;

public class ZollernItems {
	
	public static final Item superChargedCoal = new ZollernItemBase(
			"superchargedcoal");
	
	// Amaranth
	public static final Item amaranthIngot = new ZollernItemBase(
			"amaranthingot");
	public static final Item amaranthNugget = new ZollernItemBase(
			"amaranthnugget");
	public static final Item amaranthDust = new ZollernItemBase("amaranthdust");
	public static final Item amaranthBoots = new ZollernArmor(
			ZollernArmorMaterials.AMARANTH, 1, EntityEquipmentSlot.FEET,
			"amaranthboots");
	public static final Item amaranthLegs = new ZollernArmor(
			ZollernArmorMaterials.AMARANTH, 2, EntityEquipmentSlot.LEGS,
			"amaranthleggings");
	public static final Item amaranthChest = new ZollernArmor(
			ZollernArmorMaterials.AMARANTH, 1, EntityEquipmentSlot.CHEST,
			"amaranthchestplate");
	public static final Item amaranthHelm = new ZollernArmor(
			ZollernArmorMaterials.AMARANTH, 1, EntityEquipmentSlot.HEAD,
			"amaranthhelmet");
	public static final Item amaranthSword = new ZollernSword(
			ZollernToolMaterials.AMARANTH, "amaranthsword");
	public static final Item amaranthAxe = new ZollernAxe(
			ZollernToolMaterials.AMARANTH, "amaranthaxe", -3.0F);
	public static final Item amaranthPickaxe = new ZollernPickaxe(
			ZollernToolMaterials.AMARANTH, "amaranthpickaxe");
	public static final Item amaranthShovel = new ZollernShovel(
			ZollernToolMaterials.AMARANTH, "amaranthshovel");
	public static final Item amaranthHoe = new ZollernHoe(
			ZollernToolMaterials.AMARANTH, "amaranthhoe");
	
	// Azurite
	public static final Item azurite = new ZollernItemBase("azurite");
	public static final Item azuriteBoots = new ZollernArmor(
			ZollernArmorMaterials.AZURITE, 1, EntityEquipmentSlot.FEET,
			"azuriteboots");
	public static final Item azuriteLegs = new ZollernArmor(
			ZollernArmorMaterials.AZURITE, 2, EntityEquipmentSlot.LEGS,
			"azuriteleggings");
	public static final Item azuriteChest = new ZollernArmor(
			ZollernArmorMaterials.AZURITE, 1, EntityEquipmentSlot.CHEST,
			"azuritechestplate");
	public static final Item azuriteHelm = new ZollernArmor(
			ZollernArmorMaterials.AZURITE, 1, EntityEquipmentSlot.HEAD,
			"azuritehelmet");
	public static final Item azuriteSword = new ZollernSword(
			ZollernToolMaterials.AZURITE, "azuritesword");
	public static final Item azuriteAxe = new ZollernAxe(
			ZollernToolMaterials.AZURITE, "azuriteaxe", -2.5F);
	public static final Item azuritePickaxe = new ZollernPickaxe(
			ZollernToolMaterials.AZURITE, "azuritepickaxe");
	public static final Item azuriteShovel = new ZollernShovel(
			ZollernToolMaterials.AZURITE, "azuriteshovel");
	public static final Item azuriteHoe = new ZollernHoe(
			ZollernToolMaterials.AZURITE, "azuritehoe");
	
	// Zollernium
	public static final Item zollerniumIngot = new ZollernItemBase(
			"zollerniumingot");
	public static final Item zollerniumDust = new ZollernItemBase(
			"zollerniumdust");
	public static final Item zollerniumBoots = new ZollernArmor(
			ZollernArmorMaterials.ZOLLERNIUM, 1, EntityEquipmentSlot.FEET,
			"zollerniumboots");
	public static final Item zollerniumLegs = new ZollernArmor(
			ZollernArmorMaterials.ZOLLERNIUM, 2, EntityEquipmentSlot.LEGS,
			"zollerniumleggings");
	public static final Item zollerniumChest = new ZollernArmor(
			ZollernArmorMaterials.ZOLLERNIUM, 1, EntityEquipmentSlot.CHEST,
			"zollerniumchestplate");
	public static final Item zollerniumHelm = new ZollernArmor(
			ZollernArmorMaterials.ZOLLERNIUM, 1, EntityEquipmentSlot.HEAD,
			"zollerniumhelmet");
	public static final Item zollerniumSword = new ZollernSword(
			ZollernToolMaterials.ZOLLERNIUM, "zollerniumsword");
	public static final Item zollerniumAxe = new ZollernAxe(
			ZollernToolMaterials.ZOLLERNIUM, "zollerniumaxe", -2.0F);
	public static final Item zollerniumPickaxe = new ZollernPickaxe(
			ZollernToolMaterials.ZOLLERNIUM, "zollerniumpickaxe");
	public static final Item zollerniumShovel = new ZollernShovel(
			ZollernToolMaterials.ZOLLERNIUM, "zollerniumshovel");
	public static final Item zollerniumHoe = new ZollernHoe(
			ZollernToolMaterials.ZOLLERNIUM, "zollerniumhoe");
	
	// Radium
	public static final Item radium = new ZollernItemBase("radiance");
	// TODO: Apply custom potion effect on right-click
	public static final Item radiantBoots = new ZollernArmor(
			ZollernArmorMaterials.RADIUM, 1, EntityEquipmentSlot.FEET,
			"radiumboots");
	public static final Item radiantLegs = new ZollernArmor(
			ZollernArmorMaterials.RADIUM, 2, EntityEquipmentSlot.LEGS,
			"radiumleggings");
	public static final Item radiantChest = new ZollernArmor(
			ZollernArmorMaterials.RADIUM, 1, EntityEquipmentSlot.CHEST,
			"radiumchestplate");
	public static final Item radiantHelm = new ZollernArmor(
			ZollernArmorMaterials.RADIUM, 1, EntityEquipmentSlot.HEAD,
			"radiumhelmet");
	
	public static final Item enderShard = new ZollernItemBase("endershard");
	public static final Item obsidianIngot = new ZollernItemBase(
			"obsidianingot");
	public static final Item obsidianDust = new ZollernItemBase("obsidiandust");
	public static final Item witherite = new ZollernItemBase("witherite");
	public static final Item fuelonite = new ZollernItemBase("fuelonite");
	public static final Item fueltoniumIngot = new ZollernItemBase(
			"fueltoniumingot");
	public static final Item zincIngot = new ZollernItemBase("zincingot");
	public static final Item zincDust = new ZollernItemBase("zincdust");
	public static final Item aquamarine = new ZollernItemBase("aquamarine");
	public static final Item amber = new ZollernItemBase("amber");
	public static final Item opal = new ZollernItemBase("opal");
	
	public static final Item ruby = new ZollernItemBase("ruby");
	
	public static final Item garnet = new ZollernItemBase("garnet");
	public static final Item topaz = new ZollernItemBase("topaz");
	public static final Item sapphire = new ZollernItemBase("sapphire");
	public static final Item steelIngot = new ZollernItemBase("steelingot");
	public static final Item steelDust = new ZollernItemBase("steeldust");
	public static final Item enderiteIngot = new ZollernItemBase(
			"enderiteingot");
	public static final Item enderiteDust = new ZollernItemBase("enderitedust");
	public static final Item enderDiamond = new ZollernItemBase("enderdiamond");
	public static final Item flour = new ZollernItemBase("flour");
	
	// Chargium
	public static final Item chargiumIngot = new ZollernItemBase(
			"chargiumingot");
	public static final Item chargiumDust = new ZollernItemBase("chargiumdust");
	
}