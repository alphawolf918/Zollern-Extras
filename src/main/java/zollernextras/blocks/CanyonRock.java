package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class CanyonRock extends Block {
	public CanyonRock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		this.setHardness(1.1F);
		this.setResistance(9.9F);
		ZollernHelper.setNameAndTexture(this, "canyonrock");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
}