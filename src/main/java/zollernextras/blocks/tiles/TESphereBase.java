package zollernextras.blocks.tiles;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollernextras.blocks.spheres.CandySphereBase;

public class TESphereBase extends TileEntity {
	private int facing;
	
	public int getFacing() {
		return this.facing;
	}
	
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	@Override
	public boolean shouldRefresh(Block oldBlock, Block newBlock, int oldMeta,
			int newMeta, World world, int x, int y, int z) {
		return !(newBlock instanceof CandySphereBase);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	@Override
	public void onDataPacket(NetworkManager net,
			S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		facing = nbttagcompound.getInteger("facing");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setInteger("facing", facing);
	}
}
