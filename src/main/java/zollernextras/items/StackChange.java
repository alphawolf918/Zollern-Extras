package zollernextras.items;

import net.minecraft.init.Items;

public class StackChange {
	
	public static void init() {
		Items.saddle.setMaxStackSize(64);
		Items.ender_pearl.setMaxStackSize(64);
		Items.bucket.setMaxStackSize(64);
		Items.snowball.setMaxStackSize(64);
	}
	
}