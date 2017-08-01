package zollernextras.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ZollernSand extends ZollernBlockFalling {
	
	public ZollernSand(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setMaterial(Material.SAND);
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.SAND);
	}
	
}