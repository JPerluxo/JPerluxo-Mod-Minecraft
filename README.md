# JPerluxo Mod
![Version](https://img.shields.io/badge/Version-1.2.0-white.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.16.5-white.svg?labelColor=52a535&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAACXBIWXMAAAsTAAALEwEAmpwYAAAB30lEQVR4nO2dQWrDUBBD53gJvf8F0t5Dpcv/NzVUVuX4PdAugpmRlYA3mQEAAAAAAACAbj5m5mtmhObMG3zOzPNIID8fJIyJ3OB1JBDCmOgNCGQuHgh4IZAyCKQMAimDQMogkDIIpAwCKYNAyiCQMgikDAK5eyDxl28Xm49ANgiEhizQkA0aQkMWaMgGDaEhCzRkg4bQkAUaskFDaMgCDdmgITRkgYZs0BAaskBDNmgIDVmgIRs0hIYs0JC7N+TdDuiGQIZATn2iREP+FxFId8VFQwjECT/q0914v+FkxFcWgZwJDZnuB8xvMA2mMqX29htMg6lMqb39BtNgKlNqb7/BNJjKlNrbbzANpjKl9vYbTIOpTKm9/QbTYCpTam+/wTSYypTa228wDaYypfb2G0yDqUypvf0G02AqU2pvv8E0mMqU2ttvMA2mMqX29htMg6lMqb39BtNgKlNqb7/BNJjKlNrbbzANpjKl9vYbTIOpTKm9/QbTYCpTam+/wTSYypTa228wDabQYQik7DCiIV2HEYF0HUYE0nUYEUjXYUQgXYcRgXQdRgTSdRgRSNdhRCBwiVcnd0UE0gWBvFsgaE69AYFM10P2K/zB/XT9wf2TUCYVxuNIIAAAAAAwf+QbD2H/7GI71IEAAAAASUVORK5CYII=)
![Java](https://img.shields.io/badge/Java-1.8-white.svg?labelColor=ED1D25&logo=openjdk)
![Gradle](https://img.shields.io/badge/Gradle-4.10.3-white.svg?labelColor=06A0CE&logo=gradle)

A simple add-on with some new features for [Minecraft: Java Edition](https://www.minecraft.net/en-us/store/minecraft-java-bedrock-edition-pc) on pc.

⚠️ **Requirements:**  
- Minecraft: Java Edition **1.16.5**
- Minecraft Forge **36.2.34**

<details>
<summary>Installation</summary>

## Development
1. **Clone the repository:**
  ```bash
    git clone https://github.com/jperluxo/jperluxo-mod-minecraft.git
    cd jperluxo-mod-minecraft
  ```

2. **Java requirement:**
  - Make sure you have **Java 8 JDK** installed (`java -version` should show `1.8`).

3. **Open in VS Code:**
  - Install the recommended Java extensions.
  - The repo already provides [.vscode/tasks.json](/.vscode/tasks.json) with useful tasks.

4. **Run Minecraft in Dev:**
  - Press `Ctrl+Shift+B` (or go to *Terminal → Run Task*).
  - Choose **Gradle: runClient**.
  - This launches Minecraft with the mod loaded in a development environment.

5. **Build release JAR:**
  - Run **Gradle: build** (or `./gradlew build`).
  - The distributable JAR will be in `build/libs/`.

## Release
1. **Install Minecraft Forge:**
  - Download and install the [Minecraft Forge](https://maven.minecraftforge.net/net/minecraftforge/forge/1.16.5-36.2.34/forge-1.16.5-36.2.34-installer.jar).
  - Run the Forge installer and make sure it creates a new Forge profile in the Minecraft Launcher.

2. **Download JPerluxo Mod:**
  - Get the latest release of the mod from the [Releases page](https://github.com/jperluxo/jperluxo-mod-minecraft/tree/main/releases).

3. **Locate the Minecraft mods folder:**
  - On Windows: `C:\Users\<YourUser>\AppData\Roaming\.minecraft\mods`
  - On Linux: `~/.minecraft/mods`
  - On macOS: `~/Library/Application Support/minecraft/mods`
  - If the `mods` folder does not exist, create it.

4. **Install the mod:**
  - Place the downloaded `.jar` file of **JPerluxo Mod** into the `mods` folder.

5. **Launch Minecraft:**
  - Open the Minecraft Launcher.
  - Select the **Forge 1.16.5** profile.
  - Click **Play**.

6. **Verify installation:**
  - Once Minecraft loads, click on **Mods** in the main menu.
  - You should see **JPerluxo Mod** listed there.
</details>

<details>
<summary>License</summary>
<br>

This project is licensed under the **MIT License** – you are free to use, modify, and distribute it as long as proper credit is given.
For more details, see the [LICENSE](LICENSE) file.
</details>

<details>
<summary>Changelog</summary>

## [1.2.0] - 2025-11-16
### Added
- The JPerluxo's Armor now grants passive bonuses when the full set is equipped, including Speed and Regeneration.
- The JPerluxo's Sword now provides a passive Strength boost while held, enhancing its legendary feel.

### Changed
- Changed the armor’s description slightly.

## [1.1.5] - 2025-11-11
### Changed
- Adjusted the JPerluxo's Armor balance to be closer to Netherite gear, keeping it powerful but more consistent with game mechanics.
- Updated the Forge 1.16.5 version to the recommended build, improving reability and cohesion.

## [1.1.0] - 2025-11-10
### Added
- Introduced the **JPerluxo's Armor** — a complete legendary indestructible armor set, to match the sword.

### Changed
- Refined the JPerluxo's Sword to make its indestructibility smoother and more consistent.
- Changed the sword’s texture to visually match the armor.

### Updated
- Bumped mod support to **Minecraft 1.16.5**, ensuring better stability and compatibility.

## [1.0.5] - 2025-11-07
### Added
- Introduced the **JPerluxo's Sword** module — a unique, legendary indestructible blade.

### Fixed
- Reorganized the mod features into its own module. This improves code structure and modularity, allowing independent feature management.

## [1.0.0] - 2025-10-19
### Added
- Initial build.
- Added the **JPerluxo's Banner**, a unique custom banner design.


[1.2.0]: https://github.com/jperluxo/jperluxo-mod-minecraft/compare/1.1.5...1.2.0
[1.1.5]: https://github.com/jperluxo/jperluxo-mod-minecraft/compare/1.1.0...1.1.5
[1.1.0]: https://github.com/jperluxo/jperluxo-mod-minecraft/compare/1.0.5...1.1.0
[1.0.5]: https://github.com/jperluxo/jperluxo-mod-minecraft/compare/1.0.0...1.0.5
[1.0.0]: https://github.com/jperluxo/jperluxo-mod-minecraft/releases/tag/1.0.0
</details>
