package zollernextras.events;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollernextras.lib.ZollernModInfo;

public class ZollernSoundEvents {
	
	// Duckly Wuckly
	public static SoundEvent ENTITY_DUCK_AMBIENT = regSound("duck.say");
	public static SoundEvent ENTITY_DUCK_HURT = regSound("duck.hurt");
	public static SoundEvent ENTITY_DUCK_DIE = regSound("duck.die");
	
	// Hell Duckly Wuckly
	public static SoundEvent ENTITY_HELLDUCK_AMBIENT = regSound("hellduck.say");
	public static SoundEvent ENTITY_HELLDUCK_HURT = regSound("hellduck.hurt");
	public static SoundEvent ENTITY_HELLDUCK_DIE = regSound("hellduck.die");
	
	// Mummy
	public static SoundEvent ENTITY_MUMMY_AMBIENT = regSound("mummy.say");
	public static SoundEvent ENTITY_MUMMY_HURT = regSound("mummy.hurt");
	public static SoundEvent ENTITY_MUMMY_DIE = regSound("mummy.die");
	
	// Shade
	public static SoundEvent ENTITY_SHADE_AMBIENT = regSound("shade.say");
	public static SoundEvent ENTITY_SHADE_HURT = regSound("shade.hurt");
	public static SoundEvent ENTITY_SHADE_DIE = regSound("shade.die");
	
	// Krull
	public static SoundEvent ENTITY_KRULL_AMBIENT = regSound("krull.say");
	public static SoundEvent ENTITY_KRULL_HURT = regSound("krull.hurt");
	public static SoundEvent ENTITY_KRULL_DIE = regSound("krull.die");
	
	public static void init() {
		// Duck
		registerSound(ENTITY_DUCK_AMBIENT);
		registerSound(ENTITY_DUCK_HURT);
		registerSound(ENTITY_DUCK_DIE);
		
		// Hell Duck
		registerSound(ENTITY_HELLDUCK_AMBIENT);
		registerSound(ENTITY_HELLDUCK_HURT);
		registerSound(ENTITY_HELLDUCK_DIE);
		
		// Mummy
		registerSound(ENTITY_MUMMY_AMBIENT);
		registerSound(ENTITY_MUMMY_HURT);
		registerSound(ENTITY_MUMMY_DIE);
		
		// Shade
		registerSound(ENTITY_SHADE_AMBIENT);
		registerSound(ENTITY_SHADE_HURT);
		registerSound(ENTITY_SHADE_DIE);
		
		// Krull
		registerSound(ENTITY_KRULL_AMBIENT);
		registerSound(ENTITY_KRULL_HURT);
		registerSound(ENTITY_KRULL_DIE);
	}
	
	private static void registerSound(SoundEvent sound) {
		ForgeRegistries.SOUND_EVENTS.register(sound);
	}
	
	private static SoundEvent regSound(String strSound) {
		SoundEvent s = new SoundEvent(new ResourceLocation(ZollernModInfo.modId + ":" + strSound));
		s.setRegistryName(strSound);
		return s;
	}
}