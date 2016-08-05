package zollernextras.blocks;

import net.minecraft.block.material.Material;

public class GemBlock extends GenericBlock {
	
	public GemBlock(String strTexture) {
		super(strTexture, 1.2F);
		this.setResistance(2F);
		this.setMaterial(Material.iron);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 2);
	}
}