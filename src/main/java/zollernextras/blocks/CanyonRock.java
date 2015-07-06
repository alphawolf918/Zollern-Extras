package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class CanyonRock extends Block {
	public CanyonRock() {
		super(Material.rock);
		M.setTab(this);
		this.setHardness(1.4F);
		this.setResistance(9.9F);
		M.setNameAndTexture(this, "canyonrock");
		this.setStepSound(soundTypeStone);
	}
}