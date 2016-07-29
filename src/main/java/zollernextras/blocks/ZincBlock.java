package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class ZincBlock extends Block {
	public ZincBlock() {
		super(Material.iron);
		ZollernHelper.setTab(this);
		this.setHardness(1.3F);
		this.setResistance(8.0F);
		ZollernHelper.setNameAndTexture(this, "zincblock");
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
	}
}