package utils;

import java.util.Arrays;

public class ChunkList{
    Boolean[][] chunks;
    int xMin;
    int xMax;
    int zMin;
    int zMax;
    public ChunkList(int xMin, int xMax, int zMin, int zMax) {
        chunks = new Boolean[xMax - xMin + 1][zMax - zMin + 1];
        this.xMin = xMin;
        this.xMax = xMax;
        this.zMin = zMin;
        this.zMax = zMax;
    }

    public void setChunks(int x, int z, boolean b) {
        chunks[x - xMin][z - zMin] = b;
    }

    public boolean getChunks(int x, int z) {
        return chunks[x - xMin][z - zMin];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(chunks);
    }
}
