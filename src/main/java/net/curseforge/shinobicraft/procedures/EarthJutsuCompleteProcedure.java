package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class EarthJutsuCompleteProcedure extends ShinobicraftModElements.ModElement {
	public EarthJutsuCompleteProcedure(ShinobicraftModElements instance) {
		super(instance, 103);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EarthJutsuComplete!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("vbc"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 10))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Mud-Wall Jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "mud wall");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("vvbc"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 15))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Raising-Spikes Jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "raising spikes");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
	}
}
