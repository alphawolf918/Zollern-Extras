package zollernextras.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import zollernextras.blocks.tiles.TEAmaranthBlockIngot;
import zollernextras.blocks.tiles.TEBlockBase;
import zollernextras.blocks.tiles.TECandySphereRed;
import zollernextras.blocks.tiles.TEFueltoniumBlockIngot;
import zollernextras.blocks.tiles.TEGoldBlockIngot;
import zollernextras.blocks.tiles.TEIronBlockIngot;
import zollernextras.blocks.tiles.TELapisBlockIngot;
import zollernextras.blocks.tiles.TEShinestoneBlockIngot;
import zollernextras.blocks.tiles.TEShiniumBlockIngot;
import zollernextras.blocks.tiles.TESphereBase;
import zollernextras.blocks.tiles.TEZincBlockIngot;
import zollernextras.blocks.tiles.TEZollerniumBlockIngot;
import zollernextras.blocks.tiles.renders.TESRAmaranthIngotStack;
import zollernextras.blocks.tiles.renders.TESRFueltoniumIngotStack;
import zollernextras.blocks.tiles.renders.TESRGoldIngotStack;
import zollernextras.blocks.tiles.renders.TESRIronIngotStack;
import zollernextras.blocks.tiles.renders.TESRLapisIngotStack;
import zollernextras.blocks.tiles.renders.TESRShinestoneIngotStack;
import zollernextras.blocks.tiles.renders.TESRShiniumIngotStack;
import zollernextras.blocks.tiles.renders.TESRSphereRed;
import zollernextras.blocks.tiles.renders.TESRZincIngotStack;
import zollernextras.blocks.tiles.renders.TESRZollerniumIngotStack;
import zollernextras.entity.EntityDuckEgg;
import zollernextras.entity.render.RenderDuckEgg;
import zollernextras.gui.GuiBiomeType;
import zollernextras.items.ZollernItems;
import zollernextras.lib.DSource;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.mobs.entities.EntityBabyDragon;
import zollernextras.mobs.entities.EntityDuck;
import zollernextras.mobs.entities.EntityEnderBug;
import zollernextras.mobs.entities.EntityEnderCreeper;
import zollernextras.mobs.entities.EntityEnderSkeleton;
import zollernextras.mobs.entities.EntityFish;
import zollernextras.mobs.entities.EntityHellDuck;
import zollernextras.mobs.entities.EntityHog;
import zollernextras.mobs.entities.EntityHogZombie;
import zollernextras.mobs.entities.EntityJellyfish;
import zollernextras.mobs.entities.EntityKrull;
import zollernextras.mobs.entities.EntityMegaCreeper;
import zollernextras.mobs.entities.EntityMummy;
import zollernextras.mobs.entities.EntityPigshroom;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.entities.EntityShark;
import zollernextras.mobs.entities.EntityShrimp;
import zollernextras.mobs.entities.EntitySpiderling;
import zollernextras.mobs.entities.boss.EntityShadowAlien;
import zollernextras.mobs.models.ModelBabyDragon;
import zollernextras.mobs.models.ModelDuck;
import zollernextras.mobs.models.ModelEnderBug;
import zollernextras.mobs.models.ModelEnderCreeper;
import zollernextras.mobs.models.ModelEnderSkeleton;
import zollernextras.mobs.models.ModelFish;
import zollernextras.mobs.models.ModelHog;
import zollernextras.mobs.models.ModelHogZombie;
import zollernextras.mobs.models.ModelJellyfish;
import zollernextras.mobs.models.ModelKrull;
import zollernextras.mobs.models.ModelMegaCreeper;
import zollernextras.mobs.models.ModelMummy;
import zollernextras.mobs.models.ModelPigshroom;
import zollernextras.mobs.models.ModelScorpion;
import zollernextras.mobs.models.ModelShadowSkeleton;
import zollernextras.mobs.models.ModelShark;
import zollernextras.mobs.models.ModelShrimp;
import zollernextras.mobs.models.ModelSpiderling;
import zollernextras.mobs.models.boss.ModelShadowAlien;
import zollernextras.mobs.renders.RenderBabyDragon;
import zollernextras.mobs.renders.RenderDuck;
import zollernextras.mobs.renders.RenderEnderBug;
import zollernextras.mobs.renders.RenderEnderCreeper;
import zollernextras.mobs.renders.RenderEnderSkeleton;
import zollernextras.mobs.renders.RenderFish;
import zollernextras.mobs.renders.RenderHellDuck;
import zollernextras.mobs.renders.RenderHog;
import zollernextras.mobs.renders.RenderHogZombie;
import zollernextras.mobs.renders.RenderJellyfish;
import zollernextras.mobs.renders.RenderKrull;
import zollernextras.mobs.renders.RenderMegaCreeper;
import zollernextras.mobs.renders.RenderMummy;
import zollernextras.mobs.renders.RenderPigshroom;
import zollernextras.mobs.renders.RenderScorpion;
import zollernextras.mobs.renders.RenderShadowSkeleton;
import zollernextras.mobs.renders.RenderShark;
import zollernextras.mobs.renders.RenderShrimp;
import zollernextras.mobs.renders.RenderSpiderling;
import zollernextras.mobs.renders.boss.RenderShadowAlien;
import zollernextras.potions.ZollernPotion;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFish.class,
				new RenderFish(new ModelFish(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMegaCreeper.class, new RenderMegaCreeper(
						new ModelMegaCreeper(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class,
				new RenderScorpion(new ModelScorpion(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class,
				new RenderJellyfish(new ModelJellyfish(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShrimp.class,
				new RenderShrimp(new ModelShrimp(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityBabyDragon.class, new RenderBabyDragon(
						new ModelBabyDragon(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class,
				new RenderDuck(new ModelDuck(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPigshroom.class,
				new RenderPigshroom(new ModelPigshroom(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShadowSkeleton.class, new RenderShadowSkeleton(
						new ModelShadowSkeleton(), 0.5F));
		
		if (ModHelperBase.useZaneExtras) {
			RenderingRegistry.registerEntityRenderingHandler(
					EntityEnderSkeleton.class, new RenderEnderSkeleton(
							new ModelEnderSkeleton(), 0.5F));
		}
		
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderBug.class,
				new RenderEnderBug(new ModelEnderBug(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityEnderCreeper.class, new RenderEnderCreeper(
						new ModelEnderCreeper(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class,
				new RenderMummy(new ModelMummy(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHog.class,
				new RenderHog(new ModelHog(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHogZombie.class,
				new RenderHogZombie(new ModelHogZombie(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class,
				new RenderShark(new ModelShark(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHellDuck.class,
				new RenderHellDuck(new ModelDuck(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShadowAlien.class, new RenderShadowAlien(
						new ModelShadowAlien(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityKrull.class,
				new RenderKrull(new ModelKrull(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntitySpiderling.class, new RenderSpiderling(
						new ModelSpiderling(), 0.5F));
		
		addTile(TEIronBlockIngot.class, new TESRIronIngotStack());
		addTile(TEGoldBlockIngot.class, new TESRGoldIngotStack());
		addTile(TEFueltoniumBlockIngot.class, new TESRFueltoniumIngotStack());
		addTile(TEAmaranthBlockIngot.class, new TESRAmaranthIngotStack());
		addTile(TEZollerniumBlockIngot.class, new TESRZollerniumIngotStack());
		addTile(TEZincBlockIngot.class, new TESRZincIngotStack());
		addTile(TELapisBlockIngot.class, new TESRLapisIngotStack());
		addTile(TEShinestoneBlockIngot.class, new TESRShinestoneIngotStack());
		addTile(TEShiniumBlockIngot.class, new TESRShiniumIngotStack());
		
		addSphere(TECandySphereRed.class, new TESRSphereRed());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDuckEgg.class,
				new RenderDuckEgg(ZollernItems.duckEgg));
		
		ZollernHelper.Log("Renderers initialized.");
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		if (!player.worldObj.isRemote) {
			ZollernHelper.addChatMessage(player, message);
		}
	}
	
	@Override
	public void doPotionEffect(EntityPlayer player, int potionId) {
		
		// Do NOT use an "else if" here! There is a possibility that the Player
		// could have more than one effect, and if we did an "else if" clause,
		// then they would only get one or the other - we want them to get both.
		if (potionId == ZollernPotion.infected.id) {
			player.attackEntityFrom(DSource.deathInfection,
					ZollernPotion.infectionDamage);
		}
	}
	
	@Override
	public Minecraft getMinecraft() {
		return this.mc;
	}
	
	@Override
	public void initGUI() {
		MinecraftForge.EVENT_BUS.register(new GuiBiomeType(Minecraft
				.getMinecraft()));
	}
	
	public void addTile(Class<? extends TEBlockBase> TEClass,
			TileEntitySpecialRenderer TESR) {
		ClientRegistry.bindTileEntitySpecialRenderer(TEClass, TESR);
	}
	
	public void addSphere(Class<? extends TESphereBase> TEClass,
			TileEntitySpecialRenderer TESR) {
		ClientRegistry.bindTileEntitySpecialRenderer(TEClass, TESR);
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super
				.getPlayerEntity(ctx);
	}
}