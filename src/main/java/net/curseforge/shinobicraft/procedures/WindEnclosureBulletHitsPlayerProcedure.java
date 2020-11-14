package net.curseforge.shinobicraft.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.potion.WindEnclosureEffectPotion;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class WindEnclosureBulletHitsPlayerProcedure extends ShinobicraftModElements.ModElement {
	public WindEnclosureBulletHitsPlayerProcedure(ShinobicraftModElements instance) {
		super(instance, 107);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WindEnclosureBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(WindEnclosureEffectPotion.potion, (int) 120, (int) 1, (false), (false)));
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(WindEnclosureEffectPotion.potion, (int) 120, (int) 1, (false), (false)));
	}
}
