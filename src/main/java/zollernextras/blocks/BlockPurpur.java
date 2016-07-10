package zollernextras.blocks;

import java.util.Random;
import net.minecraft.world.World;
import zollernextras.mobs.entities.EntityEnderBug;

public class BlockPurpur extends GenericBlock {
	
	public BlockPurpur() {
		super("purpurblock", 1.2F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_,
			int p_149664_3_, int p_149664_4_, int p_149664_5_) {
		if (!p_149664_1_.isRemote) {
			Random rand = new Random();
			if (rand.nextInt(100) <= 56) {
				EntityEnderBug entityenderBug = new EntityEnderBug(p_149664_1_);
				entityenderBug.setLocationAndAngles(p_149664_2_ + 0.5D,
						p_149664_3_, p_149664_4_ + 0.5D, 0.0F, 0.0F);
				p_149664_1_.spawnEntityInWorld(entityenderBug);
				entityenderBug.spawnExplosionParticle();
			}
		}
		
		super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_,
				p_149664_4_, p_149664_5_);
	}
	
}