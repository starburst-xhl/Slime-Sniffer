package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Your Seed: ");
        long seed = scanner.nextLong();
        System.out.print("Input Your xRange(<4000): ");
        int x = scanner.nextInt();
        System.out.print("Input Your zRange(<4000): ");
        int z = scanner.nextInt();
        System.out.print("Output threshold: ");
        int threshold = scanner.nextInt();
        ChunkList chunkList = new ChunkList(-x,x,-z,z);
        for(int i = -x; i <= x; i++){
            for (int j = -z; j <= z; j++){
                chunkList.setChunks(i,j,CheckSlimeChunk.isSlimeChunk(seed,i,j));
            }
        }
        final Boolean[][] mat = new Boolean[][]{
                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,true ,true ,true ,true ,true ,false,false,false,false,false,false},
                {false,false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false},
                {false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false},
                {false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false},
                {false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false},
                {false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false},
                {false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false},
                {false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false},
                {false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false},
                {false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false},
                {false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false},
                {false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false},
                {false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false},
                {false,false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false},
                {false,false,false,false,false,false,true ,true ,true ,true ,true ,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};

        ArrayList<Ranking> rankings = new ArrayList<>();
        for(int i = -x; i <= x - 16; i++){
            for (int j = -z; j <= z - 16; j++){
                int sum = 0;
                for(int p = 0; p < 17; p++){
                    for (int q = 0; q < 17; q++){
                        if (chunkList.getChunks(i+p,j+q) && mat[p][q]){
                            sum += 1;
                        }
                    }
                }
                if(sum>threshold){
                    rankings.add(new Ranking(i + 8,j + 8,sum));
                }
            }
        }
        if (rankings.isEmpty()){
            System.out.println("None of the region has more than 35 slime chunks!");
        }else {
            Collections.sort(rankings);
            System.out.println("-------------------Ranking of the regions-------------------");
            System.out.printf("   %8s%16s%16s%20s\n","ranking","xPosition","zPosition","total slime chunks");
            for (Ranking ranking : rankings) {
                System.out.printf("%8d",rankings.indexOf(ranking) + 1);
                System.out.println(ranking);
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write("Seed: ");
            bw.write(String.valueOf(seed));
            bw.newLine();
            bw.write("xRange: ");
            bw.write(String.valueOf(x));
            bw.newLine();
            bw.write("zRange: ");
            bw.write(String.valueOf(z));
            bw.newLine();
            bw.write("-------------------Ranking of the regions-------------------");
            bw.newLine();
            bw.write(String.format("   %8s%16s%16s%20s","ranking","xPosition","zPosition","total slime chunks"));
            bw.newLine();
            for (Ranking ranking : rankings) {
                bw.write(String.format("%8d",rankings.indexOf(ranking) + 1));
                bw.write(ranking.toString());
                bw.newLine();
            }
            bw.close();
        }
    }
}