package zollernextras.blocks;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.EnumHarvestLevel;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;

public class ZollernBlockBase extends Block {
	
	protected static ZollernBlockBase instance;
	protected static Material blockMaterial = Material.ROCK;
	protected static SoundType blockSound = SoundType.STONE;
	protected boolean shouldAlwaysBurn = false;
	protected boolean isHotFloorBlock = false;
	protected boolean hasInfo = false;
	protected String blockInfo = "";
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(blockMaterial);
		instance = this;
		ZollernHelper.setName(this, blockName);
		this.setHardResist(hardResist);
		this.setHarvestLevel("pickaxe", EnumHarvestLevel.STONE.getHarvestLevel());
		this.setSoundType(blockSound);
	}
	
	public Block setSound(SoundType bSound) {
		this.blockSoundType = bSound;
		return this;
	}
	
	public SoundType getSound() {
		return this.blockSound;
	}
	
	public boolean hasInfo() {
		return this.hasInfo;
	}
	
	public String getInfo() {
		return this.blockInfo;
	}
	
	public Block setInfo(String info) {
		this.blockInfo = info;
		return this;
	}
	
	public Block setHardResist(float hard, float resist) {
		this.setHardness(hard);
		this.setResistance(resist);
		return this;
	}
	
	public Block setHardResist(float hardResist) {
		this.setHardness(hardResist);
		this.setResistance(hardResist);
		return this;
	}
	
	public Block setIsHotBlock(boolean par1HotBlock) {
		this.isHotFloorBlock = par1HotBlock;
		return this;
	}
	
	public boolean getIsHotBlock() {
		return this.isHotFloorBlock;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
				&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)
				&& this.getIsHotBlock()) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.5F);
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (this.getShouldAlwaysBurn() && side == EnumFacing.UP) {
			return true;
		}
		return false;
	}
	
	public Block setShouldAlwaysBurn(boolean shouldBurn) {
		this.shouldAlwaysBurn = shouldBurn;
		return this;
	}
	
	public boolean getShouldAlwaysBurn() {
		return this.shouldAlwaysBurn;
	}
	
	public Block setBlockHarvestLevel(String toolClass, int level) {
		this.setHarvestLevel(toolClass, level);
		return this;
	}
	
	public Block setMaterial(Material material) {
		blockMaterial = material;
		return this;
	}
	
	@Override
	public Material getMaterial(IBlockState block) {
		return blockMaterial;
	}
	
	public static ZollernBlockBase instance() {
		return instance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list,
			boolean advanced) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			// list.add("");
		} else {
			/*
			 * list.add("Hold SHIFT for"); list.add("more information.");
			 */
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernTabs.zTab;
	}
}