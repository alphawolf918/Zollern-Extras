package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class GemBlock extends Block {
	public GemBlock(String strTexture) {
		super(Material.iron);
		M.setTab(this);
		M.setNameAndTexture(this, strTexture);
		this.setResistance(2F);
		this.setHardness(2F);
		this.setLightLevel(0.9F);
		this.setStepSound(soundTypeMetal);
	}
}