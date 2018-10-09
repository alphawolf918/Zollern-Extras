package zollernextras.blocks.upsidedown.corrupt;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollernextras.blocks.ZollernBlockBase;
import zollernextras.lib.ZDamageSrc;

public class CorruptBlock extends ZollernBlockBase {
	
	private static CorruptBlock instance;
	Random rand = new Random();
	
	public CorruptBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setHarvestLevel("pickaxe", 3);
		this.instance = this;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote) {
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityIn;
				if (rand.nextInt(10) <= 4) {
					player.attackEntityFrom(ZDamageSrc.deathCorruption, 8.0F);
				}
			}
		}
	}
	
}