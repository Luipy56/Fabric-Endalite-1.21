package net.luipy.endalite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.luipy.endalite.Endalite;
import net.luipy.endalite.block.ModBlocks;
import net.luipy.endalite.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //Compactador
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ENDALITE, RecipeCategory.DECORATIONS, ModBlocks.ENDALITE_BLOCK);

        List<ItemConvertible> ENDALITE_SMELTABLES = List.of(ModItems.RAW_ENDALITE, ModBlocks.ENDALITE_ORE);//TODO: NO necesita lista
        offerSmelting(exporter, ENDALITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDALITE_NUGGET, 3f, 600, "endalite");
        offerBlasting(exporter, ENDALITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDALITE_NUGGET, 3f, 300, "endalite");

        offerSmelting(exporter, List.of(ModBlocks.ENDALITE_CLUSTER), RecipeCategory.MISC, ModItems.ENDALITE_CHUNK, 3f, 600, "endalite");
        offerBlasting(exporter, List.of(ModBlocks.ENDALITE_CLUSTER), RecipeCategory.MISC, ModItems.ENDALITE_CHUNK, 3f, 300, "endalite");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDALITE)
                .pattern("NNN")
                .pattern("NEE")
                .pattern("EE ")
                .input('E', ModItems.ENDALITE_CHUNK)
//                .input('A', Items.AIR)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.ENDALITE_CHUNK), conditionsFromItem(ModItems.ENDALITE_CHUNK))
                .offerTo(exporter, Identifier.of(Endalite.MOD_ID, "endalite_from_recipe")); //Importante para crafter secundarios

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDALITE_CHUNK)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', ModItems.ENDALITE_NUGGET)
                .criterion(hasItem(ModItems.ENDALITE_NUGGET), conditionsFromItem(ModItems.ENDALITE_NUGGET))
                .offerTo(exporter, Identifier.of(Endalite.MOD_ID, "endalite_from_nugget"));
    }
}
