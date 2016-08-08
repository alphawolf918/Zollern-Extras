package zollernextras.lib;

import java.io.File;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ModTabs;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class ZollernHelper {
	
	public static boolean getRNGChance(int min, int max) {
		if (min >= max) {
			ZollernHelper
			.Log("Error: min chance was set to higher than max in RNG.");
			return false;
		}
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		if (randInt <= min) {
			return true;
		}
		return false;
	}
	
	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setName(Block block, String strName) {
		block.setBlockName(ZollernModInfo.MODID + "_" + strName);
	}
	
	public static void setName(Item item, String strName) {
		item.setUnlocalizedName(ZollernModInfo.MODID + "_" + strName);
	}
	
	public static void setTexture(Block block, String strTexture) {
		block.setBlockTextureName(ZollernModInfo.MODID + ":" + strTexture);
	}
	
	public static void setTexture(Item item, String strTexture) {
		item.setTextureName(ZollernModInfo.MODID + ":" + strTexture);
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
	
	public static void setHardResist(Block block, float hardness,
			float resistance) {
		block.setHardness(hardness);
		block.setResistance(resistance);
	}
	
	public static void setHardResist(Block block, float hardResist) {
		ZollernHelper.setHardResist(block, hardResist, hardResist);
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
	
	/**
	 * Send a chat message to the Player. Call this from your ClientProxy!
	 * 
	 * @param player
	 * @param text
	 */
	public static void addChatMessage(EntityPlayer player, String text) {
		player.addChatMessage(new ChatComponentText(text));
	}
	
	/**
	 * Log a message to the console.
	 * 
	 * @param str
	 *            The message to log.
	 */
	public static void echo(String str) {
		FMLRelaunchLog.log(ZollernModInfo.OFFICIAL_NAME, Level.INFO, str);
	}
	
	/**
	 * Log a message to the console.
	 * 
	 * @param str
	 *            The message to log.
	 */
	public static void Log(String str) {
		echo(str);
	}
	
	public static void debugLog(String str) {
		if (ZEConfig.enableDebugMode) {
			FMLRelaunchLog.log(ZollernModInfo.OFFICIAL_NAME, Level.DEBUG, str);
		}
	}
}