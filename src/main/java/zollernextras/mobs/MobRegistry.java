package zollernextras.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollernextras.ZollernExtrasMod;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityHellFish;
import com.google.common.base.CaseFormat;

public class MobRegistry {
	
	private static int entityId = -1;
	
	public static void init() {
		
		// HellFish
		registerEntity("hellfish", EntityHellFish.class, entityId++, 0x8b0000,
				0x000000);
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