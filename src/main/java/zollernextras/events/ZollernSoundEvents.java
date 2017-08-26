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
	
	public static void init() {
		// Duck
		registerSound(ENTITY_DUCK_AMBIENT);
		registerSound(ENTITY_DUCK_HURT);
		registerSound(ENTITY_DUCK_DIE);
		
		// Hell Duck
		registerSound(ENTITY_HELLDUCK_AMBIENT);
		registerSound(ENTITY_HELLDUCK_HURT);
		registerSound(ENTITY_HELLDUCK_DIE);
	}
	
	private static void registerSound(SoundEvent sound) {
		ForgeRegistries.SOUND_EVENTS.register(sound);
	}
	
	private static SoundEvent regSound(String strSound) {
		SoundEvent s = new SoundEvent(new ResourceLocation(ZollernModInfo.modId
				+ ":" + strSound));
		s.setRegistryName(strSound);
		return s;
	}
}