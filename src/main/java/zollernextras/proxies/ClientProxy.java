package zollernextras.proxies;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zollernextras.gui.GuiBiomeType;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.renderers.RenderHellFish;
import zollernextras.mobs.renderers.RenderMegaCreeper;
import zollernextras.mobs.renderers.RenderScorpion;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityHellFish.class,
				RenderHellFish::new);
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMegaCreeper.class, RenderMegaCreeper::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class,
				RenderScorpion::new);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
	@Override
	public void initGUI() {
		MinecraftForge.EVENT_BUS.register(new GuiBiomeType(Minecraft
				.getMinecraft()));
	}
	
	@Override
	public Minecraft getMinecraft() {
		return this.mc;
	}
	
}