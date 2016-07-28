package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.lib.ZollernModInfo;

public class FluidChargium extends Fluid {
	
	public FluidChargium(String fluidName) {
		super(fluidName);
		this.setDensity(180);
		this.setViscosity(800);
		this.setLuminosity(20);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_chargium");
		this.setGaseous(true);
		this.setTemperature(100);
		this.rarity = rarity.rare;
		FluidRegistry.registerFluid(this);
	}
}