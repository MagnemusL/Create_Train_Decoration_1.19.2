package net.magne.traindeco.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.core.NonNullList;
import net.minecraft.world.level.Level;

public class WaterItem extends Item {
    public WaterItem(Properties properties) {
        super(properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (player.isInWater()) {
                player.getInventory().removeItem(stack);
            }
        }
    }
}
