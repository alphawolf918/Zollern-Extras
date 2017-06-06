package zollernextras.dimension.upsidedown.providers;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimension.upsidedown.MapGenCavesUpsideDown;
import zollernextras.dimension.upsidedown.MapGenUpsideDownRavine;
import zollernextras.dimension.upsidedown.WorldGenUpsideDownDungeons;
import zollernextras.lib.noise.Gradient;
import zollernextras.lib.noise.NoiseModule;
import zollernextras.mobs.entities.EntityKrull;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.entities.EntityShade;
import zollernextras.mobs.entities.EntityShadowSkeleton;

public class ChunkProviderUpsideDown extends ChunkProviderGenerate {
	
	final Block topBlockID = ZollernBlocks.upsideDownSurfaceRock;
	final byte topBlockMeta = 0;
	final Block fillBlockID = ZollernBlocks.upsideDownRock;
	final byte fillBlockMeta = 0;
	final Block lowerBlockID = ZollernBlocks.upsideDownStone;
	final byte lowerBlockMeta = 0;
	
	private final Random rand;
	
	private final NoiseModule noiseGen1;
	private final NoiseModule noiseGen2;
	private final NoiseModule noiseGen3;
	private final NoiseModule noiseGen4;
	
	private final World worldObj;
	
	private BiomeGenBase[] biomesForGeneration = { BiomeList.upsideDown };
	
	private MapGenBase caveGenerator = new MapGenCavesUpsideDown();
	
	/** Holds Village Generator */
	private MapGenVillage villageGenerator = new MapGenVillage();
	
	/** Holds Mineshaft Generator */
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	
	/** Holds ravine generator */
	private MapGenUpsideDownRavine ravineGenerator = new MapGenUpsideDownRavine();
	
	private WorldGenUpsideDownDungeons dungeonGenerator = new WorldGenUpsideDownDungeons();
	
	private static final int MID_HEIGHT = 63;
	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Y = 128;
	private static final int CHUNK_SIZE_Z = 16;
	
	public ChunkProviderUpsideDown(World par1World, long par2, boolean par4) {
		super(par1World, par2, par4);
		this.worldObj = par1World;
		this.rand = new Random(par2);
		this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen3 = new Gradient(this.rand.nextLong(), 1, 0.25F);
		this.noiseGen4 = new Gradient(this.rand.nextLong(), 1, 0.25F);
	}
	
	public void generateTerrain(int chunkX, int chunkZ, Block[] idArray,
			byte[] metaArray) {
		this.noiseGen1.setFrequency(0.0125F);
		this.noiseGen2.setFrequency(0.015F);
		this.noiseGen3.setFrequency(0.01F);
		this.noiseGen4.setFrequency(0.02F);
		
		for (int x = 0; x < ChunkProviderUpsideDown.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderUpsideDown.CHUNK_SIZE_Z; z++) {
				final double d = this.noiseGen1.getNoise(x + chunkX * 16, z
						+ chunkZ * 16) * 8;
				final double d2 = this.noiseGen2.getNoise(x + chunkX * 16, z
						+ chunkZ * 16) * 24;
				double d3 = this.noiseGen3.getNoise(x + chunkX * 16, z + chunkZ
						* 16) - 0.1;
				d3 *= 4;
				
				double yDev = 0;
				
				if (d3 < 0.0D) {
					yDev = d;
				} else if (d3 > 1.0D) {
					yDev = d2;
				} else {
					yDev = d + (d2 - d) * d3;
				}
				
				for (int y = 0; y < ChunkProviderUpsideDown.CHUNK_SIZE_Y; y++) {
					if (y < ChunkProviderUpsideDown.MID_HEIGHT + yDev) {
						idArray[this.getIndex(x, y, z)] = this.lowerBlockID;
						metaArray[this.getIndex(x, y, z)] = this.lowerBlockMeta;
					}
				}
			}
		}
	}
	
	@Override
	public void replaceBlocksForBiome(int par1, int par2, Block[] arrayOfIDs,
			byte[] arrayOfMeta, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
		final int var5 = 20;
		for (int var8 = 0; var8 < 16; ++var8) {
			for (int var9 = 0; var9 < 16; ++var9) {
				final int var12 = (int) (this.noiseGen4.getNoise(var8 + par1
						* 16, var9 * par2 * 16) / 3.0D + 3.0D + this.rand
						.nextDouble() * 0.25D);
				int var13 = -1;
				Block var14 = this.topBlockID;
				byte var14m = this.topBlockMeta;
				Block var15 = this.fillBlockID;
				byte var15m = this.fillBlockMeta;
				
				for (int var16 = 127; var16 >= 0; --var16) {
					final int index = this.getIndex(var8, var16, var9);
					arrayOfMeta[index] = 0;
					
					if (var16 <= 0 + this.rand.nextInt(5)) {
						arrayOfIDs[index] = Blocks.bedrock;
					} else {
						final Block var18 = arrayOfIDs[index];
						if (Blocks.air == var18) {
							var13 = -1;
						} else if (var18 == this.lowerBlockID) {
							arrayOfMeta[index] = this.lowerBlockMeta;
							
							if (var13 == -1) {
								if (var12 <= 0) {
									var14 = Blocks.air;
									var14m = 0;
									var15 = this.lowerBlockID;
									var15m = this.lowerBlockMeta;
								} else if (var16 >= var5 - -16
										&& var16 <= var5 + 1) {
									var14 = this.topBlockID;
									var14m = this.topBlockMeta;
									var14 = this.fillBlockID;
									var14m = this.fillBlockMeta;
								}
								
								var13 = var12;
								
								if (var16 >= var5 - 1) {
									arrayOfIDs[index] = var14;
									arrayOfMeta[index] = var14m;
								} else if (var16 < var5 - 1
										&& var16 >= var5 - 2) {
									arrayOfIDs[index] = var15;
									arrayOfMeta[index] = var15m;
								}
							} else if (var13 > 0) {
								--var13;
								arrayOfIDs[index] = var15;
								arrayOfMeta[index] = var15m;
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
		final Block[] ids = new Block[16 * 16 * 256];
		final byte[] meta = new byte[16 * 16 * 256];
		Arrays.fill(ids, Blocks.air);
		this.generateTerrain(par1, par2, ids, meta);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager()
				.loadBlockGeneratorData(this.biomesForGeneration, par1 * 16,
						par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, ids, meta,
				this.biomesForGeneration);
		this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ids);
		this.ravineGenerator
				.func_151539_a(this, this.worldObj, par1, par2, ids);
		final Chunk var4 = new Chunk(this.worldObj, ids, meta, par1, par2);
		var4.generateSkylightMap();
		return var4;
	}
	
	@Override
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}
	
	@Override
	public boolean chunkExists(int par1, int par2) {
		return true;
	}
	
	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}
	
	@Override
	public int getLoadedChunkCount() {
		return 0;
	}
	
	private int getIndex(int x, int y, int z) {
		return (x * 16 + z) * 256 + y;
	}
	
	private double randFromPoint(int x, int z) {
		int n;
		n = x + z * 57;
		n = n << 13 ^ n;
		return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
	}
	
	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockFalling.fallInstantly = true;
		final int var4 = par2 * 16;
		final int var5 = par3 * 16;
		this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		final long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		final long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(par2 * var7 + par3 * var9 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		int k = var4;
		int l = var5;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));
		
		this.mineshaftGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		this.dungeonGenerator.generate(worldObj, rand, var5, k, l);
		flag = this.villageGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		
		int k1;
		int l1;
		int i2;
		
		if (this.rand.nextInt(4) == 0
				&& TerrainGen.populate(par1IChunkProvider, worldObj, rand,
						par2, par3, flag, LAKE)) {
			k1 = var4 + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = var5 + this.rand.nextInt(16) + 8;
		}
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3,
				flag, LAVA) && !flag && this.rand.nextInt(8) == 0) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			i2 = l + this.rand.nextInt(16) + 8;
		}
		
		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand,
				par2, par3, flag, DUNGEON);
		for (k1 = 0; doGen && k1 < 8; ++k1) {
			l1 = k + this.rand.nextInt(16) + 8;
			i2 = this.rand.nextInt(256);
			int j2 = l + this.rand.nextInt(16) + 8;
			new WorldGenUpsideDownDungeons().generate(this.worldObj, this.rand,
					l1, i2, j2);
		}
		
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16,
				l + 16);
		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		k += 8;
		l += 8;
		
		doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2,
				par3, flag, ICE);
		for (k1 = 0; doGen && k1 < 16; ++k1) {
			for (l1 = 0; l1 < 16; ++l1) {
				i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
				
				if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l)) {
					this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice,
							0, 2);
				}
			}
		}
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}
	
	@Override
	public boolean canSave() {
		return true;
	}
	
	@Override
	public String makeString() {
		return "RandomLevelSource";
	}
	
	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType,
			int i, int j, int k) {
		if (par1EnumCreatureType == EnumCreatureType.monster) {
			final List monsters = new ArrayList();
			monsters.add(new SpawnListEntry(EntityShadowSkeleton.class, 5, 2, 4));
			monsters.add(new SpawnListEntry(EntityScorpion.class, 5, 2, 4));
			monsters.add(new SpawnListEntry(EntityShade.class, 5, 2, 4));
			monsters.add(new SpawnListEntry(EntityKrull.class, 1, 0, 1));
			return monsters;
		} else {
			// TODO
			return null;
		}
	}
	
	@Override
	public void recreateStructures(int x, int z) {
		int y = this.worldObj.getHeightValue(x, z);
		this.mineshaftGenerator.func_151539_a(this, this.worldObj, x, z,
				(Block[]) null);
		this.dungeonGenerator.generate(worldObj, rand, x, y, z);
	}
}