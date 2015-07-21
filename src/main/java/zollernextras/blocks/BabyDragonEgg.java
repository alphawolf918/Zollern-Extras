package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import zollernextras.lib.MainHelper;
import zollernextras.mobs.entities.EntityBabyDragon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BabyDragonEgg extends BlockDragonEgg {
	private static int ticksExisted = 0;
	
	public BabyDragonEgg() {
		MainHelper.setTab(this);
		MainHelper.setName(this, "babydragonegg");
		MainHelper.setTexture(this, "azurite");
		setHardness(3.0F);
		setResistance(15.0F);
		setStepSound(Block.soundTypePiston);
		setLightLevel(1.0F);
		setTickRandomly(true);
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_,
			int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		p_149695_1_.scheduleBlockUpdate(p_149695_2_, p_149695_3_, p_149695_4_,
				this, tickRate(p_149695_1_));
	}
	
	private void func_150018_e(World p_150018_1_, int p_150018_2_,
			int p_150018_3_, int p_150018_4_) {
		if (BlockFalling.func_149831_e(p_150018_1_, p_150018_2_,
				p_150018_3_ - 1, p_150018_4_) && p_150018_3_ >= 0) {
			byte b0 = 32;
			
			if (!BlockFalling.fallInstantly
					&& p_150018_1_.checkChunksExist(p_150018_2_ - b0,
							p_150018_3_ - b0, p_150018_4_ - b0, p_150018_2_
							+ b0, p_150018_3_ + b0, p_150018_4_ + b0)) {
				EntityFallingBlock entityfallingblock = new EntityFallingBlock(
						p_150018_1_, p_150018_2_ + 0.5F, p_150018_3_ + 0.5F,
						p_150018_4_ + 0.5F, this);
				p_150018_1_.spawnEntityInWorld(entityfallingblock);
			} else {
				p_150018_1_
				.setBlockToAir(p_150018_2_, p_150018_3_, p_150018_4_);
				
				while (BlockFalling.func_149831_e(p_150018_1_, p_150018_2_,
						p_150018_3_ - 1, p_150018_4_) && p_150018_3_ > 0) {
					--p_150018_3_;
				}
				
				if (p_150018_3_ > 0) {
					p_150018_1_.setBlock(p_150018_2_, p_150018_3_, p_150018_4_,
							this, 0, 2);
				}
			}
		}
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int par2, int par3, int p_149674_4_,
			Random p_149674_5_) {
		super.updateTick(world, p_149674_4_, p_149674_4_, p_149674_4_,
				p_149674_5_);
		func_150018_e(world, par2, par3, p_149674_4_);
		ticksExisted += 1;
		if (ticksExisted >= 1001) {
			Entity spider = new EntityBabyDragon(world);
			spider.setLocationAndAngles(par2 + 0.5D, par3, p_149674_4_ + 0.5D,
					0.0F, 0.0F);
			world.spawnEntityInWorld(spider);
			ticksExisted = 0;
			world.setBlock(par2, par3, p_149674_4_, Blocks.air);
		} else {
			ticksExisted += 10;
		}
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4,
			EntityPlayer par5EntityPlayer) {
	}
	
	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return Item.getItemById(0);
	}
}