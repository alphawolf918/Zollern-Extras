package zollernextras;

import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BlockList;
import zollernextras.command.Commands;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ModTabs;
import zollernextras.handlers.Handlers;
import zollernextras.items.ItemList;
import zollernextras.lib.M;
import zollernextras.lib.OreDict;
import zollernextras.lib.Recipes;
import zollernextras.lib.Reference;
import zollernextras.mobs.Mobs;
import zollernextras.network.PacketDispatcher;
import zollernextras.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME,
		version = Reference.VERSION)
public class ZollernExtrasMod {
	
	@Mod.Instance(Reference.MODID)
	public static ZollernExtrasMod INSTANCE;
	
	@SidedProxy(clientSide = Reference.PROXY_LOCATION + ".ClientProxy",
			serverSide = Reference.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static int modGuiIndex = 10;
	public static final int QUIVER_INV = modGuiIndex++,
			BACKPACK_INV = modGuiIndex + 2;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		M.Log("Beginning to load Zollern Extras...");
		ModTabs.init();
		ZEConfig.init(event);
		ItemList.init();
		BlockList.init();
		Mobs.init();
		PacketDispatcher.registerPackets();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initRenderers();
		BiomeList.init();
		Recipes.init();
		Handlers.init();
		OreDict.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ZEConfig.biomeDisplaysOnHUD) {
			proxy.initGUI();
		}
		M.Log("Loaded Zollern Extras successfully!");
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		Commands.init(event);
		M.Log("Commands loaded.");
	}
}