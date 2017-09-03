package zollernextras;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.fluid.ZollernFluids;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.dimensions.DimensionRegistry;
import zollernextras.events.ZollernSoundEvents;
import zollernextras.handlers.Handlers;
import zollernextras.lib.OreDictZo;
import zollernextras.lib.StackChanges;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.lib.recipes.RecipeManager;
import zollernextras.mobs.MobRegistry;
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
		ZEConfig.init(event);
		ZollernSoundEvents.init();
		MobRegistry.init();
		ZollernFluids.init();
		ZollernRegistry.registerAll(event);
		ZollernTabs.init();
		if (ZEConfig.enableStackChanges) {
			StackChanges.init();
		}
		FluidRegistry.enableUniversalBucket();
		instance().proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RecipeManager.init();
		BiomeList.init();
		Handlers.init();
		OreDictZo.init();
		instance().proxy.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ZEConfig.biomeDisplaysOnHUD) {
			instance().proxy.initGUI();
		}
		DimensionRegistry.postInit();
		instance().proxy.postInit(event);
	}
}