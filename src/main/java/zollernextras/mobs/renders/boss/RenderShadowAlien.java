package zollernextras.mobs.renders.boss;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import zollernextras.items.ZollernItems;
import zollernextras.mobs.entities.boss.EntityShadowAlien;
import zollernextras.mobs.models.boss.ModelShadowAlien;

public class RenderShadowAlien extends RenderLiving {
	
	public ModelShadowAlien model;
	float f6 = 1.4F;
	
	public RenderShadowAlien(ModelShadowAlien par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelShadowAlien) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"zollernextras:textures/entity/shadowalien.png");
	}
	
	@Override
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.renderEquippedItems((EntityLiving) par1EntityLivingBase, par2);
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
			this.model.head.postRender(0.0625F);
			
			IItemRenderer customRenderer = MinecraftForgeClient
					.getItemRenderer(itemstack1, EQUIPPED);
			boolean is3D = customRenderer != null
					&& customRenderer.shouldUseRenderHelper(EQUIPPED,
							itemstack1, BLOCK_3D);
			
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
			
			this.model.rightarm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			
			IItemRenderer customRenderer = MinecraftForgeClient
					.getItemRenderer(itemstack, EQUIPPED);
			boolean is3D = customRenderer != null
					&& customRenderer.shouldUseRenderHelper(EQUIPPED,
							itemstack, BLOCK_3D);
			
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
			} else if (itemstack.getItem() == ZollernItems.witherSword) {
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
				
				// this.func_82422_c();
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
	
	public void renderShadowAlien(EntityShadowAlien entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(entity, true);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderShadowAlien((EntityShadowAlien) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderShadowAlien((EntityShadowAlien) par1Entity, par2, par4, par6,
				par8, par9);
	}
	
	protected void scaleShadowAlien(EntityShadowAlien par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleShadowAlien((EntityShadowAlien) par1EntityLivingBase, par2);
	}
}