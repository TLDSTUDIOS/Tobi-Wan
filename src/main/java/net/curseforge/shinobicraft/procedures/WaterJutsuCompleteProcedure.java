package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class WaterJutsuCompleteProcedure extends ShinobicraftModElements.ModElement {
	public WaterJutsuCompleteProcedure(ShinobicraftModElements instance) {
		super(instance, 97);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WaterJutsuComplete!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double xcord = 0;
		boolean fas = false;
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("bvc"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 5))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water-Bullets Jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "waterbullets");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
		if ((((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).jutsukeys)).equals("bbvb"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 1))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Raging-Waves Jutsu"), (true));
			}
			entity.getPersistentData().putString("currentjutsu", "ragingwaves");
			entity.getPersistentData().putDouble("ptimer", 0);
		}
	}
}
