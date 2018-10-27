package zollernextras.mobs;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import zollernextras.mobs.entities.EntityDuck;
import zollernextras.mobs.entities.EntityHellDuck;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityMummy;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.entities.EntityShade;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.renderers.RenderDuck;
import zollernextras.mobs.renderers.RenderHellDuck;
import zollernextras.mobs.renderers.RenderHellFish;
import zollernextras.mobs.renderers.RenderMegaCreeper;
import zollernextras.mobs.renderers.RenderMummy;
import zollernextras.mobs.renderers.RenderScorpion;
import zollernextras.mobs.renderers.RenderShade;
import zollernextras.mobs.renderers.RenderShadowSkeleton;

public class MobRenders {
	
	public static void init() {
		RenderMob(EntityHellFish.class, RenderHellFish::new);
		RenderMob(EntityMegaCreeper.class, RenderMegaCreeper::new);
		RenderMob(EntityScorpion.class, RenderScorpion::new);
		RenderMob(EntityDuck.class, RenderDuck::new);
		RenderMob(EntityHellDuck.class, RenderHellDuck::new);
		RenderMob(EntityShadowSkeleton.class, RenderShadowSkeleton::new);
		RenderMob(EntityMummy.class, RenderMummy::new);
		RenderMob(EntityShade.class, RenderShade::new);
	}
	
	public static <T extends Entity> void RenderMob(Class<T> entityClass,
			IRenderFactory<? super T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
	
}