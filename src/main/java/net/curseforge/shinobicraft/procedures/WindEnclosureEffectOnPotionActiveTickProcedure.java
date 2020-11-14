package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class WindEnclosureEffectOnPotionActiveTickProcedure extends ShinobicraftModElements.ModElement {
	public WindEnclosureEffectOnPotionActiveTickProcedure(ShinobicraftModElements instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WindEnclosureEffectOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure WindEnclosureEffectOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double loop = 0;
		double xRadius = 0;
		double particleAmount = 0;
		double zRadius = 0;
		loop = (double) 0;
		particleAmount = (double) 15;
		xRadius = (double) 1;
		zRadius = (double) 1;
		while (((loop) < (particleAmount))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD,
						((entity.getPosX()) + (Math.cos((((Math.PI * 2) / (particleAmount)) * (loop))) * (xRadius))), (entity.getPosY()),
						(((entity.getPosZ()) + 0.5) + (Math.sin((((Math.PI * 2) / (particleAmount)) * (loop))) * (zRadius))), (int) 5, 0, 0.05, 0, 1);
			}
			loop = (double) ((loop) + 1);
		}
		entity.setMotion(((entity.getMotion().getX()) * 0), ((entity.getMotion().getY()) * 0), ((entity.getMotion().getZ()) * 0));
		entity.attackEntityFrom(DamageSource.IN_WALL, (float) 0.8);
	}
}
