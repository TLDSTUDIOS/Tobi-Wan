
package net.curseforge.shinobicraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.curseforge.shinobicraft.ShinobicraftModElements;

@ShinobicraftModElements.ModElement.Tag
public class LeapIconItem extends ShinobicraftModElements.ModElement {
	@ObjectHolder("shinobicraft:leap_icon")
	public static final Item block = null;
	public LeapIconItem(ShinobicraftModElements instance) {
		super(instance, 297);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("leap_icon");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
