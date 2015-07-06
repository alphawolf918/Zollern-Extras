package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class CandyCube extends Block {
	public CandyCube(String strTexture) {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "candycube_" + strTexture);
		setHardness(0.6F);
		setResistance(0.4F);
		setStepSound(soundTypeStone);
		setLightLevel(0.6F);
	}
}