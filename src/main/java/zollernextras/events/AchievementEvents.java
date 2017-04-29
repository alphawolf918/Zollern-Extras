package zollernextras.events;

import net.minecraft.item.Item;
import zollernextras.achievements.ZollernAchievements;
import zollernextras.items.ZollernItems;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementEvents {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		Item craftedItem = event.crafting.getItem();
		if (craftedItem == ZollernItems.radiance) {
			event.player.addStat(
					ZollernAchievements.radianceCraftedAchievement, 1);
		}
	}
	
}
