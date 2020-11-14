
package net.curseforge.shinobicraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.network.IPacket;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.curseforge.shinobicraft.procedures.BoulderBlastBulletHitsBlockProcedure;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@ShinobicraftModElements.ModElement.Tag
public class BoulderBlastItem extends ShinobicraftModElements.ModElement {
	@ObjectHolder("shinobicraft:boulder_blast")
	public static final Item block = null;
	@ObjectHolder("shinobicraft:entitybulletboulder_blast")
	public static final EntityType arrow = null;
	public BoulderBlastItem(ShinobicraftModElements instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletboulder_blast").setRegistryName("entitybulletboulder_blast"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void init(FMLCommonSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(arrow, renderManager -> new CustomRender(renderManager));
	}
	public static class ItemRanged extends Item {
		public ItemRanged() {
			super(new Item.Properties().group(null).maxDamage(100));
			setRegistryName("boulder_blast");
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.BOW;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
			if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
				ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (true) {
					ArrowCustomEntity entityarrow = shoot(world, entity, random, 4f, 2, 0);
					itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
					entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
				}
			}
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return null;
		}

		@Override
		protected ItemStack getArrowStack() {
			return null;
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity entity) {
			super.onCollideWithPlayer(entity);
			Entity sourceentity = this.getShooter();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BoulderBlastBulletHitsBlockProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			Entity sourceentity = this.getShooter();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BoulderBlastBulletHitsBlockProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void tick() {
			super.tick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity entity = this.getShooter();
			if (this.inGround) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					BoulderBlastBulletHitsBlockProcedure.executeProcedure($_dependencies);
				}
				this.remove();
			}
		}
	}

	public static class CustomRender extends EntityRenderer<ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("shinobicraft:textures/bigdirt-1.png.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
				int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new ModelBoulderToss();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelBoulderToss extends EntityModel<Entity> {
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
			addBoxHelper(bone, 0, 0, -8.0F, -16.0F, -8.0F, 16, 16, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, -8.0F, -16.0F, 8.0F, 16, 16, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, -8.0F, -16.0F, -8.0F, 0, 16, 16, 0.0F, false);
			addBoxHelper(bone, 0, 0, 7.75F, -16.0F, -8.0F, 0, 16, 16, 0.0F, false);
			addBoxHelper(bone, 0, 0, 0.5F, 0.0F, -8.0F, 7, 0, 16, 0.0F, false);
			addBoxHelper(bone, 0, 0, 0.5F, -16.0F, -8.0F, 7, 0, 16, 0.0F, false);
			addBoxHelper(bone, 0, 0, -8.0F, 0.0F, -8.0F, 8, 0, 16, 0.0F, false);
			addBoxHelper(bone, 0, 0, -8.0F, -16.0F, -8.0F, 8, 0, 16, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(1.0F, 24.25F, 0.0F);
			addBoxHelper(bone2, 0, 0, -11.868F, -15.0F, -7.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -11.868F, -15.0F, 7.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -11.484F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone2, 0, 0, 3.132F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -3.868F, 0.0F, -7.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -3.868F, -14.848F, -7.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -11.828F, 0.0F, -7.424F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone2, 0, 0, -11.828F, -14.848F, -7.424F, 8, 0, 15, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 24.25F, -4.0F);
			addBoxHelper(bone3, 0, 0, -8.118F, -15.0F, -7.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -8.118F, -15.0F, 7.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -7.734F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone3, 0, 0, 6.882F, -15.0F, -7.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -0.118F, 0.0F, -7.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -0.118F, -14.848F, -7.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -8.078F, 0.0F, -7.424F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone3, 0, 0, -8.078F, -14.848F, -7.424F, 8, 0, 15, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.25F, 23.25F, -4.0F);
			addBoxHelper(bone4, 0, 0, -8.118F, -12.0F, -3.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -8.118F, -12.0F, 11.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -7.734F, -12.0F, -3.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone4, 0, 0, 6.882F, -12.0F, -3.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -0.118F, 3.0F, -3.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -0.118F, -11.848F, -3.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -8.078F, 3.0F, -3.424F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone4, 0, 0, -8.078F, -11.848F, -3.424F, 8, 0, 15, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.25F, 23.25F, -4.0F);
			addBoxHelper(bone5, 0, 0, -5.118F, -14.0F, -3.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone5, 0, 0, -5.118F, -14.0F, 11.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone5, 0, 0, -4.734F, -14.0F, -3.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone5, 0, 0, 9.882F, -14.0F, -3.424F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone5, 0, 0, 2.882F, 1.0F, -3.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone5, 0, 0, 2.882F, -13.848F, -3.424F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone5, 0, 0, -5.078F, 1.0F, -3.424F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone5, 0, 0, -5.078F, -13.848F, -3.424F, 8, 0, 15, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.5F, 24.25F, -5.0F);
			addBoxHelper(bone6, 0, 0, -8.118F, -15.0F, 0.576F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -8.118F, -15.0F, 15.424F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -7.734F, -15.0F, 0.576F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone6, 0, 0, 6.882F, -15.0F, 0.576F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -0.118F, 0.0F, 0.576F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -0.118F, -14.848F, 0.576F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -8.078F, 0.0F, 0.576F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone6, 0, 0, -8.078F, -14.848F, 0.576F, 8, 0, 15, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.5F, 24.25F, -5.0F);
			addBoxHelper(bone7, 0, 0, -8.118F, -18.0F, -2.674F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -8.118F, -18.0F, 12.174F, 15, 15, 0, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -7.734F, -18.0F, -2.674F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone7, 0, 0, 6.882F, -18.0F, -2.674F, 0, 15, 15, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -0.118F, -3.0F, -2.674F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -0.118F, -17.848F, -2.674F, 7, 0, 15, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -8.078F, -3.0F, -2.674F, 8, 0, 15, 0.0F, false);
			addBoxHelper(bone7, 0, 0, -8.078F, -17.848F, -2.674F, 8, 0, 15, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.5F, 24.25F, -4.25F);
			addBoxHelper(bone8, 0, 0, -6.9438F, -9.48F, -2.3531F, 13, 13, 0, 0.0F, false);
			addBoxHelper(bone8, 0, 0, -6.9438F, -9.48F, 10.7131F, 13, 13, 0, 0.0F, false);
			addBoxHelper(bone8, 0, 0, -6.8059F, -9.48F, -2.3531F, 0, 13, 13, 0.0F, false);
			addBoxHelper(bone8, 0, 0, 6.0562F, -9.48F, -2.3531F, 0, 13, 13, 0.0F, false);
			addBoxHelper(bone8, 0, 0, 0.0562F, 3.52F, -2.3531F, 6, 0, 13, 0.0F, false);
			addBoxHelper(bone8, 0, 0, 0.0562F, -9.5462F, -2.3531F, 6, 0, 13, 0.0F, false);
			addBoxHelper(bone8, 0, 0, -7.0686F, 3.52F, -2.3531F, 7, 0, 13, 0.0F, false);
			addBoxHelper(bone8, 0, 0, -7.0686F, -9.5462F, -2.3531F, 7, 0, 13, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			bone.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone2.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone3.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone4.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone5.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone6.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone7.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone8.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}

	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
				SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 4f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setDamage(2);
		entityarrow.setKnockbackStrength(0);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
				SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
