package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollernextras.config.ZEConfig;

public class BiomeList {
	
	public static int biomeColor = 1204859;
	
	public static Biome biomeMinersLand = new BiomeMinersLand(new Biome.BiomeProperties(
			"Miner's Land"));
	public static Biome biomeSlimeLands = new BiomeSlimeLands(new Biome.BiomeProperties(
			"Slime Lands"));
	public static Biome biomeBadLands = new BiomeBadLands(new Biome.BiomeProperties("Bad Lands"));
	public static Biome biomeRedshroomField = new BiomeRedshroomField(new Biome.BiomeProperties(
			"Redshroom Field"));
	public static Biome biomeIceDesert = new BiomeIceDesert(new Biome.BiomeProperties(
			"Ice Sand Desert"));
	public static Biome biomeCoalHills = new BiomeCoalHills(new Biome.BiomeProperties("Coal Hills"));
	public static Biome biomeGrandCanyon = new BiomeGrandCanyon(new Biome.BiomeProperties(
			"Grand Canyon"));
	public static Biome biomeIceMountains = new BiomeIceMountains(new Biome.BiomeProperties(
			"Ice Mountains"));
	public static Biome biomeMudSwamp = new BiomeMudSwamp(new Biome.BiomeProperties("Mud Swamp"));
	
	public static void init() {
		addBiome(biomeMinersLand, ZEConfig.biomeMinersLandID, "miners_land",
				ZEConfig.biomeMinersLandSpawnRate, BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN);
		addBiome(biomeSlimeLands, ZEConfig.biomeSlimeLandsID, "slime_lands",
				ZEConfig.biomeSlimeLandsSpawnRate, BiomeType.WARM, BiomeDictionary.Type.PLAINS);
		addBiome(biomeBadLands, ZEConfig.biomeBadLandsID, "bad_lands",
				ZEConfig.biomeBadLandsSpawnRate, BiomeType.DESERT, BiomeDictionary.Type.DEAD);
		addBiome(biomeRedshroomField, ZEConfig.biomeRedshroomPlainsID, "redshroom_plains",
				ZEConfig.biomeRedshroomPlainsSpawnRate, BiomeType.WARM, BiomeDictionary.Type.HILLS);
		addBiome(biomeIceDesert, ZEConfig.biomeIcyDesertID, "ice_desert",
				ZEConfig.biomeIcyDesertSpawnRate + 60, BiomeType.DESERT, BiomeDictionary.Type.SNOWY);
		addBiome(biomeCoalHills, ZEConfig.biomeCoalHillsID, "coal_hills",
				ZEConfig.biomeCoalHillsSpawnRate, BiomeType.DESERT, BiomeDictionary.Type.WASTELAND);
		addBiome(biomeGrandCanyon, ZEConfig.biomeGrandCanyonID, "grand_canyon",
				ZEConfig.biomeGrandCanyonSpawnRate, BiomeType.DESERT, BiomeDictionary.Type.MOUNTAIN);
		addBiome(biomeIceMountains, ZEConfig.biomeIceMountainsID, "icey_mountains",
				ZEConfig.biomeIceMountainsSpawnRate, BiomeType.ICY, BiomeDictionary.Type.SNOWY);
		addBiome(biomeMudSwamp, ZEConfig.biomeMudSwampID, "mud_swamp",
				ZEConfig.biomeMudSwampSpawnRate, BiomeType.WARM, BiomeDictionary.Type.SWAMP);
	}
	
	public static void addBiome(Biome biome, int biomeID, String biomeName, int biomeWeight,
			BiomeType biomeType, BiomeDictionary.Type biomeDictType) {
		Biome.registerBiome(biomeID, biomeName, biome);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		if (biomeWeight > 0) {
			BiomeManager.addStrongholdBiome(biome);
			BiomeManager.addSpawnBiome(biome);
			BiomeManager.addVillageBiome(biome, true);
		}
		BiomeDictionary.addTypes(biome, biomeDictType);
	}
	
}