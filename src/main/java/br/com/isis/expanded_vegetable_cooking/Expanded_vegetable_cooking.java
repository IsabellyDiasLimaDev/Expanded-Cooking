package br.com.isis.expanded_vegetable_cooking;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(Expanded_vegetable_cooking.MODID)
public class Expanded_vegetable_cooking {
    public static final String MODID = "expanded_vegetable_cooking";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<CropBlock> RICE_CROP = BLOCKS.registerBlock("rice_crop",
            properties -> new CropBlock(properties) {
                @Override
                protected ItemLike getBaseSeedId() {
                    return RICE_SEEDS.get();
                }
            },
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final DeferredBlock<CropBlock> BEANS_CROP = BLOCKS.registerBlock("beans_crop",
            properties -> new CropBlock(properties) {
                @Override
                protected ItemLike getBaseSeedId() {
                    return BEANS.get();
                }
            },
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS));
    public static final DeferredBlock<CropBlock> CORN_CROP = BLOCKS.registerBlock("corn_crop",
            properties -> new CropBlock(properties) {
                @Override
                protected ItemLike getBaseSeedId() {
                    return CORN.get();
                }
            },
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final DeferredBlock<CropBlock> TOMATO_CROP = BLOCKS.registerBlock("tomato_crop",
            properties -> new CropBlock(properties) {
                @Override
                protected ItemLike getBaseSeedId() {
                    return TOMATO_SEEDS.get();
                }
            },
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));

    public static final DeferredItem<Item> COOKED_CARROT = ITEMS.registerSimpleItem("cooked_carrot",
            properties -> properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).build()));
    public static final DeferredItem<Item> COOKED_BEETROOT = ITEMS.registerSimpleItem("cooked_beetroot",
            properties -> properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build()));
    public static final DeferredItem<Item> BOILED_EGG = ITEMS.registerSimpleItem("boiled_egg",
            properties -> properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.6f).build()));
    public static final DeferredItem<Item> RAW_PASTA = ITEMS.registerSimpleItem("raw_pasta");
    public static final DeferredItem<Item> COOKED_PASTA = ITEMS.registerSimpleItem("cooked_pasta",
            properties -> properties.food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f).build()));
    public static final DeferredItem<Item> PASTA_WITH_TOMATO_SAUCE = ITEMS.registerItem("pasta_with_tomato_sauce",
            properties -> new BowlFoodItem(properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).build())));
    public static final DeferredItem<Item> RAW_RICE_BOWL = ITEMS.registerSimpleItem("raw_rice_bowl");
    public static final DeferredItem<Item> RAW_BEANS_BOWL = ITEMS.registerSimpleItem("raw_beans_bowl");
    public static final DeferredItem<BlockItem> RICE_SEEDS = ITEMS.registerItem("rice_seeds",
            properties -> new BlockItem(RICE_CROP.get(), properties));
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice");
    public static final DeferredItem<BlockItem> CORN = ITEMS.registerItem("corn",
            properties -> new BlockItem(CORN_CROP.get(), properties));
    public static final DeferredItem<BlockItem> TOMATO_SEEDS = ITEMS.registerItem("tomato_seeds",
            properties -> new BlockItem(TOMATO_CROP.get(), properties));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato");
    public static final DeferredItem<Item> TOMATO_SAUCE = ITEMS.registerSimpleItem("tomato_sauce");
    public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour");
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.registerSimpleItem("chocolate",
            properties -> properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build()));
    public static final DeferredItem<BlockItem> BEANS = ITEMS.registerItem("beans",
            properties -> new BlockItem(BEANS_CROP.get(), properties));
    public static final DeferredItem<Item> COOKED_RICE = ITEMS.registerItem("cooked_rice",
            properties -> new BowlFoodItem(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build())));
    public static final DeferredItem<Item> COOKED_BEANS = ITEMS.registerItem("cooked_beans",
            properties -> new BowlFoodItem(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.6f).build())));
    public static final DeferredItem<Item> RICE_AND_BEANS = ITEMS.registerItem("rice_and_beans",
            properties -> new BowlFoodItem(properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).build())));
    public static final DeferredItem<Item> BEANS_WITH_FLOUR = ITEMS.registerItem("beans_with_flour",
            properties -> new BowlFoodItem(properties.food(new FoodProperties.Builder().nutrition(20).saturationModifier(0.8f).build())));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXPANDED_VEGETABLE_COOKING_TAB = CREATIVE_MODE_TABS.register("expanded_vegetable_cooking_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.expanded_vegetable_cooking")).withTabsBefore(CreativeModeTabs.FOOD_AND_DRINKS).icon(() -> RICE_AND_BEANS.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(COOKED_CARROT.get());
        output.accept(COOKED_BEETROOT.get());
        output.accept(BOILED_EGG.get());
        output.accept(RAW_PASTA.get());
        output.accept(COOKED_PASTA.get());
        output.accept(PASTA_WITH_TOMATO_SAUCE.get());
        output.accept(RAW_RICE_BOWL.get());
        output.accept(RAW_BEANS_BOWL.get());
        output.accept(RICE_SEEDS.get());
        output.accept(RICE.get());
        output.accept(CORN.get());
        output.accept(TOMATO_SEEDS.get());
        output.accept(TOMATO.get());
        output.accept(TOMATO_SAUCE.get());
        output.accept(FLOUR.get());
        output.accept(CHOCOLATE.get());
        output.accept(BEANS.get());
        output.accept(COOKED_RICE.get());
        output.accept(COOKED_BEANS.get());
        output.accept(RICE_AND_BEANS.get());
        output.accept(BEANS_WITH_FLOUR.get());
    }).build());

    public Expanded_vegetable_cooking(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Expanded Vegetable Cooking loaded");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(COOKED_CARROT.get());
            event.accept(COOKED_BEETROOT.get());
            event.accept(BOILED_EGG.get());
            event.accept(RAW_PASTA.get());
            event.accept(COOKED_PASTA.get());
            event.accept(PASTA_WITH_TOMATO_SAUCE.get());
            event.accept(RAW_RICE_BOWL.get());
            event.accept(RAW_BEANS_BOWL.get());
            event.accept(RICE_SEEDS.get());
            event.accept(RICE.get());
            event.accept(CORN.get());
            event.accept(TOMATO_SEEDS.get());
            event.accept(TOMATO.get());
            event.accept(TOMATO_SAUCE.get());
            event.accept(FLOUR.get());
            event.accept(CHOCOLATE.get());
            event.accept(BEANS.get());
            event.accept(COOKED_RICE.get());
            event.accept(COOKED_BEANS.get());
            event.accept(RICE_AND_BEANS.get());
            event.accept(BEANS_WITH_FLOUR.get());
        }
    }

    private static class BowlFoodItem extends Item {
        private BowlFoodItem(Properties properties) {
            super(properties);
        }

        @Override
        public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
            ItemStack result = super.finishUsingItem(stack, level, livingEntity);
            ItemStack bowl = new ItemStack(Items.BOWL);

            if (livingEntity instanceof Player player && !player.hasInfiniteMaterials()) {
                if (result.isEmpty()) {
                    return bowl;
                }

                if (!player.getInventory().add(bowl)) {
                    player.drop(bowl, false);
                }
            }

            return result;
        }
    }
}
