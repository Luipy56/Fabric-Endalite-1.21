package net.luipy.endalite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.luipy.endalite.block.ModBlocks;
import net.luipy.endalite.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENDALITE_BLOCK);

        addDrop(ModBlocks.ENDALITE_ORE, oreDrops(ModBlocks.ENDALITE_ORE, ModItems.RAW_ENDALITE));
    }
}
