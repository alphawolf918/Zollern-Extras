package zollernextras.blocks;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.lib.EnumBlockVariant;
import zollernextras.lib.EnumHarvestLevel;
import zollernextras.lib.KeyHelper;

public class ZollernBlockOre extends ZollernBlockBase {
	
	protected EnumBlockVariant oreVariant = EnumBlockVariant.OVERWORLD;
	protected static ZollernBlockOre instance;
	protected boolean isExplosive = false;
	protected int explosionChance = 40;
	protected boolean hasPotionEffect = false;
	protected Potion blockPotionEffect;
	protected Random rand = new Random();
	
	public ZollernBlockOre(String strName, float hardResist) {
		super(strName, hardResist);
		instance = this;
		this.setHarvestLevel("pickaxe", EnumHarvestLevel.DIAMOND.getHarvestLevel());
	}
	
	public Block setShouldGivePotionEffect(boolean shouldGivePotionEffect, Potion potionEffect) {
		this.hasPotionEffect = shouldGivePotionEffect;
		this.blockPotionEffect = potionEffect;
		return this;
	}
	
	public boolean getShouldGivePotionEffect() {
		return this.hasPotionEffect;
	}
	
	/**
	 * Sets the chance for this block to go kablooey. Higher numbers mean a
	 * lower chance.
	 * 
	 * @param par1ExplosionChance
	 *            int
	 * @return Block
	 */
	public Block setExplosionChance(int par1ExplosionChance) {
		this.explosionChance = par1ExplosionChance;
		return this;
	}
	
	/**
	 * Gets the chance this block has to explode. Higher numbers mean a lower
	 * chance.
	 * 
	 * @return int
	 */
	public int getExplosionChance() {
		return this.explosionChance;
	}
	
	public Block setShouldExplode(boolean shouldExplode, int explodeChance) {
		this.setShouldExplode(shouldExplode);
		this.setExplosionChance(explodeChance);
		return this;
	}
	
	public Block setShouldExplode(boolean shouldExplode) {
		isExplosive = shouldExplode;
		return this;
	}
	
	public boolean getShouldExplode() {
		return isExplosive;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode()) {
				if (rand.nextInt(this.getExplosionChance()) <= 2) {
					worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.5F, true);
				}
			}
		}
		if (this.getShouldGivePotionEffect()) {
			if (rand.nextInt(10) <= 4) {
				EntityPlayer player = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(),
						2.5D, false);
				if (player != null && this.blockPotionEffect != null) {
					player.addPotionEffect(new PotionEffect(this.blockPotionEffect, 200, 0));
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list,
			boolean advanced) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			if (this.getShouldExplode()) {
				list.add("Explosion Chance: " + explosionChance + "%");
			}
		} else {
			list.add("Hold LSHIFT for");
			list.add("more information.");
		}
	}
}