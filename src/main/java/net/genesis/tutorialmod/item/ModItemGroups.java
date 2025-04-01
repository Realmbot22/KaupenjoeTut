package net.genesis.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.genesis.tutorialmod.DomsMod;
import net.genesis.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
public static final ItemGroup DOMS_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(DomsMod.MOD_ID, "doms_mod"),
        FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
        .displayName(Text.translatable("itemgroup.tutorialmod.doms_mod"))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.PINK_GARNET);
                    entries.add(ModItems.RAW_PINK_GARNET);

                    entries.add(ModItems.CHISEL);

                }).build());

public static final ItemGroup DOMS_MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(DomsMod.MOD_ID, "doms_mod_blocks"),
        FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
        .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                .entries((displayContext, entries) -> {
                    entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                    entries.add(ModBlocks.PINK_GARNET_ORE);
                    entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                }).build());



    public static void registerItemGroups() {
        DomsMod.LOGGER.info("Registering Item Groups for " + DomsMod.MOD_ID);
    }
}
