import java.util.Arrays;

public class UnionFind {
    public static int find(int[] parent, int a) {
        if(parent[a] == a) {
            return a;
        }
        return find(parent,parent[a]);
    }
    public static int union(int[] parent, int a, int b) {
        int pA = find(parent,a);
        int pB = find(parent,b);
        if(pA != pB) {
            parent[pA] = pB;
            return 1;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,1}};
        int n = 5;
        int[] parent = new int[n+1];
        for(int i = 1;i<=n;i++) {
            parent[i] = i;
        }
        boolean hasCycle = false;
        for(int[] edge : edges) {
            if(-1 == union(parent,edge[0],edge[1])) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle)
            System.out.println("The graph does not have any cycle");
        if(hasCycle)
            System.out.println("There is cycle in the graph");
    }
}
