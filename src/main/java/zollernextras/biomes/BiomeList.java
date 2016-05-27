package zollernextras.biomes;

import java.util.ArrayList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollernextras.config.ZEConfig;
import zollernextras.lib.MainHelper;

public class BiomeList {
	
	public static int biomeColor = 1204859;
	public static ArrayList<BiomeGenBase> biomeGenList = new ArrayList<BiomeGenBase>();
	public static int biomeStartId = 67;
	
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
	public static BiomeGenBase lostDesert = new BiomeGenLostDesert(
			ZEConfig.biomeLostDesertID);
	
	public static void init() {
		MainHelper.Log("Preparing to load biomes..");
		addBiome(icyDesert, BiomeType.ICY, 15);
		addBiome(slimeLands, BiomeType.WARM, 15);
		addBiome(redShroomPlains, BiomeType.WARM, 34);
		addBiome(redRockMountains, BiomeType.WARM, 46);
		addBiome(mushroomForest, BiomeType.COOL, 11);
		addBiome(mudSwamp, BiomeType.WARM, 42);
		addBiome(floweryField, BiomeType.WARM, 71);
		addBiome(grandCanyon, BiomeType.DESERT, 22);
		addBiome(iceMountains, BiomeType.ICY, 45);
		addBiome(coalHills, BiomeType.WARM, 10);
		addBiome(badLands, BiomeType.DESERT, 27);
		addBiome(minersLand, BiomeType.WARM, 6);
		addBiome(candyLand, BiomeType.WARM, 26);
		addBiome(crystalOcean, BiomeType.WARM, 32);
		addNoSpawnBiome(lostDesert, BiomeType.WARM, 0);
		MainHelper.Log("Biomes loaded!");
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
		biomeGenList.add(biome);
		MainHelper.Log("Loaded biome '" + biome.biomeName + "' with ID: "
				+ biome.biomeID);
	}
	
	public static void addNoSpawnBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
	}
}