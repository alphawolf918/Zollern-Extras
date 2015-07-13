package zollernextras.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import zollernextras.lib.M;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ZEConfig {
	
	public static Configuration config;
	
	public static String CATEGORY_BIOMES = "Biomes";
	public static String CATEGORY_IMPROVEMENTS = "Improvements";
	public static String CATEGORY_MOBS = "Mobs";
	public static String CATEGORY_ORES = "Ores";
	
	public static boolean fueltoniumIsYellorite;
	public static boolean shiniumIsPlatinum;
	public static boolean betterGlassIsGlass;
	public static boolean rottenFleshCooksIntoLeather;
	public static boolean vanillaItemsAreCraftable;
	public static boolean horseArmorIsCraftable;
	public static boolean biomeDisplaysOnHUD;
	
	public static int biomeIcyDesertID;
	public static int biomeSlimeLandsID;
	public static int biomeRedshroomPlainsID;
	public static int biomeRedrockMountainsID;
	public static int biomeMushroomForestID;
	public static int biomeMudSwampID;
	public static int biomeFloweryFieldID;
	public static int biomeGrandCanyonID;
	public static int biomeIceMountainsID;
	public static int biomeCoalHillsID;
	public static int biomeBadLandsID;
	public static int biomeMinersLandID;
	public static int biomeCandyLandID;
	public static int biomeCrystalOceanID;
	
	public static int mobDuckSpawnRate;
	public static int mobFishSpawnRate;
	public static int mobSharkSpawnRate;
	public static int mobHellDuckSpawnRate;
	public static int mobHogSpawnRate;
	public static int mobHogZombieSpawnRate;
	public static int mobJellyfishSpawnRate;
	public static int mobMegaCreeperSpawnRate;
	public static int mobMummySpawnRate;
	public static int mobPigshroomSpawnRate;
	public static int mobScorpionSpawnRate;
	public static int mobShadowSkeletonSpawnRate;
	public static int mobShrimpSpawnRate;
	
	public static int oreSuperCoalSpawnRate;
	public static int oreFueltoniumSpawnRate;
	public static int oreEnderShardSpawnRate;
	public static int oreAmaranthSpawnRate;
	public static int oreZincSpawnRate;
	public static int oreDiamondIncreaseSpawnRate;
	public static int oreOpalSpawnRate;
	public static int oreGarnetSpawnRate;
	public static int oreAmberSpawnRate;
	public static int oreTopazSpawnRate;
	public static int oreAzuriteSpawnRate;
	public static int oreEnderiteSpawnRate;
	public static int oreAquamarineSpawnRate;
	
	public static void init(FMLPreInitializationEvent event) {
		config = new Configuration(new File(event
				.getModConfigurationDirectory().getAbsolutePath()
				+ "/ZollernExtras.cfg"));
		config.load();
		
		config.addCustomCategoryComment(config.CATEGORY_GENERAL,
				"General settings for the mod.");
		config.addCustomCategoryComment(CATEGORY_BIOMES, "IDs for ZE biomes.");
		config.addCustomCategoryComment(CATEGORY_IMPROVEMENTS,
				"Various improvements and extras for the mod.");
		config.addCustomCategoryComment(CATEGORY_MOBS,
				"Spawn rates of ZE mobs.");
		config.addCustomCategoryComment(CATEGORY_ORES,
				"Spawn rates of ZE ores.");
		
		// category, key, default value, comment
		
		fueltoniumIsYellorite = config
				.get(config.CATEGORY_GENERAL,
						"fueltoniumActsAsYellorite",
						true,
						"If enabled, Fueltonium Ingots will do the same as Yellorium Ingots in BigReactors, and can be used in their place.")
						.getBoolean();
		shiniumIsPlatinum = config
				.get(config.CATEGORY_GENERAL,
						"shiniumIsPlatinum",
						true,
						"If enabled, Shinium Ingots and Precious Shinium will function as Platinum Ingots and Platinum Dust, respectively (Thermal Foundation, Metallurgy, etc).")
						.getBoolean();
		betterGlassIsGlass = config
				.get(config.CATEGORY_GENERAL,
						"betterGlassIsGlass",
						true,
						"If enabled, Better Glass can be used in place of regular glass. Useful if you have a lot of gravel.")
						.getBoolean();
		rottenFleshCooksIntoLeather = config.get(CATEGORY_IMPROVEMENTS,
				"rottenFleshCooksIntoLeather", true,
				"If enabled, rotten flesh can be smelted into leather.")
				.getBoolean();
		
		// Improvements
		vanillaItemsAreCraftable = config
				.get(CATEGORY_IMPROVEMENTS, "vanillaItemsAreCraftable", true,
						"If enabled, normally uncraftable vanilla items will be craftable.")
						.getBoolean();
		horseArmorIsCraftable = config
				.get(CATEGORY_IMPROVEMENTS,
						"horseArmorIsCraftable",
						true,
						"If enabled, horse armor may be crafted using its respective material and obsidian. (This is separate from the above on purpose.)")
						.getBoolean();
		biomeDisplaysOnHUD = config
				.get(CATEGORY_IMPROVEMENTS, "biomeDisplaysOnHUD", true,
						"Disable this if you don't want the current biome to show on your HUD.")
						.getBoolean();
		
		// Biomes
		biomeIcyDesertID = config.get(CATEGORY_BIOMES, "biomeIcyDesertID", 67)
				.getInt();
		biomeSlimeLandsID = config
				.get(CATEGORY_BIOMES, "biomeSlimeLandsID", 68).getInt();
		biomeRedshroomPlainsID = config.get(CATEGORY_BIOMES,
				"biomeRedshroomPlainsID", 69).getInt();
		biomeRedrockMountainsID = config.get(CATEGORY_BIOMES,
				"biomeRedrockMountainsID", 70).getInt();
		biomeMushroomForestID = config.get(CATEGORY_BIOMES,
				"biomeMushroomForestID", 71).getInt();
		biomeMudSwampID = config.get(CATEGORY_BIOMES, "biomeMudSwampID", 72)
				.getInt();
		biomeFloweryFieldID = config.get(CATEGORY_BIOMES,
				"biomeFloweryFieldID", 73).getInt();
		biomeGrandCanyonID = config.get(CATEGORY_BIOMES, "biomeGrandCanyonID",
				74).getInt();
		biomeIceMountainsID = config.get(CATEGORY_BIOMES,
				"biomeIceMountainsID", 75).getInt();
		biomeCoalHillsID = config.get(CATEGORY_BIOMES, "biomeCoalHillsID", 76)
				.getInt();
		biomeBadLandsID = config.get(CATEGORY_BIOMES, "biomeBadLandsID", 77)
				.getInt();
		biomeMinersLandID = config
				.get(CATEGORY_BIOMES, "biomeMinersLandID", 78).getInt();
		biomeCandyLandID = config.get(CATEGORY_BIOMES, "biomeCandyLandID", 79)
				.getInt();
		biomeCrystalOceanID = config.get(CATEGORY_BIOMES,
				"biomeCrystalOceanID", 80).getInt();
		// Mobs
		mobFishSpawnRate = config.get(CATEGORY_MOBS, "mobFishSpawnRate", 70)
				.getInt();
		mobSharkSpawnRate = config.get(CATEGORY_MOBS, "mobSharkSpawnRate", 24)
				.getInt();
		mobMegaCreeperSpawnRate = config.get(CATEGORY_MOBS,
				"mobMegaCreeperSpawnRate", 10).getInt();
		mobScorpionSpawnRate = config.get(CATEGORY_MOBS,
				"mobScorpionSpawnRate", 8).getInt();
		mobJellyfishSpawnRate = config.get(CATEGORY_MOBS,
				"mobJellyfishSpawnRate", 32).getInt();
		mobShrimpSpawnRate = config
				.get(CATEGORY_MOBS, "mobShrimpSpawnRate", 20).getInt();
		mobDuckSpawnRate = config.get(CATEGORY_MOBS, "mobDuckSpawnRate", 25)
				.getInt();
		mobPigshroomSpawnRate = config.get(CATEGORY_MOBS,
				"mobPigshroomSpawnRate", 8).getInt();
		mobShadowSkeletonSpawnRate = config.get(CATEGORY_MOBS,
				"mobShadowSkeletonSpawnRate", 10).getInt();
		mobMummySpawnRate = config.get(CATEGORY_MOBS, "mobMummySpawnRate", 15)
				.getInt();
		mobHogSpawnRate = config.get(CATEGORY_MOBS, "mobHogSpawnRate", 20)
				.getInt();
		mobHogZombieSpawnRate = config.get(CATEGORY_MOBS,
				"mobHogZombieSpawnRate", 25).getInt();
		mobHellDuckSpawnRate = config.get(CATEGORY_MOBS,
				"mobHellDuckSpawnRate", 20).getInt();
		
		// Ore Generation
		oreSuperCoalSpawnRate = config.get(CATEGORY_ORES,
				"oreSuperCoalSpawnRate", 6).getInt();
		oreFueltoniumSpawnRate = config.get(CATEGORY_ORES,
				"oreFueltoniumSpawnRate", 14).getInt();
		oreEnderShardSpawnRate = config.get(CATEGORY_ORES,
				"oreEnderShardOreSpawnRate", 8).getInt();
		oreAmaranthSpawnRate = config.get(CATEGORY_ORES,
				"oreAmaranthSpawnRate", 10).getInt();
		oreZincSpawnRate = config.get(CATEGORY_ORES, "oreZincSpawnRate", 11)
				.getInt();
		oreDiamondIncreaseSpawnRate = config.get(CATEGORY_ORES,
				"oreDiamondIncreaseSpawnRate", 13).getInt();
		oreOpalSpawnRate = config.get(CATEGORY_ORES, "oreOpalSpawnRate", 4)
				.getInt();
		oreAmberSpawnRate = config.get(CATEGORY_ORES, "oreAmberSpawnRate", 4)
				.getInt();
		oreGarnetSpawnRate = config.get(CATEGORY_ORES, "oreGarnetSpawnRate", 4)
				.getInt();
		oreAquamarineSpawnRate = config.get(CATEGORY_ORES,
				"oreAquamarineSpawnRate", 4).getInt();
		oreTopazSpawnRate = config.get(CATEGORY_ORES, "oreTopazSpawnRate", 4)
				.getInt();
		oreAzuriteSpawnRate = config.get(CATEGORY_ORES, "oreAzuriteSpawnRate",
				4).getInt();
		oreEnderiteSpawnRate = config.get(CATEGORY_ORES,
				"oreEnderiteSpawnRate", 4).getInt();
		
		config.save();
		M.Log("Config loaded.");
	}
}