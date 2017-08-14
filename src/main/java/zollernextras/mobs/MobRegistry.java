package zollernextras.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollernextras.ZollernExtrasMod;
import zollernextras.biomes.BiomeList;
import zollernextras.config.ZEConfig;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityScorpion;
import com.google.common.base.CaseFormat;

public class MobRegistry {
	
	private static int entityId = -1;
	
	public static void init() {
		
		// HellFish
		registerEntity("hellfish", EntityHellFish.class, entityId++, 0x8b0000,
				0x000000);
		
		// Mega Creeper
		registerEntity("megacreeper", EntityMegaCreeper.class, entityId++,
				0xee00ee, 0x00ee00);
		EntityRegistry.addSpawn(EntityMegaCreeper.class,
				ZEConfig.mobMegaCreeperSpawnRate, 2, 6,
				EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.FOREST,
				Biomes.DESERT, Biomes.EXTREME_HILLS, Biomes.JUNGLE,
				Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.OCEAN,
				Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE,
				Biomes.DESERT_HILLS, Biomes.RIVER, Biomes.BEACH,
				Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER,
				Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.JUNGLE_HILLS,
				Biomes.TAIGA_HILLS, BiomeList.biomeIceDesert,
				BiomeList.biomeIceMountains, BiomeList.biomeRedshroomField,
				BiomeList.biomeSlimeLands, BiomeList.biomeMudSwamp,
				BiomeList.biomeGrandCanyon, Biomes.SAVANNA,
				Biomes.BIRCH_FOREST, Biomes.MUTATED_REDWOOD_TAIGA, Biomes.MESA);
		
		// Scorpion
		registerEntity("scorpion", EntityScorpion.class, entityId++, 0xf5eeb3,
				0x8b9900);
		EntityRegistry.addSpawn(EntityScorpion.class,
				ZEConfig.mobScorpionSpawnRate, 2, 6, EnumCreatureType.MONSTER,
				Biomes.PLAINS, Biomes.FOREST, Biomes.DESERT,
				Biomes.EXTREME_HILLS, Biomes.JUNGLE, Biomes.SWAMPLAND,
				Biomes.TAIGA, Biomes.OCEAN, Biomes.EXTREME_HILLS,
				Biomes.EXTREME_HILLS_EDGE, Biomes.DESERT_HILLS, Biomes.RIVER,
				Biomes.BEACH, Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN,
				Biomes.FROZEN_RIVER, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS,
				Biomes.JUNGLE_HILLS, Biomes.TAIGA_HILLS,
				BiomeList.biomeIceDesert, BiomeList.biomeIceMountains,
				BiomeList.biomeRedshroomField, BiomeList.biomeSlimeLands,
				BiomeList.biomeMudSwamp, BiomeList.biomeGrandCanyon,
				Biomes.SAVANNA, Biomes.BIRCH_FOREST,
				Biomes.MUTATED_REDWOOD_TAIGA, Biomes.MESA);
	}
	
	private static void registerEntity(String name,
			Class<? extends Entity> cls, int id) {
		ResourceLocation registryName = new ResourceLocation(
				ZollernModInfo.modId + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,
						registryName.toString()), id, ZollernExtrasMod
						.instance(), 64, 1, true);
	}
	
	private static void registerEntity(String name,
			Class<? extends Entity> cls, int id, int primaryEggColor,
			int secondaryEggColor) {
		ResourceLocation registryName = new ResourceLocation(
				ZollernModInfo.modId + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,
						registryName.toString()), id, ZollernExtrasMod
						.instance(), 64, 1, true, primaryEggColor,
				secondaryEggColor);
	}
}