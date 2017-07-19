package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernBlockBase extends Block {
	
	protected static ZollernBlockBase instance;
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(Material.ROCK);
		instance = this;
		ZollernHelper.setName(this, blockName);
		ZollernHelper.setTab(this);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
	}
	
	public static ZollernBlockBase instance() {
		return instance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ModTabs.zTab;
	}
}