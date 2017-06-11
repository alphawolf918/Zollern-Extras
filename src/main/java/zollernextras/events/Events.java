package zollernextras.events;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import zaneextras.blocks.BlockList;
import zollernextras.ZollernExtrasMod;
import zollernextras.api.ores.IOre;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BabyDragonEgg;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.enchantments.EnchantmentEnlightened;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.items.ZollernItems;
import zollernextras.items.armor.amaranth.AmaranthArmor;
import zollernextras.items.armor.azurite.AzuriteArmor;
import zollernextras.items.armor.zollernium.ZollerniumArmor;
import zollernextras.lib.DSource;
import zollernextras.lib.ZollernHelper;
import zollernextras.mobs.entities.EntityBabyDragon;
import zollernextras.mobs.entities.EntityEnderBug;
import zollernextras.mobs.entities.IShadeEntity;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.potions.ZollernPotion;
import zollernextras.proxies.CommonProxy;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class Events {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityConstructingEvent(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
				ExtendedPlayer.register((EntityPlayer) event.entity);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityEnderTeleport(EnderTeleportEvent event) {
		EntityLivingBase living = event.entityLiving;
		Random rand = new Random();
		int randInt = rand.nextInt(500);
		if (randInt <= 10) {
			double xCoord = event.targetX;
			double yCoord = event.targetY;
			double zCoord = event.targetZ;
			World worldObj = living.worldObj;
			if (!worldObj.isRemote) {
				EntityEnderBug enderBug = new EntityEnderBug(worldObj);
				enderBug.setLocationAndAngles(xCoord, yCoord, zCoord, 0, 0);
				worldObj.spawnEntityInWorld(enderBug);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		
		// Let's make 100% certain that we're actually using a Player
		// entity.
		if (entity instanceof EntityPlayer) {
			
			// Now type-cast it so we can use the Player functionality.
			EntityPlayer player = (EntityPlayer) entity;
			
			// Check to see if we're in the Upside-Down dimension.
			if (player.dimension == ZEConfig.dimensionUpsideDownID) {
				
				// Hurt the Player every few ticks, unless they have the
				// "Radiance" potion effect. What this does is it checks the
				// Player's inventory for the Radiance item, and if it finds it,
				// it automatically uses its potion effect (which consumes the
				// item) to apply Radiance to the Player, protecting them from
				// Shadow damage. However, it will only automatically use itself
				// in the Upside-Down. Anywhere else, it must be used manually
				// with a right-click.
				
				// All we're doing here is defining our item for easy access.
				Item lightItem = ZollernItems.radiance;
				
				// Grab the inventory of the Player.
				InventoryPlayer playerInventory = player.inventory;
				
				// Checks to see if the Player has the item in their inventory,
				// if they're not in Creative Mode, and if the Radiance potion
				// effect is not already active (we don't want it to constantly
				// apply).
				if (playerInventory.hasItem(lightItem)
						&& !player.capabilities.isCreativeMode
						&& !player.isPotionActive(ZollernPotion.radiance)) {
					
					// (1 second = 20 ticks)
					player.addPotionEffect(new PotionEffect(
							ZollernPotion.radiance.id,
							ZollernPotion.radianceTime, 0));
					
					// We have to manually consume the item. The best way to do
					// this is to make use of the method that we are given.
					playerInventory.consumeInventoryItem(lightItem);
					
					// When sending a message to the Player, do it through your
					// ClientProxy. That way the server doesn't have to bother
					// with it.
					ZollernExtrasMod.proxy.sendChatMessage(player,
							"You are irradiated with a brilliant light.");
				}
				
				// If the Player is not in Creative Mode, and does not have the
				// Radiance potion effect, make the shadows attack them.
				if (!player.capabilities.isCreativeMode
						&& !player.isPotionActive(ZollernPotion.radiance)) {
					player.attackEntityFrom(DSource.deathShadows,
							ZollernPotion.shadowDamage);
				}
			}
			
			// This is where we handle the "spread" of the virus potion effect,
			// called Infected. First, we check to see if the effect is active,
			// which we can do with a simple player.isPotionActive check.
			if (player.isPotionActive(ZollernPotion.infected)) {
				
				// Cause pain!
				ZollernPotion.infected.performEffect(player, 1);
				
				// Grab the world we're in by calling the world that the Player
				// is in.
				World worldObj = player.worldObj;
				
				// Now is where things get a little complicated. What this
				// method does is it searches for other Players within the
				// infected Player's bounding box. They are then stored in our
				// java.util.List. You can search for any entity class this way.
				List playerList = worldObj.getEntitiesWithinAABB(
						EntityPlayer.class, player.boundingBox.expand(
								1 + Math.floor(player.ticksExisted / 50), 2,
								1 + Math.floor(player.ticksExisted / 50)));
				
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
					// it's just redundant..
					if (!currentPlayer.isPotionActive(ZollernPotion.infected)) {
						
						// Now just add the potion effect. Voila! This should
						// infect any Players around the original infected
						// Player. Pandemic!
						currentPlayer.addPotionEffect(new PotionEffect(
								ZollernPotion.infected.getId(),
								ZollernPotion.infectionTime, 1));
					}
				}
			}
			
			// Perform the Radiance potion effect.
			if (player.isPotionActive(ZollernPotion.radiance)) {
				ZollernPotion.radiance.performEffect(player, 1);
			}
			
			// This is where the armor potion effects are applied. First, we
			// just simply grab the ItemStack[] array of the Player's armor
			// inventory (easy access!).
			ItemStack[] armor = player.inventory.armorInventory;
			
			// These three indices are important. They will count how many armor
			// pieces are worn for each specific set, to save us some
			// complicated stuff.
			int amArmorCount = 0;
			int zArmorCount = 0;
			int azArmorCount = 0;
			
			// Loop through each armor set.
			for (ItemStack armorStack : armor) {
				
				// Each of these "if" statements checks the count for each
				// specific set of armor, and increments it depending on what's
				// in the slot.
				if (armorStack != null
						&& armorStack.getItem() instanceof AmaranthArmor) {
					AmaranthArmor amaranthArmor = (AmaranthArmor) armorStack
							.getItem();
					amArmorCount++;
				} else if (armorStack != null
						&& armorStack.getItem() instanceof ZollerniumArmor) {
					ZollerniumArmor zollernArmor = (ZollerniumArmor) armorStack
							.getItem();
					zArmorCount++;
				} else if (armorStack != null
						&& armorStack.getItem() instanceof AzuriteArmor) {
					AzuriteArmor azuriteArmor = (AzuriteArmor) armorStack
							.getItem();
					azArmorCount++;
				}
			}
			
			// Now we loop through the indices as necessary, and apply the
			// potion effect for each specific set of armor, so long as the
			// count equals 4 (helmet, chestplate, leggings, and boots).
			for (int i = 0; i < 4; ++i) {
				if (amArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.resistance.id, 2, 1));
				} else if (azArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.damageBoost.id, 2, 1));
				} else if (zArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.fireResistance.id, 2, 1));
					player.stepHeight = 2F;
				}
			}
		}
		
		// If the entity (mob) is an IShadeEntity (shadow) mob, and they have
		// the Radiance potion effect (applied by the Enlightened enchantment on
		// weapons), cause damage. Shadow entities being murdered by light!
		if (entity instanceof IShadeEntity) {
			if (entity.isPotionActive(ZollernPotion.radiance.id)) {
				entity.attackEntityFrom(DSource.deathLight,
						EnchantmentEnlightened.lightDamageBase);
			}
		}
	}
	
	// The idea of the two below functions is that I wanted to be able to tell
	// if the Player has arrows inside of a quiver that's in their inventory,
	// and if they do, then the bow will use arrows from that, without Players
	// having to get them out manually.
	
	// Began using a bow
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerStartedUsingBow(ArrowNockEvent event) {
		Entity entity = event.entity;
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = event.entityPlayer;
			World world = event.entityPlayer.worldObj;
			InventoryPlayer playerInventory = player.inventory;
			if (playerInventory.hasItem(ZollernItems.quiver)) {
				// int quiverInventorySlot = playerInventory
				// .func_146029_c(ZollernItems.quiver);
				// TODO
			}
		}
	}
	
	// Stopped using a bow
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerStoppedUsingBow(ArrowLooseEvent event) {
		// TODO
	}
	
	// @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	// public void onPlayerLoginEvent(PlayerLoggedInEvent event) {
	// if (!event.player.worldObj.isRemote) {
	//
	// }
	// }
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onNameFormatEvent(NameFormat event) {
		String username = event.username;
		if (username.toLowerCase().equals("alphawolf918")) {
			event.displayname = EnumChatFormatting.GOLD + "Zollern Wolf"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("nascarmpfan")) {
			event.displayname = EnumChatFormatting.RED + "Mike"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("applepiec00kie")) {
			event.displayname = EnumChatFormatting.LIGHT_PURPLE + "Queen Apple"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("lazy_logic")) {
			event.displayname = EnumChatFormatting.AQUA + "Logic"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("master_zane")) {
			event.displayname = EnumChatFormatting.GOLD + "Master Zane"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("chronoxshift")) {
			event.displayname = EnumChatFormatting.BLACK + "ChronoxShift"
					+ EnumChatFormatting.WHITE;
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayer) event.entity
					.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
					.saveNBTData(playerData);
			CommonProxy.storeEntityData(
					((EntityPlayer) event.entity).getCommandSenderName(),
					playerData);
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onBlockBrokenEvent(BreakEvent event) {
		World world = event.world;
		if (!world.isRemote) {
			Block block = event.block;
			if (block.getClass() == BlockTallGrass.class) {
				Random rand = new Random();
				int randInt = rand.nextInt(75);
				if (randInt <= 5) {
					Item seedToDrop;
					switch (randInt) {
					default:
						seedToDrop = ZollernItems.tomatoSeeds;
						break;
					case 1:
						seedToDrop = ZollernItems.cucumberSeeds;
						break;
					}
					EntityItem seedItem = new EntityItem(world, event.x,
							event.y, event.z, new ItemStack(seedToDrop, 1));
					world.spawnEntityInWorld(seedItem);
				}
			} else if (block.getClass() == BabyDragonEgg.class) {
				EntityBabyDragon dragon = new EntityBabyDragon(world);
				dragon.setLocationAndAngles(event.x + 0.5D, event.y + 0.5D,
						event.z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(dragon);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void FillBucket(FillBucketEvent event) {
		ItemStack result = attemptFill(event.world, event.target);
		if (result != null) {
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
	
	private ItemStack attemptFill(World world, MovingObjectPosition p) {
		Block id = world.getBlock(p.blockX, p.blockY, p.blockZ);
		if (id == ZollernBlocks.blockChocolate) {
			if (world.getBlockMetadata(p.blockX, p.blockY, p.blockZ) == 0) {
				world.setBlock(p.blockX, p.blockY, p.blockZ, Blocks.air);
				return new ItemStack(ZollernItems.chocolateBucket);
			}
		} else if (id == ZollernBlocks.blockFuel) {
			if (world.getBlockMetadata(p.blockX, p.blockY, p.blockZ) == 0) {
				world.setBlock(p.blockX, p.blockY, p.blockZ, Blocks.air);
				return new ItemStack(ZollernItems.fuelBucket);
			}
		} else if (id == ZollernBlocks.blockChargium) {
			if (world.getBlockMetadata(p.blockX, p.blockY, p.blockZ) == 0) {
				world.setBlock(p.blockX, p.blockY, p.blockZ, Blocks.air);
				return new ItemStack(ZollernItems.chargiumBucket);
			}
		} else if (id == ZollernBlocks.blockWhiteLava) {
			if (world.getBlockMetadata(p.blockX, p.blockY, p.blockZ) == 0) {
				world.setBlock(p.blockX, p.blockY, p.blockZ, Blocks.air);
				return new ItemStack(ZollernItems.whiteLavaBucket);
			}
		}
		return null;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer
				&& !event.entity.worldObj.isRemote) {
			NBTTagCompound playerData = CommonProxy
					.getEntityData(((EntityPlayer) event.entity)
							.getCommandSenderName());
			if (playerData != null) {
				((ExtendedPlayer) event.entity
						.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
						.loadNBTData(playerData);
			}
			EntityPlayer player = (EntityPlayer) event.entity;
			PacketDispatcher.sendTo(new SyncPlayerPropsMessage(player),
					(EntityPlayerMP) player);
		}
	}
	
	@SubscribeEvent
	public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
		EntityPlayer player = event.player;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if (!player.capabilities.isCreativeMode) {
			double maxHealth = props.getMaxHealth();
			player.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(maxHealth);
		}
	}
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if (!event.entity.worldObj.isRemote) {
				event.entity.motionY += props.getMaxJump();
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (!player.capabilities.isCreativeMode) {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				float fallDistance = event.distance;
				if (fallDistance >= 2.5F) {
					double resist = props.getFallResistance();
					double totalResistance = fallDistance - resist;
					if (totalResistance > 0.0D) {
						event.distance -= (float) resist;
					}
					
					if (new Random().nextInt(15) == 1) {
						double incrAmnt = new Random().nextDouble();
						if (incrAmnt > 0.3D) {
							incrAmnt = 0.3D;
						}
						if (incrAmnt < 0.1D) {
							incrAmnt = 0.1D;
						}
						if (incrAmnt > 0.0D) {
							props.setMaxFallResistance(resist + incrAmnt);
							String fullResist = "" + resist + incrAmnt;
							String strIncrAmnt = "" + incrAmnt;
							ZollernHelper.addChatMessage(
									player,
									EnumChatFormatting.GOLD + "+"
											+ strIncrAmnt.substring(0, 3)
											+ " Fall Resistance! Total: "
											+ fullResist.substring(0, 3));
							if (new Random().nextInt(20) <= 2) {
								if (props.getMaxJump() < 8.0D) {
									props.setMaxJump(props.getMaxJump()
											+ incrAmnt);
									fullResist = props.getMaxJump() + incrAmnt
											+ "";
									ZollernHelper.addChatMessage(
											player,
											EnumChatFormatting.GOLD
													+ "+"
													+ strIncrAmnt.substring(0,
															3)
													+ " Jump Height! Total: "
													+ fullResist
															.substring(0, 3));
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingHurtEvent(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			double defense = props.getMaxDefense();
			event.ammount = (float) (event.ammount - defense > 0F ? event.ammount
					- defense
					: 0F);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onHarvestDropsEvent(BlockEvent.HarvestDropsEvent event) {
		if (event.harvester instanceof EntityPlayer) {
			if (event.harvester.getClass() == EntityPlayer.class) {
				EntityPlayer player = event.harvester;
				if (!event.world.isRemote) {
					if (!player.capabilities.isCreativeMode) {
						if (event.block instanceof IOre) {
							Random rand = new Random();
							IOre oreBlock = (IOre) event.block;
							ExtendedPlayer props = ExtendedPlayer.get(player);
							double fortune = props.getMaxFortune();
							if (rand.nextInt(10) <= 4) {
								double blockFortune = oreBlock.getFortune();
								props.setMaxFortune(fortune + blockFortune);
								String strFortuneLevel = ""
										+ props.getMaxFortune();
								ZollernHelper.addChatMessage(
										player,
										EnumChatFormatting.GOLD
												+ "+"
												+ blockFortune
												+ " Fortune! Total: "
												+ strFortuneLevel.substring(0,
														3));
							}
							if (new Random().nextInt(5) <= 2) {
								int numDropped = 0;
								if (fortune >= 1.0D) {
									int r = new Random().nextInt((int) fortune);
									numDropped = r == 0 ? 1 : r;
								}
								if (numDropped > oreBlock.getMaxDropIncrease()) {
									numDropped = oreBlock.getMaxDropIncrease();
								}
								Item droppedItem = oreBlock
										.getDroppedItemStack().getItem();
								event.drops.add(new ItemStack(droppedItem,
										numDropped));
							}
						} else if (event.block instanceof BlockCrops) {
							// TODO
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityZombie) {
			if (new Random().nextInt(100) <= 50) {
				EntityItem item = new EntityItem(worldObj, theEntity.posX,
						theEntity.posY, theEntity.posZ, new ItemStack(
								ZollernItems.flour, 1));
				worldObj.spawnEntityInWorld(item);
			}
		} else if (theEntity instanceof EntityBlaze) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.blaze_rod, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityEnderman) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ender_pearl, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity.getClass() == EntitySkeleton.class) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ,
					new ItemStack(Items.bone, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySilverfish) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ZollernItems.silverNugget, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityGhast) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ghast_tear, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySheep) {
			Item theItem = theEntity.isBurning() ? ZollernItems.cookedLamb
					: ZollernItems.rawLamb;
			Random rand = new Random();
			int numDropped = rand.nextInt(2);
			numDropped = numDropped == 0 ? 1 : numDropped;
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(theItem,
							numDropped));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof IShadeEntity) {
			Random rand = new Random();
			int randInt = rand.nextInt(100);
			if (randInt <= 60) {
				ItemStack itemStack = new ItemStack(ZollernItems.shadowEssence,
						1);
				EntityItem itemEntity = new EntityItem(worldObj,
						theEntity.posX, theEntity.posY, theEntity.posZ,
						itemStack);
				worldObj.spawnEntityInWorld(itemEntity);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onClonePlayerEvent(PlayerEvent.Clone event) {
		ExtendedPlayer.get(event.entityPlayer).copy(
				ExtendedPlayer.get(event.original));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void UseHoeEvent(UseHoeEvent event) {
		EntityPlayer par2EntityPlayer = event.entityPlayer;
		ItemStack par1ItemStack = par2EntityPlayer.getHeldItem();
		World par3World = event.world;
		int par4 = event.x;
		int par5 = event.y;
		int par6 = event.z;
		int par7 = 1;
		
		if (event.getResult() == Result.ALLOW) {
			par1ItemStack.damageItem(1, par2EntityPlayer);
		}
		
		Block i1 = par3World.getBlock(par4, par5, par6);
		boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
		
		if (par7 != 0 && air && i1 == ZollernBlocks.betterGrass) {
			Block block = Block.getBlockById(60);
			par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F,
					block.stepSound.getBreakSound(),
					(block.stepSound.getVolume() + 1.0F) / 2.0F,
					block.stepSound.getPitch() * 0.8F);
			
			if (!par3World.isRemote) {
				par3World.setBlock(par4, par5, par6, block);
				par1ItemStack.damageItem(1, par2EntityPlayer);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
		World worldObj = event.world;
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(event.chunkX * 16,
				event.chunkZ * 16);
		if (biome.isEqualTo(BiomeList.candyLand)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = ZollernBlocks.candyCubeBrown;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock) {
									Block theBlock = toBlock;
									int rand = new Random().nextInt(34);
									if (rand == 0) {
										theBlock = ZollernBlocks.candyCubeWhite;
									} else if (rand == 1) {
										theBlock = ZollernBlocks.candyCubeBlue;
									} else if (rand == 2) {
										theBlock = ZollernBlocks.candyCubeRed;
									} else if (rand == 3) {
										theBlock = ZollernBlocks.candyCubeCyan;
									} else if (rand == 4) {
										theBlock = ZollernBlocks.candyCubeOrange;
									} else if (rand == 5) {
										theBlock = ZollernBlocks.candyCubePurple;
									} else if (rand == 6) {
										theBlock = ZollernBlocks.candyCubeGreen;
									} else if (rand == 7) {
										theBlock = ZollernBlocks.candyCubeBrown;
									} else if (rand == 8) {
										theBlock = ZollernBlocks.candyCubeYellow;
									} else if (rand == 9) {
										theBlock = ZollernBlocks.candyCubePurple;
									} else if (rand == 10) {
										theBlock = ZollernBlocks.sugarCube;
									} else if (rand == 11) {
										theBlock = ZollernBlocks.chocolateBlock;
									} else if (rand == 12) {
										theBlock = ZollernBlocks.brownieBlock;
									} else if (rand == 13) {
										theBlock = ZollernBlocks.iceCreamSandwichBlock;
									} else if (rand == 14) {
										theBlock = ZollernBlocks.cookieBlock;
									} else {
										theBlock = toBlock;
									}
									storage.func_150818_a(x, y, z, theBlock);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.dirt) {
									storage.func_150818_a(x, y, z,
											ZollernBlocks.candyCubeOrange);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.gravel) {
									storage.func_150818_a(x, y, z,
											ZollernBlocks.candyCubeGray);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.clay) {
									storage.func_150818_a(x, y, z,
											ZollernBlocks.candyCubeBlack);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (biome.isEqualTo(BiomeList.crystalOcean)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = ZollernBlocks.prismarine;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock
										|| storage.getBlockByExtId(x, y, z) == Blocks.dirt) {
									Block theBlock = toBlock;
									storage.func_150818_a(x, y, z, toBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (biome.isEqualTo(BiomeList.cheesePlains)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.cheeseBlock;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock
										|| storage.getBlockByExtId(x, y, z) == Blocks.dirt
										|| storage.getBlockByExtId(x, y, z) == Blocks.gravel) {
									Block theBlock = toBlock;
									storage.func_150818_a(x, y, z, toBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (biome.isEqualTo(BiomeList.upsideDown)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.dirt;
			Block toBlock = ZollernBlocks.upsideDownDirt;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock) {
									Block theBlock = toBlock;
									storage.func_150818_a(x, y, z, toBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityStruckByLightningEvent(
			EntityStruckByLightningEvent event) {
		Entity theEntity = event.entity;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityVillager) {
			EntityVillager theVillager = (EntityVillager) theEntity;
			theVillager.setDead();
			EntityWitch theWitch = new EntityWitch(worldObj);
			theWitch.setLocationAndAngles(theVillager.posX, theVillager.posY,
					theVillager.posZ, theVillager.rotationYaw,
					theVillager.rotationPitch);
			worldObj.spawnEntityInWorld(theWitch);
		}
	}
}