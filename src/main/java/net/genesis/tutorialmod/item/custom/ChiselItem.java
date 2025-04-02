package net.genesis.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.OAK_LOG, Blocks.OAK_PLANKS,
                    Blocks.BIRCH_LOG, Blocks.BIRCH_PLANKS,
                    Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS,
                    Blocks.SPRUCE_LOG, Blocks.SPRUCE_PLANKS,
                    Blocks.JUNGLE_LOG, Blocks.JUNGLE_PLANKS,
                    Blocks.ACACIA_LOG, Blocks.ACACIA_PLANKS,
                    Blocks.MANGROVE_LOG, Blocks.MANGROVE_PLANKS,
                    Blocks.CHERRY_LOG, Blocks.CHERRY_PLANKS,
                    Blocks.CRIMSON_STEM, Blocks.CRIMSON_PLANKS,
                    Blocks.WARPED_STEM, Blocks.WARPED_PLANKS

            );


    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

if (CHISEL_MAP.containsKey(clickedBlock)) {
    if (!world.isClient()) {
        world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

        context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
    }
}

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
       if (Screen.hasShiftDown()) {
           tooltip.add(Text.translatable("tooltip.tutorialmod.chisel.shift_down"));
       } else {
           tooltip.add(Text.translatable("tooltip.tutorialmod.chisel"));
       }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
