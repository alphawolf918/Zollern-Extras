package zollernextras.events;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollernextras.items.ZollernItems;

public class ZollernEventManager {
	
	// Modifies names for Patrons and my friends.
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onNameFormatEvent(NameFormat event) {
		String username = event.getUsername();
		if (username.toLowerCase().equals("alphawolf918")) {
			event.setDisplayname(TextFormatting.GOLD + "Zollern Wolf"
					+ TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("nascarmpfan")) {
			event.setDisplayname(TextFormatting.RED + "Mike"
					+ TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("applepiec00kie")) {
			event.setDisplayname(TextFormatting.LIGHT_PURPLE + "Queen Apple"
					+ TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("lazy_logic")) {
			event.setDisplayname(TextFormatting.AQUA + "Logic"
					+ TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("master_zane")) {
			event.setDisplayname(TextFormatting.GOLD + "Master Zane"
					+ TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("chronoxshift")) {
			event.setDisplayname(TextFormatting.BLACK + "ChronoxShift"
					+ TextFormatting.WHITE);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onBlockBrokenEvent(BreakEvent event) {
		IBlockState brokenBlock = event.getState();
		World world = event.getWorld();
		BlockPos blockPos = event.getPos();
		if (brokenBlock == Blocks.SLIME_BLOCK.getDefaultState()) {
			if (!world.isRemote) {
				Random rand = new Random();
				int randInt = rand.nextInt(10);
				if (randInt <= 5) {
					EntitySlime slime = new EntitySlime(world);
					slime.setLocationAndAngles(blockPos.getX(),
							blockPos.getY(), blockPos.getZ(), 0, 0);
					world.spawnEntity(slime);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		if (theEntity instanceof EntityZombie) {
			if (new Random().nextInt(100) <= 50) {
				EntityItem item = new EntityItem(worldObj, theEntity.posX,
						theEntity.posY, theEntity.posZ, new ItemStack(
								ZollernItems.flour, 1));
				worldObj.spawnEntity(theEntity);
			}
		} else if (theEntity instanceof EntityBlaze) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.BLAZE_ROD, 1));
			worldObj.spawnEntity(item);
		} else if (theEntity instanceof EntityEnderman) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ENDER_PEARL, 1));
			worldObj.spawnEntity(item);
		} else if (theEntity.getClass() == EntitySkeleton.class) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ,
					new ItemStack(Items.BONE, 1));
			worldObj.spawnEntity(item);
		} else if (theEntity instanceof EntitySilverfish) {
			// EntityItem item = new EntityItem(worldObj, theEntity.posX,
			// theEntity.posY, theEntity.posZ, new ItemStack(
			// ZollernItems.silverNugget, 1));
			// worldObj.spawnEntityInWorld(item);
			// TODO
		} else if (theEntity instanceof EntityGhast) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.GHAST_TEAR, 1));
			worldObj.spawnEntity(item);
		}// else if (theEntity instanceof IShadeEntity) {
			// Random rand = new Random();
		// int randInt = rand.nextInt(100);
		// if (randInt <= 60) {
		// ItemStack itemStack = new ItemStack(ZollernItems.shadowEssence,
		// 1);
		// EntityItem itemEntity = new EntityItem(worldObj,
		// theEntity.posX, theEntity.posY, theEntity.posZ,
		// itemStack);
		// worldObj.spawnEntityInWorld(itemEntity);2
		// }
		// }
	}
	
	// THIS DOES NOT DO A WORK.
	// @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	// public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
	// World world = event.getWorld();
	// int worldY = world.getHeight(event.getChunkX(), event.getChunkZ());
	// Biome currentBiome = world.getBiome(new BlockPos(
	// event.getChunkX() * 16, worldY, event.getChunkZ() * 16));
	// Chunk chunk = event.getWorld().getChunkFromChunkCoords(
	// event.getChunkX() * 16, event.getChunkZ() * 16);
	// if (currentBiome == BiomeList.biomeIceDesert) {
	// for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
	// for (int x = 0; x < 16; x++) {
	// for (int y = 0; y < 16; y++) {
	// for (int z = 0; z < 16; z++) {
	// IBlockState blockState = storage.get(x, y, z)
	// .getActualState(world,
	// new BlockPos(x, y, z));
	// if (blockState == Blocks.WATER.getDefaultState()) {
	// storage.set(x, y, z,
	// Blocks.ICE.getDefaultState());
	// }
	// }
	// }
	// }
	// }
	// chunk.setModified(true);
	// }
	// }
}