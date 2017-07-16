package zollernextras.lib;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class KeyHelper {
	
	/**
	 * Returns true if Ctrl key (Windows) or Option key (Mac) is pressed.
	 * 
	 * @return
	 */
	public static boolean isCtrlKeyDown() {
		boolean isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)
				|| Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
		if (!isCtrlKeyDown && Minecraft.IS_RUNNING_ON_MAC) {
			isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LMETA)
					|| Keyboard.isKeyDown(Keyboard.KEY_RMETA);
		}
		return isCtrlKeyDown;
	}
	
	/**
	 * Returns true if the Shift key is pressed.
	 * 
	 * @return
	 */
	public static boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
				|| Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
}