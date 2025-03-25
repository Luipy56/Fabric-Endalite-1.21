package net.luipy.endalite.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luipy.endalite.Endalite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


//Endalite
public class ModItems {

    public static final Item ENDALITE = registerItems("endalite", new Item(new Item.Settings()));
    public static final Item RAW_ENDALITE = registerItems("raw_endalite", new Item(new Item.Settings()));


    //Funcion Para Registrar Items con SubFuncion
    private static Item registerItems(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Endalite.MOD_ID, name), item);
    }




    //Llamar al registro de Items
    public static void registerModItems(){
        Endalite.LOGGER.info("Registrando Items para "+ Endalite.MOD_ID);

    //ENDALITE
        //ENDALITE
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ENDALITE);
        });
        //RAW ENDALITE
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ENDALITE);
        });
    }






}























