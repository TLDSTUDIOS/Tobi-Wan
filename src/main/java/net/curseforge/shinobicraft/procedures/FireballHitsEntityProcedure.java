package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class FireballHitsEntityProcedure extends ShinobicraftModElements.ModElement {
	public FireballHitsEntityProcedure(ShinobicraftModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FireballHitsEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FireballHitsEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof ServerPlayerEntity) || (entity instanceof PlayerEntity))) {
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 1,
						Explosion.Mode.BREAK);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 30, 1, 1,
						1, 1);
			}
			world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 1), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 1), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 2), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 2), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 1)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 1)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 2)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 2)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 1), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 1)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 1), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 1)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 2), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 2)),
					Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 2), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 2)),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 1,
					Explosion.Mode.BREAK);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 30, 1, 1, 1,
					1);
		}
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ())), Blocks.FIRE.getDefaultState(),
				3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 1), (int) (entity.getPosY()), (int) (entity.getPosZ())),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 1), (int) (entity.getPosY()), (int) (entity.getPosZ())),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 2), (int) (entity.getPosY()), (int) (entity.getPosZ())),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 2), (int) (entity.getPosY()), (int) (entity.getPosZ())),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 1)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 1)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 2)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 2)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 1), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 1)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 1), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 1)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) - 2), (int) (entity.getPosY()), (int) ((entity.getPosZ()) - 2)),
				Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) ((entity.getPosX()) + 2), (int) (entity.getPosY()), (int) ((entity.getPosZ()) + 2)),
				Blocks.FIRE.getDefaultState(), 3);
	}
}
