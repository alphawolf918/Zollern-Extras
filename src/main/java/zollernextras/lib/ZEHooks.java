package zollernextras.lib;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;

public class ZEHooks {
	
	private static ArrayList<ZollernDungeonMob> netherDungeonMobs = new ArrayList<ZollernDungeonMob>();
	private static ArrayList<ZollernDungeonMob> upsideDownDungeonMobs = new ArrayList<ZollernDungeonMob>();
	
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
			throw new IllegalArgumentException("Rarity must be greater than zero");
		}
		
		for (ZollernDungeonMob mob : netherDungeonMobs) {
			if (name.equals(mob.type)) {
				return mob.itemWeight += rarity;
			}
		}
		
		netherDungeonMobs.add(new ZollernDungeonMob(rarity, name));
		return rarity;
	}
	
	public static float addUpsideDownDungeonMob(ResourceLocation name, int rarity) {
		if (rarity <= 0) {
			throw new IllegalArgumentException("Rarity must be greater than zero");
		}
		
		for (ZollernDungeonMob mob : upsideDownDungeonMobs) {
			if (name.equals(mob.type)) {
				return mob.itemWeight += rarity;
			}
		}
		
		upsideDownDungeonMobs.add(new ZollernDungeonMob(rarity, name));
		return rarity;
	}
	
	public static int removeNetherDungeonMob(ResourceLocation name) {
		for (ZollernDungeonMob mob : netherDungeonMobs) {
			if (name.equals(mob.type)) {
				netherDungeonMobs.remove(mob);
				return mob.itemWeight;
			}
		}
		return 0;
	}
	
	public static int removeUpsideDownDungeonMob(ResourceLocation name) {
		for (ZollernDungeonMob mob : upsideDownDungeonMobs) {
			if (name.equals(mob.type)) {
				upsideDownDungeonMobs.remove(mob);
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
		ZollernDungeonMob mob = WeightedRandom.getRandomItem(rand, netherDungeonMobs);
		return mob.type;
	}
	
	public static ResourceLocation getRandomUpsideDownDungeonMob(Random rand) {
		ZollernDungeonMob mob = WeightedRandom.getRandomItem(rand, upsideDownDungeonMobs);
		return mob.type;
	}
	
	public static class ZollernDungeonMob extends WeightedRandom.Item {
		
		public ResourceLocation type;
		
		public ZollernDungeonMob(int weight, ResourceLocation type) {
			super(weight);
			this.type = type;
		}
		
		@Override
		public boolean equals(Object target) {
			return target instanceof ZollernDungeonMob
					&& type.equals(((ZollernDungeonMob) target).type);
		}
	}
}