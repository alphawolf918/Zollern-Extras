package zollernextras.items;

import java.util.List;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.lib.MainHelper;
import zollernextras.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHeartForce extends Item {
	
	double dblMaxHealthLimit = 80.0D;
	int intMaxHealthLimit = (int) dblMaxHealthLimit;
	int numTimes = 0;
	double healthIncreaseAmount = 2.0D;
	
	public ItemHeartForce() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_heartforce");
		this.setTextureName(Reference.MODID + ":" + "heartforce");
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		EntityPlayer player = par2EntityPlayer;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if (!player.capabilities.isCreativeMode) {
			float maxHealth = player.getMaxHealth();
			IAttributeInstance attrMaxHealth = player
					.getEntityAttribute(SharedMonsterAttributes.maxHealth);
			if (attrMaxHealth.getAttributeValue() < dblMaxHealthLimit
					&& props.getMaxHealth() < dblMaxHealthLimit) {
				maxHealth += healthIncreaseAmount;
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth)
						.setBaseValue(maxHealth);
				player.setHealth(maxHealth);
				props.setMaxHealth(maxHealth);
				par1ItemStack.damageItem(2, par2EntityPlayer);
				if (!player.worldObj.isRemote) {
					MainHelper.addChatMessage(player, EnumChatFormatting.GOLD + "+"
							+ this.healthIncreaseAmount
							+ " Max Health! Total: " + props.getMaxHealth());
				}
			} else {
				MainHelper.addChatMessage(player, "Max health cannot exceed "
						+ dblMaxHealthLimit + ".");
			}
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.ITALIC + "A great and healing power.");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}
}