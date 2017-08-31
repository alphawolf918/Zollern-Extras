package zollernextras.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ChargiumLiquidBlock extends ZollernFluidBlock {
	
	public ChargiumLiquidBlock(Fluid fluid) {
		super("chargium", fluid, Material.LAVA);
		this.setQuantaPerBlock(6);
	}
	
	public void init() {
		this.setRegistryName("fluid_chargium");
		GameRegistry.register(this);
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(this.getRegistryName());
		GameRegistry.register(itemBlock);
	}
	
}