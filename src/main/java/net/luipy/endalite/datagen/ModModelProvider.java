package net.luipy.endalite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.luipy.endalite.block.ModBlocks;
import net.luipy.endalite.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    //BLOCKS CUBE ALL
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDALITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDALITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDALITE_CLUSTER);

    }

    //ITEMS
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDALITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ENDALITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDALITE_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TAMARA, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDALITE_NUGGET, Models.GENERATED);
    }
}
