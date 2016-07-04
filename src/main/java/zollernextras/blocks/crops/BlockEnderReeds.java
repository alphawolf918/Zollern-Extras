package zollernextras.blocks.crops;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import zollernextras.blocks.BlockList;
import zollernextras.items.ItemList;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEnderReeds extends BlockReed {
	
	public BlockEnderReeds() {
		MainHelper.setNameAndTexture(this, "enderreeds");
		this.setLightLevel(0.4F);
		float f = 0.375F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_,
			int p_149674_4_, Random p_149674_5_) {
		if (p_149674_1_.getBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_) == BlockList.enderReeds
				|| this.func_150170_e(p_149674_1_, p_149674_2_, p_149674_3_,
						p_149674_4_)) {
			if (p_149674_1_.isAirBlock(p_149674_2_, p_149674_3_ + 1,
					p_149674_4_)) {
				int l;
				
				for (l = 1; p_149674_1_.getBlock(p_149674_2_, p_149674_3_ - l,
						p_149674_4_) == this; ++l) {
					;
				}
				
				if (l < 6) {
					int i1 = p_149674_1_.getBlockMetadata(p_149674_2_,
							p_149674_3_, p_149674_4_);
					
					if (i1 == 15) {
						p_149674_1_.setBlock(p_149674_2_, p_149674_3_ + 1,
								p_149674_4_, this);
						p_149674_1_.setBlockMetadataWithNotify(p_149674_2_,
								p_149674_3_, p_149674_4_, 0, 4);
					} else {
						p_149674_1_.setBlockMetadataWithNotify(p_149674_2_,
								p_149674_3_, p_149674_4_, i1 + 1, 4);
					}
				}
			}
		}
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.enderReeds;
	}
	
	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_,
			int p_149742_3_, int p_149742_4_) {
		Block block = p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1,
				p_149742_4_);
		if (block == Blocks.end_stone || block == BlockList.enderReeds
				|| block == BlockList.enderDirt) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return ItemList.enderReeds;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		return 0xbb00ff;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}
	
}