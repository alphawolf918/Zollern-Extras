package zollernextras.lib;

import java.io.File;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;
import zollernextras.config.ZEConfig;
import zollernextras.creativetabs.ModTabs;

public class ZollernHelper {
	
	public static boolean getRNGChance(int min, int max) {
		if (min >= max) {
			return false;
		}
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		if (randInt <= min) {
			return true;
		}
		return false;
	}
	
	public static int rngNumber(int min, int max) {
		if (min >= max) {
			return 0;
		}
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		if (randInt < min) {
			randInt = min;
		}
		return randInt;
	}
	
	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setName(Block block, String strName) {
		block.setRegistryName(ZollernModInfo.modId + "_" + strName);
		block.setUnlocalizedName(ZollernModInfo.modId + "_" + strName);
	}
	
	public static void setName(Item item, String strName) {
		item.setRegistryName(ZollernModInfo.modId + "_" + strName);
		item.setUnlocalizedName(ZollernModInfo.modId + "_" + strName);
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
		player.sendMessage(new TextComponentString(text));
	}
	
	public static void log(Level level, String strMessage) {
		FMLLog.log(ZollernModInfo.officialName, level,
				String.valueOf(strMessage));
	}
	
	public static void logInfo(String str) {
		log(Level.INFO, str);
	}
	
	public static void logDebug(String str) {
		if (ZEConfig.enableDebugMode) {
			log(Level.DEBUG, str);
		}
	}
}