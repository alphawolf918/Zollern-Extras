package zollernextras.items.teleporter;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageTeleportToDimension implements IMessage {
	
	int dim;
	int id;
	
	public MessageTeleportToDimension() {
	}
	
	public MessageTeleportToDimension(int dim, int id) {
		this.dim = dim;
		this.id = id;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.dim = buf.readInt();
		this.id = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.dim);
		buf.writeInt(this.id);
	}
	
	// Used to be, we would do mcServer.getConfigurationManager(). That no
	// longer exists. This is, as far as I know, the only way to call the
	// transferPlayerToDimension method. There's the player.changeDimension, but
	// that assumes that they're in a portal so it causes a crash. This
	// teleports them there, then crashes with a ConcurrentModificationException
	// in the tick() method in WorldServer when it tries to update. Even the
	// blocks place properly. From what I understand about this Exception, it
	// occurs when something is trying to access a thing that something else is
	// already iterating over. I've scoured the web and can't seem to find
	// anything on this.
	// AbstractMessage and PacketDispatcher live under the networks folder, and
	// CustomTeleporter and MessageTeleportToDimension live in items.teleporter.
	public class TeleportHandler implements IMessageHandler<MessageTeleportToDimension, IMessage> {
		@Override
		public IMessage onMessage(MessageTeleportToDimension message, MessageContext ctx) {
			Entity ent = ctx.getServerHandler().playerEntity.getEntityWorld().getEntityByID(
					message.id);
			if (ent instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) ent;
				int x = (int) player.posX;
				int y = (int) player.posY;
				int z = (int) player.posZ;
				int dim = message.dim;
				synchronized (this) {
					MinecraftServer server = player.getEntityWorld().getMinecraftServer();
					WorldServer worldServ = server.worldServerForDimension(dim);
					MinecraftServer serverWorld = worldServ.getMinecraftServer();
					PlayerList playerList = serverWorld.getPlayerList();
					CustomTeleporter custTel = new CustomTeleporter(worldServ, x, y, z);
					playerList.transferPlayerToDimension(player, dim, custTel);
				}
				player.setPositionAndUpdate(x, y, z);
				player.addExperienceLevel(0);
				
				// This part works fine, no issues here.
				World worldObj = player.world;
				
				Block blockAir = Blocks.AIR;
				Block blockStone = Blocks.STONE;
				
				IBlockState airState = blockAir.getDefaultState();
				IBlockState stoneState = blockStone.getDefaultState();
				
				if (worldObj.getBlockState(new BlockPos(x, y - 1, z)) == blockAir) {
					worldObj.setBlockState(new BlockPos(x, y - 1, z), stoneState);
					worldObj.setBlockState(new BlockPos(x + 1, y - 1, z + 1), stoneState);
					worldObj.setBlockState(new BlockPos(x - 1, y - 1, z - 1), stoneState);
					worldObj.setBlockState(new BlockPos(x + 1, y - 1, z - 1), stoneState);
					worldObj.setBlockState(new BlockPos(x - 1, y - 1, z + 1), stoneState);
					worldObj.setBlockState(new BlockPos(x - 1, y - 1, z), stoneState);
					worldObj.setBlockState(new BlockPos(x, y - 1, z - 1), stoneState);
					worldObj.setBlockState(new BlockPos(x + 1, y - 1, z), stoneState);
					worldObj.setBlockState(new BlockPos(x, y - 1, z + 1), stoneState);
				}
				
				worldObj.setBlockState(new BlockPos(x, y, z), airState);
				worldObj.setBlockState(new BlockPos(x, y + 1, z), airState);
				
				worldObj.setBlockState(new BlockPos(x + 1, y, z + 1), airState);
				worldObj.setBlockState(new BlockPos(x + 1, y + 1, z + 1), airState);
				
				worldObj.setBlockState(new BlockPos(x - 1, y, z - 1), airState);
				worldObj.setBlockState(new BlockPos(x - 1, y + 1, z - 1), airState);
				
				worldObj.setBlockState(new BlockPos(x + 1, y, z - 1), airState);
				worldObj.setBlockState(new BlockPos(x + 1, y + 1, z - 1), airState);
				
				worldObj.setBlockState(new BlockPos(x - 1, y, z + 1), airState);
				worldObj.setBlockState(new BlockPos(x - 1, y + 1, z + 1), airState);
				
				worldObj.setBlockState(new BlockPos(x - 1, y, z), airState);
				worldObj.setBlockState(new BlockPos(x - 1, y + 1, z), airState);
				
				worldObj.setBlockState(new BlockPos(x, y, z - 1), airState);
				worldObj.setBlockState(new BlockPos(x, y + 1, z - 1), airState);
				
				worldObj.setBlockState(new BlockPos(x + 1, y, z), airState);
				worldObj.setBlockState(new BlockPos(x + 1, y + 1, z), airState);
				
				worldObj.setBlockState(new BlockPos(x, y, z + 1), airState);
				worldObj.setBlockState(new BlockPos(x, y + 1, z + 1), airState);
				
				// player.fallDistance = 0.0f;
			}
			return message;
		}
	}
}