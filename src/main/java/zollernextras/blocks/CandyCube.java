package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class CandyCube extends Block {
	public CandyCube(String strTexture) {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "candycube_" + strTexture);
		setHardness(1.0F);
		setResistance(0.2F);
		setStepSound(soundTypeStone);
		setLightLevel(0.4F);
		this.setHarvestLevel("pickaxe", 0);
	}
}