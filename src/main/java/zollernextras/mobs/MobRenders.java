package zollernextras.mobs;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import zollernextras.mobs.entities.EntityDuck;
import zollernextras.mobs.entities.EntityHellDuck;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.renderers.RenderDuck;
import zollernextras.mobs.renderers.RenderHellDuck;
import zollernextras.mobs.renderers.RenderHellFish;
import zollernextras.mobs.renderers.RenderMegaCreeper;
import zollernextras.mobs.renderers.RenderScorpion;

public class MobRenders {
	
	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityHellFish.class,
				RenderHellFish::new);
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMegaCreeper.class, RenderMegaCreeper::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class,
				RenderScorpion::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class,
				RenderDuck::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityHellDuck.class,
				RenderHellDuck::new);
	}
	
}