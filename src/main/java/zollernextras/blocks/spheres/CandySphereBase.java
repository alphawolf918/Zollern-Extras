package zollernextras.blocks.spheres;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollernextras.blocks.tiles.TESphereBase;
import zollernextras.lib.MainHelper;

public class CandySphereBase extends BlockContainer {
	
	private float boundingBoxMaxY = 0.4F;
	
	public CandySphereBase(String strTexture) {
		super(Material.piston);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "bowlingpin");
		this.setHardness(0.6F);
		this.setResistance(0.4F);
		this.setBlockBounds(0.125F, 0.0F, 0.125F, 1.0F - 0.125F,
				boundingBoxMaxY, 1.0F - 0.125F);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y,
			int z, int side) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TESphereBase();
	}
}