package zollernextras.proxies;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zollernextras.blocks.fluid.IZollernModelRegister;
import zollernextras.gui.GuiBiomeType;
import zollernextras.lib.ZDamageSrc;
import zollernextras.lib.ZollernHelper;
import zollernextras.mobs.MobRenders;
import zollernextras.potions.ZollernPotions;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	private static List<IZollernModelRegister> modelRegisters = new ArrayList();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MobRenders.init();
		
		for (IZollernModelRegister model : modelRegisters) {
			model.registerModels();
		}
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		ZollernHelper.addChatMessage(player, message);
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
	
	@Override
	public boolean addIModelRegister(IZollernModelRegister register) {
		return modelRegisters.add(register);
	}
	
	@Override
	public void doPotionEffect(EntityPlayer player, Potion potionId) {
		// Do NOT use an "else if" here! There is a possibility that the Player
		// could have more than one effect, and if we did an "else if" clause,
		// then they would only get one or the other - we want them to get both.
		if (potionId == ZollernPotions.infected) {
			player.attackEntityFrom(ZDamageSrc.deathInfection,
					ZollernPotions.infectionDamage);
		}
		
		if (potionId == ZollernPotions.radiance) {
			// TODO
		}
		
		if (potionId == ZollernPotions.antiCorruption) {
			// TODO
		}
	}
}