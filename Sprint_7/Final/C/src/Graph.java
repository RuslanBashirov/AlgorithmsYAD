/*
import java.util.*;
import java.lang.*;
import java.io.*;

public class Graph {
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return  compareEdge.weight - this.weight;
        }
    }

    // A class to represent a subset for
    // union-find
    class subset
    {
        int parent, rank;
    }

    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find set of an
    // element i (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent
                    = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets
    // of x and y (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)
        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as
            // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's
    // algorithm
    void KruskalMST()
    {
        // Tnis will store the resultant MST
        Edge result[] = new Edge[V];

        // An index variable, used for result[]
        int e = 0;

        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                //if (result[e].src == next_edge.src && result[e].dest != next_edge.dest) continue;

                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
*/
/*System.out.println(result[i].src + " -- "
                    + result[i].dest
                    + " == " + result[i].weight);*//*
*/
/*

            minimumCost += result[i].weight;
        }
        if (e < V - 1) System.out.println("Oops! I did it again");
        else System.out.println(minimumCost);
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] all_edges_string_array = reader.readLine().split(" ");
        final int n = Integer.parseInt(all_edges_string_array[0]);
        final int m = Integer.parseInt(all_edges_string_array[1]);
        if (m < n - 1) {
            System.out.println("Oops! I did it again");
            return;
        }
        Graph graph = new Graph(n, m);

        int v1, v2, w;

        for (int i = 0; i < m; i++) {
            all_edges_string_array = reader.readLine().split(" ");
            v1 = Integer.parseInt(all_edges_string_array[0]) - 1;
            v2 = Integer.parseInt(all_edges_string_array[1]) - 1;
            w = Integer.parseInt(all_edges_string_array[2]);

            if (v1 != v2){
                    graph.edge[i].src = v1;
                    graph.edge[i].dest = v2;
                    graph.edge[i].weight = w;
            }
        }
        // Function call
        graph.KruskalMST();
    }
}
*/

