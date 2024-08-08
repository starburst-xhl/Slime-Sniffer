package utils

class Sniffer(seed: Long, xMax: Int, zMax: Int) {
    private val chunkList = SlimeChunkList(-xMax, xMax, -zMax, zMax)
    private val ranking = mutableListOf<Ranking>()

    init {
        chunkList.initChunks(seed)
    }

    private fun isSlimeChunk(x: Int, z: Int): Boolean? {
        return chunkList.getChunk(x, z)
    }

    fun sniff(xPosMax: Int, zPosMax: Int): String {
        for (i in -xPosMax + 8..xPosMax - 8) {
            for (j in -zPosMax + 8..zPosMax - 8) {
                var sum = 0
                for (k in -8..8) {
                    for (l in -8..8) {
                        if (isSlimeChunk(i + k, j + l) == true) {
                            sum++
                        }
                    }
                }
                ranking.add(Ranking(i, j, sum))
            }
        }
        ranking.sort()
        val sb = StringBuilder()
        sb.append("-------------------Ranking of the regions-------------------\n")
        sb.append(String.format("   %8s%16s%16s%20s\n", "ranking", "xPosition", "zPosition", "total slime chunks"))
        for (i in 0 until 10) {
            sb.append(String.format("%8d", i + 1))
            sb.append(ranking[i].toString()).append("\n")
        }
        return sb.toString()
    }
}

private class SlimeChunkList(var xMin: Int, var xMax: Int, var zMin: Int, var zMax: Int) {
    private var chunks: Array<Array<Boolean?>> = Array(xMax - xMin + 1) { arrayOfNulls(zMax - zMin + 1) }
    fun initChunks(seed: Long) {
        for (i in 0 until xMax - xMin + 1) {
            for (j in 0 until zMax - zMin + 1) {
                chunks[i][j] = CheckSlimeChunk.isSlimeChunk(seed, i + xMin, j + zMin)
            }
        }
    }

    fun getChunk(x: Int, z: Int): Boolean? {
        return chunks[x - xMin][z - zMin]
    }
}

private class Ranking(val xp: Int, val zp: Int, val sum: Int) : Comparable<Ranking> {
    override fun compareTo(other: Ranking): Int {
        return other.sum - this.sum
    }

    override fun toString(): String {
        return String.format("%16d%16d%20d", xp, zp, sum)
    }
}