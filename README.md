# WorldBattles Texture Lock

Minecraft Forge 1.20.1 / Java 17.

This repository contains the source project archive and a GitHub Actions workflow that builds the Forge mod and publishes the resulting JAR as a workflow artifact.

## Build

1. Open the **Actions** tab.
2. Select **Build WorldBattles Texture Lock**.
3. Run the workflow with **Run workflow**, or push a new commit.
4. Download the `WorldBattlesTextureLock-1.0.0` artifact from the successful workflow run.

The source ZIP is stored as base64 fragments in [`source-archive/`](./tree/main/source-archive); the workflow reconstructs and integrity-checks it before compiling. The Forge 47.4.28 compatibility patch is maintained in [`patches/ClientPackEvents.java`](./blob/main/patches/ClientPackEvents.java).

## Resource-pack priority

1. WB Hammers
2. Tissou's Zombie Pack
3. FA Details
4. Fresh Animations
5. FA Player
6. WorldBattles Blue Portal

The merger applies packs from lowest to highest priority so that pack #1 wins collisions.

## Important

The four third-party packs are not redistributed here. The client installer downloads their pinned versions from their official project/CDN locations and verifies their SHA-256 hashes. WB Hammers and WorldBattles Blue Portal are supplied WorldBattles resources.

Build #6 completed successfully and produced the `WorldBattlesTextureLock-1.0.0.jar` artifact. Compilation does not prove runtime behavior: the client installer, pack activation and ordering, Forge login gate, and behavior on the actual WorldBattles server still require in-game testing.
