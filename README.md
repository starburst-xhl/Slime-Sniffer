# slime-chunk-finder-for-xhl

**English** | [中文](https://github.com/starburst-xhl/slime-chunk-finder-for-xhl/blob/main/README_zh-cn.md)

## Simple introduction

This is the README file for my "Minecraft Void Realm Slime Chunk Helper", a simple Java program for finding the round mob-spawnable region which has as many slime chunks as possible. This is a preliminary version, with limited functionality, but I will keep improving and updating it.

## What is this program about to do

The principle of this program is to match the slime chunks in a specified area by a circle, and find the circular area with the most slime chunks. This way you can build your slime farm in this area, and collect a lot of slime balls. I referred to the source code of minecraft Wiki, and I thank them for providing the generation algorithm of slime chunks. The image below shows the match pattern, the black squares indicate chunks that will be matched, while the other squares will be ignored.

<div align=center><img src="./ReadmeSrc/Img_chunkpair.png" width=200 height=200 alt="match pattern"></div>

## How to use

You should install Java previusly(Probably you have already installed java in order to run Minecraft Java Edition), then run command below using Powershell(Windows) or Bash(Linux) in the directory where the jar file is located.

```
java -jar ./SlimeChunkFinderForXHL.jar
```
Input your seed and search range, the program will output the ranking of detected regions.

## Problem

The program couldn't exclude deep dark biome, please check beforehand.


I hope you like this program, if you have any suggestions or feedback, please contact me. Thank you!


