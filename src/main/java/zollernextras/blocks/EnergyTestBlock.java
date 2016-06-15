package zollernextras.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollernextras.blocks.tiles.TileEntityEnergyTestBlock;
import zollernextras.lib.MainHelper;

public class EnergyTestBlock extends GenericBlock implements
		ITileEntityProvider {
	
	public EnergyTestBlock(String strTexture) {
		super(strTexture, 2.0F);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityEnergyTestBlock();
	}
}