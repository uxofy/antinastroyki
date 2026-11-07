# Animatium

Client-side Fabric mod for **Minecraft 1.21.11**.

## Description

Hides selected third-party keybinding rows from the Controls menu:

- Any keybinding ID containing `macecore` (case-insensitive).
- The exact keybinding ID `key.shieldbreaker.open_gui`.

The filter runs after Minecraft creates the Controls list. It only removes matching rows from that screen; it does not unregister or modify the keybindings.

## Build

Requires Java 21. Push this project to GitHub and run the included Actions workflow. Download the `Animatium-build` artifact from the workflow run.
