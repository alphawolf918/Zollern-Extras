package zollernextras.lib;

import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import zollernextras.creativetabs.ModTabs;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MainHelper {
	
	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setName(Block block, String strName) {
		block.setBlockName(ModInfo.MODID + "_" + strName);
	}
	
	public static void setName(Item item, String strName) {
		item.setUnlocalizedName(ModInfo.MODID + "_" + strName);
	}
	
	public static void setTexture(Block block, String strTexture) {
		block.setBlockTextureName(ModInfo.MODID + ":" + strTexture);
	}
	
	public static void setTexture(Item item, String strTexture) {
		item.setTextureName(ModInfo.MODID + ":" + strTexture);
	}
	
	public static void setNameAndTexture(Block block, String strName,
			String strTexture) {
		setName(block, strName);
		setTexture(block, strTexture);
	}
	
	public static void setNameAndTexture(Item item, String strName,
			String strTexture) {
		setName(item, strName);
		setTexture(item, strTexture);
	}
	
	public static void setNameAndTexture(Block block, String strBoth) {
		setName(block, strBoth);
		setTexture(block, strBoth);
	}
	
	public static void setNameAndTexture(Item item, String strBoth) {
		setName(item, strBoth);
		setTexture(item, strBoth);
	}
	
	public static boolean getConfig(Configuration config,
			String configCategory, String configKey,
			boolean configDefaultValue, String configComment) {
		return config.get(configCategory, configKey, configDefaultValue,
				configComment).getBoolean();
	}
	
	public static int getConfig(Configuration config, String configCategory,
			String configKey, int configDefaultValue, String configComment) {
		return config.get(configCategory, configKey, configDefaultValue,
				configComment).getInt();
	}
	
	public static File getFilePath(FMLPreInitializationEvent event) {
		return new File(event.getModConfigurationDirectory().getAbsolutePath()
				+ "ZollernExtras/");
	}
	
	public static void addChatMessage(EntityPlayer player, String text) {
		player.addChatMessage(new ChatComponentText(text));
	}
	
	public static void echo(String str) {
		System.out.println(str);
	}
	
	public static void Log(String str) {
		echo("[Zollern Extras] " + str);
	}
}