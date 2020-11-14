package net.curseforge.shinobicraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class ResetondeathProcedure extends ShinobicraftModElements.ModElement {
	public ResetondeathProcedure(ShinobicraftModElements instance) {
		super(instance, 170);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Resetondeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) ((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ShinobicraftModVariables.PlayerVariables())).maxchakra);
			entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentchakra = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) ((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ShinobicraftModVariables.PlayerVariables())).maxstamina);
			entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.stamina = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

	@SubscribeEvent
	public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
