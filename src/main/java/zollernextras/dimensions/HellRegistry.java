package zollernextras.dimensions;

import java.util.List;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollernextras.biomes.ZollernNetherBiome;
import zollernextras.biomes.nether.BiomeBlazingInferno;
import zollernextras.biomes.nether.BiomeNewHell;
import zollernextras.dimensions.providers.world.WorldHellProvider;
import zollernextras.lib.ZollernModInfo;
import com.google.common.collect.Lists;

@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
public class HellRegistry {
	
	public static Biome biomeNewHell = new BiomeNewHell();
	public static Biome biomeBlazingInferno = new BiomeBlazingInferno();
	
	private static List<ZollernNetherBiome> netherBiomeEntry = Lists
			.newArrayList();
	
	@Mod.EventBusSubscriber(modid = ZollernModInfo.modId)
	public static class EventHandler {
		
		@SubscribeEvent
		public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
			registerHellBiomeEntries();
			event.getRegistry().registerAll(biomeNewHell, biomeBlazingInferno);
		}
	}
	
	public static void registerHellBiomeEntries() {
		netherBiomeEntry.add((ZollernNetherBiome) biomeNewHell);
		netherBiomeEntry.add((ZollernNetherBiome) biomeBlazingInferno);
	}
	
	public static Biome getNetherBiome(int index) {
		return netherBiomeEntry.get(index);
	}
	
	public static List<ZollernNetherBiome> getNetherBiomeList() {
		return netherBiomeEntry;
	}
	
	public static void postInit() {
		DimensionManager.unregisterDimension(-1);
		DimensionType nether = DimensionType.register("Nether", "_nether", -1,
				WorldHellProvider.class, false);
		DimensionManager.registerDimension(-1, nether);
	}
	
}