package zollernextras.lib.recipes;

import net.minecraft.item.ItemStack;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.lib.modhelper.TEHelper;

public class PulverizerRecipes {
	
	public static void init() {
		// Amaranth Ore
		// Overworld
		TEHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.amaranthOre, 1), new ItemStack(
				ZollernItems.amaranthDust, 2));
		// Nether
		TEHelper.addPulverizerRecipe(4500, new ItemStack(
				ZollernBlocks.netherAmaranthOre), new ItemStack(
				ZollernItems.amaranthDust, 4));
		// Ender
		TEHelper.addPulverizerRecipe(5200, new ItemStack(
				ZollernBlocks.enderAmaranthOre), new ItemStack(
				ZollernItems.amaranthDust, 6));
		
		// Amaranth Ingot
		TEHelper.addPulverizerRecipe(500, new ItemStack(
				ZollernItems.amaranthIngot), new ItemStack(
				ZollernItems.amaranthDust, 1));
		
		// Zinc Ore
		// Overworld
		TEHelper.addPulverizerRecipe(4500,
				new ItemStack(ZollernBlocks.zincOre), new ItemStack(
						ZollernItems.zincDust, 2));
		// Nether
		TEHelper.addPulverizerRecipe(5500, new ItemStack(
				ZollernBlocks.netherZincOre), new ItemStack(
				ZollernItems.zincDust, 4));
		// Ender
		TEHelper.addPulverizerRecipe(6500, new ItemStack(
				ZollernBlocks.enderZincOre), new ItemStack(
				ZollernItems.zincDust, 6));
		
		// Zinc Ingot
		TEHelper.addPulverizerRecipe(600,
				new ItemStack(ZollernItems.zincIngot), new ItemStack(
						ZollernItems.zincDust, 1));
		
		// Steel Ore
		// Overworld
		TEHelper.addPulverizerRecipe(3200,
				new ItemStack(ZollernBlocks.steelOre), new ItemStack(
						ZollernItems.steelDust, 2));
		// Nether
		TEHelper.addPulverizerRecipe(6400, new ItemStack(
				ZollernBlocks.netherSteelOre), new ItemStack(
				ZollernItems.steelDust, 4));
		// Ender
		TEHelper.addPulverizerRecipe(6800, new ItemStack(
				ZollernBlocks.enderSteelOre), new ItemStack(
				ZollernItems.steelDust, 6));
		
		// Steel Ingot
		TEHelper.addPulverizerRecipe(800, new ItemStack(
				ZollernItems.steelIngot, 1), new ItemStack(
				ZollernItems.steelDust, 1));
		
		// Zollernium Ore
		TEHelper.addPulverizerRecipe(7200, new ItemStack(
				ZollernBlocks.zollerniumOre), new ItemStack(
				ZollernItems.zollerniumDust, 2));
		
		// Zollernium Ingot
		TEHelper.addPulverizerRecipe(1600, new ItemStack(
				ZollernItems.zollerniumIngot, 1), new ItemStack(
				ZollernItems.zollerniumDust, 1));
		
	}
	
}