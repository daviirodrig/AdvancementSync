# AdvancementSync

Minecraft Spigot plugin to sync players' advancements (formerly achievements in versions before 1.12)

## Usage

Whenever a player make an advancement, everyone online in the server will also receive it.

- `/scan <player>` - Scans the advancements of \<player>, giving every advancement completed to everyone online at the moment.
  Useful for when you made an advancement and someone is offline.

- `/scanprogress <advancement resource name>` - Shows the criteria that you need to complete to get the advancement specified.
  You can get the advancement resource name [here](https://minecraft.fandom.com/wiki/Advancement#:~:text=and%20data%20packs.-,List%20of%20advancements,-Minecraft) under the resource location section.

## Compatibility

This plugin was made with spigot 1.16.5 in mind, but it doesn't use any spigot-only functionality, so it should work on any bukkit fork.

Tested only in minecraft 1.16.5 but should work in other versions since it doesn't do anything version-specific

## Download

You can download the built jar in the [releases page](https://github.com/daviirodrig/advancementsync/releases)
