package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class AmaranthBlock extends Block {
	public AmaranthBlock() {
		super(Material.iron);
		MainHelper.setTab(this);
		MainHelper.setHardResist(this, 3.0F, 6.0F);
		MainHelper.setNameAndTexture(this, "amaranthblock");
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
	}
}