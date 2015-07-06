package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import zollernextras.lib.M;

public class Brimstone extends Block {
	public Brimstone() {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "brimstone");
		this.setHardness(4.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypeStone);
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z,
			ForgeDirection side) {
		return true;
	}
}