package zollernextras.blocks.upsidedown.corrupt;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import zollernextras.blocks.GenericBlock;
import zollernextras.lib.DSource;

public class CorruptBlock extends GenericBlock {
	
	private static CorruptBlock instance;
	Random rand = new Random();
	
	public CorruptBlock(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setHarvestLevel("pickaxe", 3);
		this.instance = this;
	}
	
	@Override
	public void onEntityWalking(World par1World, int par2x, int par3y,
			int par3z, Entity par4Entity) {
		if (par4Entity instanceof EntityPlayer) {
			if (rand.nextInt(10) <= 4) {
				EntityPlayer player = (EntityPlayer) par4Entity;
				player.attackEntityFrom(DSource.deathCorruption, 8.0F);
			}
		}
	}
	
	public static CorruptBlock getInstance() {
		return instance;
	}
}