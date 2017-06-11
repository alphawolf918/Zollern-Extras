package zollernextras.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import zollernextras.ZollernExtrasMod;
import zollernextras.config.ZEConfig;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZollernPotion extends Potion {
	
	/**
	 * Protects the Player from Shadow damage. Also applied to an entity when
	 * whacked with a weapon enchanted with the custom Enlightened enchantment,
	 * which will damage shadow (Upside-Down) mobs.
	 */
	public static Potion radiance;
	
	/**
	 * Causes viral harm to the Player, and spreads to any other Players around
	 * them.
	 */
	public static Potion infected;
	
	// Radiance variables.
	public static final int radianceTime = 6000;
	public static final float shadowDamage = 5.0f;
	
	// Infection variables.
	public static final int infectionTime = 200;
	public static final float infectionDamage = 2.0F;
	
	public static int totalEntries = 0;
	
	// The color of our Potion's liquid. Included here for convenience.
	protected int potionColor = 0xffffff;
	
	/**
	 * Instantiate a new Potion type for this mod.
	 * 
	 * @param potionName
	 *            The name of the Potion.
	 * @param potionId
	 *            The ID of the Potion.
	 * @param potionIsBadEffect
	 *            Whether or not the Potion is a bad (harmful) effect.
	 * @param potionEffectiveness
	 *            The effectiveness of the Potion.
	 * @param potionLiquidColor
	 *            The color of the Potion's liquid.
	 */
	public ZollernPotion(String potionName, int potionId,
			boolean potionIsBadEffect, int potionEffectiveness,
			int potionLiquidColor) {
		super(potionId, potionIsBadEffect, potionEffectiveness);
		
		// Add our mod's ID on to the actual Potion name, to prevent any future
		// compatibility issues.
		this.setPotionName(ZollernModInfo.MODID + "_" + potionName);
		
		// Apply the specified liquid color.
		this.setLiquidColor(potionLiquidColor);
		
		// This part is probably pointless, considering we tell it not to use an
		// icon at all. But let's play it safe.
		this.setIconIndex(0, 0);
		this.totalEntries++;
	}
	
	// Make sure you call this init BEFORE your items or it will crash when you
	// use a custom potion!
	public static void init() {
		ZollernHelper.Log("Initializing new Potion effects..");
		
		// Now let's actually initialize them.
		radiance = new ZollernPotion("radiance", ZEConfig.potionRadianceID,
				false, 13458603, 0xeeee00);
		infected = new ZollernPotion("infected", ZEConfig.potionInfectedID,
				true, 13615421, 0x000000);
		
		ZollernHelper.Log("Successfully loaded " + totalEntries
				+ " new Potion effects.");
	}
	
	/**
	 * This is where we actually program the 'effect' for the Potion. Note: We
	 * must call this manually! I do it through the LivingUpdate event in the
	 * Minecraft Forge event bus. Note that I call this through the proxy, just
	 * to be on the safe side.
	 */
	@Override
	public void performEffect(EntityLivingBase par1LivingBase, int par2Amplifier) {
		if (par1LivingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par1LivingBase;
			
			// Sending it through the proxy eliminates any client-on-server
			// issues we may have.
			ZollernExtrasMod.proxy.doPotionEffect(player, this.getId());
		}
	}
	
	@Override
	public int getLiquidColor() {
		return this.potionColor;
	}
	
	/**
	 * Sets the liquid color for the Potion.
	 * 
	 * @param par1PotionColor
	 */
	public Potion setLiquidColor(int par1PotionColor) {
		this.potionColor = par1PotionColor;
		return this;
	}
	
	// This just gets rid of those status icons that our Potion could have.
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() {
		return false;
	}
}