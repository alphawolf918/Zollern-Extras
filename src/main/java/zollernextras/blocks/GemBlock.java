package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class GemBlock extends Block {
	public GemBlock(String strTexture) {
		super(Material.iron);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
		this.setResistance(2F);
		this.setHardness(1.2F);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 2);
	}
}