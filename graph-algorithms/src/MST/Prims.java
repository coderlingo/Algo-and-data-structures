package MST;

import java.util.Arrays;

public class Prims {
    public static void main(String[] args) {
        // n*n matrix of vertices and edge weights
        // complexity of this approach in O(V^2) but we can improve it to O(ElogV) if we store the edges in adj list
        // and use heap to get the next vertex.
        int[][] graph =
                       {{Integer.MAX_VALUE,10,6,5},
                        {10,Integer.MAX_VALUE,Integer.MAX_VALUE,15},
                        {6,Integer.MAX_VALUE,Integer.MAX_VALUE,4},
                        {5,15,4,Integer.MAX_VALUE}};
        int n = 4;
        boolean[] inMst = new boolean[n];
        Arrays.fill(inMst,false);
        int[][] curWeights = new int[n][2];
        for(int i = 0;i<n;i++) {
            curWeights[i][0] = Integer.MAX_VALUE;
            curWeights[i][1] = i;
        }
        curWeights[0][0]=0;
        int min = 0;
        int minIdx = 0;
        int count = 0;
        while(count <n) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (min > curWeights[i][0] && inMst[i] == false) {
                    minIdx = i;
                    min = curWeights[i][0];
                }
            }
            inMst[minIdx] = true;
            System.out.println(minIdx+" "+curWeights[minIdx][1]);
            for(int i=0;i<n;i++) {
                if(curWeights[i][0]>graph[minIdx][i]) {
                    curWeights[i][0] = graph[minIdx][i];
                    curWeights[i][1] = minIdx;
                }
            }
            count++;
        }
    }
}
