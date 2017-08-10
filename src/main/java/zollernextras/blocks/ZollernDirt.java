package zollernextras.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ZollernDirt extends ZollernBlockBase {
	
	public ZollernDirt(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setMaterial(Material.GROUND);
		this.setSoundType(SoundType.GROUND);
		this.setBlockHarvestLevel("shovel", 0);
	}
	
}