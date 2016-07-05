package zollernextras.blocks.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialFueltonium extends MaterialLiquid {
	
	public MaterialFueltonium(MapColor mapColor) {
		super(mapColor);
		// this.setNoPushMobility();
	}
	
	@Override
	public boolean getCanBurn() {
		return false;
	}
	
	@Override
	public boolean isOpaque() {
		return true;
	}
	
}