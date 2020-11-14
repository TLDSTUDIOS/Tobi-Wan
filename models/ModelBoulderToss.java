// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelBoulderToss extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;

	public ModelBoulderToss() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -16.0F, -8.0F, 16, 16, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -16.0F, 8.0F, 16, 16, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -16.0F, -8.0F, 0, 16, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.75F, -16.0F, -8.0F, 0, 16, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.5F, 0.0F, -8.0F, 7, 0, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.5F, -16.0F, -8.0F, 7, 0, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, 0.0F, -8.0F, 8, 0, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -16.0F, -8.0F, 8, 0, 16, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.0F, 24.25F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -11.868F, -15.0F, -7.424F, 15, 15, 0, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -11.868F, -15.0F, 7.424F, 15, 15, 0, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -11.484F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 3.132F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -3.868F, 0.0F, -7.424F, 7, 0, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -3.868F, -14.848F, -7.424F, 7, 0, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -11.828F, 0.0F, -7.424F, 8, 0, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -11.828F, -14.848F, -7.424F, 8, 0, 15, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.25F, -4.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -8.118F, -15.0F, -7.424F, 15, 15, 0, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -8.118F, -15.0F, 7.424F, 15, 15, 0, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -7.734F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.882F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -0.118F, 0.0F, -7.424F, 7, 0, 15, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -0.118F, -14.848F, -7.424F, 7, 0, 15, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -8.078F, 0.0F, -7.424F, 8, 0, 15, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -8.078F, -14.848F, -7.424F, 8, 0, 15, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.25F, 23.25F, -4.0F);
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -8.118F, -12.0F, -3.424F, 15, 15, 0, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -8.118F, -12.0F, 11.424F, 15, 15, 0, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -7.734F, -12.0F, -3.424F, 0, 15, 15, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, 6.882F, -12.0F, -3.424F, 0, 15, 15, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -0.118F, 3.0F, -3.424F, 7, 0, 15, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -0.118F, -11.848F, -3.424F, 7, 0, 15, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -8.078F, 3.0F, -3.424F, 8, 0, 15, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -8.078F, -11.848F, -3.424F, 8, 0, 15, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.25F, 23.25F, -4.0F);
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -5.118F, -14.0F, -3.424F, 15, 15, 0, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -5.118F, -14.0F, 11.424F, 15, 15, 0, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -4.734F, -14.0F, -3.424F, 0, 15, 15, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, 9.882F, -14.0F, -3.424F, 0, 15, 15, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, 2.882F, 1.0F, -3.424F, 7, 0, 15, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, 2.882F, -13.848F, -3.424F, 7, 0, 15, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -5.078F, 1.0F, -3.424F, 8, 0, 15, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -5.078F, -13.848F, -3.424F, 8, 0, 15, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.5F, 24.25F, -5.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -8.118F, -15.0F, 0.576F, 15, 15, 0, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -8.118F, -15.0F, 15.424F, 15, 15, 0, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -7.734F, -15.0F, 0.576F, 0, 15, 15, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, 6.882F, -15.0F, 0.576F, 0, 15, 15, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -0.118F, 0.0F, 0.576F, 7, 0, 15, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -0.118F, -14.848F, 0.576F, 7, 0, 15, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -8.078F, 0.0F, 0.576F, 8, 0, 15, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -8.078F, -14.848F, 0.576F, 8, 0, 15, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.5F, 24.25F, -5.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -8.118F, -18.0F, -2.674F, 15, 15, 0, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -8.118F, -18.0F, 12.174F, 15, 15, 0, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -7.734F, -18.0F, -2.674F, 0, 15, 15, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, 6.882F, -18.0F, -2.674F, 0, 15, 15, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -0.118F, -3.0F, -2.674F, 7, 0, 15, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -0.118F, -17.848F, -2.674F, 7, 0, 15, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -8.078F, -3.0F, -2.674F, 8, 0, 15, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -8.078F, -17.848F, -2.674F, 8, 0, 15, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.5F, 24.25F, -4.25F);
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, -6.9438F, -9.48F, -2.3531F, 13, 13, 0, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, -6.9438F, -9.48F, 10.7131F, 13, 13, 0, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, -6.8059F, -9.48F, -2.3531F, 0, 13, 13, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, 6.0562F, -9.48F, -2.3531F, 0, 13, 13, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, 0.0562F, 3.52F, -2.3531F, 6, 0, 13, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, 0.0562F, -9.5462F, -2.3531F, 6, 0, 13, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, -7.0686F, 3.52F, -2.3531F, 7, 0, 13, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 0, -7.0686F, -9.5462F, -2.3531F, 7, 0, 13, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
		bone5.render(f5);
		bone6.render(f5);
		bone7.render(f5);
		bone8.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}