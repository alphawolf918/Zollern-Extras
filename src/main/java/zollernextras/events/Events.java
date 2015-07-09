package zollernextras.events;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.BlockEvent;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BlockList;
import zollernextras.blocks.ores.IOre;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.items.ItemList;
import zollernextras.lib.M;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.proxies.CommonProxy;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class Events {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
				ExtendedPlayer.register((EntityPlayer) event.entity);
			}
		}
	}
	
	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event) {
		EntityPlayer player = event.player;
		// TODO
	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = CommonProxy
					.getEntityData(((EntityPlayer) event.entity)
							.getCommandSenderName()
							+ ExtendedPlayer.EXT_PROP_NAME);
			if (playerData != null) {
				((ExtendedPlayer) event.entity
						.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
						.saveNBTData(playerData);
			}
			CommonProxy.storeEntityData(
					((EntityPlayer) event.entity).getCommandSenderName(),
					playerData);
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer
				&& !event.entity.worldObj.isRemote) {
			if (!event.entity.worldObj.isRemote
					&& event.entity instanceof EntityPlayer) {
				NBTTagCompound playerData = CommonProxy
						.getEntityData(((EntityPlayer) event.entity)
								.getCommandSenderName());
				if (playerData != null) {
					((ExtendedPlayer) event.entity
							.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
							.loadNBTData(playerData);
				}
				
				if (event.entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.entity;
					ExtendedPlayer props = ExtendedPlayer.get(player);
					if (!player.capabilities.isCreativeMode) {
						double maxHealth = props.getMaxHealth();
						IAttributeInstance attrMaxHealth = player
								.getEntityAttribute(SharedMonsterAttributes.maxHealth);
						player.getEntityAttribute(
								SharedMonsterAttributes.maxHealth)
								.setBaseValue(maxHealth);
					}
					PacketDispatcher.sendTo(new SyncPlayerPropsMessage(
							(EntityPlayer) event.entity),
							(EntityPlayerMP) event.entity);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityFalling(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (!player.capabilities.isCreativeMode) {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				float fallDistance = event.distance;
				if (fallDistance >= 1.5F) {
					double resist = props.getFallResistance();
					double totalResistance = fallDistance - resist;
					if (totalResistance > 0.0D) {
						event.distance -= (float) resist;
					}
					
					if (new Random().nextInt(20) == 1) {
						double incrAmnt = new Random().nextDouble();
						if (incrAmnt > 0.3D) {
							incrAmnt = 0.3D;
						}
						if (incrAmnt < 0.1D) {
							incrAmnt = 0.1D;
						}
						if (incrAmnt > 0.0D) {
							String strFallResist = ""
									+ props.getFallResistance();
							String strIncrAmnt = "" + incrAmnt;
							M.addChatMessage(player, EnumChatFormatting.GOLD
									+ "+" + strIncrAmnt.substring(0, 3)
									+ " Fall Resistance! Total: "
									+ strFallResist.substring(0, 3));
							props.setMaxFallResistance(resist + incrAmnt);
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onHarvestOre(BlockEvent.HarvestDropsEvent event) {
		if (event.harvester instanceof EntityPlayer) {
			EntityPlayer player = event.harvester;
			if (!player.capabilities.isCreativeMode) {
				if (event.block instanceof IOre) {
					Random rand = new Random();
					IOre oreBlock = (IOre) event.block;
					ExtendedPlayer props = ExtendedPlayer.get(player);
					double fortune = props.getMaxFortune();
					if (new Random().nextInt(20) == 1) {
						double blockFortune = oreBlock.getFortune();
						props.setMaxFortune(fortune + blockFortune);
						String strFortuneLevel = "" + props.getMaxFortune();
						M.addChatMessage(player, EnumChatFormatting.GOLD + "+"
								+ blockFortune + " Fortune! Total: "
								+ strFortuneLevel.substring(0, 3));
					}
					if (new Random().nextInt(5) == 1) {
						int numDropped = 0;
						if (fortune >= 1.0D) {
							int r = new Random().nextInt((int) fortune);
							numDropped = r == 0 ? 1 : r;
						}
						if (numDropped > oreBlock.getMaxDropIncrease()) {
							numDropped = oreBlock.getMaxDropIncrease();
						}
						Item droppedItem = oreBlock.getDroppedItemStack()
								.getItem();
						event.drops.add(new ItemStack(droppedItem, numDropped));
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityItemDrop(LivingDropsEvent event) {
		Entity theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityZombie) {
			if (new Random().nextInt(100) <= 50) {
				EntityItem item = new EntityItem(worldObj, theEntity.posX,
						theEntity.posY, theEntity.posZ, new ItemStack(
								ItemList.flour, 1));
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
		} else if (theEntity instanceof EntitySkeleton) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(Items.bow, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySilverfish) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ItemList.silverNugget, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityGhast) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ghast_tear, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySheep) {
			Item theItem = theEntity.isBurning() ? ItemList.cookedLamb
					: ItemList.rawLamb;
			Random rand = new Random();
			int numDropped = rand.nextInt(2);
			numDropped = numDropped == 0 ? 1 : numDropped;
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(theItem,
							numDropped));
			worldObj.spawnEntityInWorld(item);
		}
	}
	
	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		ExtendedPlayer.get(event.entityPlayer).copy(
				ExtendedPlayer.get(event.original));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void UseHoe(UseHoeEvent event) {
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
		
		if (par7 != 0 && air && i1 == BlockList.betterGrass) {
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
		if (worldObj.getBiomeGenForCoords(event.chunkX * 16, event.chunkZ * 16)
				.isEqualTo(BiomeList.candyLand)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.candyCubeBrown;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock) {
									Block theBlock = toBlock;
									int rand = new Random().nextInt(26);
									if (rand == 0) {
										theBlock = BlockList.candyCubeWhite;
									} else if (rand == 1) {
										theBlock = BlockList.candyCubeBlue;
									} else if (rand == 2) {
										theBlock = BlockList.candyCubeRed;
									} else if (rand == 3) {
										theBlock = BlockList.candyCubeCyan;
									} else if (rand == 4) {
										theBlock = BlockList.candyCubeOrange;
									} else if (rand == 5) {
										theBlock = BlockList.candyCubePurple;
									} else if (rand == 6) {
										theBlock = BlockList.candyCubeGreen;
									} else if (rand == 7) {
										theBlock = BlockList.candyCubeBrown;
									} else if (rand == 8) {
										theBlock = BlockList.candyCubeYellow;
									} else if (rand == 9) {
										theBlock = BlockList.candyCubePurple;
									} else if (rand == 10) {
										theBlock = BlockList.sugarCube;
									} else {
										theBlock = toBlock;
									}
									storage.func_150818_a(x, y, z, theBlock);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.dirt) {
									storage.func_150818_a(x, y, z,
											BlockList.candyCubeOrange);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.gravel) {
									storage.func_150818_a(x, y, z,
											BlockList.candyCubeGray);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (worldObj.getBiomeGenForCoords(event.chunkX * 16,
				event.chunkZ * 16).isEqualTo(BiomeList.crystalOcean)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.prismarine;
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
				chunk.isModified = true;
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
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