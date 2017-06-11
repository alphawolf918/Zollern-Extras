package zollernextras.dimension.upsidedown;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.lib.ZollernModInfo;

public class WorldGenUpsideDownDungeons extends WorldGenerator {
	
	public static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(Items.iron_ingot, 1, 1, 4, 10),
			new WeightedRandomChestContent(Items.bread, 1, 1, 1, 10),
			new WeightedRandomChestContent(Items.wheat, 1, 1, 4, 10),
			new WeightedRandomChestContent(Items.gunpowder, 1, 1, 4, 10),
			new WeightedRandomChestContent(ZollernItems.amaranthIngot, 1, 1, 4,
					10),
			new WeightedRandomChestContent(Items.string, 1, 1, 4, 10),
			new WeightedRandomChestContent(Items.bucket, 1, 1, 1, 10),
			new WeightedRandomChestContent(Items.golden_apple, 1, 1, 1, 1),
			new WeightedRandomChestContent(Items.redstone, 1, 1, 4, 10),
			new WeightedRandomChestContent(Items.name_tag, 1, 1, 1, 10) };
	
	@Override
	public boolean generate(World p_76484_1_, Random p_76484_2_,
			int p_76484_3_, int p_76484_4_, int p_76484_5_) {
		byte b0 = 3;
		int l = p_76484_2_.nextInt(2) + 2;
		int i1 = p_76484_2_.nextInt(2) + 2;
		int j1 = 0;
		int k1;
		int l1;
		int i2;
		
		for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
			for (l1 = p_76484_4_ - 1; l1 <= p_76484_4_ + b0 + 1; ++l1) {
				for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
					Material material = p_76484_1_.getBlock(k1, l1, i2)
							.getMaterial();
					
					if (l1 == p_76484_4_ - 1 && !material.isSolid()) {
						return false;
					}
					
					if (l1 == p_76484_4_ + b0 + 1 && !material.isSolid()) {
						return false;
					}
					
					if ((k1 == p_76484_3_ - l - 1 || k1 == p_76484_3_ + l + 1
							|| i2 == p_76484_5_ - i1 - 1 || i2 == p_76484_5_
							+ i1 + 1)
							&& l1 == p_76484_4_
							&& p_76484_1_.isAirBlock(k1, l1, i2)
							&& p_76484_1_.isAirBlock(k1, l1 + 1, i2)) {
						++j1;
					}
				}
			}
		}
		
		if (j1 >= 1 && j1 <= 5) {
			for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
				for (l1 = p_76484_4_ + b0; l1 >= p_76484_4_ - 1; --l1) {
					for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
						if (k1 != p_76484_3_ - l - 1 && l1 != p_76484_4_ - 1
								&& i2 != p_76484_5_ - i1 - 1
								&& k1 != p_76484_3_ + l + 1
								&& l1 != p_76484_4_ + b0 + 1
								&& i2 != p_76484_5_ + i1 + 1) {
							p_76484_1_.setBlockToAir(k1, l1, i2);
						} else if (l1 >= 0
								&& !p_76484_1_.getBlock(k1, l1 - 1, i2)
										.getMaterial().isSolid()) {
							p_76484_1_.setBlockToAir(k1, l1, i2);
						} else if (p_76484_1_.getBlock(k1, l1, i2)
								.getMaterial().isSolid()) {
							if (l1 == p_76484_4_ - 1
									&& p_76484_2_.nextInt(4) != 0) {
								p_76484_1_.setBlock(k1, l1, i2,
										ZollernBlocks.upsideDownRock, 0, 2);
							} else {
								p_76484_1_.setBlock(k1, l1, i2,
										ZollernBlocks.upsideDownSurfaceRock, 0,
										2);
							}
						}
					}
				}
			}
			
			k1 = 0;
			
			while (k1 < 2) {
				l1 = 0;
				
				while (true) {
					if (l1 < 3) {
						label101: {
							i2 = p_76484_3_ + p_76484_2_.nextInt(l * 2 + 1) - l;
							int j2 = p_76484_5_
									+ p_76484_2_.nextInt(i1 * 2 + 1) - i1;
							
							if (p_76484_1_.isAirBlock(i2, p_76484_4_, j2)) {
								int k2 = 0;
								
								if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2)
										.getMaterial().isSolid()) {
									++k2;
								}
								
								if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2)
										.getMaterial().isSolid()) {
									++k2;
								}
								
								if (p_76484_1_.getBlock(i2, p_76484_4_, j2 - 1)
										.getMaterial().isSolid()) {
									++k2;
								}
								
								if (p_76484_1_.getBlock(i2, p_76484_4_, j2 + 1)
										.getMaterial().isSolid()) {
									++k2;
								}
								
								if (k2 == 1) {
									p_76484_1_.setBlock(i2, p_76484_4_, j2,
											Blocks.chest, 0, 2);
									TileEntityChest tileentitychest = (TileEntityChest) p_76484_1_
											.getTileEntity(i2, p_76484_4_, j2);
									
									if (tileentitychest != null) {
										WeightedRandomChestContent
												.generateChestContents(
														p_76484_2_,
														ZEChestGenHooks
																.getItems(
																		ZEChestGenHooks.SHADE_TREE,
																		p_76484_2_),
														tileentitychest,
														ZEChestGenHooks
																.getCount(
																		ZEChestGenHooks.SHADE_TREE,
																		p_76484_2_));
									}
									
									break label101;
								}
							}
							
							++l1;
							continue;
						}
					}
					
					++k1;
					break;
				}
			}
			
			p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_,
					Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) p_76484_1_
					.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_);
			
			if (tileentitymobspawner != null) {
				tileentitymobspawner.func_145881_a().setEntityName(
						this.pickMobSpawner(p_76484_2_));
			} else {
				System.err.println("Failed to fetch mob spawner entity at ("
						+ p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_
						+ ")");
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Randomly decides which spawner to use in a dungeon
	 */
	private String pickMobSpawner(Random rand) {
		String defaultMob = ZollernModInfo.MODID + "_shadowskeleton";
		int rm = rand.nextInt(6);
		if (rm == 0) {
			return ZollernModInfo.MODID + "_mummy";
		} else if (rm == 1) {
			return ZollernModInfo.MODID + "_krull";
		} else if (rm == 2) {
			return ZollernModInfo.MODID + "_shade";
		} else if (rm == 3) {
			return ZollernModInfo.MODID + "_scorpion";
		} else if (rm == 4) {
			return ZollernModInfo.MODID + "_spiderling";
		} else {
			return defaultMob;
		}
	}
}