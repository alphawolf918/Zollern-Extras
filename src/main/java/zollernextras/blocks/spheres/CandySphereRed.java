package zollernextras.blocks.spheres;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollernextras.blocks.tiles.TECandySphereRed;

public class CandySphereRed extends CandySphereBase {
	public CandySphereRed() {
		super("red");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TECandySphereRed();
	}
}