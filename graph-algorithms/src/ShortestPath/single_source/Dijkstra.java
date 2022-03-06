package ShortestPath.single_source;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int n =4;
        int[][] edges = {{0,1,10},{1,3,15},{3,2,4},{2,0,6},{0,3,5}};
        List<int[]>[] graph = new LinkedList[n];
        for(int[] edge : edges) {
            if(graph[edge[0]] == null) {
                graph[edge[0]] = new LinkedList<>();
            }
            int[] e = new int[2];
            e[0] = edge[1];
            e[1] = edge[2];
            graph[edge[0]].add(e);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{0,0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(dist[cur[0]]<cur[1]) continue;
            for(int[] edge : graph[cur[0]]) {
                if(dist[edge[0]] > edge[1] + cur[1]){
                    dist[edge[0]] = edge[1]+cur[1];
                    pq.add(new int[]{edge[0],dist[edge[0]]});
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
