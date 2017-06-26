package zollernextras.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.config.ZEConfig;
import zollernextras.dimension.DimensionLoader;
import zollernextras.items.teleporter.MessageTeleportToDimension;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUpsideDownEye extends GenericItem {
	
	private static int dimensionId = DimensionLoader.getDimID();
	
	public ItemUpsideDownEye() {
		super("upsidedowneye");
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}
	
	// @Override
	// public ItemStack onItemRightClick(ItemStack par1ItemStack, World
	// par2World,
	// EntityPlayer par3EntityPlayer) {
	// if (!par3EntityPlayer.capabilities.isCreativeMode) {
	// par1ItemStack.damageItem(1, par3EntityPlayer);
	// }
	// int dimId = par3EntityPlayer.dimension == 0 ? dimensionId : 0;
	// int entityId = par3EntityPlayer.getEntityId();
	// PacketDispatcher.getSimpleNetworkWrapper().sendToServer(
	// new MessageTeleportToDimension(dimId, entityId));
	// return par1ItemStack;
	// }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer Player) {
		
		ItemStack cStack = par1ItemStack.copy();
		cStack.setItemDamage(cStack.getItemDamage() + 1);
		
		if (Player.dimension == 0) {
			ZollernExtrasMod.snw.sendToServer(new MessageTeleportToDimension(
					ZEConfig.dimensionUpsideDownID, Player.getEntityId()));
			return cStack;
		} else {
			ZollernExtrasMod.snw.sendToServer(new MessageTeleportToDimension(0,
					Player.getEntityId()));
			return cStack;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.ITALIC + "Travel through the");
		list.add(EnumChatFormatting.ITALIC + "Upside-Down..");
	}
}