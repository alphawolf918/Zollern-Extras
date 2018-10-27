package zollernextras.events;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
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
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollernextras.ZollernExtrasMod;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.blocks.upsidedown.corrupt.ICorruptBlock;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItems;
import zollernextras.items.armor.ZollernArmor;
import zollernextras.items.armor.ZollernArmorMaterials;
import zollernextras.lib.ZDamageSrc;
import zollernextras.lib.ZollernHelper;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityMummy;
import zollernextras.mobs.entities.EntityShade;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.entities.IShadeEntity;
import zollernextras.potions.ZollernPotions;

public class ZollernEventManager {
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		Random rand = new Random();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			InventoryPlayer playerInventory = player.inventory;
			NonNullList<ItemStack> armorInventory = playerInventory.armorInventory;
			BlockPos playerLocation = new BlockPos(player.posX, (player.posY - 1), player.posZ);
			World world = player.getEntityWorld();
			IBlockState blockState = world.getBlockState(playerLocation);
			Block block = blockState.getBlock();
			
			// Check to see if we're in the Upside-Down dimension.
			if (player.dimension == ZEConfig.dimensionUpsideDownID) {
				// Hurt the Player every few ticks, unless they have the
				// "Radiance" potion effect. What this does is it checks the
				// Player's inventory for the Radiance item, and if it finds it,
				// it automatically uses its potion effect (which consumes the
				// item) to apply Radiance to the Player, protecting them from
				// Shadow damage. However, it will only automatically use itself
				// in the Upside-Down.
				
				// All we're doing here is defining our item for easy access.
				Item lightItem = ZollernItems.radium;
				ItemStack radiumStack = new ItemStack(lightItem);
				// Checks to see if the Player has the item in their inventory,
				// if they're not in Creative Mode, and if the Radiance potion
				// effect is not already active (we don't want it to constantly
				// apply).
				if (playerInventory.hasItemStack(radiumStack)
						&& !player.capabilities.isCreativeMode
						&& !player.isPotionActive(ZollernPotions.radiance)) {
					
					// (1 second = 20 ticks)
					player.addPotionEffect(new PotionEffect(ZollernPotions.radiance,
							ZollernPotions.radianceTime, 1));
					
					// Check to see if the Radium item is in the Player's
					// inventory, and if it is, consume one.
					if (playerInventory.hasItemStack(radiumStack)) {
						playerInventory.decrStackSize(playerInventory.getSlotFor(radiumStack), 1);
					}
					
					// When sending a message to the Player, do it through your
					// ClientProxy. That way the server doesn't have to bother
					// with it.
					ZollernExtrasMod.proxy.sendChatMessage(player,
							"You are irradiated with a brilliant light.");
				}
				
				// If the Player is not in Creative Mode, and does not have the
				// Radiance potion effect, make the shadows attack them.
				if (!player.capabilities.isCreativeMode
						&& !player.isPotionActive(ZollernPotions.radiance)) {
					player.attackEntityFrom(ZDamageSrc.deathShadows, ZollernPotions.shadowDamage);
				}
			}
			
			// This is where we handle the "spread" of the virus potion effect,
			// called Infected. First, we check to see if the effect is active,
			// which we can do with a simple player.isPotionActive check.
			if (player.isPotionActive(ZollernPotions.infected)) {
				
				// Cause pain! Remember the performEffect code is ran in the
				// ClientProxy class.
				ZollernPotions.infected.performEffect(player, 1);
				
				// Grab the world we're in by calling the world that the Player
				// is in.
				World worldObj = player.getEntityWorld();
				
				// Now is where things get a little complicated. What this
				// method does is it searches for other Players within the
				// infected Player's bounding box. They are then stored in our
				// java.util.List. You can search for any entity class this way.
				List<? extends Entity> playerList = worldObj.<Entity> getEntitiesWithinAABB(
						EntityPlayer.class, player.getEntityBoundingBox().expand(5.0D, 2.0D, 5.0D));
				
				// The Players are not returned as an instance of EntityPlayer,
				// but rather an Object, which is the highest super-class of
				// Java. Basically what we're doing here is just converting our
				// List to an array.
				Object[] playerArray = playerList.toArray();
				
				// Now we use an enhanced for loop to loop through every
				// instance of our "Objects" (Players).
				for (Object o : playerArray) {
					
					// Since we only searched for Players, this type-cast might
					// seem redundant. However, remember that they are returned
					// as Objects, not Players, so we have to cast them in order
					// to use the EntityPlayer functionality.
					EntityPlayer currentPlayer = (EntityPlayer) o;
					
					// Make sure they don't already have the effect, otherwise
					// it's just redundant.. This is for OTHER players who are
					// NOT yet infected!
					if (!currentPlayer.isPotionActive(ZollernPotions.infected)) {
						
						// Now just add the potion effect. Voila! This should
						// infect any Players around the original infected
						// Player. Pandemic!
						currentPlayer.addPotionEffect(new PotionEffect(ZollernPotions.infected,
								ZollernPotions.infectionTime, 1));
					}
				}
			}
			
			// Perform the Radiance potion effect.
			if (player.isPotionActive(ZollernPotions.radiance)) {
				ZollernPotions.radiance.performEffect(player, 1);
			}
			
			// Initialize the count for each armor type.
			int amArmorCount = 0;
			int zArmorCount = 0;
			int azArmorCount = 0;
			int rArmorCount = 0;
			
			// Loop through the player's armor inventory, and check
			// to see if it isn't null. If not, check that it's an
			// instance of ZollernArmor. For each material, check
			// the type of armor, and increment the armor count
			// variables for each one that it finds.
			for (ItemStack armorStack : armorInventory) {
				if (armorStack != null) {
					if (armorStack.getItem() instanceof ZollernArmor) {
						ZollernArmor armorItem = (ZollernArmor) armorStack.getItem();
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
			
			// Loop through 0 to 4 and if an armor set's increment variable is
			// equal to 4, add its respective potion effect.
			for (int i = 0; i < 4; ++i) {
				if (amArmorCount == 4) {
					// Amaranth
					player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 100, 1));
				} else if (zArmorCount == 4) {
					// Zollernium
					player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 1));
					player.stepHeight = 2F;
				} else if (azArmorCount == 4) {
					// Azurite
					player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100, 1));
				} else if (rArmorCount == 4) {
					// Radium
					player.addPotionEffect(new PotionEffect(ZollernPotions.radiance, 100, 1));
					player.capabilities.allowFlying = true;
				} else {
					// Disable all "extra" potion capabilities that have nothing
					// to do with effects. If we don't do this, then the armor's
					// effects (not the potion's, but the armor's) will last.
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
							ItemStack repairItemStack = new ItemStack(
									ZollernItems.ascendantAmaranthIngot);
							if (playerInventory.hasItemStack(repairItemStack)) {
								ItemStack repairedItem = heldItem.copy();
								repairedItem.setItemDamage(0);
								int invSlot = player.inventory.getSlotFor(heldItem);
								playerInventory.setInventorySlotContents(invSlot, repairedItem);
								playerInventory.decrStackSize(
										playerInventory.getSlotFor(repairItemStack), 1);
							}
						}
					}
				}
			}
			
			// Damage the player when they walk on Corrupt blocks.
			// TODO: Add Anti-Corruption potion to prevent damage
			if (block instanceof ICorruptBlock) {
				ICorruptBlock corruptBlock = (ICorruptBlock) block;
				if (corruptBlock.canCorrupt()) {
					if (rand.nextInt(14) <= 4) {
						player.attackEntityFrom(ZDamageSrc.deathCorruption, 5.0F);
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
			event.setDisplayname(TextFormatting.GOLD + "Zollern Wolf" + TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("nascarmpfan")) {
			event.setDisplayname(TextFormatting.RED + "Mike" + TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("applepiec00kie")) {
			event.setDisplayname(TextFormatting.LIGHT_PURPLE + "Queen Apple" + TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("lazy_logic")) {
			event.setDisplayname(TextFormatting.AQUA + "Logic" + TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("master_zane")) {
			event.setDisplayname(TextFormatting.GOLD + "Master Zane" + TextFormatting.WHITE);
		} else if (username.toLowerCase().equals("chronoxshift")) {
			event.setDisplayname(TextFormatting.BLACK + "ChronoxShift" + TextFormatting.WHITE);
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
					slime.setLocationAndAngles(blockPos.getX(), blockPos.getY(), blockPos.getZ(),
							0, 0);
					world.spawnEntity(slime);
				}
			}
		} else if (brokenBlock == ZollernBlocks.netherrack.getDefaultState()) {
			if (!world.isRemote) {
				Random rand = new Random();
				int randInt = rand.nextInt(10);
				if (randInt <= 5) {
					EntityHellFish hellFish = new EntityHellFish(world);
					hellFish.setLocationAndAngles(player.posX, player.posY + 1, player.posZ,
							player.rotationYaw, player.rotationPitch);
					world.spawnEntity(hellFish);
				}
			}
		}
	}
	
	// My way around loot tables. Use a randomized integer to get a chance for a
	// specific mob to drop an item or items.
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		// Since Mummies extend Zombies, they have a chance to drop flour as
		// well.
		if (theEntity instanceof EntityZombie) {
			if (randInt <= 50) {
				ZollernHelper.dropItem(ZollernItems.flour, worldObj, theEntity);
			}
		} else if (theEntity instanceof EntityBlaze) {
			ZollernHelper.dropItem(Items.BLAZE_ROD, worldObj, theEntity);
		} else if (theEntity instanceof EntityEnderman) {
			ZollernHelper.dropItem(Items.ENDER_PEARL, worldObj, theEntity);
		} else if (theEntity.getClass() == EntitySkeleton.class) {
			ZollernHelper.dropItem(Items.BONE, worldObj, theEntity);
		} else if (theEntity instanceof EntityGhast) {
			ZollernHelper.dropItem(Items.GHAST_TEAR, worldObj, theEntity);
		} else if (theEntity instanceof EntityShadowSkeleton) {
			if (randInt <= 85) {
				ZollernHelper.dropItem(ZollernItems.shadowBone, worldObj, theEntity);
			}
		} else if (theEntity instanceof EntityMummy) {
			if (randInt <= 47) {
				ZollernHelper.dropItem(Items.PAPER, worldObj, theEntity);
			}
		} else if (theEntity instanceof EntityShade) {
			if (randInt <= 32) {
				ZollernHelper.dropItem(ZollernItems.netheridium, worldObj, theEntity);
			}
			if (randInt <= 56) {
				ZollernHelper.dropItem(ZollernItems.witherite, worldObj, theEntity);
			}
		}
		if (theEntity instanceof IShadeEntity) {
			if (randInt <= 65) {
				ZollernHelper.dropItem(ZollernItems.shadowEssence, worldObj, theEntity);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityStruckByLightningEvent(EntityStruckByLightningEvent event) {
		Entity theEntity = event.getEntity();
		World worldObj = theEntity.getEntityWorld();
		if (theEntity instanceof EntityVillager) {
			EntityVillager theVillager = (EntityVillager) theEntity;
			theVillager.setDead();
			EntityWitch theWitch = new EntityWitch(worldObj);
			theWitch.setLocationAndAngles(theVillager.posX, theVillager.posY, theVillager.posZ,
					theVillager.rotationYaw, theVillager.rotationPitch);
			worldObj.spawnEntity(theWitch);
			ZollernHelper.logInfo("Villager turned into Witch! (at: " + theVillager.posX + " "
					+ theVillager.posY + " " + theVillager.posZ);
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