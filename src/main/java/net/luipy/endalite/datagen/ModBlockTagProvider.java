package net.luipy.endalite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luipy.endalite.Endalite;
import net.luipy.endalite.block.ModBlocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //Anadir Blockes a JSON
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDALITE_BLOCK)
                .add(ModBlocks.ENDALITE_ORE)
                .add(ModBlocks.ENDALITE_CLUSTER);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)//TODO: HACER NETHERITE
                .add(ModBlocks.ENDALITE_BLOCK)
                .add(ModBlocks.ENDALITE_ORE)
                .add(ModBlocks.ENDALITE_CLUSTER);
    }
}
