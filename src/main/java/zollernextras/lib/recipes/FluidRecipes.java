package zollernextras.lib.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.UniversalBucket;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.blocks.fluid.ZollernFluids;
import zollernextras.items.ZollernItems;
import cofh.api.util.ThermalExpansionHelper;

public class FluidRecipes {
	
	public static void init() {
		CrucibleRecipes.init();
		TransposerRecipes.init();
	}
	
	static class CrucibleRecipes {
		public static void init() {
			// Molten Fueltonium
			// Ingot
			ThermalExpansionHelper.addCrucibleRecipe(3600, new ItemStack(
					ZollernItems.fueltoniumIngot, 1), new FluidStack(
					ZollernFluids.fluidFueltonium, 1000));
			// Block
			ThermalExpansionHelper.addCrucibleRecipe(7200, new ItemStack(
					ZollernBlocks.fueltoniumBlock, 1), new FluidStack(
					ZollernFluids.fluidFueltonium, 9000));
			
			// Chargium
			// Ingot
			ThermalExpansionHelper.addCrucibleRecipe(5000, new ItemStack(
					ZollernItems.superChargedCoal, 1), new FluidStack(
					ZollernFluids.fluidChargium, 500));
			// Block
			ThermalExpansionHelper.addCrucibleRecipe(10000, new ItemStack(
					ZollernBlocks.superChargedCoalBlock, 1), new FluidStack(
					ZollernFluids.fluidChargium, 4500));
		}
	}
	
	static class TransposerRecipes {
		public static void init() {
			// Molten Fueltonium
			ThermalExpansionHelper.addTransposerFill(3600, new ItemStack(
					Items.BUCKET, 1), UniversalBucket.getFilledBucket(
					ForgeModContainer.getInstance().universalBucket,
					ZollernFluids.fluidFueltonium), new FluidStack(
					ZollernFluids.fluidFueltonium, 2000), true);
			
			// Conductive Chargium
			ThermalExpansionHelper.addTransposerFill(4200, new ItemStack(
					Items.BUCKET, 1), UniversalBucket.getFilledBucket(
					ForgeModContainer.getInstance().universalBucket,
					ZollernFluids.fluidChargium), new FluidStack(
					ZollernFluids.fluidChargium, 1000), true);
		}
	}
}