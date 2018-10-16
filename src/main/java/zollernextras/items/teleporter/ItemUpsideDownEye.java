package zollernextras.items.teleporter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItemBase;

public class ItemUpsideDownEye extends ZollernItemBase {
	
	public ItemUpsideDownEye() {
		super("upsidedowneye");
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world,
			EntityPlayer player, EnumHand hand) {
		ItemStack itemStack = player.getHeldItem(hand);
		if (!player.capabilities.isCreativeMode) {
			itemStack.damageItem(1, player);
		}
		if (player.dimension == 0) {
			ZollernExtrasMod.snw.sendToServer(new MessageTeleportToDimension(
					ZEConfig.dimensionUpsideDownID, player.getEntityId()));
		} else {
			ZollernExtrasMod.snw.sendToServer(new MessageTeleportToDimension(0,
					player.getEntityId()));
		}
		// player.swingArm(hand);
		return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
	}
	
}
