package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import zollernextras.lib.ZollernHelper;

public class ZollernGemOre extends ZollernBlockOre {
	
	protected int minDropped = 2;
	protected int maxDropped = 4;
	protected Item itemToDrop;
	
	public ZollernGemOre(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist);
		this.itemToDrop = gemItem;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand,
			int fortune) {
		return this.itemToDrop;
	}
	
	public Block setMinMaxDropped(int minD, int maxD) {
		this.setMinDropped(minD);
		this.setMaxDropped(maxD);
		return this;
	}
	
	public Block setMaxDropped(int md) {
		this.maxDropped = md;
		return this;
	}
	
	public Block setMinDropped(int md) {
		this.minDropped = md;
		return this;
	}
	
	public int getMinDropped() {
		return this.minDropped;
	}
	
	public int getMaxDropped() {
		return this.maxDropped;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int numDropped = 1;
		switch (this.getBlockVariant()) {
		default:
			numDropped = ZollernHelper.rngNumber(1, 1);
			break;
		case OVERWORLD:
			numDropped = ZollernHelper.rngNumber(minDropped, maxDropped);
			break;
		case NETHER:
			numDropped = ZollernHelper.rngNumber(maxDropped, maxDropped + 2);
			break;
		case END:
			numDropped = ZollernHelper
					.rngNumber(maxDropped + 2, maxDropped + 4);
			break;
		case UPSIDE_DOWN:
		case PROMISED_LAND:
			numDropped = ZollernHelper
					.rngNumber(maxDropped + 4, maxDropped + 6);
			break;
		}
		return numDropped;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0
				&& Item.getItemFromBlock(this) != this.getItemDropped(this
						.getBlockState().getValidStates().iterator().next(),
						random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 0;
			}
			
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
	
	@Override
	public int getExpDrop(IBlockState state,
			net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand
				: new Random();
		return MathHelper.getInt(rand, 3, 7);
	}
}