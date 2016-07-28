package zollernextras.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import zollernextras.items.teleporter.MessageTeleportToDimension;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.network.server.OpenGuiMessage;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketDispatcher {
	
	private static byte packetId = 0;
	
	/**
	 * The SimpleNetworkWrapper instance is used both to register and send
	 * packets. Since I will be adding wrapper methods, this field is private,
	 * but you should make it public if you plan on using it directly.
	 */
	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE
			.newSimpleChannel(ZollernModInfo.MODID);
	
	/**
	 * Call this during pre-init or loading and register all of your packets
	 * (messages) here
	 */
	public static final void registerPackets() {
		
		MainHelper.Log("Registering packets..");
		
		// Packets handled on CLIENT
		registerMessage(SyncPlayerPropsMessage.class);
		
		// Packets handled on SERVER
		registerMessage(OpenGuiMessage.class);
		
		// Nether Eye Teleport Message
		PacketDispatcher.dispatcher.registerMessage(
				MessageTeleportToDimension.TeleportHandler.class,
				MessageTeleportToDimension.class, 1, Side.SERVER);
		
		MainHelper.Log("Packets regsitered.");
	}
	
	public static SimpleNetworkWrapper getSimpleNetworkWrapper() {
		return PacketDispatcher.dispatcher;
	}
	
	/**
	 * Registers an {@link AbstractMessage} to the appropriate side(s)
	 */
	private static final <T extends AbstractMessage<T> & IMessageHandler<T, IMessage>> void registerMessage(
			Class<T> clazz) {
		if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz,
					packetId++, Side.CLIENT);
		} else if (AbstractMessage.AbstractServerMessage.class
				.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz,
					packetId++, Side.SERVER);
		} else {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId,
					Side.CLIENT);
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz,
					packetId++, Side.SERVER);
		}
	}
	
	/**
	 * Send this message to the specified player's client-side counterpart. See
	 * {@link SimpleNetworkWrapper#sendTo(IMessage, EntityPlayerMP)}
	 */
	public static final void sendTo(IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(message, player);
	}
	
	/**
	 * Send this message to everyone. See
	 * {@link SimpleNetworkWrapper#sendToAll(IMessage)}
	 */
	public static void sendToAll(IMessage message) {
		PacketDispatcher.dispatcher.sendToAll(message);
	}
	
	/**
	 * Send this message to everyone within a certain range of a point. See
	 * {@link SimpleNetworkWrapper#sendToAllAround(IMessage, NetworkRegistry.TargetPoint)}
	 */
	public static final void sendToAllAround(IMessage message,
			NetworkRegistry.TargetPoint point) {
		PacketDispatcher.dispatcher.sendToAllAround(message, point);
	}
	
	/**
	 * Sends a message to everyone within a certain range of the coordinates in
	 * the same dimension. Shortcut to
	 * {@link SimpleNetworkWrapper#sendToAllAround(IMessage, NetworkRegistry.TargetPoint)}
	 */
	public static final void sendToAllAround(IMessage message, int dimension,
			double x, double y, double z, double range) {
		PacketDispatcher.sendToAllAround(message,
				new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}
	
	/**
	 * Sends a message to everyone within a certain range of the player
	 * provided. Shortcut to
	 * {@link SimpleNetworkWrapper#sendToAllAround(IMessage, NetworkRegistry.TargetPoint)}
	 */
	public static final void sendToAllAround(IMessage message,
			EntityPlayer player, double range) {
		PacketDispatcher.sendToAllAround(message,
				player.worldObj.provider.dimensionId, player.posX, player.posY,
				player.posZ, range);
	}
	
	/**
	 * Send this message to everyone within the supplied dimension. See
	 * {@link SimpleNetworkWrapper#sendToDimension(IMessage, int)}
	 */
	public static final void sendToDimension(IMessage message, int dimensionId) {
		PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
	}
	
	/**
	 * Send this message to the server. See
	 * {@link SimpleNetworkWrapper#sendToServer(IMessage)}
	 */
	public static final void sendToServer(IMessage message) {
		PacketDispatcher.dispatcher.sendToServer(message);
	}
}
