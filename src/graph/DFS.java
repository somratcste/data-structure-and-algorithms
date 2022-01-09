package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DFS {

    private int V;
    private LinkedList<Integer> adj[];

    DFS (int v) {
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge (int v, int e) {
        adj[v].add(e);
    }

    void DFSUtil(int source, boolean visited[]) {
        visited[source] = true;
        System.out.print(source + " ");

        Iterator<Integer> i = adj[source].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void traverse (int source) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i<V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.traverse(2);
    }
}
