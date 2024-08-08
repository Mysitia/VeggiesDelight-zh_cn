package net.mehdinoui.veggiesdelight.item;

import net.mehdinoui.veggiesdelight.VeggiesDelight;
import net.mehdinoui.veggiesdelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VeggiesDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VEGGIESDELIGHT_TAB = CREATIVE_MODE_TABS.register("veggiesdelight_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BELLPEPPER.get()))
                    .title(Component.translatable("creativetab.veggiesdelight_tab"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(ModItems.BELLPEPPER.get());
                        pOutput.accept(ModItems.CAULIFLOWER.get());

                        pOutput.accept(ModItems.BELLPEPPER_SEEDS.get());
                        pOutput.accept(ModItems.CAULIFLOWER_SEEDS.get());

                        pOutput.accept(ModBlocks.BELLPEPPER_CRATE.get());
                        pOutput.accept(ModBlocks.CAULIFLOWER_CRATE.get());

                        pOutput.accept(ModItems.SMOKED_BELLPEPPER.get());
                        pOutput.accept(ModItems.CAULIFLOWER_FLORET.get());
                        pOutput.accept(ModItems.FRIED_CAULIFLOWER_FLORET.get());

                        pOutput.accept(ModItems.CAULIFLOWER_PATTY.get());
                        pOutput.accept(ModItems.COOKED_CAULIFLOWER_PATTY.get());

                        pOutput.accept(ModItems.CACCIATORE.get());
                        pOutput.accept(ModItems.CAULIFLOWER_SOUP.get());

                        pOutput.accept(ModItems.SHAKSHOUKA.get());
                        pOutput.accept(ModItems.STUFFED_BELLPEPPERS.get());

                        pOutput.accept(ModBlocks.WILD_BELLPEPPERS.get());
                            }
                    ).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
