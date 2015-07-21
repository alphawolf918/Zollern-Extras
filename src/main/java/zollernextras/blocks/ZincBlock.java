package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class ZincBlock extends Block {
	public ZincBlock() {
		super(Material.iron);
		MainHelper.setTab(this);
		this.setHardness(3.0F);
		this.setResistance(8.0F);
		MainHelper.setNameAndTexture(this, "zincblock");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}
}