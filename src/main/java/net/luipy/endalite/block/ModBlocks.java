package net.luipy.endalite.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.luipy.endalite.Endalite;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block ENDALITE_ORE = registerBlock("endalite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
            AbstractBlock.Settings.create()
            .strength(5f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block ENDALITE_BLOCK = registerBlock("endalite_block",
            new Block(AbstractBlock.Settings.create()
            .strength(5f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block ENDALITE_CLUSTER = registerBlock("endalite_cluster",
            new Block(AbstractBlock.Settings.create()
            .strength(6f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));







    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Endalite.MOD_ID, name), block);
    }

    //Asociar
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Endalite.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }


    //Llamar al registro de Blockes
    public static void registerModBlocks() {
        Endalite.LOGGER.info("Registrando Blockes para "+ Endalite.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ENDALITE_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ENDALITE_BLOCK);
        });
    }
}
