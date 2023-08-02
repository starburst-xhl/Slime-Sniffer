# slime-chunk-finder-for-xhl

**English** | [中文](https://github.com/starburst-xhl/slime-chunk-finder-for-xhl/blob/main/README_zh-cn.md)

## Introduction

This is the README file for a simple Java program for finding the round mob-spawnable region which has as many slime chunks as possible. This is a preliminary version, with limited functionality, but I will keep improving and updating it.

## Principle

The principle of this program is to match the slime chunks in a specified area by a circle, and find the circular area with the most slime chunks. This way you can build your slime farm in this area, and collect a lot of slime balls. I referred to the source code of minecraft Wiki, and I thank them for providing the generation algorithm of slime chunks. The image below shows the match pattern, the black squares indicate chunks that will be matched, while the other squares will be ignored.

<div align=center><img src="./ReadmeSrc/Img_chunkpair.png" width=200 height=200 alt="match pattern"></div>

## How to use

You should install Java previusly(Probably you have already installed java in order to run Minecraft Java Edition), then run command below using Powershell(Windows) or Bash(Linux) in the directory where the jar file is located.

```
java -jar ./SlimeChunkFinderForXHL.jar
```
Input your seed and search range, the program will output the ranking of detected regions.Note that the output is the block coordinates of the center of the region (the actual coordinates need to be multiplied by 16).
```
Input Your Seed: 3425
Input Your xPosition: 1000
Input Your zPosition: 1000
-------------------Ranking of the regions-------------------
    ranking       xPosition       zPosition  total slime chunks
       1            -709            -474                  41
       2            -711            -474                  40
       3             682             -12                  39
       4            -711            -475                  38
       5            -711            -473                  38
       6            -710            -475                  38
...
```
## Problem

The program couldn't exclude deep dark biome, please check beforehand.

In order to reduce outputs,the program will only output the region whitch contains more than 35 slime chunks.

The program supports game version 1.18+.

### I hope you like this program, if you have any suggestions or feedback, please contact me. Thank you!


