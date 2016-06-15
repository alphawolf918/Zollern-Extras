package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class IcySandstone extends Block {
	public IcySandstone() {
		super(Material.sand);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "icysandstone", "coldsandsmooth");
		this.setResistance(2F);
		this.setHardness(1.5F);
		this.setHarvestLevel("pickaxe", 0);
	}
}