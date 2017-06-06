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
	public static Achievement craftedAmaranthShovel;
	public static Achievement craftedAmaranthHoe;
	
	public static Achievement superCharged;
	
	public static AchievementPage zollernAchievementPage;
	
	public static void init() {
		foundAmaranthOre = new Achievement(
				"achievement.zollernextras_foundamaranthore",
				"zollernextras_foundamaranthore", 2, 0,
				ZollernBlocks.amaranthOre, (Achievement) null).registerStat();
		smeltedAmaranth = new Achievement(
				"achievement.zollernextras_smeltedamaranth",
				"zollernextras_smeltedamaranth", 4, 0,
				ZollernItems.amaranthIngot, foundAmaranthOre).registerStat();
		craftedAmaranthPickaxe = new Achievement(
				"achievement.zollernextras_craftedamaranthpickaxe",
				"zollernextras_craftedamaranthpickaxe", 4, 2,
				ZollernItems.amaranthPickaxe, smeltedAmaranth).registerStat();
		craftedAmaranthSword = new Achievement(
				"achievement.zollernextras_craftedamaranthsword",
				"zollernextras_craftedamaranthsword", 6, 2,
				ZollernItems.amaranthSword, smeltedAmaranth).registerStat();
		craftedAmaranthAxe = new Achievement(
				"achievement.zollernextras_craftedamaranthaxe",
				"zollernextras_craftedamaranthaxe", 8, 2,
				ZollernItems.amaranthAxe, smeltedAmaranth).registerStat();
		craftedAmaranthShovel = new Achievement(
				"achievement.zollernextras_craftedamaranthshovel",
				"zollernextras_craftedamaranthshovel", 10, 2,
				ZollernItems.amaranthShovel, smeltedAmaranth).registerStat();
		craftedAmaranthHoe = new Achievement(
				"achievement.zollernextras_craftedamaranthhoe",
				"zollernextras_craftedamaranthhoe", 10, 2,
				ZollernItems.amaranthHoe, smeltedAmaranth).registerStat();
		
		superCharged = new Achievement(
				"achievement.zollernextras_supercharged",
				"zollernextras_supercharged", -2, -2, ZollernItems.spcItem,
				(Achievement) null).registerStat();
		
		zollernAchievementPage = new AchievementPage("Zollern Extras",
				foundAmaranthOre, smeltedAmaranth, craftedAmaranthPickaxe,
				craftedAmaranthSword, craftedAmaranthAxe,
				craftedAmaranthShovel, craftedAmaranthHoe, superCharged);
		
		AchievementPage.registerAchievementPage(zollernAchievementPage);
	}
}