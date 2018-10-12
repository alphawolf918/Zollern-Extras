package zollernextras.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import zollernextras.blocks.fluid.IZollernModelRegister;

public class CommonProxy implements IProxy, IGuiHandler {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@Override
	public void initGUI() {
		
	}
	
	public Minecraft getMinecraft() {
		return null;
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		
	}
	
	@Override
	public void doPotionEffect(EntityPlayer player, Potion potionId) {
		
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		return null;
	}
	
	@Override
	public boolean addIModelRegister(IZollernModelRegister register) {
		return false;
	}
}