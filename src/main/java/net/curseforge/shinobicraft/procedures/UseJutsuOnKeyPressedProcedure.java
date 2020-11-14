package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.item.WaterBulletItem;
import net.curseforge.shinobicraft.item.PheonixflameentityItem;
import net.curseforge.shinobicraft.item.AirbulletsItem;
import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class UseJutsuOnKeyPressedProcedure extends ShinobicraftModElements.ModElement {
	public UseJutsuOnKeyPressedProcedure(ShinobicraftModElements instance) {
		super(instance, 329);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure UseJutsuOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure UseJutsuOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure UseJutsuOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure UseJutsuOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure UseJutsuOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("airbullets"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 3))) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				AirbulletsItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1.5, (float) 2, (int) 3);
			}
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 3);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("ptimer", 0);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			entity.getPersistentData().putDouble("jcount", ((entity.getPersistentData().getDouble("jcount")) + 1));
		}
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("airbullets"))
				&& ((entity.getPersistentData().getDouble("jcount")) >= 3))) {
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putDouble("jcount", 0);
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if (((((((entity.getPersistentData().getString("currentjutsu"))).equals("ragingwaves"))
				|| (((entity.getPersistentData().getString("currentjutsu"))).equals("fireball")))
				|| (((entity.getPersistentData().getString("currentjutsu"))).equals("vacuumpush")))
				|| (((entity.getPersistentData().getString("currentjutsu"))).equals("dragonflame")))) {
			entity.getPersistentData().putBoolean("jcharge", (true));
		}
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("waterbullets"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 5))) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				WaterBulletItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1.2, (float) 2.5, (int) 1);
			}
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 5);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("ptimer", 0);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			entity.getPersistentData().putDouble("jcount", ((entity.getPersistentData().getDouble("jcount")) + 1));
		}
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("waterbullets"))
				&& ((entity.getPersistentData().getDouble("jcount")) >= 3))) {
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putDouble("jcount", 0);
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("pheonix"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 6))) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				PheonixflameentityItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1.5, (float) 2, (int) 1);
			}
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 6);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("ptimer", 0);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			entity.getPersistentData().putDouble("jcount", ((entity.getPersistentData().getDouble("jcount")) + 1));
		}
		if (((((entity.getPersistentData().getString("currentjutsu"))).equals("pheonix"))
				&& ((entity.getPersistentData().getDouble("jcount")) >= 5))) {
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putDouble("jcount", 0);
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if ((((((entity.getPersistentData().getString("currentjutsu"))).equals("raising spikes"))
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= 15))
				&& ((entity instanceof LivingEntity) ? (entity.onGround) : false))) {
			if (((entity.getHorizontalFacing()) == Direction.NORTH)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("shinobicraft", "spikes"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 4), (int) y, (int) (z - 7)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			}
			if (((entity.getHorizontalFacing()) == Direction.EAST)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("shinobicraft", "spikes"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x + 7), (int) y, (int) (z - 4)), new PlacementSettings()
								.setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			}
			if (((entity.getHorizontalFacing()) == Direction.SOUTH)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("shinobicraft", "spikes"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x + 2), (int) y, (int) (z + 7)), new PlacementSettings()
								.setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			}
			if (((entity.getHorizontalFacing()) == Direction.WEST)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("shinobicraft", "spikes"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 7), (int) y, (int) (z + 1)), new PlacementSettings()
								.setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			}
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 10);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentchakra = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putString("currentjutsu", "");
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			Usejutsuonkeypressed2Procedure.executeProcedure($_dependencies);
		}
	}
}
