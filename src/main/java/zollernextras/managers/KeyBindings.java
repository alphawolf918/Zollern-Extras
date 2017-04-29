package zollernextras.managers;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import cpw.mods.fml.client.registry.ClientRegistry;

public class KeyBindings {
	
	public static KeyBinding icePower;
	public static KeyBinding thunderPower;
	public static KeyBinding netherPower;
	public static KeyBinding enderPower;
	public static KeyBinding witherPower;
	public static KeyBinding lightPower;
	
	public static void init() {
		icePower = new KeyBinding("key.icepower", Keyboard.KEY_NUMPAD8,
				"key.categories.zollernextras.superpower");
		thunderPower = new KeyBinding("key.thunderpower", Keyboard.KEY_NUMPAD4,
				"key.categories.zollernextras.superpowers");
		netherPower = new KeyBinding("key.netherpower", Keyboard.KEY_NUMPAD2,
				"key.categories.zollernextras.superpowers");
		enderPower = new KeyBinding("key.enderpower", Keyboard.KEY_NUMPAD6,
				"key.categories.zollernextras.superpowers");
		witherPower = new KeyBinding("key.witherpower", Keyboard.KEY_NUMPAD5,
				"key.categories.zollernextras.superpowers");
		lightPower = new KeyBinding("key.lightpower", Keyboard.KEY_NUMPAD7,
				"key.categories.zollernextras.superpowers");
		ClientRegistry.registerKeyBinding(icePower);
		ClientRegistry.registerKeyBinding(thunderPower);
		ClientRegistry.registerKeyBinding(netherPower);
		ClientRegistry.registerKeyBinding(enderPower);
		ClientRegistry.registerKeyBinding(witherPower);
		ClientRegistry.registerKeyBinding(lightPower);
	}
}