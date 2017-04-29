package zollernextras.achievements;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import zollernextras.items.ZollernItems;

public class ZollernAchievements {
	
	public static Achievement radianceCraftedAchievement;
	public static AchievementPage zollernAchievementPage;
	
	public static void init() {
		radianceCraftedAchievement = new Achievement(
				"achievement.radiancecrafted", "radiancecrafted", 0, 0,
				ZollernItems.radiance, (Achievement) null)
				.initIndependentStat().registerStat();
		zollernAchievementPage = new AchievementPage("\\u00A7cZollern Extras",
				radianceCraftedAchievement);
		
		AchievementPage.registerAchievementPage(zollernAchievementPage);
	}
	
}