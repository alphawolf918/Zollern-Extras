package zollernextras.blocks.upsidedown;

import java.util.Random;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntitySpiderling;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SpiderlingEgg extends BlockDragonEgg {
	
	public int ticksEggExisted = 0;
	
	public SpiderlingEgg() {
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "spideregg");
		this.setStepSound(soundTypePiston);
		this.setLightLevel(0.1F);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
		this.setHardness(6.0F);
		this.setResistance(10.0F);
		this.setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);
		if (this.ticksEggExisted >= 1000) {
			par1World.playSoundEffect(par2 + 1.5D, par3 + 1.5D, par4 + 1.5D,
					ZollernModInfo.MODID + ":spiderling.heartbeat", 1.5F,
					par1World.rand.nextFloat() * 0.1F + 0.9F);
			this.hatchSpider(par1World, par2, par3, par4);
			this.ticksEggExisted = 0;
			par1World.setBlock(par2, par3, par4, Blocks.air);
		} else {
			this.ticksEggExisted += 5;
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3,
			int par4, int par5) {
		this.hatchSpider(par1World, par2, par3, par4);
		this.ticksEggExisted = 0;
		par1World.setBlock(par2, par3, par4, Blocks.air);
	}
	
	/**
	 * Hatch a Spiderling mob at this location.
	 * 
	 * @param par1World
	 *            The world object to use.
	 * @param par2x
	 *            X
	 * @param par3y
	 *            Y
	 * @param par4z
	 *            Z
	 */
	public void hatchSpider(World par1World, int par2x, int par3y, int par4z) {
		int randInt = new Random().nextInt(4);
		randInt = randInt == 0 ? 1 : randInt;
		for (int i = 1; i < randInt; i++) {
			if (!par1World.isRemote) {
				EntitySpiderling spiderling = new EntitySpiderling(par1World);
				spiderling.setLocationAndAngles(par2x + i, par3y + i,
						par4z + i, 0, 0);
				par1World.spawnEntityInWorld(spiderling);
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		this.ticksEggExisted += 2;
		return true;
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4,
			EntityPlayer par5EntityPlayer) {
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return Item.getItemById(0);
	}
}