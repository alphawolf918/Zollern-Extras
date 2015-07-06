package zollernextras.blocks.crops;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import zollernextras.items.ItemList;
import zollernextras.lib.M;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CropStrawberry extends BlockCrops {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] field_149868_a;
	
	public static Item itemDropped;
	
	public CropStrawberry() {
		this.setCreativeTab((CreativeTabs) null);
		M.setName(this, "strawberry");
		M.setTexture(this, "strawberry");
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
	public Item func_149866_i() {
		return ItemList.strawberry;
	}
	
	@Override
	public Item func_149865_P() {
		return ItemList.strawberry;
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
}