package zollernextras.blocks.tiles;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyConnection;

public class TileEntityEnergyTestBlock extends TileEntity implements
		IEnergyConnection {
	
	public TileEntityEnergyTestBlock() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}
	
}