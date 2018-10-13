package zollernextras.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WhiteLavaLiquidBlock extends ZollernFluidBlock {
	
	public WhiteLavaLiquidBlock(Fluid fluid) {
		super("whitelava", fluid, Material.LAVA);
		this.setQuantaPerBlock(6);
	}
	
	public void init() {
		this.setRegistryName("fluid_whitelava");
		GameRegistry.register(this);
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(this.getRegistryName());
		GameRegistry.register(itemBlock);
	}
	
}