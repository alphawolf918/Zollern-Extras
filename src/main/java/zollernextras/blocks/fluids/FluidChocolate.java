package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidChocolate extends Fluid {
	
	public FluidChocolate(String fluidName) {
		super(fluidName);
		this.setDensity(80);
		this.setViscosity(400);
		this.setLuminosity(4);
		this.setUnlocalizedName("chocolate");
		this.setGaseous(true);
		this.setTemperature(50);
		this.rarity = rarity.common;
		FluidRegistry.registerFluid(this);
	}
}