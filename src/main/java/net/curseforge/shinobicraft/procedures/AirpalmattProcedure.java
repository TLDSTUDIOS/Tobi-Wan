package net.curseforge.shinobicraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class AirpalmattProcedure extends ShinobicraftModElements.ModElement {
	public AirpalmattProcedure(ShinobicraftModElements instance) {
		super(instance, 368);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Airpalmatt!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure Airpalmatt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Airpalmatt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Airpalmatt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Airpalmatt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Airpalmatt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((sourceentity.getPersistentData().getString("currentjutsu"))).equals("airpalm"))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 2, 1, 1, 1, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 10, 1, 1, 1, 1);
			}
			entity.setMotion(((sourceentity.world
					.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity))
					.getPos().getX())
					- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
									sourceentity.getLook(1f).z * 0),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getX())),
					((sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getY())
							- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
									sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
											sourceentity.getLook(1f).z * 0),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getY())),
					((sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getZ())
							- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
									sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
											sourceentity.getLook(1f).z * 0),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getZ())));
			sourceentity.getPersistentData().putBoolean("jcharge", (false));
			sourceentity.getPersistentData().putString("currentjutsu", "");
			sourceentity.getPersistentData().putDouble("cminus", 10);
		}
		if ((((sourceentity.getPersistentData().getString("currentjutsu"))).equals("tenro"))) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 5);
			entity.setFire((int) 3);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 2, 1, 1, 1, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 10, 1, 1, 1, 1);
			}
			entity.setMotion(((sourceentity.world
					.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity))
					.getPos().getX())
					- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
									sourceentity.getLook(1f).z * 0),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getX())),
					((sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getY())
							- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
									sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
											sourceentity.getLook(1f).z * 0),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getY())),
					((sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
							sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 2, sourceentity.getLook(1f).y * 2,
									sourceentity.getLook(1f).z * 2),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getZ())
							- (sourceentity.world.rayTraceBlocks(new RayTraceContext(sourceentity.getEyePosition(1f),
									sourceentity.getEyePosition(1f).add(sourceentity.getLook(1f).x * 0, sourceentity.getLook(1f).y * 0,
											sourceentity.getLook(1f).z * 0),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, sourceentity)).getPos().getZ())));
			sourceentity.getPersistentData().putBoolean("jcharge", (false));
			sourceentity.getPersistentData().putString("currentjutsu", "");
			sourceentity.getPersistentData().putDouble("cminus", 15);
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
