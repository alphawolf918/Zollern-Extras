package zollernextras.blocks;

import net.minecraft.block.SoundType;

public class ZollernBlockMetal extends ZollernBlockBase {
	
	public ZollernBlockMetal(String strTexture) {
		super(strTexture, 2.1F);
		this.setSoundType(SoundType.METAL);
	}
	
}