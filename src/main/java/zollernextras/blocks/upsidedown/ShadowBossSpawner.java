package zollernextras.blocks.upsidedown;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.blocks.GenericBlock;
import zollernextras.items.ZollernItems;
import zollernextras.mobs.entities.boss.EntityShadowAlien;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShadowBossSpawner extends GenericBlock {
	
	public ShadowBossSpawner() {
		super("shadowspawner", 10.0F);
		this.setBlockUnbreakable();
		this.setStepSound(soundTypePiston);
		this.setMaterial(Material.iron);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer,
				par6, par7, par8, par9);
		if (par5EntityPlayer.getHeldItem() != null) {
			ItemStack heldItemStack = par5EntityPlayer.getHeldItem();
			Item heldItem = heldItemStack.getItem();
			if (heldItem != null && heldItem == ZollernItems.shadeKey) {
				InventoryPlayer playerInventory = par5EntityPlayer.inventory;
				if (playerInventory.hasItem(ZollernItems.shadeKey)
						&& !par5EntityPlayer.capabilities.isCreativeMode) {
					playerInventory.consumeInventoryItem(ZollernItems.shadeKey);
				}
				this.spawnShadowBoss(par1World, par2, par3, par4,
						par5EntityPlayer);
			} else {
				ZollernExtrasMod.proxy.sendChatMessage(par5EntityPlayer,
						"You need a Shade Key to spawn this boss!");
			}
		} else {
			ZollernExtrasMod.proxy.sendChatMessage(par5EntityPlayer,
					"You need a Shade Key to spawn this boss!");
		}
		return true;
	}
	
	public void spawnShadowBoss(World par1World, int par2, int par3, int par4,
			EntityPlayer player) {
		if (!par1World.isRemote
				&& par1World.difficultySetting != EnumDifficulty.PEACEFUL) {
			EntityShadowAlien shadowBoss = new EntityShadowAlien(par1World);
			shadowBoss.setLocationAndAngles(par2, par3, par4, 0, 0);
			par1World.spawnEntityInWorld(shadowBoss);
			par1World.setBlock(par2, par3, par4, Blocks.air);
			ZollernExtrasMod.proxy.sendChatMessage(player,
					"The beast has awoken! Slay it, lest it consume you!");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return Item.getItemById(0);
	}
	
}