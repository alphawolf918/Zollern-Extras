package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class ZollerniumBlock extends Block {
	public ZollerniumBlock() {
		super(Material.iron);
		MainHelper.setTab(this);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		MainHelper.setNameAndTexture(this, "zollerniumblock");
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypeMetal);
	}
}