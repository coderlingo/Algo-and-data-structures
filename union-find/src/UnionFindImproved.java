import java.util.Arrays;

public class UnionFindImproved {
    public static int find(int[] parent, int a) {
        if(parent[a] !=a) {
            parent[a] = find(parent,parent[a]);
            return parent[a];
        } else
            return a;
    }
    public static int union(int[] parent,int[] rank, int a, int b) {
        int pA = find(parent, a);
        int pB = find(parent, b);
        if(pA!=pB) {
            if(rank[pA] < rank[pB]) {
                parent[a] = pB;
            }
            else if(rank[pA] > rank[pB]) {
                parent[b] = pA;
            } else {
                parent[a] = pB;
                rank[pB]++;
            }
            return 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,5}};
        int n = 6;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 1;i<n;i++) {
            parent[i] = i;
        }
        Arrays.fill(rank,0);
        boolean hasCycle = false;
        for(int[] edge : edges) {
            if(-1 == union(parent,rank,edge[0],edge[1])) {
                hasCycle = true;
                break;
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(rank));
        if(hasCycle)
            System.out.println("The graph has cycle");
        else
            System.out.println("The graph does not have any cycle");
    }
}
