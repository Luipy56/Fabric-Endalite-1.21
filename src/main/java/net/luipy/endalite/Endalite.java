package net.luipy.endalite;

import net.fabricmc.api.ModInitializer;

import net.luipy.endalite.block.ModBlocks;
import net.luipy.endalite.item.ModItemGroups;
import net.luipy.endalite.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endalite implements ModInitializer {
	public static final String MOD_ID = "endalite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TEST!");
		//Registrar los Items creados
		ModItems.registerModItems();
		//Registrar Blockes
		ModBlocks.registerModBlocks();
		//Creative Slot
		ModItemGroups.register();
		LOGGER.info("TEST2!");
		LOGGER.info("TEST3!");
	}
}