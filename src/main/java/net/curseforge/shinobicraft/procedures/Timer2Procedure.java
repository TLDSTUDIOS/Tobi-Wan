package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.item.VacuumpushItem;
import net.curseforge.shinobicraft.item.RagingwavesItem;
import net.curseforge.shinobicraft.item.FireballlargeentityItem;
import net.curseforge.shinobicraft.item.DragonflameItem;
import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Random;
import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class Timer2Procedure extends ShinobicraftModElements.ModElement {
	public Timer2Procedure(ShinobicraftModElements instance) {
		super(instance, 358);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Timer2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Timer2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& ((((entity.getPersistentData().getString("currentjutsu"))).equals("airpalm"))
						|| (((entity.getPersistentData().getString("currentjutsu"))).equals("tenro"))))
				&& ((entity.getPersistentData().getDouble("jc")) < 200))) {
			entity.getPersistentData().putDouble("jc", ((entity.getPersistentData().getDouble("jc")) + 1));
		} else if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& ((((entity.getPersistentData().getString("currentjutsu"))).equals("airpalm"))
						|| (((entity.getPersistentData().getString("currentjutsu"))).equals("tenro"))))
				&& ((entity.getPersistentData().getDouble("jc")) >= 200))) {
			entity.getPersistentData().putDouble("jc", 0);
			entity.getPersistentData().putBoolean("jcharge", (false));
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if ((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("airpalm")))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD,
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
						(int) 8, 0.01, 0.01, 0.01, 0.01);
			}
		}
		if ((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("tenro")))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME,
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
						(int) 8, 0.01, 0.01, 0.01, 0.01);
			}
		}
		if (((entity.getPersistentData().getBoolean("jcharge")) == (false))) {
			entity.getPersistentData().putDouble("jc", 0);
		}
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("fireball")))
				&& ((entity.getPersistentData().getDouble("jc")) < 200))) {
			entity.getPersistentData().putDouble("jc", ((entity.getPersistentData().getDouble("jc")) + 1));
			entity.setMotion(0, (entity.getMotion().getY()), 0);
		}
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("fireball")))
				&& ((entity.getPersistentData().getDouble("jc")) >= 195))) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				FireballlargeentityItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 9, (int) 3);
			}
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 30);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putBoolean("jcharge", (false));
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("vacuumpush")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 1))) {
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 0.15);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				VacuumpushItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 0.5, (int) 3.5);
			}
		} else if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("vacuumpush")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) < 1))) {
			entity.getPersistentData().putString("currentjutsu", "");
			entity.getPersistentData().putBoolean("jcharge", (false));
		}
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("dragonflame")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 1))) {
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 0.3);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				DragonflameItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 1, (int) 0.5);
			}
		} else if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("dragonflame")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) < 1))) {
			entity.getPersistentData().putString("currentjutsu", "");
			entity.getPersistentData().putBoolean("jcharge", (false));
		}
		if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("ragingwaves")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 1))) {
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 0.2);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				RagingwavesItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 1.2, (int) 1);
			}
		} else if (((((entity.getPersistentData().getBoolean("jcharge")) == (true))
				&& (((entity.getPersistentData().getString("currentjutsu"))).equals("ragingwaves")))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) < 1))) {
			entity.getPersistentData().putString("currentjutsu", "");
			entity.getPersistentData().putBoolean("jcharge", (false));
		}
	}
}
