package zollernextras;

import java.io.File;
import net.minecraft.init.Items;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BlockList;
import zollernextras.command.Commands;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ModTabs;
import zollernextras.entity.EntityDuckEgg;
import zollernextras.handlers.FuelHandlers;
import zollernextras.handlers.Handlers;
import zollernextras.items.ItemList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
import zollernextras.lib.OreDict;
import zollernextras.lib.Recipes;
import zollernextras.lib.modhelper.TreeCapHelper;
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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class ZollernExtrasMod {
	
	@Mod.Instance(ModInfo.MODID)
	public static ZollernExtrasMod INSTANCE;
	
	public static File filePath;
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static int modGuiIndex = 10;
	public static final int QUIVER_INV = modGuiIndex++,
			BACKPACK_INV = modGuiIndex + 1;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MainHelper.Log("Beginning to load Zollern Extras...");
		this.filePath = MainHelper.getFilePath(event);
		ModTabs.init();
		ZEConfig.init(event);
		ItemList.init();
		Items.saddle.setMaxStackSize(64);
		Items.ender_pearl.setMaxStackSize(64);
		BlockList.init();
		TreeCapHelper.init();
		Mobs.init();
		PacketDispatcher.registerPackets();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initRenderers();
		EntityRegistry.registerModEntity(EntityDuckEgg.class, "DuckEgg", 1,
				INSTANCE, 64, 20, true);
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
		GameRegistry.registerFuelHandler(new FuelHandlers());
		MainHelper.Log("Loaded Zollern Extras successfully!");
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		Commands.init(event);
		MainHelper.Log("Commands loaded.");
	}
}