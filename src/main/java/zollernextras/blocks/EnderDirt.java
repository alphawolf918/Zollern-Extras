package zollernextras.blocks;

import net.minecraft.block.material.Material;

public class EnderDirt extends GenericBlock {
	
	public EnderDirt() {
		super("enderdirt", 1.4F);
		this.setMaterial(Material.grass);
		this.setStepSound(soundTypeGravel);
	}
	
}