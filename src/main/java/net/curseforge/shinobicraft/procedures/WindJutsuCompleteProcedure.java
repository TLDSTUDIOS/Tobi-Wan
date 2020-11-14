package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class WindJutsuCompleteProcedure extends ShinobicraftModElements.ModElement {
	public WindJutsuCompleteProcedure(ShinobicraftModElements instance) {
		super(instance, 93);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WindJutsuComplete!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("nmn"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 3))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Air-Bullets Jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "airbullets");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("nnvc"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 1))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Vacuum-Push jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "vacuumpush");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("nvc"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 10))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wind-Blade jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "wind blade");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("nbn"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 15))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Air-Palm jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "airpalm");
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putBoolean("jcharge", (true));
		}
	}
}
