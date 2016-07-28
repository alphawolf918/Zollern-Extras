package zollernextras.lib.modhelper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.common.event.FMLInterModComms;

public class AE2Helper {
	
	public static void init() {
		MainHelper.Log("Registered Applied Energistics 2 helper.");
	}
	
	protected static void sendInterModMessage(String to, String type,
			NBTTagCompound message) {
		FMLInterModComms.sendMessage(to, type, message);
	}
	
	public static void addGrinderRecipe(ItemStack input, ItemStack output,
			int turns) {
		NBTTagCompound msg = new NBTTagCompound();
		NBTTagCompound in = new NBTTagCompound();
		NBTTagCompound out = new NBTTagCompound();
		input.writeToNBT(in);
		output.writeToNBT(out);
		msg.setTag("in", in);
		msg.setTag("out", out);
		msg.setInteger("turns", turns);
		sendInterModMessage("appliedenergistics2", "add-grindable", msg);
	}
}