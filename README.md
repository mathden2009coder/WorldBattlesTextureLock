# WorldBattles Texture Lock

Minecraft Forge 1.20.1 / Java 17.

This repository contains the source project archive and a GitHub Actions workflow that builds the Forge mod and publishes the resulting JAR as a workflow artifact.

## Build

1. Open the **Actions** tab.
2. Select **Build WorldBattles Texture Lock**.
3. Run the workflow with **Run workflow**, or push a new commit.
4. Download the `WorldBattlesTextureLock-1.0.0` artifact from the successful workflow run.

The source project is in [WorldBattlesTextureLock-Source-1.0.0.zip](./WorldBattlesTextureLock-Source-1.0.0.zip).

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

A successful CI build verifies compilation only. The client installation flow, resource-pack activation, Forge login gate, and behavior on the actual WorldBattles server still require in-game testing.
