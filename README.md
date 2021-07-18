# Godot Android Plugins

## Make Godot more and more

## Introduce

When I make an Android Game with Godot engine, I need some features like analyze or payment,
but there are not has. So I will make it and share it.

## Godot Version

The plugins development with Godot 3.3 mono version. The submodule "godot-lib-3.3-xx" is 
Godot android build library from custom build template.

## How to use

1. run "gradle build" to compile and package all module;
1. copy plugins/<pluginName>/build/aar/<pluginName>-<debug|release>.aar
1. and copy plugins/<pluginName>/pluginName.gdap to godot custom build "plugins" folder
1. config in Godot export configuration and enable plugin
1. How to use some plugins? Read plugin README.