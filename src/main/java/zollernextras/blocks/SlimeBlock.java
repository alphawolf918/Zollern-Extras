package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class SlimeBlock extends Block {
	
	public SlimeBlock() {
		super(Material.cake);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(Reference.MODID + "_slimeblock");
		this.setBlockTextureName(Reference.MODID + ":" + "slimeblock");
		this.setResistance(1F);
		this.setHardness(0.5F);
		this.setStepSound(Block.soundTypeCloth);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1world, int par2, int par3,
			int par4, int par5) {
		int rand = (new Random()).nextInt(8);
		if (par1world.difficultySetting != EnumDifficulty.PEACEFUL
				&& !par1world.isRemote) {
			if (rand <= 3) {
				EntitySlime slime = new EntitySlime(par1world);
				slime.setLocationAndAngles(par2 + 0.5D, par3, par4 + 0.5D,
						0.0F, 0.0F);
				par1world.spawnEntityInWorld(slime);
			}
		}
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemById(341);
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) > 5) {
			return 2;
		} else {
			return 1;
		}
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		entity.motionY += 1.0F;
		entity.fallDistance = 0F;
	}
}