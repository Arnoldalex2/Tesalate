# Tesalate v0.3 — Electric Facet Expanded

Pack by **aa**, built for **Oxygen Customizer** on OnePlus/OxygenOS 16.

Based on Tesalate v0.2, with the **Bluetooth XML preserved byte-for-byte**.

## What's new

- 116 SystemUI drawable names matched in the user-supplied `System_UI_(16.99.12).apk`.
- 85 Settings drawable names matched in `Settings_(16.0.0).apk`.
- Two selectable packs in **one APK**: **Tesalate — SystemUI**, and **Tesalate — Settings**.
- Expanded signal, Wi-Fi, no-internet Wi-Fi, alarm, VPN, NFC, location, hotspot, sound, privacy, settings, and other icons.
- Added dimensional Electric Facet vectors with electric blue edges, dark shadows, and icy highlights.
- Saved detailed original-to-replacement matches in `RESOURCE_AUDIT.txt`.
- Left animated Quick Settings tiles largely alone to avoid breaking state transitions.

## Build

Upload all project files and directories (including `.github`) to the root of [your Tesalate repository](https://github.com/Arnoldalex2/Tesalate) on GitHub. Note: **a ZIP itself is not a working GitHub project upload**—extract and commit the contents. Do not mix old and new mappings.

GitHub Actions → `Build Tesalate v0.3 APK` → Run workflow (or push to `main`). Download the `Tesalate-APK` artifact. Install it over the previous version if the same signing key is used. Because GitHub-hosted debug keys can change between runners, you may need to uninstall the older Tesalate application APK before installing this new test APK (do not uninstall Oxygen Customizer). Then open Oxygen Customizer → Mods → Icon packs and enable one of the Tesalate packs.

## Important limits

- **Not compiled or tested on a phone.** XML and mapping names are checked, but we cannot guarantee every icon will show or that Android resource compilation will succeed until the workflow runs.
- **Battery is experimental**: Android/OxygenOS 16 draws several battery modes with composite/progress components; a `stat_battery` drawable mapping might not affect your actual displayed battery percentage/icon. Your screenshot showed a customized battery already. The `framework-res.apk` (actual Android framework file, not the uploaded small overlay) would allow further investigation.
- Some Wi-Fi and cellular indicators are stateful composite assets. Versions badges (Wi-Fi 6/7; LTE/5G) are left unmodified rather than replaced with misleading plain glyphs.
- **Don't enable all replacements at once initially** on a rooted device. Test Status Pack, confirm stable, then optionally Settings pack. An abnormal SystemUI crash can be recovered by disabling Oxygen Customizer's Xposed/LSPosed module and rebooting.
- Original resource file existence isn't sufficient to ensure an Xposed `Resources.getDrawable` hook is used at every UI location.

Author: aa — Tesalate v0.3
