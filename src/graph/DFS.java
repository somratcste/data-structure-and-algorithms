package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DFS {

    private int V; // number of vertices
    private LinkedList<Integer> adj[];

    DFS (int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil (int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        // recursion for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // function to do for dfs traversal - uses recursive DFSUtil() method
    void traverse (int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
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
