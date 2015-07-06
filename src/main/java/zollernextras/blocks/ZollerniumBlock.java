package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class ZollerniumBlock extends Block {
	public ZollerniumBlock() {
		super(Material.iron);
		M.setTab(this);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		M.setNameAndTexture(this, "zollerniumblock");
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypeMetal);
	}
}