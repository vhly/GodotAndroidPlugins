# Godot Android Plugin: Flurry Analyze

## Introduce

Godot Android plugin with Flurry SDK

## Usage

1. copy plugin aar file Debug or Release
1. and .gdap configuration file to godot project android custom build folder
1. this plugin with Android mini sdk 19
1. update the custom build android config.gradle file to minSDK 19
1. set godot export config, enable plugin flurry and update godot code

## Godot code: Get Plugin Instance

gdscript:

````gdscript
# class field or method local varible
var flurry = null

if Engine.has_singleton("ZCFlurry"):
    flurry = Engine.get_singleton("ZCFlurry")
    # First invoke this "initSDK" function once.
    #     flurryAppKey replace your Flurry app key
    flurry.initSDK("flurryAppKey", "channel")

# send event

if flurry != null:
    flurry.sendEvent(
````