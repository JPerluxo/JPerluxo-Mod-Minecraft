# JPerluxo Mod
![Version](https://img.shields.io/badge/Version-1.0.0-white.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.16.4-white.svg?labelColor=52a535&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAACXBIWXMAAAsTAAALEwEAmpwYAAAB30lEQVR4nO2dQWrDUBBD53gJvf8F0t5Dpcv/NzVUVuX4PdAugpmRlYA3mQEAAAAAAACAbj5m5mtmhObMG3zOzPNIID8fJIyJ3OB1JBDCmOgNCGQuHgh4IZAyCKQMAimDQMogkDIIpAwCKYNAyiCQMgikDAK5eyDxl28Xm49ANgiEhizQkA0aQkMWaMgGDaEhCzRkg4bQkAUaskFDaMgCDdmgITRkgYZs0BAaskBDNmgIDVmgIRs0hIYs0JC7N+TdDuiGQIZATn2iREP+FxFId8VFQwjECT/q0914v+FkxFcWgZwJDZnuB8xvMA2mMqX29htMg6lMqb39BtNgKlNqb7/BNJjKlNrbbzANpjKl9vYbTIOpTKm9/QbTYCpTam+/wTSYypTa228wDaYypfb2G0yDqUypvf0G02AqU2pvv8E0mMqU2ttvMA2mMqX29htMg6lMqb39BtNgKlNqb7/BNJjKlNrbbzANpjKl9vYbTIOpTKm9/QbTYCpTam+/wTSYypTa228wDabQYQik7DCiIV2HEYF0HUYE0nUYEUjXYUQgXYcRgXQdRgTSdRgRSNdhRCBwiVcnd0UE0gWBvFsgaE69AYFM10P2K/zB/XT9wf2TUCYVxuNIIAAAAAAwf+QbD2H/7GI71IEAAAAASUVORK5CYII=)
![Java](https://img.shields.io/badge/Java-1.8-white.svg?labelColor=ED1D25&logo=openjdk)
![Gradle](https://img.shields.io/badge/Gradle-4.10.3-white.svg?labelColor=06A0CE&logo=gradle)

A simple add-on with some new features for [Minecraft: Java Edition](https://www.minecraft.net/en-us/store/minecraft-java-bedrock-edition-pc) on pc.

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
  - Download and install the [Minecraft Forge](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.16.4.html).
  - Run the Forge installer and make sure it creates a new Forge profile in the Minecraft Launcher.

2. **Download JPerluxo Mod:**
  - Get the latest release of the mod from the [Releases page](https://github.com/jperluxo/jperluxo-mod-minecraft/releases).

3. **Locate the Minecraft mods folder:**
  - On Windows: `C:\Users\<YourUser>\AppData\Roaming\.minecraft\mods`
  - On Linux: `~/.minecraft/mods`
  - On macOS: `~/Library/Application Support/minecraft/mods`
  - If the `mods` folder does not exist, create it.

4. **Install the mod:**
  - Place the downloaded `.jar` file of **JPerluxo Mod** into the `mods` folder.

5. **Launch Minecraft:**
  - Open the Minecraft Launcher.
  - Select the **Forge 1.16.4** profile.
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

## [1.0.0] - 2025-09-04
### Added
- Initial build.


[1.0.0]: https://github.com/jperluxo/jperluxo-mod-minecraft/releases/tag/1.0.0
</details>
