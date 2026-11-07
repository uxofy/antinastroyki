# Animatium

A client-side Fabric mod for **Minecraft 1.21.11**.

## Description

Hides selected third-party keybinding rows from the Controls menu:

- MaceCore keybindings (`key.macecore.*` and `key.mace_core.*`)
- `key.shieldbreaker.open_gui`

Animatium only filters the displayed rows in the Controls menu. It does not unregister keybindings, alter their assigned keys, or change Minecraft's normal controls.

## Build

Requirements: JDK 21 and Gradle.

```bash
gradle build
```

The compiled JAR will be in `build/libs/`.

## GitHub

Upload the contents of this folder to a GitHub repository. The included GitHub Actions workflow builds the project on each push and makes the JAR available as an Actions artifact.
