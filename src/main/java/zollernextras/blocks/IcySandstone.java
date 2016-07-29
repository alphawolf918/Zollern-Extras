package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class IcySandstone extends Block {
	public IcySandstone() {
		super(Material.sand);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "icysandstone", "coldsandsmooth");
		this.setResistance(2F);
		this.setHardness(1.5F);
		this.setHarvestLevel("pickaxe", 0);
	}
}