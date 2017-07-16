package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZollernBlockBase extends Block {
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(Material.ROCK);
		this.setRegistryName(blockName);
		this.setUnlocalizedName(blockName);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return CreativeTabs.BUILDING_BLOCKS;
	}
}