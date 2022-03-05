package MST;

import java.util.*;

public class Kruskals {
    public static int find(int a, int[] parent) {
        if(parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a], parent);
        return parent[a];
    }
    public static void union(int[] parent, int[] rank, int a, int b) {
        if(rank[a] > rank[b]) {
            parent[b] = a;
        } else if(rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[a] = b;
            rank[b] ++;
        }
    }
    public static void kruskal(List<int[]> mst, int[][] edges, int[] parent, int[] rank) {
        for(int[] edge : edges) {
            int p1 = find(edge[0], parent);
            int p2 = find(edge[1], parent);
            if(p1!=p2) {
                mst.add(edge);
                union(parent,rank,p1,p2);
            }
        }
    }
    public static void main (String[] args) {
        int[][] edges = {{0,1,10},{1,3,15},{3,2,4},{2,0,6},{0,3,5}};
        int n = 5;
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i =0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        List<int[]> mst = new LinkedList<>();
        kruskal(mst,edges,parent,rank);
        mst.stream().forEach(e->System.out.println(e[0]+" "+e[1]+"\n"));

    }
}
