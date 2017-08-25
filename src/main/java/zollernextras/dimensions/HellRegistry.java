package zollernextras.dimensions;

import java.util.Set;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollernextras.biomes.nether.BiomeBlackMountain;
import zollernextras.biomes.nether.BiomeBlazerockMountain;
import zollernextras.biomes.nether.BiomeDeathValley;
import zollernextras.biomes.nether.BiomeNetherMinersLand;
import zollernextras.biomes.nether.BiomeNewHell;
import zollernextras.biomes.nether.BiomeSoulDesert;
import zollernextras.dimensions.providers.world.WorldHellProvider;
import zollernextras.lib.ZollernModInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
public class HellRegistry {
	
	private static Set<BiomeManager.BiomeEntry> biomeEntries = Sets
			.newHashSet();
	
	@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
	public static class EventHandler {
		
		@SubscribeEvent
		public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
			event.getRegistry().registerAll(new BiomeNewHell(),
					new BiomeBlazerockMountain(), new BiomeDeathValley(),
					new BiomeSoulDesert(), new BiomeBlackMountain(),
					new BiomeNetherMinersLand());
		}
	}
	
	public static int getBiomeId(String name) {
		for (BiomeManager.BiomeEntry entry : biomeEntries) {
			if (entry.biome.getRegistryName().getResourcePath().equals(name)) {
				return Biome.getIdForBiome(entry.biome);
			}
		}
		return -1;
	}
	
	public static boolean addBiome(Biome biome, int weight) {
		if (weight <= 0) {
			weight = 1;
		}
		
		BiomeManager.BiomeEntry biomeEntry = new BiomeManager.BiomeEntry(biome,
				weight);
		
		for (BiomeManager.BiomeEntry entry : biomeEntries) {
			if (biomeEntry.biome == entry.biome) {
				entry.itemWeight += biomeEntry.itemWeight;
				break;
			}
		}
		
		return biomeEntries.add(biomeEntry);
	}
	
	public static ImmutableList<BiomeManager.BiomeEntry> getBiomeEntries() {
		return ImmutableList.copyOf(biomeEntries);
	}
	
	public static void postInit() {
		DimensionManager.unregisterDimension(-1);
		DimensionType nether = DimensionType.register("Nether", "_nether", -1,
				WorldHellProvider.class, false);
		DimensionManager.registerDimension(-1, nether);
	}
	
}