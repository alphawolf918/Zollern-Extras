package zollernextras.blocks.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.ZollernExtrasMod;
import zollernextras.lib.ZollernModInfo;

public class ZollernFluids {
	
	public static Fluid fluidChargium;
	public static ChargiumLiquidBlock blockChargiumFluid;
	
	public static Fluid fluidFueltonium;
	public static FueltoniumLiquidBlock blockFueltoniumFluid;
	
	public static void init() {
		registerFluids();
		registerFluidBlocks();
		addBuckets();
		refreshReferences();
		
		blockChargiumFluid.init();
		blockFueltoniumFluid.init();
	}
	
	public static void registerFluids() {
		fluidChargium = new Fluid("chargium", new ResourceLocation(
				ZollernModInfo.modId, "blocks/chargiumfluid"),
				new ResourceLocation(ZollernModInfo.modId,
						"blocks/chargiumfluid"));
		fluidFueltonium = new Fluid("fueltonium", new ResourceLocation(
				ZollernModInfo.modId, "blocks/fuel"), new ResourceLocation(
				ZollernModInfo.modId, "blocks/fuel"));
		
		FluidRegistry.registerFluid(fluidChargium);
		FluidRegistry.registerFluid(fluidFueltonium);
	}
	
	public static void registerFluidBlocks() {
		blockChargiumFluid = new ChargiumLiquidBlock(fluidChargium);
		blockFueltoniumFluid = new FueltoniumLiquidBlock(fluidFueltonium);
		
		ZollernExtrasMod.proxy.addIModelRegister(blockChargiumFluid);
		ZollernExtrasMod.proxy.addIModelRegister(blockFueltoniumFluid);
	}
	
	public static void addBuckets() {
		FluidRegistry.addBucketForFluid(fluidChargium);
		FluidRegistry.addBucketForFluid(fluidFueltonium);
	}
	
	public static void refreshReferences() {
		fluidChargium = FluidRegistry.getFluid("chargium");
		fluidFueltonium = FluidRegistry.getFluid("fueltonium");
	}
}