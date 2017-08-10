package zollernextras.dimensions.providers.chunk;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import zollernextras.lib.ZollernHelper;
import com.google.common.collect.Lists;

public class ChunkHellProvider extends ChunkProviderHell {
	
	private final World world;
	private final Random rand;
	
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorOctaves noiseGenSoulSandGravel;
	private NoiseGeneratorOctaves noiseGenNetherrack;
	private NoiseGeneratorOctaves noiseGenScale;
	private NoiseGeneratorOctaves noiseGenDepth;
	
	private Biome[] biomesForGen;
	
	private double[] buffer;
	private double[] depthBuffer = new double[256];
	private double[] soulSandNoise = new double[256];
	private double[] gravelNoise = new double[256];
	private double[] noiseData1;
	private double[] noiseData2;
	private double[] noiseData3;
	private double[] noiseData4;
	private double[] noiseData5;
	private final boolean generateStructures;
	
	private final WorldGenFire fireFeature = new WorldGenFire();
	private final WorldGenGlowStone1 lightGemGen = new WorldGenGlowStone1();
	private final WorldGenGlowStone2 hellPortalGen = new WorldGenGlowStone2();
	private final WorldGenerator quartzGen = new WorldGenMinable(
			Blocks.QUARTZ_ORE.getDefaultState(), 14,
			BlockMatcher.forBlock(Blocks.NETHERRACK));
	private final WorldGenerator magmaGen = new WorldGenMinable(
			Blocks.MAGMA.getDefaultState(), 33,
			BlockMatcher.forBlock(Blocks.NETHERRACK));
	private final WorldGenHellLava lavaTrapGen = new WorldGenHellLava(
			Blocks.FLOWING_LAVA, true);
	private final WorldGenHellLava hellSpringGen = new WorldGenHellLava(
			Blocks.FLOWING_LAVA, false);
	private final WorldGenBush brownMushroomFeature = new WorldGenBush(
			Blocks.BROWN_MUSHROOM);
	private final WorldGenBush redMushroomFeature = new WorldGenBush(
			Blocks.RED_MUSHROOM);
	private MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
	private MapGenBase genNetherCaves = new MapGenCavesHell();
	
	private MapGenCavesHell netherCaves = new MapGenCavesHell();
	private MapGenNetherBridge netherBridge = new MapGenNetherBridge();
	private final List<Biome.SpawnListEntry> spawnList = Lists
			.<Biome.SpawnListEntry> newArrayList();
	
	public ChunkHellProvider(World worldIn) {
		super(worldIn, true, worldIn.getSeed());
		world = worldIn;
		generateStructures = false;
		rand = new Random(world.getSeed());
		noiseGen1 = new NoiseGeneratorOctaves(rand, 16);
		noiseGen2 = new NoiseGeneratorOctaves(rand, 16);
		noiseGen3 = new NoiseGeneratorOctaves(rand, 8);
		noiseGenSoulSandGravel = new NoiseGeneratorOctaves(rand, 4);
		noiseGenNetherrack = new NoiseGeneratorOctaves(rand, 4);
		noiseGenScale = new NoiseGeneratorOctaves(rand, 10);
		noiseGenDepth = new NoiseGeneratorOctaves(rand, 16);
		
		InitNoiseGensEvent.ContextHell ctx = new InitNoiseGensEvent.ContextHell(
				noiseGen1, noiseGen2, noiseGen3, noiseGenSoulSandGravel,
				noiseGenNetherrack, noiseGenScale, noiseGenDepth);
		ctx = TerrainGen.getModdedNoiseGenerators(world, rand, ctx);
		
		noiseGen1 = ctx.getLPerlin1();
		noiseGen2 = ctx.getLPerlin2();
		noiseGen3 = ctx.getPerlin();
		noiseGenSoulSandGravel = ctx.getPerlin2();
		noiseGenNetherrack = ctx.getPerlin3();
		noiseGenScale = ctx.getScale();
		noiseGenDepth = ctx.getDepth();
		
		this.genNetherBridge = (MapGenNetherBridge) net.minecraftforge.event.terraingen.TerrainGen
				.getModdedMapGen(
						genNetherBridge,
						net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.NETHER_BRIDGE);
		this.genNetherCaves = net.minecraftforge.event.terraingen.TerrainGen
				.getModdedMapGen(
						genNetherCaves,
						net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.NETHER_CAVE);
		
		worldIn.setSeaLevel(31);
	}
	
	@Override
	public void prepareHeights(int chunkX, int chunkZ, ChunkPrimer primer) {
		buffer = generateHeightMap(buffer, chunkX * 4, 0, chunkZ * 4, 5, 17, 5);
		
		for (int x = 0; x < 4; x++) {
			for (int z = 0; z < 4; z++) {
				for (int y = 0; y < 16; y++) {
					double d1 = buffer[(x * 5 + z) * 17 + y];
					double d2 = buffer[(((x * 5) + z + 1) * 17) + y];
					double d3 = buffer[((((x + 1) * 5) + z) * 17) + y];
					double d4 = buffer[((x + 1) * 5 + z + 1) * 17 + y];
					double d5 = (buffer[(x * 5 + z) * 17 + y + 1] - d1) * 0.125D;
					double d6 = (buffer[(x * 5 + z + 1) * 17 + y + 1] - d2) * 0.125D;
					double d7 = (buffer[((x + 1) * 5 + z) * 17 + y + 1] - d3) * 0.125D;
					double d8 = (buffer[((x + 1) * 5 + z + 1) * 17 + y + 1] - d4) * 0.125D;
					
					for (int y2 = 0; y2 < 8; y2++) {
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * 0.25D;
						double d13 = (d4 - d2) * 0.25D;
						
						for (int x2 = 0; x2 < 4; x2++) {
							double d15 = d10;
							double d16 = (d11 - d10) * 0.25D;
							
							for (int z2 = 0; z2 < 4; z2++) {
								int posX = x2 + x * 4;
								int posY = y2 + y * 8;
								int posZ = z2 + z * 4;
								
								Biome biome = biomesForGen[posX + posZ * 16];
								
								IBlockState state = null;
								IBlockState biomeFillerBlock = biome.fillerBlock;
								
								if (d15 > 0.0D) {
									state = biomeFillerBlock;
								}
								
								primer.setBlockState(posX, posY, posZ, state);
								d15 += d16;
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
	
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(
			EnumCreatureType creatureType, BlockPos pos) {
		if (creatureType == EnumCreatureType.MONSTER) {
			if (this.genNetherBridge.isInsideStructure(pos)) {
				this.spawnList.add(new Biome.SpawnListEntry(EntityBlaze.class,
						10, 2, 3));
				this.spawnList.add(new Biome.SpawnListEntry(
						EntityPigZombie.class, 5, 4, 4));
				this.spawnList.add(new Biome.SpawnListEntry(
						EntityWitherSkeleton.class, 8, 5, 5));
				this.spawnList.add(new Biome.SpawnListEntry(
						EntitySkeleton.class, 2, 5, 5));
				this.spawnList.add(new Biome.SpawnListEntry(
						EntityMagmaCube.class, 3, 4, 4));
				return this.spawnList;
			}
			
			if (this.genNetherBridge.isPositionInStructure(this.world, pos)
					&& this.world.getBlockState(pos.down()).getBlock() == Blocks.NETHER_BRICK) {
				return this.genNetherBridge.getSpawnList();
			}
		}
		
		Biome biome = this.world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}
	
	@Override
	public void buildSurfaces(int chunkX, int chunkZ, ChunkPrimer primer) {
		if (!ForgeEventFactory.onReplaceBiomeBlocks(this, chunkX, chunkZ,
				primer, world)) {
			ZollernHelper.logInfo("Could not replace biome blocks.");
			return;
		}
		
		soulSandNoise = noiseGenSoulSandGravel.generateNoiseOctaves(
				soulSandNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1,
				0.03125D, 0.03125D, 1.0D);
		gravelNoise = noiseGenSoulSandGravel.generateNoiseOctaves(gravelNoise,
				chunkX * 16, 109, chunkZ * 16, 16, 1, 16, 0.03125D, 1.0D,
				0.03125D);
		depthBuffer = noiseGenNetherrack.generateNoiseOctaves(depthBuffer,
				chunkX * 16, chunkZ * 16, 0, 16, 16, 1, 0.0625D, 0.0625D,
				0.0625D);
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int l = (int) (depthBuffer[x + z * 16] / 3.0D + 3.0D + rand
						.nextDouble() * 0.25D);
				int i1 = -1;
				boolean genSoulSand = soulSandNoise[x + z * 16]
						+ rand.nextDouble() * 0.2D > 0.0D;
				boolean genGravel = gravelNoise[x + z * 16] + rand.nextDouble()
						* 0.2D > 0.0D;
				Biome biome = biomesForGen[x + z * 16];
				
				final IBlockState biomeTopBlock = biome.topBlock;
				final IBlockState biomeFillerBlock = biome.fillerBlock;
				
				IBlockState topBlock = biomeTopBlock;
				IBlockState fillerBlock = biomeFillerBlock;
				
				for (int y = 127; y >= 0; y--) {
					if (y < 127 && y > 0) {
						IBlockState checkBlock = primer.getBlockState(x, y, z);
						
						if (checkBlock.getMaterial() != Material.AIR) {
							if (checkBlock == biomeFillerBlock) {
								if (i1 == -1) {
									if (l <= 0) {
										topBlock = Blocks.AIR.getDefaultState();
										fillerBlock = biomeTopBlock;
									} else if (y >= 62 && y <= 66) {
										topBlock = biomeTopBlock;
										fillerBlock = biomeFillerBlock;
										
										topBlock = Blocks.SOUL_SAND
												.getDefaultState();
										fillerBlock = Blocks.SOUL_SAND
												.getDefaultState();
									}
									
									i1 = l;
									
									if (topBlock == biomeTopBlock
											&& fillerBlock == biomeFillerBlock) {
										primer.setBlockState(x, y, z, topBlock);
									} else {
										if (y > 64) {
											primer.setBlockState(x, y, z,
													topBlock);
										} else {
											primer.setBlockState(x, y, z,
													fillerBlock);
										}
									}
								} else if (i1 > 0) {
									i1--;
									primer.setBlockState(x, y, z, fillerBlock);
								}
							}
						} else {
							i1 = -1;
						}
						if (y <= 32 && y > 0) {
							primer.setBlockState(x, y, z,
									Blocks.NETHERRACK.getDefaultState());
						}
					} else {
						primer.setBlockState(x, y, z,
								Blocks.BEDROCK.getDefaultState());
					}
				}
			}
		}
	}
	
	private double[] generateHeightMap(double[] heightMap, int posX, int posY,
			int posZ, int xSize, int ySize, int zSize) {
		if (heightMap == null) {
			heightMap = new double[xSize * ySize * zSize];
		}
		
		ChunkGeneratorEvent.InitNoiseField event = new ChunkGeneratorEvent.InitNoiseField(
				this, heightMap, posX, posY, posZ, xSize, ySize, zSize);
		MinecraftForge.EVENT_BUS.post(event);
		
		if (event.getResult() == Result.DENY) {
			return event.getNoisefield();
		}
		
		noiseData4 = noiseGenScale.generateNoiseOctaves(noiseData4, posX, posY,
				posZ, xSize, 1, zSize, 1.0D, 0.0D, 1.0D);
		noiseData5 = noiseGenDepth.generateNoiseOctaves(noiseData5, posX, posY,
				posZ, xSize, 1, zSize, 100.0D, 0.0D, 100.0D);
		noiseData1 = noiseGen3.generateNoiseOctaves(noiseData1, posX, posY,
				posZ, xSize, ySize, zSize, 8.555150000000001D, 34.2206D,
				8.555150000000001D);
		noiseData2 = noiseGen1.generateNoiseOctaves(noiseData2, posX, posY,
				posZ, xSize, ySize, zSize, 684.412D, 2053.236D, 684.412D);
		noiseData3 = noiseGen2.generateNoiseOctaves(noiseData3, posX, posY,
				posZ, xSize, ySize, zSize, 684.412D, 2053.236D, 684.412D);
		
		double[] newYSize = new double[ySize];
		
		for (int j = 0; j < ySize; ++j) {
			newYSize[j] = Math.cos(j * Math.PI * 6.0D / ySize) * 2.0D;
			double d2 = j;
			
			if (j > ySize / 2) {
				d2 = ySize - 1 - j;
			}
			
			if (d2 < 4.0D) {
				d2 = 4.0D - d2;
				newYSize[j] -= d2 * d2 * d2 * 10.0D;
			}
		}
		
		int index = 0;
		
		for (int l = 0; l < xSize; ++l) {
			for (int i1 = 0; i1 < zSize; ++i1) {
				for (int k = 0; k < ySize; ++k) {
					double d4 = newYSize[k];
					double d5 = noiseData2[index] / 512.0D;
					double d6 = noiseData3[index] / 512.0D;
					double d7 = (noiseData1[index] / 10.0D + 1.0D) / 2.0D;
					double d8;
					
					if (d7 < 0.0D) {
						d8 = d5;
					} else if (d7 > 1.0D) {
						d8 = d6;
					} else {
						d8 = d5 + (d6 - d5) * d7;
					}
					
					d8 = d8 - d4;
					
					if (k > ySize - 4) {
						double d9 = (k - (ySize - 4)) / 3.0F;
						d8 = d8 * (1.0D - d9) + -10.0D * d9;
					}
					
					if (k < 0.0D) {
						double d10 = (0.0D - k) / 4.0D;
						d10 = MathHelper.clamp(d10, 0.0D, 1.0D);
						d8 = d8 * (1.0D - d10) + -10.0D * d10;
					}
					
					heightMap[index] = d8;
					index++;
				}
			}
		}
		
		return heightMap;
	}
	
	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		ChunkPrimer primer = new ChunkPrimer();
		rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
		biomesForGen = world.getBiomeProvider().getBiomes(biomesForGen,
				chunkX * 16, chunkZ * 16, 16, 16);
		prepareHeights(chunkX, chunkZ, primer);
		buildSurfaces(chunkX, chunkZ, primer);
		netherCaves.generate(world, chunkX, chunkZ, primer);
		if (this.generateStructures) {
			this.genNetherBridge.generate(this.world, chunkX, chunkZ, primer);
		}
		
		Chunk chunk = new Chunk(world, primer, chunkX, chunkZ);
		byte[] biomeArray = chunk.getBiomeArray();
		
		for (int i = 0; i < biomeArray.length; ++i) {
			biomeArray[i] = (byte) Biome.getIdForBiome(biomesForGen[i]);
		}
		
		chunk.resetRelightChecks();
		return chunk;
	}
	
	@Override
	public void populate(int x, int z) {
		BlockFalling.fallInstantly = true;
		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this,
				this.world, this.rand, x, z, false);
		int i = x * 16;
		int j = z * 16;
		BlockPos blockpos = new BlockPos(i, 0, j);
		Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
		ChunkPos chunkpos = new ChunkPos(x, z);
		this.genNetherBridge.generateStructure(this.world, this.rand, chunkpos);
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.populate(
						this,
						this.world,
						this.rand,
						x,
						z,
						false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.NETHER_LAVA))
			for (int k = 0; k < 8; ++k) {
				this.hellSpringGen.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16) + 8,
								this.rand.nextInt(120) + 4,
								this.rand.nextInt(16) + 8));
			}
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.populate(
						this,
						this.world,
						this.rand,
						x,
						z,
						false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.FIRE))
			for (int i1 = 0; i1 < this.rand.nextInt(this.rand.nextInt(10) + 1) + 1; ++i1) {
				this.fireFeature.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16) + 8,
								this.rand.nextInt(120) + 4,
								this.rand.nextInt(16) + 8));
			}
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.populate(
						this,
						this.world,
						this.rand,
						x,
						z,
						false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.GLOWSTONE)) {
			for (int j1 = 0; j1 < this.rand.nextInt(this.rand.nextInt(10) + 1); ++j1) {
				this.lightGemGen.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16) + 8,
								this.rand.nextInt(120) + 4,
								this.rand.nextInt(16) + 8));
			}
			
			for (int k1 = 0; k1 < 10; ++k1) {
				this.hellPortalGen.generate(this.world, this.rand, blockpos
						.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128),
								this.rand.nextInt(16) + 8));
			}
		}// Forge: End doGLowstone
		
		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this,
				this.world, this.rand, x, z, false);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS
				.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(
						this.world, this.rand, blockpos));
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.decorate(
						this.world,
						this.rand,
						blockpos,
						net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.rand.nextBoolean()) {
				this.brownMushroomFeature.generate(this.world, this.rand,
						blockpos.add(this.rand.nextInt(16) + 8,
								this.rand.nextInt(128),
								this.rand.nextInt(16) + 8));
			}
			
			if (this.rand.nextBoolean()) {
				this.redMushroomFeature.generate(this.world, this.rand,
						blockpos.add(this.rand.nextInt(16) + 8,
								this.rand.nextInt(128),
								this.rand.nextInt(16) + 8));
			}
		}
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.generateOre(
						this.world,
						this.rand,
						quartzGen,
						blockpos,
						net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ))
			for (int l1 = 0; l1 < 16; ++l1) {
				this.quartzGen.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16),
								this.rand.nextInt(108) + 10,
								this.rand.nextInt(16)));
			}
		
		int i2 = this.world.getSeaLevel() / 2 + 1;
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.populate(
						this,
						this.world,
						this.rand,
						x,
						z,
						false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.NETHER_MAGMA))
			for (int l = 0; l < 4; ++l) {
				this.magmaGen.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16),
								i2 - 5 + this.rand.nextInt(10),
								this.rand.nextInt(16)));
			}
		
		if (net.minecraftforge.event.terraingen.TerrainGen
				.populate(
						this,
						this.world,
						this.rand,
						x,
						z,
						false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.NETHER_LAVA2))
			for (int j2 = 0; j2 < 16; ++j2) {
				this.lavaTrapGen.generate(
						this.world,
						this.rand,
						blockpos.add(this.rand.nextInt(16),
								this.rand.nextInt(108) + 10,
								this.rand.nextInt(16)));
			}
		
		biome.decorate(this.world, this.rand, new BlockPos(i, 0, j));
		
		net.minecraftforge.common.MinecraftForge.EVENT_BUS
				.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(
						this.world, this.rand, blockpos));
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public void recreateStructures(Chunk chunk, int chunkX, int chunkZ) {
		netherBridge.generate(world, chunkX, chunkZ, null);
	}
}