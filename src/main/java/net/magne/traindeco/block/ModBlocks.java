package net.magne.traindeco.block;

import net.magne.traindeco.TrainDeco;
import net.magne.traindeco.block.custom.DoubleStationSignBlock;
import net.magne.traindeco.block.custom.StationSignBlock;
import net.magne.traindeco.block.custom.TrashcanBlockOne;
import net.magne.traindeco.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TrainDeco.MOD_ID);


    public static final RegistryObject<Block> STATION_SIGN = registerBlock("station_sign",
            () -> new StationSignBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_MISC);


    public static final RegistryObject<Block> DOUBLE_STATION_SIGN = registerBlock("double_station_sign",
            () -> new DoubleStationSignBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> TRASHCAN_ONE = registerBlock("trashcan_one",
            () -> new TrashcanBlockOne(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> REINFORCED_CONCRETE = registerBlock("reinforced_concrete",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(3f).strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_MISC);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
