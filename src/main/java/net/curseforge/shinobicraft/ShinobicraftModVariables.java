package net.curseforge.shinobicraft;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class ShinobicraftModVariables {
	public ShinobicraftModVariables(ShinobicraftModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("shinobicraft", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("strength", instance.strength);
			nbt.putString("village", instance.village);
			nbt.putString("clan", instance.clan);
			nbt.putString("rank", instance.rank);
			nbt.putString("kekkeiGenkai", instance.kekkeiGenkai);
			nbt.putDouble("mind", instance.mind);
			nbt.putDouble("agility", instance.agility);
			nbt.putDouble("body", instance.body);
			nbt.putDouble("sp", instance.sp);
			nbt.putDouble("lvl", instance.lvl);
			nbt.putString("kgRelease", instance.kgRelease);
			nbt.putDouble("exp", instance.exp);
			nbt.putDouble("maxExp", instance.maxExp);
			nbt.putDouble("chakra", instance.chakra);
			nbt.putDouble("tai", instance.tai);
			nbt.putDouble("gen", instance.gen);
			nbt.putDouble("nin", instance.nin);
			nbt.putDouble("ken", instance.ken);
			nbt.putDouble("med", instance.med);
			nbt.putDouble("chacon", instance.chacon);
			nbt.putBoolean("fire", instance.fire);
			nbt.putBoolean("water", instance.water);
			nbt.putBoolean("wind", instance.wind);
			nbt.putBoolean("earth", instance.earth);
			nbt.putBoolean("lightning", instance.lightning);
			nbt.putDouble("skillpoints", instance.skillpoints);
			nbt.putBoolean("characterCreated", instance.characterCreated);
			nbt.putString("kgBeast", instance.kgBeast);
			nbt.putDouble("maxchakra", instance.maxchakra);
			nbt.putDouble("currentchakra", instance.currentchakra);
			nbt.putDouble("charging", instance.charging);
			nbt.putDouble("bhp", instance.bhp);
			nbt.putDouble("maxbhp", instance.maxbhp);
			nbt.putString("affinity", instance.affinity);
			nbt.putDouble("stamina", instance.stamina);
			nbt.putDouble("maxstamina", instance.maxstamina);
			nbt.putDouble("ccstage", instance.ccstage);
			nbt.putDouble("mstage", instance.mstage);
			nbt.putString("jutsukeys", instance.jutsukeys);
			nbt.putString("jutsucheck", instance.jutsucheck);
			nbt.putDouble("taidamage", instance.taidamage);
			nbt.putDouble("gendamage", instance.gendamage);
			nbt.putDouble("nindamage", instance.nindamage);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.strength = nbt.getDouble("strength");
			instance.village = nbt.getString("village");
			instance.clan = nbt.getString("clan");
			instance.rank = nbt.getString("rank");
			instance.kekkeiGenkai = nbt.getString("kekkeiGenkai");
			instance.mind = nbt.getDouble("mind");
			instance.agility = nbt.getDouble("agility");
			instance.body = nbt.getDouble("body");
			instance.sp = nbt.getDouble("sp");
			instance.lvl = nbt.getDouble("lvl");
			instance.kgRelease = nbt.getString("kgRelease");
			instance.exp = nbt.getDouble("exp");
			instance.maxExp = nbt.getDouble("maxExp");
			instance.chakra = nbt.getDouble("chakra");
			instance.tai = nbt.getDouble("tai");
			instance.gen = nbt.getDouble("gen");
			instance.nin = nbt.getDouble("nin");
			instance.ken = nbt.getDouble("ken");
			instance.med = nbt.getDouble("med");
			instance.chacon = nbt.getDouble("chacon");
			instance.fire = nbt.getBoolean("fire");
			instance.water = nbt.getBoolean("water");
			instance.wind = nbt.getBoolean("wind");
			instance.earth = nbt.getBoolean("earth");
			instance.lightning = nbt.getBoolean("lightning");
			instance.skillpoints = nbt.getDouble("skillpoints");
			instance.characterCreated = nbt.getBoolean("characterCreated");
			instance.kgBeast = nbt.getString("kgBeast");
			instance.maxchakra = nbt.getDouble("maxchakra");
			instance.currentchakra = nbt.getDouble("currentchakra");
			instance.charging = nbt.getDouble("charging");
			instance.bhp = nbt.getDouble("bhp");
			instance.maxbhp = nbt.getDouble("maxbhp");
			instance.affinity = nbt.getString("affinity");
			instance.stamina = nbt.getDouble("stamina");
			instance.maxstamina = nbt.getDouble("maxstamina");
			instance.ccstage = nbt.getDouble("ccstage");
			instance.mstage = nbt.getDouble("mstage");
			instance.jutsukeys = nbt.getString("jutsukeys");
			instance.jutsucheck = nbt.getString("jutsucheck");
			instance.taidamage = nbt.getDouble("taidamage");
			instance.gendamage = nbt.getDouble("gendamage");
			instance.nindamage = nbt.getDouble("nindamage");
		}
	}

	public static class PlayerVariables {
		public double strength = 0;
		public String village = "";
		public String clan = "";
		public String rank = "";
		public String kekkeiGenkai = "";
		public double mind = 0;
		public double agility = 0;
		public double body = 0;
		public double sp = 0;
		public double lvl = 0;
		public String kgRelease = "";
		public double exp = 0;
		public double maxExp = 0;
		public double chakra = 0;
		public double tai = 0;
		public double gen = 0;
		public double nin = 0;
		public double ken = 0;
		public double med = 0;
		public double chacon = 0;
		public boolean fire = false;
		public boolean water = false;
		public boolean wind = false;
		public boolean earth = false;
		public boolean lightning = false;
		public double skillpoints = 0;
		public boolean characterCreated = false;
		public String kgBeast = "";
		public double maxchakra = 100.0;
		public double currentchakra = 0;
		public double charging = 0;
		public double bhp = 0;
		public double maxbhp = 0;
		public String affinity = "";
		public double stamina = 0;
		public double maxstamina = 0;
		public double ccstage = 0;
		public double mstage = 0;
		public String jutsukeys = "";
		public String jutsucheck = "";
		public double taidamage = 0;
		public double gendamage = 0;
		public double nindamage = 0;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				ShinobicraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.strength = original.strength;
		clone.village = original.village;
		clone.clan = original.clan;
		clone.rank = original.rank;
		clone.kekkeiGenkai = original.kekkeiGenkai;
		clone.mind = original.mind;
		clone.agility = original.agility;
		clone.body = original.body;
		clone.sp = original.sp;
		clone.lvl = original.lvl;
		clone.kgRelease = original.kgRelease;
		clone.exp = original.exp;
		clone.maxExp = original.maxExp;
		clone.chakra = original.chakra;
		clone.tai = original.tai;
		clone.gen = original.gen;
		clone.nin = original.nin;
		clone.ken = original.ken;
		clone.med = original.med;
		clone.chacon = original.chacon;
		clone.fire = original.fire;
		clone.water = original.water;
		clone.wind = original.wind;
		clone.earth = original.earth;
		clone.lightning = original.lightning;
		clone.skillpoints = original.skillpoints;
		clone.characterCreated = original.characterCreated;
		clone.kgBeast = original.kgBeast;
		clone.maxchakra = original.maxchakra;
		clone.currentchakra = original.currentchakra;
		clone.charging = original.charging;
		clone.bhp = original.bhp;
		clone.maxbhp = original.maxbhp;
		clone.affinity = original.affinity;
		clone.maxstamina = original.maxstamina;
		clone.ccstage = original.ccstage;
		clone.mstage = original.mstage;
		clone.jutsucheck = original.jutsucheck;
		clone.taidamage = original.taidamage;
		clone.gendamage = original.gendamage;
		clone.nindamage = original.nindamage;
		if (!event.isWasDeath()) {
			clone.stamina = original.stamina;
			clone.jutsukeys = original.jutsukeys;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.strength = message.data.strength;
					variables.village = message.data.village;
					variables.clan = message.data.clan;
					variables.rank = message.data.rank;
					variables.kekkeiGenkai = message.data.kekkeiGenkai;
					variables.mind = message.data.mind;
					variables.agility = message.data.agility;
					variables.body = message.data.body;
					variables.sp = message.data.sp;
					variables.lvl = message.data.lvl;
					variables.kgRelease = message.data.kgRelease;
					variables.exp = message.data.exp;
					variables.maxExp = message.data.maxExp;
					variables.chakra = message.data.chakra;
					variables.tai = message.data.tai;
					variables.gen = message.data.gen;
					variables.nin = message.data.nin;
					variables.ken = message.data.ken;
					variables.med = message.data.med;
					variables.chacon = message.data.chacon;
					variables.fire = message.data.fire;
					variables.water = message.data.water;
					variables.wind = message.data.wind;
					variables.earth = message.data.earth;
					variables.lightning = message.data.lightning;
					variables.skillpoints = message.data.skillpoints;
					variables.characterCreated = message.data.characterCreated;
					variables.kgBeast = message.data.kgBeast;
					variables.maxchakra = message.data.maxchakra;
					variables.currentchakra = message.data.currentchakra;
					variables.charging = message.data.charging;
					variables.bhp = message.data.bhp;
					variables.maxbhp = message.data.maxbhp;
					variables.affinity = message.data.affinity;
					variables.stamina = message.data.stamina;
					variables.maxstamina = message.data.maxstamina;
					variables.ccstage = message.data.ccstage;
					variables.mstage = message.data.mstage;
					variables.jutsukeys = message.data.jutsukeys;
					variables.jutsucheck = message.data.jutsucheck;
					variables.taidamage = message.data.taidamage;
					variables.gendamage = message.data.gendamage;
					variables.nindamage = message.data.nindamage;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
