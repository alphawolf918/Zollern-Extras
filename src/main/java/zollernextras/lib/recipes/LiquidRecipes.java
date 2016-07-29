package zollernextras.lib.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class LiquidRecipes {
	
	public static void init() {
		CrucibleRecipes.init();
		ZollernHelper.Log("Magma cruicible recipes successfully loaded.");
		TransposerRecipes.init();
		ZollernHelper.Log("Fluid transposer recipes successfully loaded.");
		FuelRecipes.init();
		ZollernHelper.Log("Reactant dynamo recipes successfully loaded.");
	}
	
	public static class CrucibleRecipes {
		
		public static void init() {
			
			// Melted Chocolate
			ThermalExpansionHelper.addCrucibleRecipe(1500, new ItemStack(
					ZollernBlocks.chocolateBlock, 1), new FluidStack(
							ZollernBlocks.fluidChocolate, 800));
			
			// Molten Fueltonium
			// Ingot
			ThermalExpansionHelper.addCrucibleRecipe(3600, new ItemStack(
					ZollernItems.ingotFueltonium, 1), new FluidStack(
							ZollernBlocks.fluidFuel, 1000));
			// Block
			ThermalExpansionHelper.addCrucibleRecipe(7200, new ItemStack(
					ZollernBlocks.fueltoniumBlock, 1), new FluidStack(
							ZollernBlocks.fluidFuel, 9000));
			
			// Magma Block -> Lava
			ThermalExpansionHelper.addCrucibleRecipe(4000, new ItemStack(
					ZollernBlocks.magmaBlock, 1), new FluidStack(
							FluidRegistry.LAVA, 5000));
			
			// Glowing Obsidian -> Lava
			ThermalExpansionHelper.addCrucibleRecipe(4500, new ItemStack(
					ZollernBlocks.redObsidian, 1), new FluidStack(
							FluidRegistry.LAVA, 2500));
			
			// Chargium
			// Ingot
			ThermalExpansionHelper.addCrucibleRecipe(5000, new ItemStack(
					ZollernItems.spcItem, 1), new FluidStack(
							ZollernBlocks.fluidChargium, 500));
			// Block
			ThermalExpansionHelper.addCrucibleRecipe(5000, new ItemStack(
					ZollernBlocks.spcBlock, 1), new FluidStack(
							ZollernBlocks.fluidChargium, 4500));
		}
	}
	
	public static class TransposerRecipes {
		
		public static void init() {
			// Melted Chocolate
			ThermalExpansionHelper.addTransposerFill(1500, new ItemStack(
					Items.bucket, 1),
					new ItemStack(ZollernItems.chocolateBucket, 1), new FluidStack(
							ZollernBlocks.fluidChocolate, 800), true);
			
			// Molten Fueltonium
			ThermalExpansionHelper.addTransposerFill(3600, new ItemStack(
					Items.bucket, 1), new ItemStack(ZollernItems.fuelBucket, 1),
					new FluidStack(ZollernBlocks.fluidFuel, 2000), true);
			
			// Conductive Chargium
			ThermalExpansionHelper.addTransposerFill(4200, new ItemStack(
					Items.bucket, 1),
					new ItemStack(ZollernItems.chargiumBucket, 1), new FluidStack(
							ZollernBlocks.fluidChargium, 1000), true);
		}
		
	}
	
	public static class FuelRecipes {
		
		public static void init() {
			// Reactant Dynamo (Molten Fueltonium)
			ThermalExpansionHelper.addReactantFuel(
					ZollernBlocks.fluidFuel.getName(), 750000);
		}
		
	}
	
}