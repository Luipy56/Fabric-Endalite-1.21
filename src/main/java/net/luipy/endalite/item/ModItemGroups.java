package net.luipy.endalite.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.luipy.endalite.Endalite;
import net.luipy.endalite.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup NOSE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Endalite.MOD_ID, "endaliteitems"),
            FabricItemGroup.builder().icon(()->new ItemStack(net.luipy.endalite.item.ModItems.ENDALITE))
                    .displayName(Text.translatable("itemgroup.endalite.endaliteitems"))
                    .entries((displayContext, entries) -> {
                        //AQUI VAN LOS ITEMS DEL GROUP
                        entries.add(net.luipy.endalite.item.ModItems.ENDALITE);
                        entries.add(net.luipy.endalite.item.ModItems.RAW_ENDALITE);
                        entries.add(net.luipy.endalite.item.ModItems.ENDALITE_CHUNK);
                        entries.add(net.luipy.endalite.item.ModItems.ENDALITE_NUGGET);
                        entries.add(net.luipy.endalite.item.ModItems.TAMARA);
                        entries.add(ModBlocks.ENDALITE_BLOCK);
                        entries.add(ModBlocks.ENDALITE_ORE);
                        entries.add(ModBlocks.ENDALITE_CLUSTER);

                    }).build());

    public static void register() {
        Endalite.LOGGER.info("Registrando slot del menú de creativo para "+ Endalite.MOD_ID);
    }
}
