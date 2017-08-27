package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollernextras.lib.EnumBlockVariant;

public class ZollernBlockOre extends ZollernBlockBase {
	
	protected EnumBlockVariant oreVariant = EnumBlockVariant.OVERWORLD;
	protected static ZollernBlockOre instance;
	protected boolean isExplosive = false;
	protected boolean hasPotionEffect = false;
	protected Potion blockPotionEffect;
	protected Random rand = new Random();
	
	public ZollernBlockOre(String strName, float hardResist) {
		super(strName, hardResist);
		instance = this;
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public Block setShouldGivePotionEffect(boolean shouldGivePotionEffect,
			Potion potionEffect) {
		this.hasPotionEffect = shouldGivePotionEffect;
		this.blockPotionEffect = potionEffect;
		return this;
	}
	
	public boolean getShouldGivePotionEffect() {
		return this.hasPotionEffect;
	}
	
	public Block setShouldExplode(boolean shouldExplode) {
		isExplosive = shouldExplode;
		return this;
	}
	
	public boolean getShouldExplode() {
		return isExplosive;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos,
			IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode()) {
				if (rand.nextInt(20) <= 2) {
					worldIn.createExplosion(null, pos.getX(), pos.getY(),
							pos.getZ(), 2.5F, true);
				}
			}
		}
		if (this.getShouldGivePotionEffect()) {
			if (rand.nextInt(10) <= 4) {
				EntityPlayer player = worldIn.getClosestPlayer(pos.getX(),
						pos.getY(), pos.getZ(), 2.5D, false);
				if (player != null && this.blockPotionEffect != null) {
					player.addPotionEffect(new PotionEffect(
							this.blockPotionEffect, 200, 0));
				}
			}
		}
	}
	
	public static ZollernBlockOre instance() {
		return instance;
	}
	
	public EnumBlockVariant getBlockVariant() {
		return this.oreVariant;
	}
	
	public Block setBlockVariant(EnumBlockVariant variantType) {
		this.oreVariant = variantType;
		return this;
	}
	
}