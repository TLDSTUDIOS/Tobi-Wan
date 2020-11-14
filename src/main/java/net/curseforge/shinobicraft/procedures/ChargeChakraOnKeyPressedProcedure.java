package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class ChargeChakraOnKeyPressedProcedure extends ShinobicraftModElements.ModElement {
	public ChargeChakraOnKeyPressedProcedure(ShinobicraftModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChargeChakraOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(entity.isSprinting()))) {
			entity.setMotion(0, (entity.getMotion().getY()), 0);
			entity.getPersistentData().putBoolean("infusing", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Infusing Chakra!"), (true));
			}
		}
	}
}
