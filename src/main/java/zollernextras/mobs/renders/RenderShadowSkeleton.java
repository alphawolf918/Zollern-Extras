package zollernextras.mobs.renders;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.models.ModelShadowSkeleton;
import com.google.common.collect.Maps;

public class RenderShadowSkeleton extends RenderLiving {
	public ModelShadowSkeleton model;
	private final ModelBiped modelArmorChestplate;
	private final ModelBiped modelArmor;
	/** List of armor texture filenames. */
	public static String[] bipedArmorFilenamePrefix = new String[] { "leather",
			"chainmail", "iron", "diamond", "gold" };
	protected float field_77070_b;
	protected ModelBiped field_82423_g;
	protected ModelBiped field_82425_h;
	private static final Map field_110859_k = Maps.newHashMap();
	float f6 = 1.4F;
	
	public RenderShadowSkeleton(ModelShadowSkeleton par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelShadowSkeleton) mainModel;
		this.modelArmorChestplate = new ModelBiped(1.0F);
		this.modelArmor = new ModelBiped(0.5F);
	}
	
	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}
	
	@Override
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.renderEquippedItems((EntityLiving) par1EntityLivingBase, par2);
	}
	
	protected void func_82439_b(EntityLivingBase par1EntityLivingBase,
			int par2, float par3) {
		this.func_130013_c((EntityLiving) par1EntityLivingBase, par2, par3);
	}
	
	protected void func_130013_c(EntityLiving par1EntityLiving, int par2,
			float par3) {
		ItemStack itemstack = par1EntityLiving.func_130225_q(3 - par2);
		
		if (itemstack != null) {
			Item item = itemstack.getItem();
			
			if (item instanceof ItemArmor) {
				this.bindTexture(getArmorResource(par1EntityLiving, itemstack,
						par2, "overlay"));
				float f1 = 1.0F;
				GL11.glColor3f(f1, f1, f1);
			}
		}
	}
	
	protected int func_130006_a(EntityLiving par1EntityLiving, int par2,
			float par3) {
		ItemStack itemstack = par1EntityLiving.func_130225_q(3 - par2);
		
		if (itemstack != null) {
			Item item = itemstack.getItem();
			
			if (item instanceof ItemArmor) {
				ItemArmor itemarmor = (ItemArmor) item;
				this.bindTexture(getArmorResource(par1EntityLiving, itemstack,
						par2, null));
				ModelBiped modelbiped = par2 == 2 ? this.field_82425_h
						: this.field_82423_g;
				modelbiped.bipedHead.showModel = par2 == 0;
				modelbiped.bipedHeadwear.showModel = par2 == 0;
				modelbiped.bipedBody.showModel = par2 == 1 || par2 == 2;
				modelbiped.bipedRightArm.showModel = par2 == 1;
				modelbiped.bipedLeftArm.showModel = par2 == 1;
				modelbiped.bipedRightLeg.showModel = par2 == 2 || par2 == 3;
				modelbiped.bipedLeftLeg.showModel = par2 == 2 || par2 == 3;
				modelbiped = ForgeHooksClient.getArmorModel(par1EntityLiving,
						itemstack, par2, modelbiped);
				this.setRenderPassModel(modelbiped);
				modelbiped.onGround = this.mainModel.onGround;
				modelbiped.isRiding = this.mainModel.isRiding;
				modelbiped.isChild = this.mainModel.isChild;
				float f1 = 1.0F;
				
				// Move out of if to allow for more then just CLOTH to have
				// color
				int j = itemarmor.getColor(itemstack);
				if (j != -1) {
					float f2 = (j >> 16 & 255) / 255.0F;
					float f3 = (j >> 8 & 255) / 255.0F;
					float f4 = (j & 255) / 255.0F;
					GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);
					
					if (itemstack.isItemEnchanted()) {
						return 31;
					}
					
					return 16;
				}
				
				GL11.glColor3f(f1, f1, f1);
				
				if (itemstack.isItemEnchanted()) {
					return 15;
				}
				
				return 1;
			}
		}
		
		return -1;
	}
	
	protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2) {
		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack itemstack = par1EntityLiving.getHeldItem();
		ItemStack itemstack1 = par1EntityLiving.func_130225_q(3);
		float f2;
		
		if (itemstack1 != null) {
			GL11.glPushMatrix();
			this.model.bipedHead.postRender(0.0625F);
			
			IItemRenderer customRenderer = MinecraftForgeClient
					.getItemRenderer(itemstack1, EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer
					.shouldUseRenderHelper(EQUIPPED, itemstack1, BLOCK_3D));
			
			if (itemstack1.getItem() instanceof ItemBlock) {
				if (is3D
						|| RenderBlocks.renderItemIn3d(Block.getBlockFromItem(
								itemstack1.getItem()).getRenderType())) {
					f2 = 0.625F;
					GL11.glTranslatef(0.0F, -0.25F, 0.0F);
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(f2, -f2, -f2);
				}
				
				this.renderManager.itemRenderer.renderItem(par1EntityLiving,
						itemstack1, 0);
			}
			GL11.glPopMatrix();
		}
		
		if (itemstack != null) {
			GL11.glPushMatrix();
			
			if (this.mainModel.isChild) {
				f2 = 0.5F;
				GL11.glTranslatef(0.0F, 0.625F, 0.0F);
				GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
				GL11.glScalef(f2, f2, f2);
			}
			
			this.model.bipedRightArm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			
			IItemRenderer customRenderer = MinecraftForgeClient
					.getItemRenderer(itemstack, EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer
					.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));
			
			if (itemstack.getItem() instanceof ItemBlock
					&& (is3D || RenderBlocks.renderItemIn3d(Block
							.getBlockFromItem(itemstack.getItem())
							.getRenderType()))) {
				f2 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				f2 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-f2, -f2, f2);
			} else if (itemstack.getItem() == Items.bow) {
				f2 = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(f2, -f2, f2);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if (itemstack.getItem().isFull3D()) {
				f2 = 0.625F;
				
				if (itemstack.getItem().shouldRotateAroundWhenRendering()) {
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}
				
				this.func_82422_c();
				GL11.glScalef(f2, -f2, f2);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				f2 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f2, f2, f2);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}
			
			this.renderManager.itemRenderer.renderItem(par1EntityLiving,
					itemstack, 0);
			
			if (itemstack.getItem().requiresMultipleRenderPasses()) {
				for (int x = 1; x < itemstack.getItem().getRenderPasses(
						itemstack.getItemDamage()); x++) {
					this.renderManager.itemRenderer.renderItem(
							par1EntityLiving, itemstack, x);
				}
			}
			
			GL11.glPopMatrix();
		}
	}
	
	/**
	 * More generic ForgeHook version of the above function, it allows for Items
	 * to have more control over what texture they provide.
	 *
	 * @param entity
	 *            Entity wearing the armor
	 * @param stack
	 *            ItemStack for the armor
	 * @param slot
	 *            Slot ID that the item is in
	 * @param type
	 *            Subtype, can be null or "overlay"
	 * @return ResourceLocation pointing at the armor's texture
	 */
	public static ResourceLocation getArmorResource(Entity entity,
			ItemStack stack, int slot, String type) {
		ItemArmor item = (ItemArmor) stack.getItem();
		String s1 = String.format("textures/models/armor/%s_layer_%d%s.png",
				bipedArmorFilenamePrefix[item.renderIndex],
				(slot == 2 ? 2 : 1),
				type == null ? "" : String.format("_%s", type));
		
		s1 = ForgeHooksClient.getArmorTexture(entity, stack, s1, slot, type);
		ResourceLocation resourcelocation = (ResourceLocation) field_110859_k
				.get(s1);
		
		if (resourcelocation == null) {
			resourcelocation = new ResourceLocation(s1);
			field_110859_k.put(s1, resourcelocation);
		}
		
		return resourcelocation;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"zollernextras:textures/entity/shadowskeleton.png");
	}
	
	public void renderTutorial(EntityShadowSkeleton entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityShadowSkeleton) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityShadowSkeleton) par1Entity, par2, par4, par6,
				par8, par9);
	}
	
	protected void scaleShadowSkeleton(
			EntityShadowSkeleton par1EntityShadowSkeleton, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleShadowSkeleton((EntityShadowSkeleton) par1EntityLivingBase,
				par2);
	}
}