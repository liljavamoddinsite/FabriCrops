package net.sircode;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sircode.blocks.CantaloupeBlock;

public class FabriCropsMain implements ModInitializer {
	public static final String MODID = "fabricrops";

	// Items

	public static final Item CANTALOUPE_SLICE = new Item(new FabricItemSettings().food(new FoodComponent.Builder()
					.hunger(4)
					.saturationModifier(0.2F)
					.build()));

	// Blocks / BlockItems

	public static final Block CANTALOUPE = new CantaloupeBlock(
			FabricBlockSettings.of(Material.GOURD, MapColor.OAK_TAN).strength(1.0F).sounds(BlockSoundGroup.WOOD));
	public static final BlockItem CANTALOUPE_ITEM = new BlockItem(CANTALOUPE, new FabricItemSettings());
	public static final AliasedBlockItem CANTALOUPE_SEEDS = new AliasedBlockItem(FabriCropsMain.CANTALOUPE_STEM, new FabricItemSettings());
	public static final Block CANTALOUPE_STEM = new StemBlock((GourdBlock)CANTALOUPE,
			() -> CANTALOUPE_SEEDS, AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM));
	public static final Block ATTACHED_CANTALOUPE_STEM = new AttachedStemBlock((GourdBlock)CANTALOUPE,
			() -> CANTALOUPE_SEEDS, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD));

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier(MODID, "cantaloupe"), CANTALOUPE);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "cantaloupe_stem"), CANTALOUPE_STEM);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "attached_cantaloupe_stem"), ATTACHED_CANTALOUPE_STEM);
		Registry.register(Registries.ITEM, new Identifier(MODID, "cantaloupe_slice"), CANTALOUPE_SLICE);
		Registry.register(Registries.ITEM, new Identifier(MODID, "cantaloupe_seeds"), CANTALOUPE_SEEDS);
		Registry.register(Registries.ITEM, new Identifier(MODID, "cantaloupe"), CANTALOUPE_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.addAfter(Items.MELON_SLICE, CANTALOUPE_SLICE);
		});
//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
//			content.addAfter(Items.MELON_SEEDS, CANTALOUPE_SEEDS);
//			content.addAfter(Items.MELON, CANTALOUPE);
//		});
	}
}
