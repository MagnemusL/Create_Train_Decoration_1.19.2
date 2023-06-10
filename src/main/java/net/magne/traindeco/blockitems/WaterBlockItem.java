package net.magne.traindeco.blockitems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class WaterBlockItem extends BlockItem {
    public WaterBlockItem(Block block, Properties properties) {
        super(block, properties);
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
