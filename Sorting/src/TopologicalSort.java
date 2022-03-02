import java.util.*;

public class TopologicalSort {
    public static void topologicalSort(List<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int i = 1;i<graph.length;i++) {
            if(visited[i] == 0) {
                ret =sort(graph, i, stack,visited);
                if(ret == -1) {
                    break;
                }
            }
        }
        if(ret!=-1) {
            while(!stack.isEmpty()) {
                System.out.print(stack.peek()+", ");
                stack.pop();

            }
        }
    }
    public static int  sort(List<Integer>[] graph, int v, Stack<Integer> stack, int[] visited) {
        visited[v] = 1;
        List<Integer> adj = graph[v];
        if(adj == null) {
            visited[v] = 2;
            stack.add(v);
            return 1;
         }
        for(int i : adj) {
            if(visited[i]==1) {
                System.out.println("Not a DAG");
                return -1;
            }
            if(visited[i]!=2) {
                int ret = sort(graph, i, stack, visited);
                if (ret == -1) {
                    return -1;
                }
            }
        }
        stack.add(v);
        visited[v] = 2;
        return  1;
    }
    public static void main(String[] args) {
        // Can only be done on a DAG
        int[][] edges = {{1,2},{1,3},{1,4},{3,4},{4,2},{2,5},{4,5},{4,6},{4,7},{3,7},{5,6},{7,6}};
        List<Integer>[] graph = new LinkedList[8];
        for(int i = 0;i<edges.length;i++) {
            if(graph[edges[i][0]] == null) {
                graph[edges[i][0]] = new LinkedList<>();
            }
            graph[edges[i][0]].add(edges[i][1]);
        }
        topologicalSort(graph);
    }
}
