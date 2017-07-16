package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.lib.ZollernModInfo;

public class ZollernBlockBase extends Block {
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(Material.ROCK);
		this.setRegistryName(ZollernModInfo.modId + "_" + blockName);
		this.setUnlocalizedName(ZollernModInfo.modId + "_" + blockName);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return CreativeTabs.BUILDING_BLOCKS;
	}
}