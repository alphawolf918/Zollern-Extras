package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class ZollerniumBlock extends Block {
	public ZollerniumBlock() {
		super(Material.iron);
		ZollernHelper.setTab(this);
		this.setHardness(1.3F);
		this.setResistance(10.0F);
		ZollernHelper.setNameAndTexture(this, "zollerniumblock");
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypeMetal);
	}
}