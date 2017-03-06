package zollernextras.lib.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class PulverizerRecipes {
	public static void init() {
		
		/**
		 * Ores
		 */
		
		// SPC Ore
		ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
				ZollernBlocks.spcOre, 1),
				new ItemStack(ZollernItems.spcItem, 2), new ItemStack(
						Items.coal), 30);
		ThermalExpansionHelper.addPulverizerRecipe(2600, new ItemStack(
				ZollernBlocks.spcNetherOre, 1), new ItemStack(
				ZollernItems.spcItem, 4), new ItemStack(Items.coal), 60);
		ThermalExpansionHelper.addPulverizerRecipe(3600, new ItemStack(
				ZollernBlocks.enderSpcOre, 1), new ItemStack(
				ZollernItems.spcItem, 8), new ItemStack(Items.coal), 90);
		
		// FN Ore
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.fueltonium, 1), new ItemStack(
				ZollernItems.fuelonite, 2));
		ThermalExpansionHelper.addPulverizerRecipe(5200, new ItemStack(
				ZollernBlocks.fuelNetherOre, 1), new ItemStack(
				ZollernItems.fuelonite, 4));
		ThermalExpansionHelper.addPulverizerRecipe(7200, new ItemStack(
				ZollernBlocks.enderFnOre, 1), new ItemStack(
				ZollernItems.fuelonite, 8));
		
		// Shard Ore
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.enderShardOre, 1), new ItemStack(
				ZollernItems.enderShard, 2));
		ThermalExpansionHelper.addPulverizerRecipe(4200, new ItemStack(
				ZollernBlocks.enderShardNetherOre, 1), new ItemStack(
				ZollernItems.enderShard, 4));
		
		// Amaranth Ore
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.amaranthOre, 1), new ItemStack(
				ZollernItems.amaranthDust, 2));
		ThermalExpansionHelper.addPulverizerRecipe(4200, new ItemStack(
				ZollernBlocks.amaranthNetherOre, 1), new ItemStack(
				ZollernItems.amaranthDust, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5200, new ItemStack(
				ZollernBlocks.enderAmaranthOre, 1), new ItemStack(
				ZollernItems.amaranthDust, 8));
		
		// Zinc Ore
		ThermalExpansionHelper.addPulverizerRecipe(4500, new ItemStack(
				ZollernBlocks.zincOre, 1), new ItemStack(ZollernItems.zincDust,
				2));
		ThermalExpansionHelper.addPulverizerRecipe(5500, new ItemStack(
				ZollernBlocks.zincNetherOre, 1), new ItemStack(
				ZollernItems.zincDust, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5500, new ItemStack(
				ZollernBlocks.enderZincOre, 1), new ItemStack(
				ZollernItems.zincDust, 4));
		
		// Steel Ore
		ThermalExpansionHelper.addPulverizerRecipe(6500, new ItemStack(
				ZollernBlocks.steelOre, 1), new ItemStack(
				ZollernItems.steelDust, 2));
		
		/**
		 * Ingots
		 */
		
		// Amaranth Ingot
		ThermalExpansionHelper.addPulverizerRecipe(1500, new ItemStack(
				ZollernItems.amaranthIngot, 1), new ItemStack(
				ZollernItems.amaranthDust, 1));
		
		// Zinc Ingot
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				ZollernItems.zincIngot, 1), new ItemStack(
				ZollernItems.zincDust, 1));
		
		// Shinium Ingot (since apparently the Crushers are stupid..)
		ThermalExpansionHelper.addPulverizerRecipe(1000, new ItemStack(
				ZollernItems.shiniumIngot, 1), new ItemStack(
				ZollernItems.shiniumDust, 1));
		
		// Fueltonium Ingot
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				ZollernItems.ingotFueltonium, 1), new ItemStack(
				ZollernItems.fuelonite, 1));
		
		// Lapis Ingot
		ThermalExpansionHelper.addPulverizerRecipe(1000, new ItemStack(
				ZollernItems.lapisIngot, 1), new ItemStack(Items.dye, 1, 4));
		
		// Steel Ingot
		ThermalExpansionHelper.addPulverizerRecipe(2000, new ItemStack(
				ZollernItems.steelIngot, 1), new ItemStack(
				ZollernItems.steelDust));
		
		/**
		 * Other
		 */
		
		// Wheat
		ThermalExpansionHelper.addPulverizerRecipe(1000,
				new ItemStack(Item.getItemById(296), 1), new ItemStack(
						ZollernItems.flour, 2));
		
		// Shinestone Block
		ThermalExpansionHelper.addPulverizerRecipe(1500, new ItemStack(
				ZollernBlocks.shinestone, 1), new ItemStack(
				ZollernItems.shinedust, 4));
		
		// Shinestone Ingot
		ThermalExpansionHelper.addPulverizerRecipe(500, new ItemStack(
				ZollernItems.shinestoneIngot, 1), new ItemStack(
				ZollernItems.shinedust, 1));
		
		// Obsidian Dust
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				Blocks.obsidian, 1),
				new ItemStack(ZollernItems.obsidianDust, 8));
	}
}