package utils;

public class Ranking implements Comparable<Ranking>{
    final private int xp;
    final private int zp;
    final private int sum;

    public Ranking(int xp, int zp, int sum) {
        this.xp = xp;
        this.zp = zp;
        this.sum = sum;
    }

    public int getXp() {
        return xp;
    }

    public int getZp() {
        return zp;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public int compareTo(Ranking o) {
        return o.getSum()-this.getSum();
    }

    @Override
    public String toString() {
        return String.format("%16d%16d%20d",xp,zp,sum);
    }
}
