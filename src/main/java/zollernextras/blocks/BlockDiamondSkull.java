package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollernextras.lib.ZollernHelper;
import zollernextras.mobs.entities.EntityDiamondGolem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDiamondSkull extends BlockDirectional {
	
	@SideOnly(Side.CLIENT)
	private IIcon field_149984_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_149986_M;
	
	public BlockDiamondSkull() {
		super(Material.circuits);
		this.setTickRandomly(true);
		ZollernHelper.setTab(this);
		ZollernHelper.setName(this, "diamondskull");
		ZollernHelper.setTexture(this, "dh");
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
	}
	
	@Override
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_,
			int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_,
				p_149749_5_, p_149749_6_);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return Item.getItemFromBlock(ZollernBlocks.diamondSkull);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_,
			int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_,
				p_149668_4_);
		return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_,
				p_149668_3_, p_149668_4_);
	}
	
	@Override
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_,
			int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_,
			ItemStack p_149689_6_) {
		int l = MathHelper
				.floor_double(p_149689_5_.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
		p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_,
				p_149689_4_, l, 2);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_,
			int p_149719_2_, int p_149719_3_, int p_149719_4_) {
		int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_,
				p_149719_4_) & 7;
		
		switch (l) {
		case 1:
		default:
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
			break;
		case 2:
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
			break;
		case 4:
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
			break;
		case 5:
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_,
			int p_149726_3_, int p_149726_4_) {
		if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.diamond_block
				&& p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2,
						p_149726_4_) == Blocks.diamond_block) {
			boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1,
					p_149726_3_ - 1, p_149726_4_) == Blocks.diamond_block
					&& p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1,
							p_149726_4_) == Blocks.diamond_block;
			boolean flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1,
					p_149726_4_ - 1) == Blocks.diamond_block
					&& p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1,
							p_149726_4_ + 1) == Blocks.diamond_block;
			
			if (flag || flag1) {
				p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_,
						getBlockById(0), 0, 2);
				p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_,
						getBlockById(0), 0, 2);
				p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_,
						getBlockById(0), 0, 2);
				
				if (flag) {
					p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1,
							p_149726_4_, getBlockById(0), 0, 2);
					p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1,
							p_149726_4_, getBlockById(0), 0, 2);
				} else {
					p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1,
							p_149726_4_ - 1, getBlockById(0), 0, 2);
					p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1,
							p_149726_4_ + 1, getBlockById(0), 0, 2);
				}
				
				EntityDiamondGolem entitydiamondgolem = new EntityDiamondGolem(
						p_149726_1_);
				entitydiamondgolem.setPlayerCreated(true);
				entitydiamondgolem.setLocationAndAngles(p_149726_2_ + 0.5D,
						p_149726_3_ - 1.95D, p_149726_4_ + 0.5D, 0.0F, 0.0F);
				p_149726_1_.spawnEntityInWorld(entitydiamondgolem);
				
				for (int l = 0; l < 120; ++l) {
					p_149726_1_.spawnParticle("snowballpoof", p_149726_2_
							+ p_149726_1_.rand.nextDouble(), p_149726_3_ - 2
							+ p_149726_1_.rand.nextDouble() * 3.9D, p_149726_4_
							+ p_149726_1_.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
				
				p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_,
						p_149726_4_, getBlockById(0));
				p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1,
						p_149726_4_, getBlockById(0));
				p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2,
						p_149726_4_, getBlockById(0));
				
				if (flag) {
					p_149726_1_.notifyBlockChange(p_149726_2_ - 1,
							p_149726_3_ - 1, p_149726_4_, getBlockById(0));
					p_149726_1_.notifyBlockChange(p_149726_2_ + 1,
							p_149726_3_ - 1, p_149726_4_, getBlockById(0));
				} else {
					p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1,
							p_149726_4_ - 1, getBlockById(0));
					p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1,
							p_149726_4_ + 1, getBlockById(0));
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 1 ? this.field_149984_b
				: (p_149691_1_ == 0 ? this.field_149984_b
						: (p_149691_2_ == 2 && p_149691_1_ == 2 ? this.field_149986_M
								: (p_149691_2_ == 3 && p_149691_1_ == 5 ? this.field_149986_M
										: (p_149691_2_ == 0 && p_149691_1_ == 3 ? this.field_149986_M
												: (p_149691_2_ == 1
														&& p_149691_1_ == 4 ? this.field_149986_M
														: this.blockIcon)))));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_149986_M = p_149651_1_.registerIcon(this.getTextureName()
				+ "_side");
		this.field_149984_b = p_149651_1_.registerIcon(this.getTextureName()
				+ "_top");
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName()
				+ "_face");
	}
}