package zollernextras.blocks.lostdesert;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import zollernextras.blocks.BlockList;
import zollernextras.dimensions.Dimensions;
import zollernextras.dimensions.lostdesert.TeleporterLostDesert;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortalBlock extends BlockPortal {
	public PortalBlock() {
		MainHelper.setNameAndTexture(this, "portalblock");
		this.setTickRandomly(true);
		this.setLightLevel(1F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		for (int l = 0; l < 4; ++l) {
			double d0 = par2 + par5Random.nextFloat();
			double d1 = par3 + par5Random.nextFloat();
			double d2 = par4 + par5Random.nextFloat();
			double d3 = 0.0D;
			double d4 = 1.5D;
			double d5 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			d3 = (par5Random.nextFloat() - 0.5D) * 0.5D;
			d4 = (par5Random.nextFloat() - 1.5D) * 1.5D;
			d5 = (par5Random.nextFloat() - 0.5D) * 0.5D;
			
			if (par1World.getBlock(par2 - 1, par3, par4) != this
					&& par1World.getBlock(par2 + 1, par3, par4) != this) {
				d0 = par2 + 1.5D + 0.45D * i1;
				d3 = par5Random.nextFloat() * 4.0F * i1;
			} else {
				d2 = par4 + 0.5D + 0.45D * i1;
				d5 = par5Random.nextFloat() * 2.0F * i1;
			}
			
			par1World.spawnParticle("portal", 0.5F, 1.0F, 0.5F, 0.5F, 1.0F,
					0.5F);
		}
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		if (par5Entity.ridingEntity == null
				&& par5Entity.riddenByEntity == null
				&& par5Entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;
			
			MinecraftServer mServer = MinecraftServer.getServer();
			
			if (player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != Dimensions.dimId) {
				player.timeUntilPortal = 10;
				
				player.mcServer
				.getConfigurationManager()
				.transferPlayerToDimension(
						player,
						Dimensions.dimId,
						new TeleporterLostDesert(
								mServer.worldServerForDimension(Dimensions.dimId)));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager()
				.transferPlayerToDimension(
						player,
						0,
						new TeleporterLostDesert(mServer
								.worldServerForDimension(1)));
			}
		}
	}
	
	@Override
	public boolean func_150000_e(World par1World, int par2, int par3, int par4) {
		byte b0 = 0;
		byte b1 = 0;
		
		if (par1World.getBlock(par2 - 1, par3, par4) == BlockList.creepStone
				|| par1World.getBlock(par2 + 1, par3, par4) == BlockList.creepStone) {
			b0 = 1;
		}
		
		if (par1World.getBlock(par2, par3, par4 - 1) == BlockList.creepStone
				|| par1World.getBlock(par2, par3, par4 + 1) == BlockList.creepStone) {
			b1 = 1;
		}
		
		if (b0 == b1) {
			return false;
		} else {
			if (par1World.isAirBlock(par2 - b0, par3, par4 - b1)) {
				par2 -= b0;
				par4 -= b1;
			}
			
			int l;
			int i1;
			
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1,
								par4 + b1 * l);
						boolean isAirBlock = par1World.isAirBlock(
								par2 + b0 * l, par3 + i1, par4 + b1 * l);
						
						if (flag) {
							if (j1 != BlockList.creepStone) {
								return false;
							}
						} else if (!isAirBlock && j1 != Blocks.fire) {
							return false;
						}
					}
				}
			}
			
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l,
							this, 0, 2);
				}
			}
			
			return true;
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		byte b0 = 0;
		byte b1 = 1;
		
		if (par1World.getBlock(par2 - 1, par3, par4) == this
				|| par1World.getBlock(par2 + 1, par3, par4) == this) {
			b0 = 1;
			b1 = 0;
		}
		
		int i1;
		
		for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1) {
			;
		}
		
		if (par1World.getBlock(par2, i1 - 1, par4) != BlockList.creepStone) {
			par1World.setBlockToAir(par2, par3, par4);
		} else {
			int j1;
			
			for (j1 = 1; j1 < 4
					&& par1World.getBlock(par2, i1 + j1, par4) == this; ++j1) {
				;
			}
			
			if (j1 == 3
					&& par1World.getBlock(par2, i1 + j1, par4) == BlockList.creepStone) {
				boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this
						|| par1World.getBlock(par2 + 1, par3, par4) == this;
				boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this
						|| par1World.getBlock(par2, par3, par4 + 1) == this;
				
				if (flag && flag1) {
					par1World.setBlockToAir(par2, par3, par4);
				} else {
					if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != BlockList.creepStone || par1World
							.getBlock(par2 - b0, par3, par4 - b1) != this)
							&& (par1World.getBlock(par2 - b0, par3, par4 - b1) != BlockList.creepStone || par1World
							.getBlock(par2 + b0, par3, par4 + b1) != this)) {
						par1World.setBlockToAir(par2, par3, par4);
					}
				}
			} else {
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
	}
}