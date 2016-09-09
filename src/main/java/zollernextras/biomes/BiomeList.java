package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollernextras.config.ZEConfig;
import zollernextras.lib.ZollernHelper;

public class BiomeList {
	
	public static int totalEntries = 0;
	
	public static int biomeColor = 1204859;
	
	public static BiomeGenBase icyDesert = new BiomeGenIcyDesert(
			ZEConfig.biomeIcyDesertID);
	public static BiomeGenBase slimeLands = new BiomeGenSlimeLands(
			ZEConfig.biomeSlimeLandsID);
	public static BiomeGenBase redShroomPlains = new BiomeGenRedshroomPlains(
			ZEConfig.biomeRedshroomPlainsID);
	public static BiomeGenBase redRockMountains = new BiomeGenRedRockMountains(
			ZEConfig.biomeRedrockMountainsID);
	public static BiomeGenBase mushroomForest = new BiomeGenMushroomForest(
			ZEConfig.biomeMushroomForestID);
	public static BiomeGenBase mudSwamp = new BiomeGenMudSwamp(
			ZEConfig.biomeMudSwampID);
	public static BiomeGenBase floweryField = new BiomeGenFloweryField(
			ZEConfig.biomeFloweryFieldID);
	public static BiomeGenBase grandCanyon = new BiomeGenGrandCanyon(
			ZEConfig.biomeGrandCanyonID);
	public static BiomeGenBase iceMountains = new BiomeGenIceMountains(
			ZEConfig.biomeIceMountainsID);
	public static BiomeGenBase coalHills = new BiomeGenCoalHills(
			ZEConfig.biomeCoalHillsID);
	public static BiomeGenBase badLands = new BiomeGenBadLands(
			ZEConfig.biomeBadLandsID);
	public static BiomeGenBase minersLand = new BiomeGenMinersLand(
			ZEConfig.biomeMinersLandID);
	public static BiomeGenBase candyLand = new BiomeGenCandyLand(
			ZEConfig.biomeCandyLandID);
	public static BiomeGenBase crystalOcean = new BiomeGenCrystalOcean(
			ZEConfig.biomeCrystalOceanID);
	public static BiomeGenBase tropicalForest = new BiomeTropicalForest(
			ZEConfig.biomeTropicalForestID);
	public static BiomeGenBase upsideDown = new BiomeGenUpsideDown(
			ZEConfig.biomeUpsideDownID);
	
	public static void init() {
		ZollernHelper.Log("Preparing to load biomes..");
		addBiome(icyDesert, BiomeType.ICY, ZEConfig.biomeIcyDesertSpawnRate);
		addBiome(slimeLands, BiomeType.WARM, ZEConfig.biomeSlimeLandsSpawnRate);
		addBiome(redShroomPlains, BiomeType.WARM,
				ZEConfig.biomeRedshroomPlainsSpawnRate);
		addBiome(redRockMountains, BiomeType.WARM,
				ZEConfig.biomeRedrockMountainsSpawnRate);
		addBiome(mushroomForest, BiomeType.COOL,
				ZEConfig.biomeMushroomForestSpawnRate);
		addBiome(mudSwamp, BiomeType.WARM, ZEConfig.biomeMudSwampSpawnRate);
		addBiome(floweryField, BiomeType.WARM,
				ZEConfig.biomeFloweryFieldSpawnRate);
		addBiome(grandCanyon, BiomeType.DESERT,
				ZEConfig.biomeGrandCanyonSpawnRate);
		addBiome(iceMountains, BiomeType.ICY,
				ZEConfig.biomeIceMountainsSpawnRate);
		addBiome(coalHills, BiomeType.WARM, ZEConfig.biomeCoalHillsSpawnRate);
		addBiome(badLands, BiomeType.DESERT, ZEConfig.biomeBadLandsSpawnRate);
		addBiome(minersLand, BiomeType.WARM, ZEConfig.biomeMinersLandSpawnRate);
		addBiome(candyLand, BiomeType.WARM, ZEConfig.biomeCandyLandSpawnRate);
		addBiome(crystalOcean, BiomeType.WARM,
				ZEConfig.biomeCrystalOceanSpawnRate);
		addBiome(tropicalForest, BiomeType.WARM,
				ZEConfig.biomeTropicalForestSpawnRate);
		
		addNoSpawnBiome(upsideDown, BiomeType.COOL, 0);
		ZollernHelper.Log("Biomes loaded: " + totalEntries);
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		if (BiomeGenBase.getBiome(biome.biomeID) != null) {
			BiomeManager
			.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
			BiomeManager.addSpawnBiome(biome);
			BiomeManager.addVillageBiome(biome, true);
			BiomeManager.addStrongholdBiome(biome);
			totalEntries++;
			ZollernHelper.Log("Loaded biome '" + biome.biomeName
					+ "' with ID: " + biome.biomeID);
		} else {
			BiomeGenBase otherBiome = BiomeGenBase.getBiome(biome.biomeID);
			ZollernHelper.Log("Failed to load biome '" + biome.biomeName
					+ "': biome ID " + biome.biomeID
					+ " is already in use by '" + otherBiome.biomeName
					+ "'. Change the ID in the config.");
		}
	}
	
	public static void addNoSpawnBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		if (BiomeGenBase.getBiome(biome.biomeID) != null) {
			BiomeManager
					.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
			BiomeManager.addVillageBiome(biome, true);
			BiomeManager.addStrongholdBiome(biome);
			totalEntries++;
			ZollernHelper.Log("Loaded no-spawn biome \"" + biome.biomeName
					+ "\" with ID: " + biome.biomeID);
		} else {
			BiomeGenBase otherBiome = BiomeGenBase.getBiome(biome.biomeID);
			ZollernHelper.Log("Failed to load biome '" + biome.biomeName
					+ "': biome ID " + biome.biomeID
					+ " is already in use by '" + otherBiome.biomeName
					+ "'. Change the ID in the config.");
		}
	}
}