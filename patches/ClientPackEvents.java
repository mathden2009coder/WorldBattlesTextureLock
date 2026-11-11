package com.worldbattles.texturelock.client;

import com.worldbattles.texturelock.WorldBattlesTextureLock;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathPackResources;

import java.nio.file.Files;
import java.nio.file.Path;

/** Registers one fixed, required pack built from the six resources verified by the installer. */
@Mod.EventBusSubscriber(
        modid = WorldBattlesTextureLock.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public final class ClientPackEvents {
    private ClientPackEvents() {}

    @SubscribeEvent
    public static void addRequiredPack(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;
        event.addRepositorySource(consumer -> {
            try {
                Path path = ClientPackManager.combinedPackPath();
                if (!Files.isDirectory(path) || !ClientPackManager.isReady()) return;

                // Forge 47.4.x ResourcesSupplier is a single-method interface.
                Pack.ResourcesSupplier supplier =
                        packId -> new PathPackResources(packId, true, path);

                Pack.Info info = Pack.readPackInfo(ClientPackManager.PACK_ID, supplier);
                if (info == null) {
                    WorldBattlesTextureLock.LOGGER.error(
                            "The merged WorldBattles pack has invalid or incompatible metadata."
                    );
                    return;
                }

                Pack pack = Pack.create(
                        ClientPackManager.PACK_ID,
                        Component.literal("WorldBattles Texture Lock — obligatoire"),
                        true,
                        supplier,
                        info,
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        true,
                        PackSource.BUILT_IN
                );
                if (pack != null) consumer.accept(pack);
            } catch (Exception e) {
                WorldBattlesTextureLock.LOGGER.error(
                        "Could not register mandatory WorldBattles resource pack", e
                );
            }
        });
    }
}
