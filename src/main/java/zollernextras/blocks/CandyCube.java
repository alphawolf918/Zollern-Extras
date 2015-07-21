package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class CandyCube extends Block {
	public CandyCube(String strTexture) {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "candycube_" + strTexture);
		setHardness(1.6F);
		setResistance(0.2F);
		setStepSound(soundTypeStone);
		setLightLevel(0.6F);
	}
}