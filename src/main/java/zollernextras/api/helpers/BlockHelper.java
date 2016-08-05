package zollernextras.api.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;

public class BlockHelper {
	
	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.zTab);
	}
	
	public static void setName(Block block, String strName) {
		block.setBlockName(ZollernModInfo.MODID + "_" + strName);
	}
	
	public static void setTexture(Block block, String strTexture) {
		block.setBlockTextureName(ZollernModInfo.MODID + ":" + strTexture);
	}
	
	public static void setNameAndTexture(Block block, String strName,
			String strTexture) {
		setName(block, strName);
		setTexture(block, strTexture);
	}
	
	public static void setNameAndTexture(Block block, String strBoth) {
		setName(block, strBoth);
		setTexture(block, strBoth);
	}
	
	public static void setHardResist(Block block, float hardness,
			float resistance) {
		block.setHardness(hardness);
		block.setResistance(resistance);
	}
	
	public static void setHardResist(Block block, float hardResist) {
		ZollernHelper.setHardResist(block, hardResist, hardResist);
	}
	
}