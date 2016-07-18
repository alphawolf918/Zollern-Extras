package zollernextras.lib.recipes;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.items.ItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolArmorRecipes {
	
	public static void init() {
		ToolRecipes.init();
		ArmorRecipes.init();
	}
	
	static class ToolRecipes {
		public static void init() {
			// Pickaxe
			ItemStack amaranthPickaxe = new ItemStack(ItemList.amaranthPickaxe,
					1);
			amaranthPickaxe.addEnchantment(Enchantment.fortune, 2);
			addToolSet(amaranthPickaxe, ItemList.amaranthIngot, "pickaxe");
			addToolSet(new ItemStack(ItemList.zollerniumPickaxe, 1),
					ItemList.zollerniumIngot, "pickaxe");
			ItemStack azuritePickaxe = new ItemStack(ItemList.azuritePickaxe, 1);
			azuritePickaxe.addEnchantment(Enchantment.fortune, 2);
			azuritePickaxe.addEnchantment(Enchantment.unbreaking, 1);
			addToolSet(azuritePickaxe, ItemList.azurite, "pickaxe");
			addToolSet(new ItemStack(ItemList.rubyPickaxe, 1), ItemList.ruby,
					"pickaxe");
			addToolSet(new ItemStack(ItemList.sapphirePickaxe, 1),
					ItemList.sapphire, "pickaxe");
			
			// Shovel
			ItemStack amaranthShovel = new ItemStack(ItemList.amaranthShovel, 1);
			amaranthShovel.addEnchantment(Enchantment.silkTouch, 1);
			addToolSet(amaranthShovel, ItemList.amaranthIngot, "shovel");
			addToolSet(new ItemStack(ItemList.zollerniumShovel, 1),
					ItemList.zollerniumIngot, "shovel");
			ItemStack azuriteShovel = new ItemStack(ItemList.azuriteShovel, 1);
			azuriteShovel.addEnchantment(Enchantment.efficiency, 2);
			azuriteShovel.addEnchantment(Enchantment.power, 1);
			addToolSet(azuriteShovel, ItemList.azurite, "shovel");
			addToolSet(new ItemStack(ItemList.rubyShovel, 1), ItemList.ruby,
					"shovel");
			addToolSet(new ItemStack(ItemList.sapphireShovel, 1),
					ItemList.sapphire, "shovel");
			
			// Axe
			ItemStack amaranthAxe = new ItemStack(ItemList.amaranthAxe, 1);
			amaranthAxe.addEnchantment(Enchantment.efficiency, 2);
			addToolSet(amaranthAxe, ItemList.amaranthIngot, "axe");
			addToolSet(new ItemStack(ItemList.zollerniumAxe, 1),
					ItemList.zollerniumIngot, "axe");
			ItemStack azuriteAxe = new ItemStack(ItemList.azuriteAxe, 1);
			azuriteAxe.addEnchantment(Enchantment.efficiency, 3);
			addToolSet(azuriteAxe, ItemList.azurite, "axe");
			addToolSet(new ItemStack(ItemList.rubyAxe, 1), ItemList.ruby, "axe");
			addToolSet(new ItemStack(ItemList.sapphireAxe, 1),
					ItemList.sapphire, "axe");
			
			// Hoe
			ItemStack amaranthHoe = new ItemStack(ItemList.amaranthHoe, 1);
			amaranthHoe.addEnchantment(Enchantment.unbreaking, 2);
			addToolSet(amaranthHoe, ItemList.amaranthIngot, "hoe");
			ItemStack azuriteHoe = new ItemStack(ItemList.azuriteHoe, 1);
			azuriteHoe.addEnchantment(Enchantment.unbreaking, 3);
			addToolSet(azuriteHoe, ItemList.azurite, "hoe");
			addToolSet(new ItemStack(ItemList.zollerniumHoe, 1),
					ItemList.zollerniumIngot, "hoe");
			addToolSet(new ItemStack(ItemList.rubyHoe, 1), ItemList.ruby, "hoe");
			addToolSet(new ItemStack(ItemList.sapphireHoe, 1),
					ItemList.sapphire, "hoe");
			
			// Sword
			ItemStack amaranthSword = new ItemStack(ItemList.amaranthSword, 1);
			amaranthSword.addEnchantment(Enchantment.sharpness, 2);
			addToolSet(amaranthSword, ItemList.amaranthIngot, "sword");
			addToolSet(new ItemStack(ItemList.zollerniumSword, 1),
					ItemList.zollerniumIngot, "sword");
			ItemStack azuriteSword = new ItemStack(ItemList.azuriteSword, 1);
			azuriteSword.addEnchantment(Enchantment.sharpness, 2);
			azuriteSword.addEnchantment(Enchantment.smite, 1);
			addToolSet(azuriteSword, ItemList.azurite, "sword");
			addToolSet(new ItemStack(ItemList.rubySword, 1), ItemList.ruby,
					"sword");
			addToolSet(new ItemStack(ItemList.sapphireSword, 1),
					ItemList.sapphire, "sword");
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
			addArmorSet(ItemList.amaranthHelmet, ItemList.amaranthIngot,
					"helmet");
			addArmorSet(ItemList.zollerniumHelmet, ItemList.zollerniumIngot,
					"helmet");
			addArmorSet(ItemList.azuriteHelmet, ItemList.azurite, "helmet");
			addArmorSet(ItemList.woodHelmet, Blocks.planks, "helmet");
			addArmorSet(ItemList.stoneHelmet, Blocks.stone, "helmet");
			
			// Chestplate
			addArmorSet(ItemList.amaranthChestplate, ItemList.amaranthIngot,
					"chestplate");
			addArmorSet(ItemList.zollerniumChestplate,
					ItemList.zollerniumIngot, "chestplate");
			addArmorSet(ItemList.zollerniumLeggings, ItemList.zollerniumIngot,
					"chestplate");
			addArmorSet(ItemList.woodChestplate, Blocks.planks, "chestplate");
			addArmorSet(ItemList.stoneChestplate, Blocks.stone, "chestplate");
			
			// Leggings
			addArmorSet(ItemList.amaranthLeggings, ItemList.amaranthIngot,
					"leggings");
			addArmorSet(ItemList.zollerniumLeggings, ItemList.zollerniumIngot,
					"leggings");
			addArmorSet(ItemList.azuriteLeggings, ItemList.azurite, "leggings");
			addArmorSet(ItemList.woodLeggings, Blocks.planks, "leggings");
			addArmorSet(ItemList.stoneLeggings, Blocks.stone, "leggings");
			
			// Boots
			addArmorSet(ItemList.amaranthBoots, ItemList.amaranthIngot, "boots");
			addArmorSet(ItemList.zollerniumBoots, ItemList.zollerniumIngot,
					"boots");
			addArmorSet(ItemList.azuriteBoots, ItemList.azurite, "boots");
			addArmorSet(ItemList.woodBoots, Blocks.planks, "boots");
			addArmorSet(ItemList.stoneBoots, Blocks.stone, "boots");
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