package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.lib.ModInfo;

public class FluidChocolate extends Fluid {
	
	public FluidChocolate(String fluidName) {
		super(fluidName);
		this.setDensity(80);
		this.setViscosity(400);
		this.setLuminosity(4);
		this.setUnlocalizedName(ModInfo.MODID + "_chocolate");
		this.setGaseous(true);
		this.setTemperature(50);
		this.rarity = rarity.common;
		FluidRegistry.registerFluid(this);
	}
}