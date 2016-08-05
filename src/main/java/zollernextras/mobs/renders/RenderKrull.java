package zollernextras.mobs.renders;

import java.util.Map;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityKrull;
import zollernextras.mobs.models.ModelKrull;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;

public class RenderKrull extends RenderLiving {
	
	public ModelKrull model;
	float f6 = 1.4F;
	public static String[] bipedArmorFilenamePrefix = new String[] { "leather",
			"chainmail", "iron", "diamond", "gold" };
	private static final Map field_110859_k = Maps.newHashMap();
	
	public RenderKrull(ModelKrull par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelKrull) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("zollernextras:textures/entity/krull.png");
	}
	
	public void renderKrull(EntityKrull entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void func_82408_c(EntityLiving p_82408_1_, int p_82408_2_,
			float p_82408_3_) {
		ItemStack itemstack = p_82408_1_.func_130225_q(3 - p_82408_2_);
		
		if (itemstack != null) {
			Item item = itemstack.getItem();
			
			if (item instanceof ItemArmor) {
				this.bindTexture(getArmorResource(p_82408_1_, itemstack,
						p_82408_2_, "overlay"));
				float f1 = 1.0F;
				GL11.glColor3f(1.0F, 1.0F, 1.0F);
			}
		}
	}
	
	protected void renderEquippedItems(EntityLiving p_77029_1_, float p_77029_2_) {
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		super.renderEquippedItems(p_77029_1_, p_77029_2_);
		ItemStack itemstack = p_77029_1_.getHeldItem();
		ItemStack itemstack1 = p_77029_1_.func_130225_q(3);
		Item item;
		float f1;
		
		if (itemstack1 != null) {
			GL11.glPushMatrix();
			this.model.bipedHead.postRender(0.0625F);
			item = itemstack1.getItem();
			
			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient
					.getItemRenderer(
							itemstack1,
							net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = customRenderer != null
					&& customRenderer
							.shouldUseRenderHelper(
									net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED,
									itemstack1,
									net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D);
			
			if (item instanceof ItemBlock) {
				if (is3D
						|| RenderBlocks.renderItemIn3d(Block.getBlockFromItem(
								item).getRenderType())) {
					f1 = 0.625F;
					GL11.glTranslatef(0.0F, -0.25F, 0.0F);
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(f1, -f1, -f1);
				}
				
				this.renderManager.itemRenderer.renderItem(p_77029_1_,
						itemstack1, 0);
			} else if (item == Items.skull) {
				f1 = 1.0625F;
				GL11.glScalef(f1, -f1, -f1);
				GameProfile gameprofile = null;
				
				if (itemstack1.hasTagCompound()) {
					NBTTagCompound nbttagcompound = itemstack1.getTagCompound();
					
					if (nbttagcompound.hasKey("SkullOwner", 10)) {
						gameprofile = NBTUtil.func_152459_a(nbttagcompound
								.getCompoundTag("SkullOwner"));
					} else if (nbttagcompound.hasKey("SkullOwner", 8)
							&& !StringUtils.isNullOrEmpty(nbttagcompound
									.getString("SkullOwner"))) {
						gameprofile = new GameProfile((UUID) null,
								nbttagcompound.getString("SkullOwner"));
					}
				}
				
				TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F,
						0.0F, -0.5F, 1, 180.0F, itemstack1.getItemDamage(),
						gameprofile);
			}
			
			GL11.glPopMatrix();
		}
		
		if (itemstack != null && itemstack.getItem() != null) {
			item = itemstack.getItem();
			GL11.glPushMatrix();
			
			if (this.mainModel.isChild) {
				f1 = 0.5F;
				GL11.glTranslatef(0.0F, 0.625F, 0.0F);
				GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
				GL11.glScalef(f1, f1, f1);
			}
			
			this.model.bipedRightArm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			
			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient
					.getItemRenderer(
							itemstack,
							net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = customRenderer != null
					&& customRenderer
							.shouldUseRenderHelper(
									net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED,
									itemstack,
									net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D);
			
			if (item instanceof ItemBlock
					&& (is3D || RenderBlocks.renderItemIn3d(Block
							.getBlockFromItem(item).getRenderType()))) {
				f1 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				f1 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-f1, -f1, f1);
			} else if (item == Items.bow) {
				f1 = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if (item.isFull3D()) {
				f1 = 0.625F;
				
				if (item.shouldRotateAroundWhenRendering()) {
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}
				
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				f1 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f1, f1, f1);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}
			
			float f2;
			int i;
			float f5;
			
			if (itemstack.getItem().requiresMultipleRenderPasses()) {
				for (i = 0; i < itemstack.getItem().getRenderPasses(
						itemstack.getItemDamage()); ++i) {
					int j = itemstack.getItem().getColorFromItemStack(
							itemstack, i);
					f5 = (j >> 16 & 255) / 255.0F;
					f2 = (j >> 8 & 255) / 255.0F;
					float f3 = (j & 255) / 255.0F;
					GL11.glColor4f(f5, f2, f3, 1.0F);
					this.renderManager.itemRenderer.renderItem(p_77029_1_,
							itemstack, i);
				}
			} else {
				i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
				float f4 = (i >> 16 & 255) / 255.0F;
				f5 = (i >> 8 & 255) / 255.0F;
				f2 = (i & 255) / 255.0F;
				GL11.glColor4f(f4, f5, f2, 1.0F);
				this.renderManager.itemRenderer.renderItem(p_77029_1_,
						itemstack, 0);
			}
			
			GL11.glPopMatrix();
		}
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderKrull((EntityKrull) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderKrull((EntityKrull) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleKrull(EntityKrull par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleKrull((EntityKrull) par1EntityLivingBase, par2);
	}
	
	public static ResourceLocation getArmorResource(Entity entity,
			ItemStack stack, int slot, String type) {
		ItemArmor item = (ItemArmor) stack.getItem();
		String s1 = String.format("textures/models/armor/%s_layer_%d%s.png",
				bipedArmorFilenamePrefix[item.renderIndex], slot == 2 ? 2 : 1,
						type == null ? "" : String.format("_%s", type));
		
		s1 = net.minecraftforge.client.ForgeHooksClient.getArmorTexture(entity,
				stack, s1, slot, type);
		ResourceLocation resourcelocation = (ResourceLocation) field_110859_k
				.get(s1);
		
		if (resourcelocation == null) {
			resourcelocation = new ResourceLocation(s1);
			field_110859_k.put(s1, resourcelocation);
		}
		
		return resourcelocation;
	}
}