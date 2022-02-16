# Simple Intellij plugin

This plugin adds inspection, that marks all imports in kotlin files as warnings. Most of the code is taken from the
JetBrains template, the only file that is interesting is SimpleInspection.kt. You can find the latest release in github releases.

## Bonus

In addition to the regular Intellij plugin this repo also contains .plugins folder in which you can
find [Flora](https://plugins.jetbrains.com/plugin/17669-flora-beta-/)* plugin. To use it you just need to put it in
.plugins folder of your project and install Flora plugin.

&ast; Flora is a cool plugin that was developed during the latest JetBrains Hackathon. It allows you to write simple
plugins in javascript/kotlin with hot reload, which provides for a faster development.