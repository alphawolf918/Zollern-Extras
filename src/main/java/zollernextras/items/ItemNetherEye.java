package zollernextras.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.items.teleporter.MessageTeleportToDimension;

public class ItemNetherEye extends ModItem {
	
	public ItemNetherEye() {
		super("nethereye");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer Player) {
		
		ZollernExtrasMod.snw.sendToServer(new MessageTeleportToDimension(-1,
				Player.getEntityId()));
		return par1ItemStack;
	}
	
}