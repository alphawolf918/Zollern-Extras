package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShrimp extends ModelBase {
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer Fin1;
	ModelRenderer Fin2;
	ModelRenderer Tail;
	
	public ModelShrimp() {
		textureWidth = 64;
		textureHeight = 32;
		
		Head = new ModelRenderer(this, 19, 0);
		Head.addBox(0F, 0F, 0F, 1, 1, 1);
		Head.setRotationPoint(0F, 19F, 0F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 22, 7);
		Body.addBox(0F, 0F, 0F, 1, 1, 2);
		Body.setRotationPoint(0F, 20F, 1F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Fin1 = new ModelRenderer(this, 0, 0);
		Fin1.addBox(0F, 0F, 0F, 1, 0, 1);
		Fin1.setRotationPoint(1F, 21F, 2F);
		Fin1.setTextureSize(64, 32);
		Fin1.mirror = true;
		setRotation(Fin1, 0.5F, 0F, 0F);
		Fin2 = new ModelRenderer(this, 0, 0);
		Fin2.addBox(0F, 0F, 0F, 1, 0, 1);
		Fin2.setRotationPoint(-1F, 21F, 2F);
		Fin2.setTextureSize(64, 32);
		Fin2.mirror = true;
		setRotation(Fin2, 0.5F, 0F, 0F);
		Tail = new ModelRenderer(this, 17, 4);
		Tail.addBox(0F, 0F, 0F, 1, 1, 1);
		Tail.setRotationPoint(0F, 21F, 2F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Head.render(par7);
		Body.render(par7);
		Fin1.render(par7);
		Fin2.render(par7);
		Tail.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}