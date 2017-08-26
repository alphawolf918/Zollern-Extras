package zollernextras.lib;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;

public class ZEHooks {
	
	private static ArrayList<DungeonMob> netherDungeonMobs = new ArrayList<DungeonMob>();
	
	/**
	 * Adds a mob to the possible list of creatures the spawner will create. If
	 * the mob is already in the spawn list, the rarity will be added to the
	 * existing one, causing the mob to be more common.
	 *
	 * @param name
	 *            The name of the monster, use the same name used when
	 *            registering the entity.
	 * @param rarity
	 *            The rarity of selecting this mob over others. Must be greater
	 *            then 0. Vanilla Minecraft has the following mobs: Spider 100
	 *            Skeleton 100 Zombie 200 Meaning, Zombies are twice as common
	 *            as spiders or skeletons.
	 * @return The new rarity of the monster,
	 */
	public static float addNetherDungeonMob(ResourceLocation name, int rarity) {
		if (rarity <= 0) {
			throw new IllegalArgumentException(
					"Rarity must be greater then zero");
		}
		
		for (DungeonMob mob : netherDungeonMobs) {
			if (name.equals(mob.type)) {
				return mob.itemWeight += rarity;
			}
		}
		
		netherDungeonMobs.add(new DungeonMob(rarity, name));
		return rarity;
	}
	
	/**
	 * Will completely remove a Mob from the dungeon spawn list.
	 *
	 * @param name
	 *            The name of the mob to remove
	 * @return The rarity of the removed mob, prior to being removed.
	 */
	public static int removeDungeonMob(ResourceLocation name) {
		for (DungeonMob mob : netherDungeonMobs) {
			if (name.equals(mob.type)) {
				netherDungeonMobs.remove(mob);
				return mob.itemWeight;
			}
		}
		return 0;
	}
	
	/**
	 * Gets a random mob name from the list.
	 * 
	 * @param rand
	 *            World generation random number generator
	 * @return The mob name
	 */
	public static ResourceLocation getRandomNetherDungeonMob(Random rand) {
		DungeonMob mob = WeightedRandom.getRandomItem(rand, netherDungeonMobs);
		return mob.type;
	}
	
	public static class DungeonMob extends WeightedRandom.Item {
		public ResourceLocation type;
		
		public DungeonMob(int weight, ResourceLocation type) {
			super(weight);
			this.type = type;
		}
		
		@Override
		public boolean equals(Object target) {
			return target instanceof DungeonMob
					&& type.equals(((DungeonMob) target).type);
		}
	}
}