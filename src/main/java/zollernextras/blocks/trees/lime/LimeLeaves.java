package zollernextras.blocks.trees.lime;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LimeLeaves extends BlockLeavesBase implements IShearable {
	
	private IIcon texture;
	int[] adjacentTreeBlocks;
	
	public LimeLeaves() {
		super(Material.leaves, false);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(ZollernModInfo.MODID + "_limeleaves");
		this.setBlockTextureName(ZollernModInfo.MODID + ":limeleaves");
		this.setTickRandomly(true);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(Block.soundTypeGrass);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return Blocks.leaves.isOpaqueCube();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerFoliage.getFoliageColor(d0, d1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_) {
		return ColorizerFoliage.getFoliageColorBasic();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		
		for (int k1 = -1; k1 <= 1; ++k1) {
			for (int l1 = -1; l1 <= 1; ++l1) {
				int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1,
						p_149720_4_ + k1).getBiomeFoliageColor(
						p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}
		
		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		if (world.canLightningStrikeAt(x, y + 1, z)
				&& !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				&& random.nextInt(15) == 1) {
			double d0 = x + random.nextFloat();
			double d1 = y - 0.05D;
			double d2 = z + random.nextFloat();
			world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
		super.randomDisplayTick(world, x, y, z, random);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5,
			int par6) {
		byte radius = 1;
		int bounds = radius + 1;
		
		if (world.checkChunksExist(x - bounds, y - bounds, z - bounds, x
				+ bounds, y + bounds, z + bounds)) {
			for (int i = -radius; i <= radius; ++i) {
				for (int j = -radius; j <= radius; ++j) {
					for (int k = -radius; k <= radius; ++k) {
						Block block = world.getBlock(x + i, y + j, z + k);
						
						if (block != null) {
							block.beginLeavesDecay(world, x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.isRemote) {
			return;
		}
		
		int meta = world.getBlockMetadata(x, y, z);
		
		if ((meta & 8) != 0 && (meta & 4) == 0) {
			byte b0 = 4;
			int i1 = b0 + 1;
			byte b1 = 32;
			int j1 = b1 * b1;
			int k1 = b1 / 2;
			
			if (this.adjacentTreeBlocks == null) {
				this.adjacentTreeBlocks = new int[b1 * b1 * b1];
			}
			
			int l1;
			
			if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1,
					z + i1)) {
				int i2;
				int j2;
				int k2;
				
				for (l1 = -b0; l1 <= b0; ++l1) {
					for (i2 = -b0; i2 <= b0; ++i2) {
						for (j2 = -b0; j2 <= b0; ++j2) {
							Block block = world
									.getBlock(x + l1, y + i2, z + j2);
							
							if (block != null
									&& block.canSustainLeaves(world, x + l1, y
											+ i2, z + j2)) {
								this.adjacentTreeBlocks[(l1 + k1) * j1
										+ (i2 + k1) * b1 + j2 + k1] = 0;
							} else if (block != null
									&& block.isLeaves(world, x + l1, y + i2, z
											+ j2)) {
								this.adjacentTreeBlocks[(l1 + k1) * j1
										+ (i2 + k1) * b1 + j2 + k1] = -2;
							} else {
								this.adjacentTreeBlocks[(l1 + k1) * j1
										+ (i2 + k1) * b1 + j2 + k1] = -1;
							}
						}
					}
				}
				
				for (l1 = 1; l1 <= 4; ++l1) {
					for (i2 = -b0; i2 <= b0; ++i2) {
						for (j2 = -b0; j2 <= b0; ++j2) {
							for (k2 = -b0; k2 <= b0; ++k2) {
								if (this.adjacentTreeBlocks[(i2 + k1) * j1
										+ (j2 + k1) * b1 + k2 + k1] == l1 - 1) {
									if (this.adjacentTreeBlocks[(i2 + k1 - 1)
											* j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1 - 1)
												* j1 + (j2 + k1) * b1 + k2 + k1] = l1;
									}
									if (this.adjacentTreeBlocks[(i2 + k1 + 1)
											* j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1 + 1)
												* j1 + (j2 + k1) * b1 + k2 + k1] = l1;
									}
									if (this.adjacentTreeBlocks[(i2 + k1) * j1
											+ (j2 + k1 - 1) * b1 + k2 + k1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1) * j1
												+ (j2 + k1 - 1) * b1 + k2 + k1] = l1;
									}
									if (this.adjacentTreeBlocks[(i2 + k1) * j1
											+ (j2 + k1 + 1) * b1 + k2 + k1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1) * j1
												+ (j2 + k1 + 1) * b1 + k2 + k1] = l1;
									}
									if (this.adjacentTreeBlocks[(i2 + k1) * j1
											+ (j2 + k1) * b1 + k2 + k1 - 1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1) * j1
												+ (j2 + k1) * b1 + k2 + k1 - 1] = l1;
									}
									if (this.adjacentTreeBlocks[(i2 + k1) * j1
											+ (j2 + k1) * b1 + k2 + k1 + 1] == -2) {
										this.adjacentTreeBlocks[(i2 + k1) * j1
												+ (j2 + k1) * b1 + k2 + k1 + 1] = l1;
									}
								}
							}
						}
					}
				}
			}
			
			l1 = this.adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];
			
			if (l1 >= 0) {
				world.setBlockMetadataWithNotify(x, y, z, meta & -9, 4);
			} else {
				this.removeLeaves(world, x, y, z);
			}
		}
	}
	
	private void removeLeaves(World world, int x, int y, int z) {
		this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
		world.setBlockToAir(x, y, z);
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		Item droppedItem;
		int dropCheck = new Random().nextInt(2);
		switch (dropCheck) {
		case 0:
			droppedItem = ZollernItems.lime;
			break;
		case 1:
			droppedItem = Item.getItemFromBlock(ZollernBlocks.limeSapling);
			break;
		default:
			droppedItem = Item.getItemFromBlock(ZollernBlocks.limeSapling);
			break;
		case 2:
			droppedItem = ZollernItems.lime;
			break;
		}
		return droppedItem;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z,
			int meta, float chance, int par7) {
		if (world.isRemote) {
			return;
		}
		if (world.rand.nextInt(5) == 0) {
			Item var9 = this.getItemDropped(meta, world.rand, par7);
			this.dropBlockAsItem(world, x, y, z,
					new ItemStack(var9, 1, this.damageDropped(meta)));
		}
	}
	
	@Override
	public int getDamageValue(World par1World, int par2, int par3, int par4) {
		return par1World.getBlockMetadata(par2, par3, par4) & 3;
	}
	
	@Override
	public int quantityDropped(Random random) {
		Random rand = new Random();
		int randInt = rand.nextInt(2);
		int randInt2 = randInt == 0 ? 1 : randInt;
		return randInt2;
	}
	
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x,
			int y, int z) {
		return true;
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}
	
	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean par1) {
		this.field_150121_P = par1;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4, int par5) {
		return true;
	}
	
	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z,
				world.getBlockMetadata(x, y, z) | 8, 4);
	}
	
	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}