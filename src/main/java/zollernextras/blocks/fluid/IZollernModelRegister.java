package zollernextras.blocks.fluid;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IZollernModelRegister {
	
	@SideOnly(Side.CLIENT)
	public void registerModels();
	
}