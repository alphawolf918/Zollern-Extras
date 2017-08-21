package zollernextras.lib;

import net.minecraft.init.Items;

public class StackChanges {
	
	public static void init() {
		Items.SADDLE.setMaxStackSize(64);
		Items.ENDER_PEARL.setMaxStackSize(64);
		Items.BUCKET.setMaxStackSize(64);
		Items.SNOWBALL.setMaxStackSize(64);
		Items.SIGN.setMaxStackSize(64);
	}
	
}