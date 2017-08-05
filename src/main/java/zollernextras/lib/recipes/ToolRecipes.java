package zollernextras.lib.recipes;

import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.api.recipe.RecipeHelper;
import zollernextras.items.ZollernItems;

public class ToolRecipes {
	
	public static void init() {
		// Pickaxe
		ItemStack amaranthPickaxe = new ItemStack(ZollernItems.amaranthPickaxe,
				1);
		amaranthPickaxe.addEnchantment(Enchantments.FORTUNE, 2);
		addToolSet(amaranthPickaxe, ZollernItems.amaranthIngot, "pickaxe");
		addToolSet(new ItemStack(ZollernItems.zollerniumPickaxe, 1),
				ZollernItems.zollerniumIngot, "pickaxe");
		ItemStack azuritePickaxe = new ItemStack(ZollernItems.azuritePickaxe, 1);
		azuritePickaxe.addEnchantment(Enchantments.FORTUNE, 2);
		azuritePickaxe.addEnchantment(Enchantments.UNBREAKING, 1);
		RecipeHelper
				.addToolSet(azuritePickaxe, ZollernItems.azurite, "pickaxe");
		addToolSet(new ItemStack(ZollernItems.rubyPickaxe, 1),
				ZollernItems.ruby, "pickaxe");
		addToolSet(new ItemStack(ZollernItems.sapphirePickaxe, 1),
				ZollernItems.sapphire, "pickaxe");
		
		// Shovel
		ItemStack amaranthShovel = new ItemStack(ZollernItems.amaranthShovel, 1);
		amaranthShovel.addEnchantment(Enchantments.SILK_TOUCH, 1);
		addToolSet(amaranthShovel, ZollernItems.amaranthIngot, "shovel");
		addToolSet(new ItemStack(ZollernItems.zollerniumShovel, 1),
				ZollernItems.zollerniumIngot, "shovel");
		ItemStack azuriteShovel = new ItemStack(ZollernItems.azuriteShovel, 1);
		azuriteShovel.addEnchantment(Enchantments.EFFICIENCY, 2);
		azuriteShovel.addEnchantment(Enchantments.UNBREAKING, 2);
		addToolSet(azuriteShovel, ZollernItems.azurite, "shovel");
		addToolSet(new ItemStack(ZollernItems.rubyShovel, 1),
				ZollernItems.ruby, "shovel");
		addToolSet(new ItemStack(ZollernItems.sapphireShovel, 1),
				ZollernItems.sapphire, "shovel");
		
		// Axe
		ItemStack amaranthAxe = new ItemStack(ZollernItems.amaranthAxe, 1);
		amaranthAxe.addEnchantment(Enchantments.EFFICIENCY, 2);
		addToolSet(amaranthAxe, ZollernItems.amaranthIngot, "axe");
		addToolSet(new ItemStack(ZollernItems.zollerniumAxe, 1),
				ZollernItems.zollerniumIngot, "axe");
		ItemStack azuriteAxe = new ItemStack(ZollernItems.azuriteAxe, 1);
		azuriteAxe.addEnchantment(Enchantments.EFFICIENCY, 3);
		addToolSet(azuriteAxe, ZollernItems.azurite, "axe");
		addToolSet(new ItemStack(ZollernItems.rubyAxe, 1), ZollernItems.ruby,
				"axe");
		addToolSet(new ItemStack(ZollernItems.sapphireAxe, 1),
				ZollernItems.sapphire, "axe");
		
		// Hoe
		ItemStack amaranthHoe = new ItemStack(ZollernItems.amaranthHoe, 1);
		amaranthHoe.addEnchantment(Enchantments.UNBREAKING, 2);
		addToolSet(amaranthHoe, ZollernItems.amaranthIngot, "hoe");
		ItemStack azuriteHoe = new ItemStack(ZollernItems.azuriteHoe, 1);
		azuriteHoe.addEnchantment(Enchantments.UNBREAKING, 3);
		addToolSet(azuriteHoe, ZollernItems.azurite, "hoe");
		addToolSet(new ItemStack(ZollernItems.zollerniumHoe, 1),
				ZollernItems.zollerniumIngot, "hoe");
		addToolSet(new ItemStack(ZollernItems.rubyHoe, 1), ZollernItems.ruby,
				"hoe");
		addToolSet(new ItemStack(ZollernItems.sapphireHoe, 1),
				ZollernItems.sapphire, "hoe");
		
		// Sword
		ItemStack amaranthSword = new ItemStack(ZollernItems.amaranthSword, 1);
		amaranthSword.addEnchantment(Enchantments.SHARPNESS, 2);
		addToolSet(amaranthSword, ZollernItems.amaranthIngot, "sword");
		addToolSet(new ItemStack(ZollernItems.zollerniumSword, 1),
				ZollernItems.zollerniumIngot, "sword");
		ItemStack azuriteSword = new ItemStack(ZollernItems.azuriteSword, 1);
		azuriteSword.addEnchantment(Enchantments.SHARPNESS, 2);
		azuriteSword.addEnchantment(Enchantments.SMITE, 1);
		addToolSet(azuriteSword, ZollernItems.azurite, "sword");
		addToolSet(new ItemStack(ZollernItems.rubySword, 1), ZollernItems.ruby,
				"sword");
		addToolSet(new ItemStack(ZollernItems.sapphireSword, 1),
				ZollernItems.sapphire, "sword");
	}
	
	static void addToolSet(ItemStack itemOutput, Item itemIngot, String toolType) {
		RecipeHelper.addToolSet(itemOutput, itemIngot, toolType);
	}
	
}