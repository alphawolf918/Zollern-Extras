package zollernextras.blocks.lostdesert;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class WonderSand extends BlockFalling {
	public WonderSand() {
		super(Material.sand);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "wondersand");
		this.setResistance(1F);
		this.setHardness(1F);
		this.setStepSound(soundTypeSand);
		this.setHarvestLevel("shovel", 2);
	}
}