package ShortestPath.single_source;

import java.util.Arrays;

public class BellmanFord {
    // for directed graphs only. For undirected graphs with -ve edges, it will always find -ve cycles
    public static void main(String[] args) {
         int[][] edges = {{0,1,10},{1,3,15},{3,2,4},{2,0,6},{0,3,5}};
        //int[][] edges = {{0,1,10},{1,3,15},{3,2,4},{2,0,-10},{0,3,5}};
        int n = 4;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // source is 0 vertex.
        dist[0] = 0;
        for(int i=0;i<n-1;i++) {
            for(int[] edge : edges) {
                if(dist[edge[0]]!= Integer.MAX_VALUE && ((dist[edge[0]] + edge[2]) < dist[edge[1]])) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }
        boolean hasCycle = false;
        for(int[] edge : edges) {
            if(dist[edge[0]]!= Integer.MAX_VALUE && ((dist[edge[0]] + edge[2]) < dist[edge[1]])) {
                hasCycle = true;
            }
        }
        if(hasCycle) {
            System.out.println("The graph has cycle");
        } else {
            System.out.println(Arrays.toString(dist));
        }
    }
}
