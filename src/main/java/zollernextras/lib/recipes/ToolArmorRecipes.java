package zollernextras.lib.recipes;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolArmorRecipes {
	
	public static void init() {
		ToolRecipes.init();
		ArmorRecipes.init();
	}
	
	static class ToolRecipes {
		public static void init() {
			// Pickaxe
			ItemStack amaranthPickaxe = new ItemStack(
					ZollernItems.amaranthPickaxe, 1);
			amaranthPickaxe.addEnchantment(Enchantment.fortune, 2);
			addToolSet(amaranthPickaxe, ZollernItems.amaranthIngot, "pickaxe");
			addToolSet(new ItemStack(ZollernItems.zollerniumPickaxe, 1),
					ZollernItems.zollerniumIngot, "pickaxe");
			ItemStack azuritePickaxe = new ItemStack(
					ZollernItems.azuritePickaxe, 1);
			azuritePickaxe.addEnchantment(Enchantment.fortune, 2);
			azuritePickaxe.addEnchantment(Enchantment.unbreaking, 1);
			addToolSet(azuritePickaxe, ZollernItems.azurite, "pickaxe");
			addToolSet(new ItemStack(ZollernItems.rubyPickaxe, 1),
					ZollernItems.ruby, "pickaxe");
			addToolSet(new ItemStack(ZollernItems.sapphirePickaxe, 1),
					ZollernItems.sapphire, "pickaxe");
			
			// Shovel
			ItemStack amaranthShovel = new ItemStack(
					ZollernItems.amaranthShovel, 1);
			amaranthShovel.addEnchantment(Enchantment.silkTouch, 1);
			addToolSet(amaranthShovel, ZollernItems.amaranthIngot, "shovel");
			addToolSet(new ItemStack(ZollernItems.zollerniumShovel, 1),
					ZollernItems.zollerniumIngot, "shovel");
			ItemStack azuriteShovel = new ItemStack(ZollernItems.azuriteShovel,
					1);
			azuriteShovel.addEnchantment(Enchantment.efficiency, 2);
			azuriteShovel.addEnchantment(Enchantment.unbreaking, 2);
			addToolSet(azuriteShovel, ZollernItems.azurite, "shovel");
			addToolSet(new ItemStack(ZollernItems.rubyShovel, 1),
					ZollernItems.ruby, "shovel");
			addToolSet(new ItemStack(ZollernItems.sapphireShovel, 1),
					ZollernItems.sapphire, "shovel");
			
			// Axe
			ItemStack amaranthAxe = new ItemStack(ZollernItems.amaranthAxe, 1);
			amaranthAxe.addEnchantment(Enchantment.efficiency, 2);
			addToolSet(amaranthAxe, ZollernItems.amaranthIngot, "axe");
			addToolSet(new ItemStack(ZollernItems.zollerniumAxe, 1),
					ZollernItems.zollerniumIngot, "axe");
			ItemStack azuriteAxe = new ItemStack(ZollernItems.azuriteAxe, 1);
			azuriteAxe.addEnchantment(Enchantment.efficiency, 3);
			addToolSet(azuriteAxe, ZollernItems.azurite, "axe");
			addToolSet(new ItemStack(ZollernItems.rubyAxe, 1),
					ZollernItems.ruby, "axe");
			addToolSet(new ItemStack(ZollernItems.sapphireAxe, 1),
					ZollernItems.sapphire, "axe");
			
			// Hoe
			ItemStack amaranthHoe = new ItemStack(ZollernItems.amaranthHoe, 1);
			amaranthHoe.addEnchantment(Enchantment.unbreaking, 2);
			addToolSet(amaranthHoe, ZollernItems.amaranthIngot, "hoe");
			ItemStack azuriteHoe = new ItemStack(ZollernItems.azuriteHoe, 1);
			azuriteHoe.addEnchantment(Enchantment.unbreaking, 3);
			addToolSet(azuriteHoe, ZollernItems.azurite, "hoe");
			addToolSet(new ItemStack(ZollernItems.zollerniumHoe, 1),
					ZollernItems.zollerniumIngot, "hoe");
			addToolSet(new ItemStack(ZollernItems.rubyHoe, 1),
					ZollernItems.ruby, "hoe");
			addToolSet(new ItemStack(ZollernItems.sapphireHoe, 1),
					ZollernItems.sapphire, "hoe");
			
			// Sword
			ItemStack amaranthSword = new ItemStack(ZollernItems.amaranthSword,
					1);
			amaranthSword.addEnchantment(Enchantment.sharpness, 2);
			addToolSet(amaranthSword, ZollernItems.amaranthIngot, "sword");
			addToolSet(new ItemStack(ZollernItems.zollerniumSword, 1),
					ZollernItems.zollerniumIngot, "sword");
			ItemStack azuriteSword = new ItemStack(ZollernItems.azuriteSword, 1);
			azuriteSword.addEnchantment(Enchantment.sharpness, 2);
			azuriteSword.addEnchantment(Enchantment.smite, 1);
			addToolSet(azuriteSword, ZollernItems.azurite, "sword");
			addToolSet(new ItemStack(ZollernItems.rubySword, 1),
					ZollernItems.ruby, "sword");
			addToolSet(new ItemStack(ZollernItems.sapphireSword, 1),
					ZollernItems.sapphire, "sword");
		}
		
		/**
		 * Adds a tool recipe easily.
		 * 
		 * @param itemOutput
		 *            The ItemStack to be returned as a crafting result.
		 * @param itemIngot
		 *            The metal ingot used as what the tools are made of.
		 * @param toolType
		 *            The type of tool to be returned (accepts pickaxe, shovel,
		 *            axe, hoe, and sword).
		 */
		private static void addToolSet(ItemStack itemOutput, Item itemIngot,
				String toolType) {
			toolType = toolType.toLowerCase();
			// Pickaxe
			if (toolType.equals("pickaxe")) {
				GameRegistry.addRecipe(itemOutput, new Object[] { "RRR", " S ",
						" S ", 'R', itemIngot, 'S', Items.stick });
				// Shovel
			} else if (toolType.equals("shovel")) {
				GameRegistry.addRecipe(itemOutput, new Object[] { " R ", " S ",
						" S ", 'R', itemIngot, 'S', Items.stick });
				// Axe
			} else if (toolType.equals("axe")) {
				GameRegistry.addRecipe(itemOutput, new Object[] { " RR", " SR",
						" S ", 'R', itemIngot, 'S', Items.stick });
				GameRegistry.addRecipe(itemOutput, new Object[] { "RR ", "RS ",
						" S ", 'R', itemIngot, 'S', Items.stick });
				// Hoe
			} else if (toolType.equals("hoe")) {
				GameRegistry.addRecipe(itemOutput, new Object[] { "RR ", " S ",
						" S ", 'R', itemIngot, 'S', Items.stick });
				GameRegistry.addRecipe(itemOutput, new Object[] { " RR", " S ",
						" S ", 'R', itemIngot, 'S', Items.stick });
				// Sword
			} else if (toolType.equals("sword")) {
				GameRegistry.addRecipe(itemOutput, new Object[] { " R ", " R ",
						" S ", 'R', itemIngot, 'S', Items.stick });
			}
		}
	}
	
	static class ArmorRecipes {
		public static void init() {
			// Helmet
			addArmorSet(ZollernItems.amaranthHelmet,
					ZollernItems.amaranthIngot, "helmet");
			addArmorSet(ZollernItems.zollerniumHelmet,
					ZollernItems.zollerniumIngot, "helmet");
			addArmorSet(ZollernItems.azuriteHelmet, ZollernItems.azurite,
					"helmet");
			addArmorSet(ZollernItems.woodHelmet, Blocks.planks, "helmet");
			addArmorSet(ZollernItems.stoneHelmet, Blocks.stone, "helmet");
			addArmorSet(ZollernItems.radiantHelmet, ZollernItems.radiance,
					"helmet");
			
			// Chestplate
			addArmorSet(ZollernItems.amaranthChestplate,
					ZollernItems.amaranthIngot, "chestplate");
			addArmorSet(ZollernItems.zollerniumChestplate,
					ZollernItems.zollerniumIngot, "chestplate");
			addArmorSet(ZollernItems.azuriteChestPlate, ZollernItems.azurite,
					"chestplate");
			addArmorSet(ZollernItems.zollerniumLeggings,
					ZollernItems.zollerniumIngot, "chestplate");
			addArmorSet(ZollernItems.woodChestplate, Blocks.planks,
					"chestplate");
			addArmorSet(ZollernItems.stoneChestplate, Blocks.stone,
					"chestplate");
			addArmorSet(ZollernItems.radiantChestplate, ZollernItems.radiance,
					"chestplate");
			
			// Leggings
			addArmorSet(ZollernItems.amaranthLeggings,
					ZollernItems.amaranthIngot, "leggings");
			addArmorSet(ZollernItems.zollerniumLeggings,
					ZollernItems.zollerniumIngot, "leggings");
			addArmorSet(ZollernItems.azuriteLeggings, ZollernItems.azurite,
					"leggings");
			addArmorSet(ZollernItems.woodLeggings, Blocks.planks, "leggings");
			addArmorSet(ZollernItems.stoneLeggings, Blocks.stone, "leggings");
			addArmorSet(ZollernItems.radiantLeggings, ZollernItems.radiance,
					"leggings");
			
			// Boots
			addArmorSet(ZollernItems.amaranthBoots, ZollernItems.amaranthIngot,
					"boots");
			addArmorSet(ZollernItems.zollerniumBoots,
					ZollernItems.zollerniumIngot, "boots");
			addArmorSet(ZollernItems.azuriteBoots, ZollernItems.azurite,
					"boots");
			addArmorSet(ZollernItems.woodBoots, Blocks.planks, "boots");
			addArmorSet(ZollernItems.stoneBoots, Blocks.stone, "boots");
			addArmorSet(ZollernItems.radiantBoots, ZollernItems.radiance,
					"boots");
		}
		
		private static void addArmorSet(Item itemOutput, Block blockOutput,
				String armorType) {
			armorType = armorType.toLowerCase();
			// Helmet
			if (armorType.equals("helmet")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput),
						new Object[] { "ZZZ", "Z Z", "   ", 'Z',
								new ItemStack(blockOutput, 1) });
				// Chestplate
			} else if (armorType.equals("chestplate")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput),
						new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z',
								new ItemStack(blockOutput, 1) });
				// Leggings
			} else if (armorType.equals("leggings")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput),
						new Object[] { "ZZZ", "Z Z", "Z Z", 'Z',
								new ItemStack(blockOutput, 1) });
				// Boots
			} else if (armorType.equals("boots")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput),
						new Object[] { "   ", "Z Z", "Z Z", 'Z',
								new ItemStack(blockOutput, 1) });
				GameRegistry.addRecipe(new ItemStack(itemOutput),
						new Object[] { "Z Z", "Z Z", "   ", 'Z',
								new ItemStack(blockOutput, 1) });
			}
		}
		
		public static void addArmorSet(Item itemOutput, Item itemIngot,
				String armorType) {
			armorType = armorType.toLowerCase();
			// Helmet
			if (armorType.equals("helmet")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
						"ZZZ", "Z Z", "   ", 'Z', itemIngot });
				// Chestplate
			} else if (armorType.equals("chestplate")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
						"Z Z", "ZZZ", "ZZZ", 'Z', itemIngot });
				// Leggings
			} else if (armorType.equals("leggings")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
						"ZZZ", "Z Z", "Z Z", 'Z', itemIngot });
				// Boots
			} else if (armorType.equals("boots")) {
				GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
						"   ", "Z Z", "Z Z", 'Z', itemIngot });
				GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
						"Z Z", "Z Z", "   ", 'Z', itemIngot });
			}
		}
	}
}