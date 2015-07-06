package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class ZincBlock extends Block {
	public ZincBlock() {
		super(Material.iron);
		M.setTab(this);
		this.setHardness(3.0F);
		this.setResistance(8.0F);
		M.setNameAndTexture(this, "zincblock");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}
}