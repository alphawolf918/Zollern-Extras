package zollernextras.dimensions;

import java.util.Set;
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
import zollernextras.biomes.upsidedown.BiomeBlackLimbo;
import zollernextras.biomes.upsidedown.BiomeCorruption;
import zollernextras.biomes.upsidedown.BiomeUpsideDown;
import zollernextras.config.ZEConfig;
import zollernextras.dimensions.providers.world.WorldHellProvider;
import zollernextras.dimensions.providers.world.WorldProviderUpsideDown;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
public class DimensionRegistry {
	
	private static Set<BiomeManager.BiomeEntry> biomeNetherEntries = Sets
			.newHashSet();
	private static Set<BiomeManager.BiomeEntry> biomeUpsideDownEntries = Sets
			.newHashSet();
	
	@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
	public static class EventHandler {
		
		@SubscribeEvent
		public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
			// Nether biomes
			event.getRegistry().registerAll(new BiomeNewHell(),
					new BiomeBlazerockMountain(), new BiomeDeathValley(),
					new BiomeSoulDesert(), new BiomeBlackMountain(),
					new BiomeNetherMinersLand());
			
			// NOTE: It probably would not hurt to register all of these biomes
			// in the same registerAll() method, but this way is cleaner and
			// more sorted, so it doesn't hurt to separate them.
			
			// Upside-Down biomes
			event.getRegistry().registerAll(new BiomeUpsideDown(),
					new BiomeBlackLimbo(), new BiomeCorruption());
		}
	}
	
	public static int getNetherBiomeId(String name) {
		for (BiomeManager.BiomeEntry entry : biomeNetherEntries) {
			if (entry.biome.getRegistryName().getResourcePath().equals(name)) {
				return Biome.getIdForBiome(entry.biome);
			}
		}
		return -1;
	}
	
	public static int getUpsideDownBiomeId(String name) {
		for (BiomeManager.BiomeEntry entry : biomeUpsideDownEntries) {
			if (entry.biome.getRegistryName().getResourcePath().equals(name)) {
				return Biome.getIdForBiome(entry.biome);
			}
		}
		return -1;
	}
	
	public static boolean addNetherBiome(Biome biome, int weight) {
		if (weight <= 0) {
			weight = 1;
		}
		
		BiomeManager.BiomeEntry biomeEntry = new BiomeManager.BiomeEntry(biome,
				weight);
		
		for (BiomeManager.BiomeEntry entry : biomeNetherEntries) {
			if (biomeEntry.biome == entry.biome) {
				entry.itemWeight += biomeEntry.itemWeight;
				break;
			}
		}
		
		return biomeNetherEntries.add(biomeEntry);
	}
	
	public static boolean addUpsideDownBiome(Biome biome, int weight) {
		if (weight <= 0) {
			weight = 1;
		}
		
		BiomeManager.BiomeEntry biomeEntry = new BiomeManager.BiomeEntry(biome,
				weight);
		
		for (BiomeManager.BiomeEntry entry : biomeUpsideDownEntries) {
			if (biomeEntry.biome == entry.biome) {
				entry.itemWeight += biomeEntry.itemWeight;
				break;
			}
		}
		
		return biomeUpsideDownEntries.add(biomeEntry);
	}
	
	public static ImmutableList<BiomeManager.BiomeEntry> getNetherBiomeEntries() {
		return ImmutableList.copyOf(biomeNetherEntries);
	}
	
	public static ImmutableList<BiomeManager.BiomeEntry> getUpsideDownBiomeEntries() {
		return ImmutableList.copyOf(biomeUpsideDownEntries);
	}
	
	public static void postInit() {
		// New Nether
		DimensionManager.unregisterDimension(-1);
		ZollernHelper.registerDimension("Nether", "_nether", -1,
				WorldHellProvider.class);
		
		// Upside-Down
		ZollernHelper.registerDimension("Upside-Down", "upside_down",
				ZEConfig.dimensionUpsideDownID, WorldProviderUpsideDown.class);
	}
	
}