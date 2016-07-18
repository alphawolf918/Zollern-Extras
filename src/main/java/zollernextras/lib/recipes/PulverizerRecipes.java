package zollernextras.lib.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.blocks.BlockList;
import zollernextras.items.ItemList;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class PulverizerRecipes {
	public static void init() {
		
		// SPC Ore
		ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
				BlockList.spcOre, 1), new ItemStack(ItemList.spcItem, 2),
				new ItemStack(Items.coal), 30);
		ThermalExpansionHelper.addPulverizerRecipe(2600, new ItemStack(
				BlockList.spcNetherOre, 1), new ItemStack(ItemList.spcItem, 4),
				new ItemStack(Items.coal), 60);
		ThermalExpansionHelper.addPulverizerRecipe(3600, new ItemStack(
				BlockList.enderSpcOre, 1), new ItemStack(ItemList.spcItem, 8),
				new ItemStack(Items.coal), 90);
		
		// FN Ore
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				BlockList.fueltonium, 1), new ItemStack(ItemList.fuelonite, 2));
		ThermalExpansionHelper.addPulverizerRecipe(5200, new ItemStack(
				BlockList.fuelNetherOre, 1), new ItemStack(ItemList.fuelonite,
						4));
		ThermalExpansionHelper.addPulverizerRecipe(7200, new ItemStack(
				BlockList.enderFnOre, 1), new ItemStack(ItemList.fuelonite, 8));
		
		// Shard Ore
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				BlockList.enderShardOre, 1), new ItemStack(ItemList.enderShard,
						2));
		ThermalExpansionHelper.addPulverizerRecipe(4200, new ItemStack(
				BlockList.enderShardNetherOre, 1), new ItemStack(
						ItemList.enderShard, 4));
		
		// Amaranth
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				BlockList.amaranthOre, 1), new ItemStack(ItemList.amaranthDust,
						2));
		ThermalExpansionHelper.addPulverizerRecipe(4200, new ItemStack(
				BlockList.amaranthNetherOre, 1), new ItemStack(
						ItemList.amaranthDust, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5200, new ItemStack(
				BlockList.enderAmaranthOre, 1), new ItemStack(
						ItemList.amaranthDust, 8));
		
		// Zinc Ore
		ThermalExpansionHelper.addPulverizerRecipe(4500, new ItemStack(
				BlockList.zincOre, 1), new ItemStack(ItemList.zincDust, 2));
		ThermalExpansionHelper.addPulverizerRecipe(5500, new ItemStack(
				BlockList.zincNetherOre, 1),
				new ItemStack(ItemList.zincDust, 4));
		ThermalExpansionHelper
		.addPulverizerRecipe(5500, new ItemStack(
				BlockList.enderZincOre, 1), new ItemStack(
						ItemList.zincDust, 4));
		
		// Amaranth Ingot
		ThermalExpansionHelper.addPulverizerRecipe(1500, new ItemStack(
				ItemList.amaranthIngot, 1), new ItemStack(
						ItemList.amaranthDust, 1));
		
		// Zinc Ingot
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				ItemList.zincIngot, 1), new ItemStack(ItemList.zincDust, 1));
		
		// Shinium Ingot (since apparently the Crushers are stupid..)
		ThermalExpansionHelper.addPulverizerRecipe(1000, new ItemStack(
				ItemList.shiniumIngot, 1), new ItemStack(ItemList.shiniumDust,
				1));
		
		// Fueltonium Dust
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				ItemList.ingotFueltonium, 1), new ItemStack(ItemList.fuelonite,
						1));
		
		// Lapis
		ThermalExpansionHelper.addPulverizerRecipe(1000, new ItemStack(
				ItemList.lapisIngot, 1), new ItemStack(Items.dye, 1, 4));
		
		// Wheat
		ThermalExpansionHelper.addPulverizerRecipe(1000,
				new ItemStack(Item.getItemById(296), 1), new ItemStack(
						ItemList.flour, 2));
		
		// Shinestone Block
		ThermalExpansionHelper.addPulverizerRecipe(1500, new ItemStack(
				BlockList.shinestone, 1), new ItemStack(ItemList.shinedust, 4));
		
		// Shinestone Ingot
		ThermalExpansionHelper.addPulverizerRecipe(500, new ItemStack(
				ItemList.shinestoneIngot, 1), new ItemStack(ItemList.shinedust,
						1));
		
		// Obsidian Dust
		ThermalExpansionHelper.addPulverizerRecipe(2500, new ItemStack(
				Blocks.obsidian, 1), new ItemStack(ItemList.obsidianDust, 8));
	}
}