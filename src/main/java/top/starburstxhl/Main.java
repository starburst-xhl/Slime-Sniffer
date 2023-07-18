package top.starburstxhl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Your Seed: ");
        long seed = scanner.nextLong();
        System.out.print("Input Your xPosition: ");
        int x = scanner.nextInt();
        System.out.print("Input Your zPosition: ");
        int z = scanner.nextInt();
        ChunkList chunkList = new ChunkList(-x,x,-z,z);
        for(int i = -x; i <= x; i++){
            for (int j = -z; j <= z; j++){
                chunkList.setChunks(i,j,CheckSlimeChunk.isSlimeChunk(seed,i,j));
            }
        }
        Boolean[][] mat = new Boolean[][]{
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
                if(sum>35){
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
        }
    }
}