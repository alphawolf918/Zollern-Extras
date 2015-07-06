package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class IcySandstone extends Block {
	public IcySandstone() {
		super(Material.sand);
		M.setTab(this);
		M.setNameAndTexture(this, "icysandstone", "coldsandsmooth");
		this.setResistance(2F);
		this.setHardness(2F);
	}
}