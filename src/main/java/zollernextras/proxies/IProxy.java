package zollernextras.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zollernextras.blocks.fluid.IZollernModelRegister;

public interface IProxy {
	
	public void preInit(FMLPreInitializationEvent event);
	
	public void init(FMLInitializationEvent event);
	
	public void postInit(FMLPostInitializationEvent event);
	
	public void initGUI();
	
	public boolean addIModelRegister(IZollernModelRegister register);
	
	public void doPotionEffect(EntityPlayer player, Potion potionId);
	
	public void sendChatMessage(EntityPlayer player, String message);
}