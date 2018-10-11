package zollernextras.events;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollernextras.blocks.ICorruptBlock;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import zollernextras.items.armor.ZollernArmor;
import zollernextras.items.armor.ZollernArmorMaterials;
import zollernextras.lib.ZDamageSrc;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.entities.IShadeEntity;

public class ZollernEventManager {
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		Random rand = new Random();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			NonNullList<ItemStack> armorInventory = player.inventory.armorInventory;
			
			int amArmorCount = 0;
			int zArmorCount = 0;
			int azArmorCount = 0;
			int rArmorCount = 0;
			
			for (ItemStack armorStack : armorInventory) {
				if (armorStack != null) {
					if (armorStack.getItem() instanceof ZollernArmor) {
						ZollernArmor armorItem = (ZollernArmor) armorStack
								.getItem();
						if (armorItem.getArmorMaterial() == ZollernArmorMaterials.AMARANTH) {
							amArmorCount++;
						} else if (armorItem.getArmorMaterial() == ZollernArmorMaterials.ZOLLERNIUM) {
							zArmorCount++;
						} else if (armorItem.getArmorMaterial() == ZollernArmorMaterials.AZURITE) {
							azArmorCount++;
						} else if (armorItem.getArmorMaterial() == ZollernArmorMaterials.RADIUM) {
							rArmorCount++;
						}
					}
				}
			}
			
			for (int i = 0; i < 4; ++i) {
				if (amArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							MobEffects.RESISTANCE, 100, 1));
				} else if (zArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							MobEffects.FIRE_RESISTANCE, 100, 1));
					player.stepHeight = 2F;
				} else if (azArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							MobEffects.STRENGTH, 100, 1));
				} else if (rArmorCount == 4) {
					// TODO: Add Radiance
					player.capabilities.allowFlying = true;
				} else {
					player.stepHeight = 0.5F;
					if (!player.capabilities.isCreativeMode) {
						player.capabilities.allowFlying = false;
					}
				}
			}
			
			// Check what hand the Player is using, and check to see if it isn't
			// null. Then, grab the item they're holding, and check to see if
			// that's not equal to null. If it is the Bedrock Breaker, check the
			// Player's inventory to see if they have any Ascendant Amaranth
			// Ingots. If they do, then copy the original held item, set its
			// damage to 0, and put it in the slot that the old one occupied.
			// This also will decrease the stack size of the ingots. If none
			// remain, then it will not be repaired.
			EnumHand currentHand = player.getActiveHand();
			if (currentHand != null) {
				ItemStack heldItem = player.getHeldItem(currentHand);
				if (heldItem != null) {
					Item currentItem = heldItem.getItem();
					if (currentItem == ZollernItems.bedrockBreaker) {
						int toolDamage = heldItem.getItemDamage();
						if (toolDamage >= heldItem.getMaxDamage()) {
							InventoryPlayer playerInventory = player.inventory;
							ItemStack repairItemStack = new ItemStack(
									ZollernItems.ascendantAmaranthIngot);
							if (playerInventory.hasItemStack(repairItemStack)) {
								ItemStack repairedItem = heldItem.copy();
								repairedItem.setItemDamage(0);
								int invSlot = player.inventory
										.getSlotFor(heldItem);
								playerInventory.setInventorySlotContents(
										invSlot, repairedItem);
								playerInventory.decrStackSize(playerInventory
										.getSlotFor(repairItemStack), 1);
							}
						}
					}
				}
			}
			
			// Damage the player when they walk on Corrupt blocks.
			// TODO: Add Anti-Corruption potion to prevent damage
			BlockPos playerLocation = new BlockPos(player.posX,
					(player.posY - 1), player.posZ);
			World world = player.getEntityWorld();
			IBlockState blockState = world.getBlockState(playerLocation);
			Block block = blockState.getBlock();
			if (block instanceof ICorruptBlock) {
				ICorruptBlock corruptBlock = (ICorruptBlock) block;
				if (corruptBlock.isCorrupt()) {
					if (rand.nextInt(14) <= 4) {
						player.attackEntityFrom(ZDamageSrc.deathCorruption,
								5.0F);
					}
				}
			}
		}
	}
	
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
		EntityPlayer player = event.getPlayer();
		BlockPos blockPos = event.getPos();
		if (brokenBlock == Blocks.SLIME_BLOCK.getDefaultState()) {
			if (!world.isRemote) {
				Random rand = new Random();
				int randInt = rand.nextInt(10);
				if (randInt <= 6) {
					EntitySlime slime = new EntitySlime(world);
					slime.setLocationAndAngles(blockPos.getX(),
							blockPos.getY(), blockPos.getZ(), 0, 0);
					world.spawnEntity(slime);
				}
			}
		} else if (brokenBlock == ZollernBlocks.netherrack.getDefaultState()) {
			if (!world.isRemote) {
				Random rand = new Random();
				int randInt = rand.nextInt(10);
				if (randInt <= 5) {
					EntityHellFish hellFish = new EntityHellFish(world);
					hellFish.setLocationAndAngles(player.posX, player.posY + 1,
							player.posZ, player.rotationYaw,
							player.rotationPitch);
					world.spawnEntity(hellFish);
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
		} else if (theEntity instanceof EntityGhast) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.GHAST_TEAR, 1));
			worldObj.spawnEntity(item);
		} else if (theEntity instanceof EntityShadowSkeleton) {
			Random rand = new Random();
			int randInt = rand.nextInt(100);
			if (randInt <= 85) {
				ItemStack itemStack = new ItemStack(ZollernItems.shadowBone, 1);
				EntityItem itemEntity = new EntityItem(worldObj,
						theEntity.posX, theEntity.posY, theEntity.posZ,
						itemStack);
				worldObj.spawnEntity(itemEntity);
			}
		}
		if (theEntity instanceof IShadeEntity) {
			Random rand = new Random();
			int randInt = rand.nextInt(100);
			if (randInt <= 65) {
				ItemStack itemStack = new ItemStack(ZollernItems.shadowEssence,
						1);
				EntityItem itemEntity = new EntityItem(worldObj,
						theEntity.posX, theEntity.posY, theEntity.posZ,
						itemStack);
				worldObj.spawnEntity(itemEntity);
			}
		}
	}
	
	// THIS DOES NOT DO A WORK.
	// @SubscribeEvent(priority = EventPriority.NORMAL)
	// public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
	// World world = event.getWorld();
	// int chunkX = event.getChunkX() * 16;
	// int chunkZ = event.getChunkZ() * 16;
	// int chunkY = world.getHeight(event.getChunkX(), event.getChunkZ());
	// BlockPos biomePos = new BlockPos(chunkX, chunkY, chunkZ);
	// Biome currentBiome = world.getBiomeForCoordsBody(biomePos);
	// Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
	// if (currentBiome.equals(BiomeList.biomeIceDesert)) {
	// for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
	// if (storage != Chunk.NULL_BLOCK_STORAGE) {
	// for (int x = 0; x < 16; ++x) {
	// for (int y = 0; y < 16; ++y) {
	// for (int z = 0; z < 16; ++z) {
	// if (storage.get(x, y, z).getBlock() == Blocks.WATER) {
	// storage.set(x, y, z,
	// Blocks.ICE.getDefaultState());
	// }
	// }
	// }
	// }
	// // world.theProfiler.startSection("getChunk");
	// // int updateLCG = (new Random()).nextInt();
	// // int j1 = updateLCG >> 2;
	// // int k1 = j1 & 15;
	// // int l1 = j1 >> 8 & 15;
	// // int i2 = j1 >> 16 & 15;
	// // IBlockState iblockstate = storage.get(k1, i2, l1);
	// // Block block = iblockstate.getBlock();
	// // if (block == Blocks.WATER) {
	// // storage.set(k1, i2, l1, Blocks.ICE.getDefaultState());
	// // chunk.setModified(true);
	// // event.setResult(Result.ALLOW);
	// // world.theProfiler.endSection();
	// // }
	// }
	// }
	// }
	// }
}