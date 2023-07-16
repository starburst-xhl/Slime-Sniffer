# slime-chunk-finder-for-xhl
A simple Java program for finding the 17 by 17 region which has as many slime chunks as possible.

这是我的“Minecraft空置域史莱姆区块助手”的自述文件，它是一个用Java编写的小程序，可以帮助你在空置域中找到最佳的史莱姆区块。这是一个初级版本，功能有限，但我会不断改进和更新。

这个程序的原理是按圆形匹配指定区域内的史莱姆区块，并找到史莱姆区块最多的圆形区域。这样你就可以在这个区域内建造你的史莱姆农场，收集大量的史莱姆球。我参考了minecraft Wiki的源代码，感谢他们提供了史莱姆区块的生成算法。

使用方法很简单，只需要修改源代码中的x和z两个变量，以修改查找范围（不要超过2000，否则会影响效率），然后运行Main类即可。程序会输出圆形区域的中心坐标，以及该区域内的史莱姆区块数量。你可以根据这些信息在游戏中找到对应的位置，并开始建造你的史莱姆农场。

希望你喜欢这个程序，如果你有任何建议或反馈，请联系我。谢谢！

This is the README file for my "Minecraft Void Realm Slime Chunk Helper", a small program written in Java that can help you find the best slime chunks in the void realm. This is a preliminary version, with limited functionality, but I will keep improving and updating it.

The principle of this program is to match the slime chunks in a specified area by a circle, and find the circular area with the most slime chunks. This way you can build your slime farm in this area, and collect a lot of slime balls. I referred to the source code of minecraft Wiki, and I thank them for providing the generation algorithm of slime chunks.

The usage is very simple, you just need to modify the x and z variables in the source code, to change the search range (do not exceed 2000, otherwise it will affect the efficiency), and then run the Main class. The program will output the center coordinates, as well as the number of slime chunks in that area. You can use this information to find the corresponding location in the game, and start building your slime farm.

I hope you like this program, if you have any suggestions or feedback, please contact me. Thank you!

<div align="center"> <img src="./ReadmeSrc/Img_chunkpair.png" width = 500 height = 500 /> </div>
<div style="text-align: center;">pair region</div>