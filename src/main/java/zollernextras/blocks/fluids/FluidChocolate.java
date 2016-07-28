package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.lib.ZollernModInfo;

public class FluidChocolate extends Fluid {
	
	public FluidChocolate(String fluidName) {
		super(fluidName);
		this.setDensity(80);
		this.setViscosity(400);
		this.setLuminosity(4);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_chocolate");
		this.setGaseous(true);
		this.setTemperature(50);
		this.rarity = rarity.common;
		FluidRegistry.registerFluid(this);
	}
}