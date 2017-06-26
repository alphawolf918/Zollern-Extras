package zollernextras.events;

import net.minecraft.item.ItemStack;
import zollernextras.achievements.ZollernAchievements;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementEvents {
	
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		if (event.crafting.getItem().equals(ZollernItems.amaranthPickaxe)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthPickaxe, 1);
		} else if (event.crafting.getItem().equals(ZollernItems.amaranthSword)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthSword, 1);
		} else if (event.crafting.getItem().equals(ZollernItems.amaranthAxe)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthAxe, 1);
		} else if (event.crafting.getItem().equals(ZollernItems.amaranthShovel)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthShovel, 1);
		} else if (event.crafting.getItem().equals(ZollernItems.amaranthHoe)) {
			event.player.addStat(ZollernAchievements.craftedAmaranthHoe, 1);
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
		} else if (itemPickedUp
				.isItemEqual(new ItemStack(ZollernItems.spcItem))) {
			event.player.addStat(ZollernAchievements.superCharged, 1);
		}
	}
	
	@SubscribeEvent
	public void onDimensionChanged(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.toDim == ZEConfig.dimensionUpsideDownID) {
			event.player.addStat(ZollernAchievements.upsideDownArrived, 1);
		}
	}
}