package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class CaveMarble extends Block {
	public CaveMarble(String strName) {
		super(Material.iron);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strName);
		this.setHardness(1.0F);
		this.setResistance(4.9F);
		this.setStepSound(Block.soundTypeMetal);
		this.setHarvestLevel("pickaxe", 2);
	}
}