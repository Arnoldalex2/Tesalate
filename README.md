# Tesalate — Oxygen Customizer system icon pack starter

**Pack:** Tesalate  
**Author:** aa  
**Package ID:** `com.aa.tesalate`  
**Design:** mixed bold filled and outline details, lightly futuristic, electric cyan inset and subtle dark shadow/ridge.

## Important: starter and verification scope

This is a **source project**, not an already-compiled APK. Its XML structure follows the Oxygen Customizer icon-pack discovery protocol and the `DHD2280/OCIconPackTemplate` reference. It has **not been compiled on a real Android toolchain or tested on the user's OxygenOS 16 device**.

- Built-in Oxygen Customizer icon styles use a different overlay mechanism from the Mods > Icon packs screen.
- This starter registers the `it.dhd.oxygencustomizer.iconpack` intent and two string-array maps required for Mods > Icon packs.
- System resource names are device/build specific. **Do not assume all mappings take effect.** The names `android:ic_wifi_signal_0` (from official template) and `stat_sys_data_bluetooth`, `stat_sys_airplane_mode`, `stat_signal_wifi_signal_3`, `stat_signal_signal_lte_single_3` (referenced in Oxygen Customizer source) are reference candidates, not proof those names are drawable IDs used on this particular device.
- **Battery:** modern OxygenOS may draw battery with a custom status bar view instead of using one drawable. Even if `stat_sys_battery` maps, the status bar battery icon may not change. Dynamic battery charge/level-list support must be verified on device.
- The included Wi-Fi, signal, and battery vectors are an initial style/test set. Some are deliberately conservative.
- The source XML is not system-image modification and the ZIP itself does not need root. Oxygen Customizer requires its own root/LSPosed configuration.

## Files

- `app/build.gradle.kts` — package `com.aa.tesalate`, API 35 configuration.
- `app/src/main/AndroidManifest.xml` — APK name/author + Intent that allows Oxygen Customizer to discover this installed pack.
- `app/src/main/res/values/arrays.xml` — original drawable resource names paired with Tesalate replacements.
- `app/src/main/res/drawable/` — Wi-Fi levels 0–4, cellular signal levels 0–4, battery level lists including charging states, Bluetooth, airplane mode.
- `.github/workflows/build-apk.yml` — builds with GitHub Actions.

## Build using GitHub Actions

1. Create a GitHub repository (e.g. `Tesalate`) and upload/extract this project's contents **at the repository root**. Keep `.github/workflows/build-apk.yml` (the hidden `.github` directory) intact.
2. In GitHub open **Actions > Build Tesalate APK > Run workflow** (or push to `main`).
3. When complete, open that workflow run and download the **Tesalate-APK** artifact.
4. Extract the artifact ZIP. Install `app-debug.apk` on the OnePlus 13.
5. Open Oxygen Customizer > **Mods > Icon packs**. Look for `Tesalate`. Enable it and check actual effects.
6. If the app shows but icons do not change, get **exact resource names** from your phone's real `SystemUI.apk` and framework resources, then edit the left side of `arrays.xml` and rebuild.

The debug APK is signed by the build's debug key. If reinstalling from a new GitHub Actions runner causes a signature mismatch, uninstall the old Tesalate app first (not Oxygen Customizer), then install the new debug APK. For stable upgrades/signatures eventually add a proper private release-signing workflow.

## Validate resource names with ADB

```sh
adb devices
adb shell pm path com.android.systemui
adb shell pm path android
adb shell pm path com.android.settings
```

Run `adb pull <actual-path> <local-filename>` using each relevant result. Do not blindly guess file paths. Inspect with `aapt2 dump resources`, `apktool` or Android Studio's APK Analyzer to identify drawable resource names and state dependencies. Do not overwrite your installed SystemUI APK.

## Design note

SystemUI sometimes automatically tints vector icons. Shadows, accent colors and dual-tone shapes may therefore become monochrome; test on phone before investing in more gradients/shading.

## Reference

- Official template: https://github.com/DHD2280/OCIconPackTemplate
- Oxygen Customizer: https://github.com/DHD2280/Oxygen-Customizer
