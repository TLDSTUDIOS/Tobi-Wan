package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class ChakraControlKeyOnKeyPressedProcedure extends ShinobicraftModElements.ModElement {
	public ChakraControlKeyOnKeyPressedProcedure(ShinobicraftModElements instance) {
		super(instance, 77);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChakraControlKeyOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPersistentData().getBoolean("chakracontrol")) == (false))
				&& ((entity.getPersistentData().getBoolean("chargingchakra")) == (false)))) {
			entity.getPersistentData().putBoolean("chakracontrol", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra-Control On!"), (true));
			}
		} else {
			entity.getPersistentData().putBoolean("chakracontrol", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra-Control Off!"), (true));
			}
		}
	}
}
