
package net.curseforge.shinobicraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.curseforge.shinobicraft.procedures.ChakraPillFoodEatenProcedure;
import net.curseforge.shinobicraft.itemgroup.NincraftTabItemGroup;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class ChakraPillItem extends ShinobicraftModElements.ModElement {
	@ObjectHolder("shinobicraft:chakra_pill")
	public static final Item block = null;
	public ChakraPillItem(ShinobicraftModElements instance) {
		super(instance, 149);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NincraftTabItemGroup.tab).maxStackSize(6).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("chakra_pill");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A small pill that has immense chakra restorative capabilities."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ChakraPillFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
