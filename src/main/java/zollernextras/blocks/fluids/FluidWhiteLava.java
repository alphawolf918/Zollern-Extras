package zollernextras.blocks.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollernextras.lib.ZollernModInfo;

public class FluidWhiteLava extends Fluid {
	
	public FluidWhiteLava(String fluidName) {
		super(fluidName);
		this.setDensity(200);
		this.setViscosity(800);
		this.setLuminosity(100);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_whitelava");
		this.setGaseous(true);
		this.setTemperature(200);
		this.rarity = rarity.epic;
		FluidRegistry.registerFluid(this);
	}
}