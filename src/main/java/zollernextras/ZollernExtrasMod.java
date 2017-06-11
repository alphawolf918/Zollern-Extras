package zollernextras;

import java.io.File;
import zollernextras.achievements.ZollernAchievements;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.command.Commands;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ModTabs;
import zollernextras.dimension.DimensionLoader;
import zollernextras.enchantments.EnchantmentList;
import zollernextras.entity.EntityDuckEgg;
import zollernextras.handlers.FuelHandlers;
import zollernextras.handlers.Handlers;
import zollernextras.items.StackChange;
import zollernextras.items.ZollernItems;
import zollernextras.lib.OreDict;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.modhelper.AE2Helper;
import zollernextras.lib.modhelper.BRTurbineHelper;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.lib.modhelper.TreeCapHelper;
import zollernextras.lib.recipes.RecipeManager;
import zollernextras.mobs.Mobs;
import zollernextras.network.PacketDispatcher;
import zollernextras.potions.ZollernPotion;
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

@Mod(modid = ZollernModInfo.MODID, name = ZollernModInfo.NAME,
		version = ZollernModInfo.VERSION)
public class ZollernExtrasMod {
	
	@Mod.Instance(ZollernModInfo.MODID)
	public static ZollernExtrasMod INSTANCE;
	
	public static File filePath;
	
	@SidedProxy(clientSide = ZollernModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ZollernModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static int modGuiIndex = 10;
	public static final int QUIVER_INV = modGuiIndex++,
			BACKPACK_INV = modGuiIndex + 1;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ZollernHelper.Log("Beginning to load Zollern Extras v"
				+ ZollernModInfo.VERSION + "...");
		ModHelperBase.detectMods();
		this.filePath = ZollernHelper.getFilePath(event);
		ModTabs.init();
		ZEConfig.init(event);
		ZollernPotion.init();
		EnchantmentList.init();
		ZollernItems.init();
		ZollernBlocks.init();
		ZollernAchievements.init();
		if (ZEConfig.enableStackChanges) {
			StackChange.init();
		}
		if (ModHelperBase.useBigReactors) {
			BRTurbineHelper.init();
		}
		if (ModHelperBase.useAppliedEnergistics2) {
			AE2Helper.init();
		}
		TreeCapHelper.init();
		Mobs.init();
		Treasures.init();
		DimensionLoader.init();
		PacketDispatcher.registerPackets();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initRenderers();
		EntityRegistry.registerModEntity(EntityDuckEgg.class, "DuckEgg", 1,
				INSTANCE, 64, 20, true);
		BiomeList.init();
		RecipeManager.init();
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
		ZollernHelper.Log("Loaded Zollern Extras successfully!");
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		Commands.init(event);
		ZollernHelper.Log("Commands loaded.");
	}
}