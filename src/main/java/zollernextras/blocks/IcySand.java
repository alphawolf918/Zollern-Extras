package zollernextras.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class IcySand extends BlockFalling {
	public IcySand() {
		super(Material.sand);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "icysand", "coldsand");
		this.setResistance(1F);
		this.setHardness(1F);
		this.setStepSound(soundTypeSand);
		this.setHarvestLevel("shovel", 1);
	}
}