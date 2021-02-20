
import java.lang.*;
import java.io.*;

public class MST {
    // Number of vertices in the graph
    private int V;

    public MST(int n) {
        V = n;
    }

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MIN_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] > min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int graph[][])
    {
        int sum = 0;

        for (int i = 1; i < V; i++)
            sum += graph[i][parent[i]];

        System.out.println(sum);
    }

    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    void primMST(int graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];

        // To represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MIN_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        int counter = 0;
        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);
            if (u == -1){
                System.out.println("Oops! I did it again");
                return;
            }

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] > key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                    counter++;
                }
        }

        /*if (counter-1 != V-1){
            System.out.println("Oops! I did it again");
            return;
        }*/
        // print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] all_edges_string_array = reader.readLine().split(" ");
        final int n = Integer.parseInt(all_edges_string_array[0]);
        final int m = Integer.parseInt(all_edges_string_array[1]);
        if (m < n - 1) {
            System.out.println("Oops! I did it again");
            return;
        }
        int graph[][] = new int[n][n];

        int v1, v2, w;

        for (int i = 0; i < m; i++) {
            all_edges_string_array = reader.readLine().split(" ");
            v1 = Integer.parseInt(all_edges_string_array[0]) - 1;
            v2 = Integer.parseInt(all_edges_string_array[1]) - 1;
            w = Integer.parseInt(all_edges_string_array[2]);

            if (v1 != v2){
                graph[v1][v2] = w;
                graph[v2][v1] = w;
            }
        }


        MST t = new MST(n);


        // Print the solution
        t.primMST(graph);
    }
}

