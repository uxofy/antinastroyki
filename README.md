# Animatium

Client-side Fabric mod for **Minecraft 1.21.11**.

## Description

Hides selected third-party keybinding rows from the Controls menu:

- Keybinding IDs containing `macecore` or `mace_core` (case-insensitive).
- The exact keybinding ID `key.shieldbreaker.open_gui`.

This only removes the matching rows from the visible Controls list. It does not unregister the bindings or change their behavior.

## Build

Requires Java 21.

The GitHub Actions workflow builds the project on every push, pull request, or manual workflow run. Download the `Animatium-build` artifact from the Actions run.
