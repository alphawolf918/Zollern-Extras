package zollernextras.mobs;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.biomes.BiomeList;
import zollernextras.config.ZEConfig;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.mobs.entities.EntityBabyDragon;
import zollernextras.mobs.entities.EntityDuck;
import zollernextras.mobs.entities.EntityEnderBug;
import zollernextras.mobs.entities.EntityEnderCreeper;
import zollernextras.mobs.entities.EntityEnderSkeleton;
import zollernextras.mobs.entities.EntityFish;
import zollernextras.mobs.entities.EntityHellDuck;
import zollernextras.mobs.entities.EntityHog;
import zollernextras.mobs.entities.EntityHogZombie;
import zollernextras.mobs.entities.EntityJellyfish;
import zollernextras.mobs.entities.EntityKrull;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityMummy;
import zollernextras.mobs.entities.EntityPigshroom;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.entities.EntityShark;
import zollernextras.mobs.entities.EntityShrimp;
import zollernextras.mobs.entities.EntitySpiderling;
import zollernextras.mobs.entities.boss.EntityShadowAlien;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Mobs {
	
	static int startEntityId = 300;
	
	public static void init() {
		
		ZollernHelper.Log("Registering entities..");
		
		// Fish
		registerEntity(EntityFish.class, "fish", 0x0099ff, 0x00008b);
		EntityRegistry.addSpawn(EntityFish.class, ZEConfig.mobFishSpawnRate,
				10, 15, EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.desertHills, BiomeGenBase.river,
				BiomeGenBase.beach, BiomeGenBase.forestHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore, BiomeGenBase.taigaHills,
				BiomeList.icyDesert, BiomeList.floweryField,
				BiomeList.iceMountains, BiomeList.redRockMountains,
				BiomeList.redShroomPlains, BiomeList.slimeLands,
				BiomeList.coalHills, BiomeList.badLands, BiomeGenBase.beach,
				BiomeGenBase.coldBeach, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.deepOcean, BiomeGenBase.megaTaiga,
				BiomeGenBase.mesa, BiomeGenBase.birchForest,
				BiomeList.crystalOcean);
		
		// Mega Creeper
		registerEntity(EntityMegaCreeper.class, "megacreeper", 0xee00ee,
				0x00ee00);
		EntityRegistry.addSpawn(EntityMegaCreeper.class,
				ZEConfig.mobMegaCreeperSpawnRate, 1, 6,
				EnumCreatureType.monster, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.desertHills, BiomeGenBase.river,
				BiomeGenBase.beach, BiomeGenBase.forestHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.jungleHills, BiomeGenBase.taigaHills,
				BiomeList.icyDesert, BiomeList.floweryField,
				BiomeList.iceMountains, BiomeList.redRockMountains,
				BiomeList.redShroomPlains, BiomeList.slimeLands,
				BiomeList.coalHills, BiomeList.mudSwamp, BiomeList.grandCanyon,
				BiomeGenBase.savanna, BiomeList.slimeLands,
				BiomeGenBase.birchForest, BiomeGenBase.megaTaiga,
				BiomeGenBase.mesa);
		
		// Scorpion
		registerEntity(EntityScorpion.class, "scorpion", 0xf5eeb3, 0x8b9900);
		EntityRegistry.addSpawn(EntityScorpion.class,
				ZEConfig.mobScorpionSpawnRate, 2, 4, EnumCreatureType.monster,
				BiomeGenBase.desert, BiomeGenBase.desertHills,
				BiomeList.icyDesert, BiomeList.badLands,
				BiomeList.redRockMountains, BiomeGenBase.mesaPlateau,
				BiomeGenBase.mesa, BiomeGenBase.mesaPlateau_F,
				BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
				BiomeList.grandCanyon);
		
		// Jellyfish
		registerEntity(EntityJellyfish.class, "jellyfish", 0xed08b5, 0x9b0476);
		EntityRegistry.addSpawn(EntityJellyfish.class,
				ZEConfig.mobJellyfishSpawnRate, 1, 10,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.deepOcean, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.taigaHills, BiomeList.icyDesert,
				BiomeList.floweryField, BiomeList.iceMountains,
				BiomeList.redRockMountains, BiomeList.redShroomPlains,
				BiomeList.slimeLands, BiomeGenBase.deepOcean,
				BiomeGenBase.river, BiomeList.crystalOcean);
		
		// Shrimp
		registerEntity(EntityShrimp.class, "shrimp", 0xef08c5, 0xaf04d6);
		EntityRegistry.addSpawn(EntityShrimp.class,
				ZEConfig.mobShrimpSpawnRate, 5, 10,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.desertHills, BiomeGenBase.river,
				BiomeGenBase.beach, BiomeGenBase.forestHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore, BiomeGenBase.taigaHills,
				BiomeList.icyDesert, BiomeList.floweryField,
				BiomeList.iceMountains, BiomeList.redRockMountains,
				BiomeList.redShroomPlains, BiomeList.slimeLands,
				BiomeGenBase.deepOcean, BiomeList.crystalOcean);
		
		// Duck
		registerEntity(EntityDuck.class, "duck", 0x008b00, 0x8b2200);
		EntityRegistry.addSpawn(EntityDuck.class, ZEConfig.mobDuckSpawnRate, 2,
				4, EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.taiga,
				BiomeGenBase.ocean, BiomeGenBase.river, BiomeList.mudSwamp,
				BiomeList.crystalOcean);
		
		// Pigshroom
		registerEntity(EntityPigshroom.class, "pigshroom", 0x990000, 0xeeeeee);
		EntityRegistry.addSpawn(EntityPigshroom.class,
				ZEConfig.mobPigshroomSpawnRate, 2, 4,
				EnumCreatureType.creature, BiomeGenBase.mushroomIsland,
				BiomeList.redShroomPlains);
		
		// Baby Dragon
		registerEntity(EntityBabyDragon.class, "babydragon", 0x000000, 0x7D26CD);
		
		// Shadow Skeleton
		registerEntity(EntityShadowSkeleton.class, "shadowskeleton", 0xeeeeee,
				0x00009e);
		EntityRegistry.addSpawn(EntityShadowSkeleton.class,
				ZEConfig.mobShadowSkeletonSpawnRate, 2, 4,
				EnumCreatureType.monster, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.desertHills, BiomeGenBase.river,
				BiomeGenBase.beach, BiomeGenBase.forestHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.jungleHills, BiomeGenBase.taigaHills,
				BiomeList.icyDesert, BiomeList.floweryField,
				BiomeList.iceMountains, BiomeList.redRockMountains,
				BiomeList.redShroomPlains, BiomeList.slimeLands,
				BiomeGenBase.savanna, BiomeList.coalHills, BiomeList.mudSwamp,
				BiomeList.grandCanyon, BiomeList.slimeLands);
		
		// Mummy
		registerEntity(EntityMummy.class, "mummy", 0x8b990, 0xf5eeb3);
		EntityRegistry.addSpawn(EntityMummy.class, ZEConfig.mobMummySpawnRate,
				2, 4, EnumCreatureType.monster, BiomeGenBase.desert,
				BiomeGenBase.desertHills, BiomeList.icyDesert,
				BiomeList.badLands, BiomeList.redRockMountains,
				BiomeGenBase.mesaPlateau, BiomeGenBase.mesa,
				BiomeGenBase.mesaPlateau_F, BiomeGenBase.savanna,
				BiomeGenBase.savannaPlateau, BiomeList.grandCanyon);
		
		// Hog
		registerEntity(EntityHog.class, "hog", 0x8b5a00, 0xf5eeb3);
		EntityRegistry.addSpawn(EntityHog.class, ZEConfig.mobHogSpawnRate, 4,
				8, EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean);
		
		// Hog Zombie
		registerEntity(EntityHogZombie.class, "hogzombie", 0x8b9900, 0x00ee00);
		EntityRegistry.addSpawn(EntityHogZombie.class,
				ZEConfig.mobHogZombieSpawnRate, 8, 10,
				EnumCreatureType.monster, BiomeGenBase.hell);
		
		// Shark
		registerEntity(EntityShark.class, "shark", 0x444444, 0x8b2222);
		EntityRegistry.addSpawn(EntityShark.class, ZEConfig.mobSharkSpawnRate,
				2, 4, EnumCreatureType.monster, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.ocean,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.desertHills, BiomeGenBase.river,
				BiomeGenBase.beach, BiomeGenBase.forestHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore, BiomeGenBase.taigaHills,
				BiomeList.icyDesert, BiomeList.floweryField,
				BiomeList.iceMountains, BiomeList.redRockMountains,
				BiomeList.redShroomPlains, BiomeList.slimeLands,
				BiomeList.coalHills, BiomeList.badLands, BiomeGenBase.beach,
				BiomeGenBase.coldBeach, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.deepOcean, BiomeGenBase.megaTaiga,
				BiomeGenBase.mesa, BiomeGenBase.birchForest,
				BiomeList.crystalOcean);
		
		// Hell Duck
		registerEntity(EntityHellDuck.class, "hellduck", 0x8b0000, 0x000000);
		EntityRegistry.addSpawn(EntityHellDuck.class,
				ZEConfig.mobHellDuckSpawnRate, 2, 4, EnumCreatureType.monster,
				BiomeGenBase.hell);
		
		// Ender Skeleton
		if (ModHelperBase.useZaneExtras) {
			registerEntity(EntityEnderSkeleton.class, "enderskeleton",
					0xffffff, 0xbb00ff);
			EntityRegistry.addSpawn(EntityEnderSkeleton.class, 45, 4, 6,
					EnumCreatureType.monster, BiomeGenBase.sky);
		}
		
		// Ender Bug
		registerEntity(EntityEnderBug.class, "enderbug", 0xeeeeee, 0xdd008b);
		
		// Ender Creeper
		registerEntity(EntityEnderCreeper.class, "endercreeper", 0x008b00,
				0x000000);
		EntityRegistry.addSpawn(EntityEnderSkeleton.class, 14, 1, 1,
				EnumCreatureType.monster, BiomeGenBase.sky);
		
		// Shadow Alien
		registerEntity(EntityShadowAlien.class, "shadowalien", 0xeeeeee,
				0xffffff);
		
		// Krull
		registerEntity(EntityKrull.class, "krull", 0xf5eeb3, 0x444444);
		
		// Spiderling
		registerEntity(EntitySpiderling.class, "spiderling", 0x000000, 0xff8b00);
		
		ZollernHelper.Log("Entities have been registered!");
	}
	
	public static void registerEntity(Class<? extends EntityLiving> entity,
			String entityName, int entityPrimaryColor, int entitySecondaryColor) {
		int uniqueEntityId = EntityRegistry.findGlobalUniqueEntityId();
		ZollernHelper.Log("Loading entity '" + entityName + "' with ID "
				+ uniqueEntityId);
		EntityRegistry.registerGlobalEntityID(entity, ZollernModInfo.MODID
				+ "_" + entityName, uniqueEntityId);
		registerEntityEgg(entity, entityPrimaryColor, entitySecondaryColor);
	}
	
	public static void registerEntityEgg(Class<? extends EntityLiving> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
}