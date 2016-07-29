package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class AmaranthBlock extends Block {
	public AmaranthBlock() {
		super(Material.iron);
		ZollernHelper.setTab(this);
		ZollernHelper.setHardResist(this, 3.0F, 6.0F);
		ZollernHelper.setNameAndTexture(this, "amaranthblock");
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
	}
}