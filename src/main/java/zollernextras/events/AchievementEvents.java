package zollernextras.events;

import net.minecraft.item.ItemStack;
import zollernextras.achievements.ZollernAchievements;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementEvents {
	
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		if (event.crafting.getItem().equals(ZollernItems.amaranthPickaxe)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthPickaxe, 1);
		}
	}
	
	@SubscribeEvent
	public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
		if (event.smelting.getItem().equals(ZollernItems.amaranthIngot)) {
			event.player.addStat(ZollernAchievements.smeltedAmaranth, 1);
		}
	}
	
	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent event) {
		ItemStack itemPickedUp = event.pickedUp.getEntityItem();
		if (itemPickedUp.isItemEqual(new ItemStack(ZollernBlocks.amaranthOre))) {
			event.player.addStat(ZollernAchievements.foundAmaranthOre, 1);
		}
	}
}