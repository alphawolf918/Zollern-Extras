package zollernextras.achievements;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;

public class ZollernAchievements {
	
	public static Achievement foundAmaranthOre;
	public static Achievement smeltedAmaranth;
	public static Achievement craftedAmaranthPickaxe;
	public static Achievement craftedAmaranthSword;
	public static Achievement craftedAmaranthAxe;
	public static Achievement craftedAamaranthShovel;
	public static Achievement craftedAmaranthHoe;
	
	public static AchievementPage zollernAchievementPage;
	
	public static void init() {
		foundAmaranthOre = new Achievement(
				"achievement.zollernextras_foundamaranthore",
				"zollernextras_foundamaranthore", 2, 0,
				ZollernBlocks.amaranthOre, (Achievement) null);
		smeltedAmaranth = new Achievement(
				"achievement.zollernextras_smeltedamaranth",
				"zollernextras_smeltedamaranth", 4, 0,
				ZollernItems.amaranthIngot, foundAmaranthOre);
		craftedAmaranthPickaxe = new Achievement(
				"achievement.zollernextras_craftedamaranthpickaxe",
				"zollernextras_craftedamaranthpickaxe", 4, 2,
				ZollernItems.amaranthPickaxe, smeltedAmaranth);
		craftedAmaranthSword = new Achievement(
				"achievement.zollernextras_craftedamaranthsword",
				"zollernextras_craftedamaranthsword", 6, 2,
				ZollernItems.amaranthSword, smeltedAmaranth);
		
		zollernAchievementPage = new AchievementPage("Zollern Extras",
				foundAmaranthOre, smeltedAmaranth, craftedAmaranthPickaxe,
				craftedAmaranthSword);
		
		AchievementPage.registerAchievementPage(zollernAchievementPage);
	}
}