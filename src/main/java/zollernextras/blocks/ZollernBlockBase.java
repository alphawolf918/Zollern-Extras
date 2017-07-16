package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ZollernBlockBase extends Block {
	
	public ZollernBlockBase(Material materialIn, float hardResist) {
		super(materialIn);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
	}
	
	// @Override
	// @SideOnly(Side.CLIENT)
	// public CreativeTabs getCreativeTabToDisplayOn() {
	//
	// }
}