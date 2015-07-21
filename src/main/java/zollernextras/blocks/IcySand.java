package zollernextras.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class IcySand extends BlockFalling {
	public IcySand() {
		super(Material.sand);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "icysand", "coldsand");
		this.setResistance(1F);
		this.setHardness(1F);
		this.setStepSound(soundTypeSand);
		this.setHarvestLevel("shovel", 1);
	}
}