package zollernextras.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ShineBlock extends ZollernBlockBase {
	
	public ShineBlock(String blockName) {
		this(blockName, 1.2F);
	}
	
	public ShineBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setLightLevel(1.0F);
		this.setMaterial(Material.GLASS);
		this.setSound(SoundType.GLASS);
	}
	
}