package zollernextras.lib.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import zollernextras.blocks.BlockList;
import zollernextras.items.ItemList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class LiquidRecipes {
	
	public static void init() {
		CrucibleRecipes.init();
		MainHelper.Log("Magma cruicible recipes successfully loaded.");
		TransposerRecipes.init();
		MainHelper.Log("Fluid transposer recipes successfully loaded.");
	}
	
	public static class CrucibleRecipes {
		
		public static void init() {
			
			// Melted Chocolate
			ThermalExpansionHelper.addCrucibleRecipe(1500, new ItemStack(
					BlockList.chocolateBlock, 1), new FluidStack(
					BlockList.fluidChocolate, 800));
			
			// Molten Fueltonium
			// Ingot
			ThermalExpansionHelper.addCrucibleRecipe(3600, new ItemStack(
					ItemList.ingotFueltonium, 1), new FluidStack(
					BlockList.fluidFuel, 2000));
			// Block
			ThermalExpansionHelper.addCrucibleRecipe(7200, new ItemStack(
					BlockList.fueltoniumBlock, 1), new FluidStack(
					BlockList.fluidFuel, 18000));
			
			// Magma Block -> Lava
			ThermalExpansionHelper.addCrucibleRecipe(4000, new ItemStack(
					BlockList.magmaBlock, 1), new FluidStack(
					FluidRegistry.LAVA, 5000));
			
			// Glowing Obsidian -> Lava
			ThermalExpansionHelper.addCrucibleRecipe(4500, new ItemStack(
					BlockList.redObsidian, 1), new FluidStack(
					FluidRegistry.LAVA, 2500));
		}
	}
	
	public static class TransposerRecipes {
		
		public static void init() {
			// Melted Chocolate
			ThermalExpansionHelper.addTransposerFill(1500, new ItemStack(
					Items.bucket, 1),
					new ItemStack(ItemList.chocolateBucket, 1), new FluidStack(
							BlockList.fluidChocolate, 800), true);
			
			// Molten Fueltonium
			ThermalExpansionHelper.addTransposerFill(3600, new ItemStack(
					Items.bucket, 1), new ItemStack(ItemList.fuelBucket, 1),
					new FluidStack(BlockList.fluidFuel, 2000), true);
		}
		
	}
	
}