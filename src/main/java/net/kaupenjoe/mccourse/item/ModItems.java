package net.kaupenjoe.mccourse.item;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.custom.ChainsawItem;
import net.kaupenjoe.mccourse.item.custom.DataTabletItem;
import net.kaupenjoe.mccourse.item.custom.FuelItem;
import net.kaupenjoe.mccourse.item.custom.MetalDetectorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCCourseMod.MOD_ID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.registerItem("chainsaw", ChainsawItem::new, new Item.Properties().durability(32));

    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.mccourse.tomato.1"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.TOMATO));
    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties());

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> KAUPEN_BOW = ITEMS.register("kaupen_bow",
            () -> new BowItem(new Item.Properties().durability(500)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
