package net.dl1793.tutorialmod.item;

import net.dl1793.tutorialmod.TutorialMod;
import net.dl1793.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.PINK_GARNET);
                      entries.add(ModItems.RAW_PINK_GARNET);
                      entries.add(ModItems.CHISEL);
                      entries.add(ModItems.CAULIFLOWER);
                      entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());

    public static final ItemGroup AMPLOR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "amplor_items"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.AMPLOR_EGG))
            .displayName(Text.translatable("itemgroup.tutorialmod.amplor_items"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.AMPLOR_EGG);
            }).build());


    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
            .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.PINK_GARNET_BLOCK);
                entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                entries.add(ModBlocks.PINK_GARNET_ORE);
                entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                entries.add(ModBlocks.MAGIC_BLOCK);
            }).build());

    public static final ItemGroup AMPLOR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "amplor_blocks"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.AMPLOR_BLOCK))
            .displayName(Text.translatable("itemgroup.tutorialmod.amplor_blocks"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.AMPLOR_BLOCK);
            }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
