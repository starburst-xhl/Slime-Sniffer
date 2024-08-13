package utils;

import java.util.Random;

public class CheckSlimeChunk {
    public static boolean isSlimeChunk(long seed, int xPosition, int zPosition) {
        Random rnd = new Random(
                seed +
                        (int) (xPosition * xPosition * 0x4c1906) +
                        (int) (xPosition * 0x5ac0db) +
                        (int) (zPosition * zPosition) * 0x4307a7L +
                        (int) (zPosition * 0x5f24f) ^ 0x3ad8025fL
        );
        return rnd.nextInt(10) == 0;
    }
}