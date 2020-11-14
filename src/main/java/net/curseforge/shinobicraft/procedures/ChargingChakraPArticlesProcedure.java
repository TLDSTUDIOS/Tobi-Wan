package net.curseforge.shinobicraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class ChargingChakraPArticlesProcedure extends ShinobicraftModElements.ModElement {
	public ChargingChakraPArticlesProcedure(ShinobicraftModElements instance) {
		super(instance, 62);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChargingChakraPArticles!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ChargingChakraPArticles!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double loop = 0;
		double particleAmount = 0;
		double xRadius = 0;
		double zRadius = 0;
		if (((((entity.getPersistentData().getBoolean("infusing"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).stamina) >= 0.1)) == (true))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).ccstage) >= 3))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.DOLPHIN, (entity.getPosX()), ((entity.getPosY()) + 0.5), (entity.getPosZ()),
						(int) 8, 0.2, 1, 0.2, 6);
			}
			entity.setMotion(0, (entity.getMotion().getY()), 0);
			if ((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) < ((entity
							.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ShinobicraftModVariables.PlayerVariables())).maxchakra))) {
				{
					double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) + 0.1);
					entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ShinobicraftModVariables.PlayerVariables())).stamina) - 0.1);
					entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((entity.isSprinting()) || (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).stamina) < 0.1))) {
			entity.getPersistentData().putBoolean("infusing", (false));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
