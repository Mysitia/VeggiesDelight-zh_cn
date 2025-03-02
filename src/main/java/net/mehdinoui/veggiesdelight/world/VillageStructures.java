package net.mehdinoui.veggiesdelight.world;

import com.mojang.datafixers.util.Pair;
import net.mehdinoui.veggiesdelight.Configuration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VillageStructures
{
    public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
        if (!Configuration.GENERATE_VILLAGE_STRUCTURES.get()) {
            return;
        }

        Registry<StructureTemplatePool> templatePools = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).get();
        Registry<StructureProcessorList> processorLists = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).get();

        VillageStructures.addBuildingToPool(templatePools, processorLists, new ResourceLocation("minecraft:village/plains/houses"), "veggiesdelight:village/houses/plains_depot_house", 4);
        VillageStructures.addBuildingToPool(templatePools, processorLists, new ResourceLocation("minecraft:village/snowy/houses"), "veggiesdelight:village/houses/snowy_depot_house", 5);
        VillageStructures.addBuildingToPool(templatePools, processorLists, new ResourceLocation("minecraft:village/taiga/houses"), "veggiesdelight:village/houses/taiga_depot_house", 5);
        VillageStructures.addBuildingToPool(templatePools, processorLists, new ResourceLocation("minecraft:village/savanna/houses"), "veggiesdelight:village/houses/savanna_depot_house", 4);
        VillageStructures.addBuildingToPool(templatePools, processorLists, new ResourceLocation("minecraft:village/desert/houses"), "veggiesdelight:village/houses/desert_depot_house", 4);
    }

    public static void addBuildingToPool(Registry<StructureTemplatePool> templatePoolRegistry, Registry<StructureProcessorList> processorListRegistry, ResourceLocation poolRL, String nbtPieceRL, int weight) {
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) return;

        ResourceLocation emptyProcessor = new ResourceLocation("minecraft", "empty");
        Holder<StructureProcessorList> processorHolder = processorListRegistry.getHolderOrThrow(ResourceKey.create(Registries.PROCESSOR_LIST, emptyProcessor));

        SinglePoolElement piece = SinglePoolElement.single(nbtPieceRL, processorHolder).apply(StructureTemplatePool.Projection.RIGID);

        for (int i = 0; i < weight; i++) {
            pool.templates.add(piece);
        }

        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.rawTemplates = listOfPieceEntries;
    }
}
