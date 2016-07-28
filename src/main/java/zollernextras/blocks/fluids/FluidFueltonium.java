package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.lib.ZollernModInfo;

public class FluidFueltonium extends Fluid {
	
	public FluidFueltonium(String fluidName) {
		super(fluidName);
		this.setDensity(180);
		this.setViscosity(800);
		this.setLuminosity(15);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_fuel");
		this.setGaseous(true);
		this.setTemperature(100);
		this.rarity = rarity.rare;
		FluidRegistry.registerFluid(this);
	}
}