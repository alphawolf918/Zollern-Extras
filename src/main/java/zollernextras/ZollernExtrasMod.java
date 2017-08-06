package zollernextras;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import zollernextras.biomes.BiomeList;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.handlers.Handlers;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.lib.recipes.RecipeManager;
import zollernextras.proxies.CommonProxy;
import zollernextras.proxies.IProxy;
import zollernextras.util.ZollernRegistry;

@Mod(modid = ZollernModInfo.modId, version = ZollernModInfo.modVersion,
		name = ZollernModInfo.name)
public class ZollernExtrasMod {
	
	@SidedProxy(clientSide = ZollernModInfo.proxyClient,
			serverSide = ZollernModInfo.proxyServer)
	public static IProxy proxy;
	
	@Mod.Instance(ZollernModInfo.modId)
	private static ZollernExtrasMod INSTANCE;
	
	public static SimpleNetworkWrapper snw;
	
	public static int modGuiIndex = 10;
	public static final int QUIVER_INV = modGuiIndex++;
	
	public static ZollernExtrasMod instance() {
		return INSTANCE;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		snw = NetworkRegistry.INSTANCE.newSimpleChannel(ZollernModInfo.channel);
		ModHelperBase.detectMods();
		Handlers.init();
		ZollernTabs.init();
		ZEConfig.init(event);
		ZollernRegistry.registerAll(event);
		BiomeList.init();
		instance().proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		instance().proxy.init(event);
		RecipeManager.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		instance().proxy.postInit(event);
		if (ZEConfig.biomeDisplaysOnHUD) {
			instance().proxy.initGUI();
		}
	}
}