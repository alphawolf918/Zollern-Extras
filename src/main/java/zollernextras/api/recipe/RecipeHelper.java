package zollernextras.api.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollernextras.lib.modhelper.ModHelperBase;
import cofh.api.util.ThermalExpansionHelper;

public class RecipeHelper {
	
	/**
	 * Add craftable horse armor.
	 * 
	 * @param horseArmor
	 *            The armor to craft.
	 * @param armorMetal
	 *            The metal to use.
	 */
	public static void addHorseArmor(Item horseArmor, Block armorMetal) {
		GameRegistry.addRecipe(new ItemStack(horseArmor, 1), new Object[] {
				"I I", " I ", "OOO", 'I', armorMetal, 'O', Blocks.OBSIDIAN });
	}
	
	/**
	 * @param itemInput
	 * @param itemOutput
	 */
	public static void fullItemCraft(Item itemInput, Item itemOutput) {
		GameRegistry.addRecipe(new ItemStack(itemInput, 1), new Object[] {
				"RRR", "RRR", "RRR", 'R', itemOutput });
		GameRegistry.addShapelessRecipe(new ItemStack(itemOutput, 9),
				new Object[] { itemInput });
	}
	
	/**
	 * Add a crop-to-seeds converter.
	 * 
	 * @param crop
	 *            The crop to use.
	 * @param seeds
	 *            The seeds for the crop to turn into.
	 */
	public static void addSeeds(Item crop, Item seeds) {
		GameRegistry.addShapelessRecipe(new ItemStack(seeds, 2),
				new Object[] { crop });
	}
	
	/**
	 * Adds bricks that can be crafted, but not decrafted.
	 * 
	 * @param itemInput
	 * @param blockOutput
	 */
	public static void addOneWayBricks(Item itemInput, Block blockOutput) {
		GameRegistry.addRecipe(new ItemStack(blockOutput, 4), new Object[] {
				"CC ", "CC ", "   ", 'C', itemInput });
	}
	
	/**
	 * Adds craftable and decraftable bricks.
	 * 
	 * @param coloredBrick
	 * @param coloredBlock
	 */
	public static void addBricks(Item coloredBrick, Block coloredBlock) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, 1), new Object[] {
				"CC ", "CC ", "   ", 'C', coloredBrick });
		GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
				new Object[] { coloredBlock });
	}
	
	/**
	 * Adds craftable and decraftable bricks.
	 * 
	 * @param coloredBrick
	 * @param coloredBlock
	 */
	public static void addBricks(Block coloredBrick, Block coloredBlock) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, 1), new Object[] {
				"CC ", "CC ", "   ", 'C', coloredBrick });
		GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
				new Object[] { coloredBlock });
	}
	
	/**
	 * Adds craftable and decraftable bricks.
	 * 
	 * @param coloredBrick
	 * @param coloredBlock
	 * @param numOutput
	 */
	public static void addBricks(Item coloredBrick, Block coloredBlock,
			int numOutput) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, numOutput),
				new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
		GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
				new Object[] { coloredBlock });
	}
	
	/**
	 * Adds craftable and decraftable bricks.
	 * 
	 * @param coloredBrick
	 * @param coloredBlock
	 * @param numOutput
	 */
	public static void addBricks(Block coloredBrick, Block coloredBlock,
			int numOutput) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, numOutput),
				new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
		GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
				new Object[] { coloredBlock });
	}
	
	/**
	 * Adds bricks that can be crafted, but not decrafted.
	 * 
	 * @param blockInput
	 * @param blockOutput
	 */
	public static void addOneWayBricks(Block blockInput, Block blockOutput) {
		GameRegistry.addRecipe(new ItemStack(blockOutput, 4), new Object[] {
				"CC ", "CC ", "   ", 'C', blockInput });
	}
	
	/**
	 * Adds a craftable block using 9 of an item.
	 * 
	 * @param block
	 * @param item
	 * @param numItem
	 */
	public static void fullBlockCraft(Block block, Item item, int numItem) {
		GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] { "SSS",
				"SSS", "SSS", 'S', item });
		GameRegistry.addShapelessRecipe(new ItemStack(item, numItem),
				new Object[] { block });
	}
	
	/**
	 * Adds a craftable block using 9 of an item.
	 * 
	 * @param block
	 * @param item
	 */
	public static void fullBlockCraft(Block block, Item item) {
		fullBlockCraft(block, item, 9);
	}
	
	/**
	 * Adds recipe for turning a log into planks.
	 * 
	 * @param log
	 * @param planks
	 */
	public static void addLogPlanks(Block log, Block planks) {
		GameRegistry.addShapelessRecipe(new ItemStack(planks, 4),
				new Object[] { log });
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
		if (ModHelperBase.useThermalExpansion) {
			ThermalExpansionHelper.addFurnaceRecipe(500, input, output);
		}
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(Block input, Item output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(Item input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
		if (ModHelperBase.useThermalExpansion) {
			ThermalExpansionHelper.addFurnaceRecipe(1500, new ItemStack(input,
					1), output);
		}
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(Item input, Item output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(Block input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
		if (ModHelperBase.useThermalExpansion) {
			ThermalExpansionHelper.addFurnaceRecipe(1500, new ItemStack(input,
					1), output);
		}
	}
	
	/**
	 * Adds a smelting recipe.
	 * 
	 * @param input
	 * @param output
	 * @param xp
	 */
	public static void addSmelting(Block input, Block output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
	
	public static void addArmorSet(Item itemOutput, Block blockOutput,
			String armorType) {
		armorType = armorType.toLowerCase();
		// Helmet
		if (armorType.equals("helmet")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"ZZZ", "Z Z", "   ", 'Z', new ItemStack(blockOutput, 1) });
			// Chestplate
		} else if (armorType.equals("chest")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"Z Z", "ZZZ", "ZZZ", 'Z', new ItemStack(blockOutput, 1) });
			// Leggings
		} else if (armorType.equals("legs")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"ZZZ", "Z Z", "Z Z", 'Z', new ItemStack(blockOutput, 1) });
			// Boots
		} else if (armorType.equals("boots")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"   ", "Z Z", "Z Z", 'Z', new ItemStack(blockOutput, 1) });
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"Z Z", "Z Z", "   ", 'Z', new ItemStack(blockOutput, 1) });
		}
	}
	
	/**
	 * Adds an armor set easily.
	 * 
	 * @param itemOutput
	 *            The armor to be crafted.
	 * @param itemIngot
	 *            The metal that the armor is made of.
	 * @param armorType
	 *            A string of what type of armor it is (helmet, chestplate,
	 *            leggings or boots).
	 */
	public static void addArmorSet(Item itemOutput, Item itemIngot,
			String armorType) {
		armorType = armorType.toLowerCase();
		// Helmet
		if (armorType.equals("helmet")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"ZZZ", "Z Z", "   ", 'Z', itemIngot });
			// Chestplate
		} else if (armorType.equals("chest")) {
			GameRegistry.addRecipe(new ItemStack(itemOutput), new Object[] {
					"Z Z", "ZZZ", "ZZZ", 'Z', itemIngot });
			// Leggings
		} else if (armorType.equals("legs")) {
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
	
	/**
	 * Adds a tool recipe easily.
	 * 
	 * @param itemOutput
	 *            The ItemStack to be returned as a crafting result.
	 * @param itemIngot
	 *            The metal ingot used as what the tools are made of.
	 * @param toolType
	 *            The type of tool to be returned (accepts pickaxe, shovel, axe,
	 *            hoe, and sword).
	 */
	public static void addToolSet(ItemStack itemOutput, Item itemIngot,
			String toolType) {
		toolType = toolType.toLowerCase();
		// Pickaxe
		if (toolType.equals("pickaxe")) {
			GameRegistry.addRecipe(itemOutput, new Object[] { "RRR", " S ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			// Shovel
		} else if (toolType.equals("shovel")) {
			GameRegistry.addRecipe(itemOutput, new Object[] { " R ", " S ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			// Axe
		} else if (toolType.equals("axe")) {
			GameRegistry.addRecipe(itemOutput, new Object[] { " RR", " SR",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			GameRegistry.addRecipe(itemOutput, new Object[] { "RR ", "RS ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			// Hoe
		} else if (toolType.equals("hoe")) {
			GameRegistry.addRecipe(itemOutput, new Object[] { "RR ", " S ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			GameRegistry.addRecipe(itemOutput, new Object[] { " RR", " S ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
			// Sword
		} else if (toolType.equals("sword")) {
			GameRegistry.addRecipe(itemOutput, new Object[] { " R ", " R ",
					" S ", 'R', itemIngot, 'S', Items.STICK });
		}
	}
	
	/**
	 * Add ingots that craft into an ingot stack.
	 * 
	 * @param ingot
	 * @param ingotStack
	 */
	public static void addIngotStack(Item ingot, Block ingotStack) {
		GameRegistry.addRecipe(new ItemStack(ingotStack, 1), new Object[] {
				" I ", "I I", "III", 'I', ingot });
	}
	
	/**
	 * Adds a torch crafting recipe.
	 * 
	 * @param itemCoalIn
	 *            The item to use as coal.
	 * @param blockTorchOut
	 *            The torch block to craft.
	 * @param numCrafted
	 *            The number of torches crafted.
	 */
	public static void addTorch(Item itemCoalIn, Block blockTorchOut,
			int numCrafted) {
		GameRegistry
				.addRecipe(new ItemStack(blockTorchOut, numCrafted),
						new Object[] { "G  ", "S  ", 'G', itemCoalIn, 'S',
								Items.STICK });
		GameRegistry
				.addRecipe(new ItemStack(blockTorchOut, numCrafted),
						new Object[] { " G ", " S ", 'G', itemCoalIn, 'S',
								Items.STICK });
	}
	
	/**
	 * Overloaded version of addTorch method. Crafts 4 by default.
	 * 
	 * @param itemCoalIn
	 *            The item to use as coal.
	 * @param blockTorchOut
	 *            The torch block to craft.
	 */
	public static void addTorch(Item itemCoalIn, Block blockTorchOut) {
		RecipeHelper.addTorch(itemCoalIn, blockTorchOut, 4);
	}
	
}