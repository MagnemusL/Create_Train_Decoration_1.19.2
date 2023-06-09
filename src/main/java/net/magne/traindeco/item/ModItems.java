package net.magne.traindeco.item;

import net.magne.traindeco.TrainDeco;
import net.magne.traindeco.block.ModBlocks;
import net.magne.traindeco.blockitems.WaterBlockItem;
import net.magne.traindeco.item.custom.WaterItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TrainDeco.MOD_ID);

    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> COLA = ITEMS.register("cola",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SIGN_ITEM = ITEMS.register("sign_item",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> WATER_ITEM = ITEMS.register("water_item",
            () -> new WaterItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<BlockItem> WATER_BLOCK_ITEM = ITEMS.register("water_block",
    () -> new WaterBlockItem(ModBlocks.WATER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

