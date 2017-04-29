package zollernextras.items.teleporter;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

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
	
	public static class TeleportHandler implements
			IMessageHandler<MessageTeleportToDimension, IMessage> {
		@Override
		public IMessage onMessage(MessageTeleportToDimension message,
				MessageContext ctx) {
			Entity ent = ctx.getServerHandler().playerEntity.worldObj
					.getEntityByID(message.id);
			if (ent instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) ent;
				player.mcServer.getConfigurationManager()
						.transferPlayerToDimension(
								player,
								message.dim,
								new CustomTeleporter(player.mcServer
										.worldServerForDimension(message.dim)));
				
				int x = (int) player.posX;
				int y = (int) player.posY;
				int z = (int) player.posZ;
				
				World worldObj = player.worldObj;
				Block blockAir = Blocks.air;
				
				if (worldObj.getBlock(x, y - 1, z) == blockAir) {
					worldObj.setBlock(x, y - 1, z, Blocks.stone);
					worldObj.setBlock(x + 1, y - 1, z + 1, Blocks.stone);
					worldObj.setBlock(x - 1, y - 1, z - 1, Blocks.stone);
					worldObj.setBlock(x + 1, y - 1, z - 1, Blocks.stone);
					worldObj.setBlock(x - 1, y - 1, z + 1, Blocks.stone);
					worldObj.setBlock(x - 1, y - 1, z, Blocks.stone);
					worldObj.setBlock(x, y - 1, z - 1, Blocks.stone);
					worldObj.setBlock(x + 1, y - 1, z, Blocks.stone);
					worldObj.setBlock(x, y - 1, z + 1, Blocks.stone);
				}
				
				worldObj.setBlock(x, y, z, blockAir);
				worldObj.setBlock(x, y + 1, z, blockAir);
				
				worldObj.setBlock(x + 1, y, z + 1, blockAir);
				worldObj.setBlock(x + 1, y + 1, z + 1, blockAir);
				
				worldObj.setBlock(x - 1, y, z - 1, blockAir);
				worldObj.setBlock(x - 1, y + 1, z - 1, blockAir);
				
				worldObj.setBlock(x + 1, y, z - 1, blockAir);
				worldObj.setBlock(x + 1, y + 1, z - 1, blockAir);
				
				worldObj.setBlock(x - 1, y, z + 1, blockAir);
				worldObj.setBlock(x - 1, y + 1, z + 1, blockAir);
				
				worldObj.setBlock(x - 1, y, z, blockAir);
				worldObj.setBlock(x - 1, y + 1, z, blockAir);
				
				worldObj.setBlock(x, y, z - 1, blockAir);
				worldObj.setBlock(x, y + 1, z - 1, blockAir);
				
				worldObj.setBlock(x + 1, y, z, blockAir);
				worldObj.setBlock(x + 1, y + 1, z, blockAir);
				
				worldObj.setBlock(x, y, z + 1, blockAir);
				worldObj.setBlock(x, y + 1, z + 1, blockAir);
				
				player.fallDistance = 0.0f;
			}
			return message;
		}
	}
}