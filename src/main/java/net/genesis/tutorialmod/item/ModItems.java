package net.genesis.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.genesis.tutorialmod.DomsMod;
import net.genesis.tutorialmod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item COOKED_DRUMSTICK = registerItem("cooked_drumstick", new Item(new Item.Settings().food(ModFoodComponents.COOKED_DRUMSTICK)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cooked_drumstick.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_DRUMSTICK = registerItem("raw_drumstick", new Item(new Item.Settings().food(ModFoodComponents.RAW_DRUMSTICK)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.raw_drumstick.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(DomsMod.MOD_ID, name), item);
}

    public static void registerModItems() {
        DomsMod.LOGGER.info("Registering Mod Items For " + DomsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
            fabricItemGroupEntries.add(RAW_PINK_GARNET);
        });
    }
}
