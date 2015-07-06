package zollernextras.blocks;

import net.minecraft.block.material.Material;

public class Prismarine extends GenericBlock {
	public Prismarine() {
		super("prismarine", 0F);
		this.setHardness(1.2F);
		this.setResistance(0.3F);
		this.setMaterial(Material.rock);
		this.setStepSound(this.soundTypeStone);
		this.harvestLevel = 1;
	}
}