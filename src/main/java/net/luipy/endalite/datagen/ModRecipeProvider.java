package net.luipy.endalite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.luipy.endalite.block.ModBlocks;
import net.luipy.endalite.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> ENDALITE_SMELTABLES = List.of(ModItems.ENDALITE, ModBlocks.ENDALITE_ORE, ModBlocks.ENDALITE_ORE);//TODO: NO necesita lista

        offerSmelting(exporter, ENDALITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDALITE, 3f, 600, "endalite");
        offerBlasting(exporter, ENDALITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDALITE, 3f, 300, "endalite");


        //Compactador
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ENDALITE, RecipeCategory.DECORATIONS, ModBlocks.ENDALITE_BLOCK);

    }
}
