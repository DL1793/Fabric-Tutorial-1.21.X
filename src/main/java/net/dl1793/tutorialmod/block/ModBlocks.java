package net.dl1793.tutorialmod.block;

import net.dl1793.tutorialmod.TutorialMod;
import net.dl1793.tutorialmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Predicate;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", new Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", new Block(AbstractBlock.Settings.create()
            .strength(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.GLASS)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block AMPLOR_BLOCK = registerBlock("amplor_block", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.BRIGHT_TEAL)
            .luminance(state -> 15)
            .strength(1f)
            .requiresTool()
            .sounds(BlockSoundGroup.SCULK)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(AbstractBlock.Settings.create()
            .strength(1f)
            .requiresTool()));

//Helper methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

            entries.add(ModBlocks.PINK_GARNET_ORE);
            entries.add((ModBlocks.PINK_GARNET_DEEPSLATE_ORE));

            entries.add(ModBlocks.AMPLOR_BLOCK);

            entries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
