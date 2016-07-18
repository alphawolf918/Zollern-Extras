package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class GemBlock extends Block {
	public GemBlock(String strTexture) {
		super(Material.iron);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
		this.setResistance(2F);
		this.setHardness(1.2F);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 2);
	}
}