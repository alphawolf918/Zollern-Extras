package zollernextras.lib.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import zollernextras.api.recipe.RecipeHelper;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;

public class RecipeManager {
	
	public static void init() {
		Crafting.init();
		Smelting.init();
		PulverizerRecipes.init();
		InductionSmelterRecipes.init();
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
		}
		
	}
	
}