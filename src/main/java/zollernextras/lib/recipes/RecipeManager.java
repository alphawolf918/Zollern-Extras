package zollernextras.lib.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollernextras.api.recipe.RecipeHelper;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.lib.modhelper.ModHelperBase;

public class RecipeManager {
	
	public static void init() {
		Crafting.init();
		Smelting.init();
		if (ModHelperBase.useThermalFoundation) {
			PulverizerRecipes.init();
			InductionSmelterRecipes.init();
		}
	}
	
	static class Crafting {
		
		public static void init() {
			// Super Charged Coal Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.superChargedCoalBlock,
					ZollernItems.superChargedCoal);
			
			// Amaranth Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.amaranthBlock,
					ZollernItems.amaranthIngot);
			
			// Azurite Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.azuriteBlock,
					ZollernItems.azurite);
			
			// Ender Shards -> Ender Pearl
			GameRegistry.addRecipe(new ItemStack(Items.ENDER_PEARL, 1),
					new Object[] { "EEE", "E E", "EEE", 'E',
							ZollernItems.enderShard });
			
			// Ender Pearl -> Ender Shards
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.enderShard, 8),
					new Object[] { Items.ENDER_PEARL });
			
			// Ender Pearls -> Ender Pearl Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.enderPearlBlock,
					Items.ENDER_PEARL);
			
			// Zollernium
			RecipeHelper.fullBlockCraft(ZollernBlocks.zollerniumBlock,
					ZollernItems.zollerniumIngot);
			
			// Obisidian Ingot -> Obsidian Block
			RecipeHelper.fullBlockCraft(Blocks.OBSIDIAN,
					ZollernItems.obsidianIngot);
			
			// Witherite -> Witherite Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.witheriteBlock,
					ZollernItems.witherite);
			
			// Fueltonium Ingot -> Fueltonium Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.fueltoniumBlock,
					ZollernItems.fueltoniumIngot);
			
			// Garnet -> Garnet Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.garnetBlock,
					ZollernItems.garnet);
			
			// Amber -> Amber Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.amberBlock,
					ZollernItems.amber);
			
			// Aquamarine -> Aquamarine Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.aquamarineBlock,
					ZollernItems.aquamarine);
			
			// Ruby -> Ruby Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.rubyBlock,
					ZollernItems.ruby);
			
			// Sapphire -> Sapphire Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.sapphireBlock,
					ZollernItems.sapphire);
			
			// Topaz -> Topaz Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.topazBlock,
					ZollernItems.topaz);
			
			// Opal -> Opal Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.opalBlock,
					ZollernItems.opal);
			
			// Steel Ingot -> Steel Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.steelBlock,
					ZollernItems.steelIngot);
			
			// Enderite Ingot -> Enderite Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.enderiteBlock,
					ZollernItems.enderiteIngot);
			
			// Ender Diamond -> Ender Diamond Block
			RecipeHelper.fullBlockCraft(ZollernBlocks.enderDiamondBlock,
					ZollernItems.enderDiamond);
		}
	}
	
	static class Smelting {
		
		public static void init() {
			// Rotten Flesh -> Leather
			RecipeHelper.addSmelting(Items.ROTTEN_FLESH, Items.LEATHER, 0.5F);
			
			// Amaranth Ore -> Amaranth Ingot
			RecipeHelper.addSmelting(ZollernBlocks.amaranthOre,
					ZollernItems.amaranthIngot, 1.0F);
			
			// Nether Amaranth Ore -> Amaranth Ingot
			RecipeHelper.addSmelting(ZollernBlocks.netherAmaranthOre,
					new ItemStack(ZollernItems.amaranthIngot, 2), 1.5F);
			
			// Ender Amaranth Ore -> Amaranth Ingot
			RecipeHelper.addSmelting(ZollernBlocks.enderAmaranthOre,
					new ItemStack(ZollernItems.amaranthIngot, 3), 2.0F);
			
			// Amaranth Dust -> AmaranthIngot
			RecipeHelper.addSmelting(ZollernItems.amaranthDust,
					ZollernItems.amaranthIngot, 0.5F);
			
			// Zollernium Ore -> Zollernium Ingot
			RecipeHelper.addSmelting(ZollernBlocks.zollerniumOre,
					ZollernItems.zollerniumIngot, 4.0F);
			
			// Zollernium Dust -> Zollernium Ingot
			RecipeHelper.addSmelting(ZollernItems.zollerniumDust,
					ZollernItems.zollerniumIngot, 1.2F);
			
			// Obsidian Dust -> Obsidian Ingot
			RecipeHelper.addSmelting(ZollernItems.obsidianDust,
					ZollernItems.obsidianIngot, 0.5F);
			
			// Fueltonium Dust -> Fueltonium Ingot
			RecipeHelper.addSmelting(ZollernItems.fuelonite,
					ZollernItems.fueltoniumIngot, 1.4F);
			
			// Zinc Ore -> Zinc Ingot
			RecipeHelper.addSmelting(ZollernBlocks.zincOre,
					ZollernItems.zincIngot, 1.2F);
			
			// Nether Zinc Ore -> Zinc Ingot
			RecipeHelper.addSmelting(ZollernBlocks.netherZincOre,
					new ItemStack(ZollernItems.zincIngot, 2), 1.4F);
			
			// Ender Zinc Ore -> Zinc Ingot
			RecipeHelper.addSmelting(ZollernBlocks.enderZincOre, new ItemStack(
					ZollernItems.zincIngot, 3), 1.6F);
			
			// Zinc Dust -> Zinc Ingot
			RecipeHelper.addSmelting(ZollernItems.zincDust,
					ZollernItems.zincIngot, 1.2F);
			
			// Steel Ore -> Steel Ingot
			RecipeHelper.addSmelting(ZollernBlocks.steelOre,
					ZollernItems.steelIngot, 0.6F);
			
			// Nether Steel Ore -> Steel Ingot
			RecipeHelper.addSmelting(ZollernBlocks.netherSteelOre,
					new ItemStack(ZollernItems.steelIngot, 2), 0.6F);
			
			// Ender Steel Ore -> Steel Ingot
			RecipeHelper.addSmelting(ZollernBlocks.enderSteelOre,
					new ItemStack(ZollernItems.steelIngot, 3), 0.6F);
			
			// Steel Dust -> Steel Ingot
			RecipeHelper.addSmelting(ZollernItems.steelDust,
					ZollernItems.steelIngot, 0.4F);
			
			// Enderite Ore -> Enderite Ingot
			RecipeHelper.addSmelting(ZollernBlocks.enderiteOre,
					ZollernItems.enderiteIngot, 1.2F);
			
			// Enderite Dust -> Enderite Ingot
			RecipeHelper.addSmelting(ZollernItems.enderiteDust,
					ZollernItems.enderiteIngot, 1.0F);
		}
		
	}
	
}