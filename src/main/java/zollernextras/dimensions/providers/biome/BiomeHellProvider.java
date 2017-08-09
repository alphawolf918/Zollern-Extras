package zollernextras.dimensions.providers.biome;

import java.lang.reflect.Field;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import zollernextras.dimensions.providers.chunk.layer.ZollernGenLayer;

public class BiomeHellProvider extends BiomeProvider {
	
	private static final Field FIELD_GEN_BIOMES = ReflectionHelper.findField(
			BiomeProvider.class, "field_76944_d", "genBiomes");
	private static final Field FIELD_BIOME_INDEX_LAYER = ReflectionHelper
			.findField(BiomeProvider.class, "field_76945_e", "biomeIndexLayer");
	
	public BiomeHellProvider(World world) {
		super();
		
		GenLayer[] genLayers = ZollernGenLayer.initializeAllBiomeGenerators(
				world.getSeed(), world.getWorldType());
		
		try {
			FIELD_GEN_BIOMES.set(this, genLayers[0]);
			FIELD_BIOME_INDEX_LAYER.set(this, genLayers[1]);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}