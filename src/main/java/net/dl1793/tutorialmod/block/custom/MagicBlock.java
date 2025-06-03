package net.dl1793.tutorialmod.block.custom;

import net.dl1793.tutorialmod.item.ModItems;
import net.dl1793.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class MagicBlock extends Block {
    public static final Map<Item, Item> ITEM_MAP =
            Map.of(
                    ModItems.RAW_PINK_GARNET, ModItems.PINK_GARNET,
                    Items.DIAMOND, ModItems.AMPLOR_EGG,
                    Items.COPPER_INGOT, Items.GOLD_INGOT
            );


    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 5f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack()))
            {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }



//            if (ITEM_MAP.containsKey(itemEntity.getStack().getItem())) {
//                if(!world.isClient()) {
//                    double randomValue = Math.random();
//                    double Probability = 0.3f;
//                    if (randomValue > Probability) {
//                        itemEntity.setStack(new ItemStack(Items.COAL, itemEntity.getStack().getCount()));
//                    } else {
//                        itemEntity.setStack(new ItemStack(ITEM_MAP.get(itemEntity.getStack().getItem()), itemEntity.getStack().getCount()));
//                    }
//                }
//            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
