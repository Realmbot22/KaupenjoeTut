package net.genesis.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.genesis.tutorialmod.block.ModBlocks;
import net.genesis.tutorialmod.item.ModItemGroups;
import net.genesis.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomsMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}