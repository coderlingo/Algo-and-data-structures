package ShortestPath.all_source;

import java.util.Arrays;

public class FloydWarshal {
    static int INF = 9999;
    public static void floydWarshal(int[][] graph, int n) {
        int[][] next = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(graph[i][j] != INF){
                    next[i][j] = j;
                }
            }
        }
        for(int k =0;k<n;k++) {
            for(int i = 0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(graph[i][j] > graph[i][k]+graph[k][j]) {
                        graph[i][j] = graph[i][k]+graph[k][j];
                        next[i][k] = j;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        int n = graph.length;
        floydWarshal(graph,n);
        for(int i=0;i<n;i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
