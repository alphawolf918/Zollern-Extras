package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class CanyonRock extends Block {
	public CanyonRock() {
		super(Material.rock);
		MainHelper.setTab(this);
		this.setHardness(1.4F);
		this.setResistance(9.9F);
		MainHelper.setNameAndTexture(this, "canyonrock");
		this.setStepSound(soundTypeStone);
	}
}