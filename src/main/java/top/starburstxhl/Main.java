package top.starburstxhl;

import java.util.ArrayList;
import java.util.Collections;



public class Main {
    public static void main(String[] args) {
        long seed = -3248040441770110058L;
        int x = 1250;
        int z = 1250;
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
                    rankings.add(new Ranking(i,j,sum));
                }
            }
        }
        Collections.sort(rankings);
        for (Ranking ranking : rankings) {
            System.out.println(ranking);
        }
    }
}