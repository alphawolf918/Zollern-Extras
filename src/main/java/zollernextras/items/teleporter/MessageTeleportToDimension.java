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
import net.minecraftforge.fml.common.FMLCommonHandler;
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
	
	public static class TeleportHandler implements
			IMessageHandler<MessageTeleportToDimension, IMessage> {
		
		@Override
		public synchronized IMessage onMessage(MessageTeleportToDimension message,
				MessageContext ctx) {
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler)
					.addScheduledTask(() -> this.teleportPlayer(message, ctx));
			return message;
		}
		
		public static void teleportPlayer(MessageTeleportToDimension message, MessageContext ctx) {
			Entity ent = ctx.getServerHandler().playerEntity.getEntityWorld().getEntityByID(
					message.id);
			if (ent instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) ent;
				int x = (int) player.posX;
				int y = (int) player.posY;
				int z = (int) player.posZ;
				int dim = message.dim;
				MinecraftServer server = player.getEntityWorld().getMinecraftServer();
				WorldServer worldServ = server.worldServerForDimension(dim);
				MinecraftServer serverWorld = worldServ.getMinecraftServer();
				PlayerList playerList = serverWorld.getPlayerList();
				CustomTeleporter custTel = new CustomTeleporter(worldServ, x, y, z);
				player.setPositionAndUpdate(x, y, z);
				playerList.transferPlayerToDimension(player, dim, custTel);
				worldServ.updateEntityWithOptionalForce(player, false);
				player.addExperienceLevel(0);
				
				World worldObj = player.world;
				
				Block blockAir = Blocks.AIR;
				Block blockStone = Blocks.STONE;
				
				IBlockState airState = blockAir.getDefaultState();
				IBlockState stoneState = blockStone.getDefaultState();
				
				if (worldObj.getBlockState(new BlockPos(x, y - 1, z)) == airState) {
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
				
				player.fallDistance = 0.0f;
			}
		}
	}
}