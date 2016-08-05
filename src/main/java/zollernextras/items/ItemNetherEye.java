package zollernextras.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import zollernextras.items.teleporter.MessageTeleportToDimension;
import zollernextras.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherEye extends GenericItem {
	
	public ItemNetherEye() {
		super("nethereye");
		this.setMaxStackSize(1);
		this.setMaxDamage(16);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			par1ItemStack.damageItem(1, par3EntityPlayer);
		}
		int dimId = par3EntityPlayer.dimension == 0 ? -1 : 0;
		int entityId = par3EntityPlayer.getEntityId();
		PacketDispatcher.getSimpleNetworkWrapper().sendToServer(
				new MessageTeleportToDimension(dimId, entityId));
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.ITALIC + "Teleport to and from");
		list.add(EnumChatFormatting.ITALIC + "the Nether at will!");
	}
}