package zollernextras.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.items.ingots.Gem;
import zollernextras.potions.ZollernPotion;

public class ItemRadiance extends Gem {
	
	public ItemRadiance() {
		super("radiance");
	}
	
	// Here we just call the exact same thing that we called in the Events file.
	// Refer there for a more in depth explanation.
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3Entity) {
		if (!par3Entity.isPotionActive(ZollernPotion.radiance)) {
			par3Entity.addPotionEffect(new PotionEffect(
					ZollernPotion.radiance.id, ZollernPotion.radianceTime, 0));
			par3Entity.inventory.consumeInventoryItem(ZollernItems.radiance);
			ZollernExtrasMod.proxy.sendChatMessage(par3Entity,
					"You are irradiated with a brilliant light.");
		}
		return par1ItemStack;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1) {
		return EnumRarity.rare;
	}
	
}