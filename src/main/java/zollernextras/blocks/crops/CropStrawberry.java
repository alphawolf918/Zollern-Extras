package zollernextras.blocks.crops;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CropStrawberry extends BlockCrops {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] field_149868_a;
	
	public static Item itemDropped;
	
	public CropStrawberry() {
		super();
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.35F, 0.5F + f);
		this.setCreativeTab((CreativeTabs) null);
		ZollernHelper.setName(this, "strawberry");
		ZollernHelper.setTexture(this, "strawberry");
		this.setTickRandomly(true);
		this.disableStats();
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block p_149854_1_) {
		return p_149854_1_ == Blocks.farmland;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return 6;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_,
			int p_149690_3_, int p_149690_4_, int p_149690_5_,
			float p_149690_6_, int p_149690_7_) {
		super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_,
				p_149690_4_, p_149690_5_, p_149690_6_, 0);
	}
	
	private float func_149864_n(World p_149864_1_, int p_149864_2_,
			int p_149864_3_, int p_149864_4_) {
		float f = 1.0F;
		Block block = p_149864_1_.getBlock(p_149864_2_, p_149864_3_,
				p_149864_4_ - 1);
		Block block1 = p_149864_1_.getBlock(p_149864_2_, p_149864_3_,
				p_149864_4_ + 1);
		Block block2 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_,
				p_149864_4_);
		Block block3 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_,
				p_149864_4_);
		Block block4 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_,
				p_149864_4_ - 1);
		Block block5 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_,
				p_149864_4_ - 1);
		Block block6 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_,
				p_149864_4_ + 1);
		Block block7 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_,
				p_149864_4_ + 1);
		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this
				|| block7 == this;
		
		for (int l = p_149864_2_ - 1; l <= p_149864_2_ + 1; ++l) {
			for (int i1 = p_149864_4_ - 1; i1 <= p_149864_4_ + 1; ++i1) {
				float f1 = 0.0F;
				
				if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1)
						.canSustainPlant(p_149864_1_, l, p_149864_3_ - 1, i1,
								ForgeDirection.UP, this)) {
					f1 = 1.0F;
					
					if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1).isFertile(
							p_149864_1_, l, p_149864_3_ - 1, i1)) {
						f1 = 3.0F;
					}
				}
				
				if (l != p_149864_2_ || i1 != p_149864_4_) {
					f1 /= 4.0F;
				}
				
				f += f1;
			}
		}
		
		if (flag2 || flag && flag1) {
			f /= 2.0F;
		}
		
		return f;
	}
	
	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_,
			int p_149674_4_, Random p_149674_5_) {
		super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_,
				p_149674_5_);
		
		if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1,
				p_149674_4_) >= 9) {
			int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_,
					p_149674_4_);
			
			if (l < 7) {
				float f = this.func_149864_n(p_149674_1_, p_149674_2_,
						p_149674_3_, p_149674_4_);
				
				if (p_149674_5_.nextInt((int) (25.0F / f) + 1) == 0) {
					++l;
					p_149674_1_.setBlockMetadataWithNotify(p_149674_2_,
							p_149674_3_, p_149674_4_, l, 2);
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return p_149650_1_ == 7 ? this.func_149865_P() : this.func_149866_i();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		if (p_149691_2_ < 7) {
			if (p_149691_2_ == 6) {
				p_149691_2_ = 5;
			}
			return this.field_149868_a[p_149691_2_ >> 1];
		} else {
			return this.field_149868_a[3];
		}
	}
	
	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_,
			int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_,
				p_149851_4_) != 7;
	}
	
	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_,
			int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}
	
	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return this.func_149866_i();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_149868_a = new IIcon[4];
		for (int i = 0; i < this.field_149868_a.length; ++i) {
			this.field_149868_a[i] = p_149651_1_.registerIcon(this
					.getTextureName() + "_stage_" + i);
		}
	}
	
	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_,
			int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		this.func_149863_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
	}
	
	@Override
	public void func_149863_m(World p_149863_1_, int p_149863_2_,
			int p_149863_3_, int p_149863_4_) {
		int l = p_149863_1_.getBlockMetadata(p_149863_2_, p_149863_3_,
				p_149863_4_)
				+ MathHelper.getRandomIntegerInRange(p_149863_1_.rand, 2, 5);
		
		if (l > 7) {
			l = 7;
		}
		
		p_149863_1_.setBlockMetadataWithNotify(p_149863_2_, p_149863_3_,
				p_149863_4_, l, 2);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata,
				fortune);
		
		if (metadata >= 7) {
			for (int i = 0; i < 3 + fortune; ++i) {
				if (world.rand.nextInt(15) <= metadata) {
					ret.add(new ItemStack(this.func_149866_i(), 1, 0));
				}
			}
		}
		return ret;
	}
	
	@Override
	public Item func_149866_i() {
		return ZollernItems.strawberry;
	}
	
	@Override
	public Item func_149865_P() {
		return ZollernItems.strawberry;
	}
}