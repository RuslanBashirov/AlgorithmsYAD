/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static int minus_inf = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] all_edges_string_array = reader.readLine().split(" ");
        final int n = Integer.parseInt(all_edges_string_array[0]);
        final int m = Integer.parseInt(all_edges_string_array[1]);
        int v1, v2, w;
        int V = n;
        int[] parent = new int[V];
        int weight[][] = new int[n][n];

        for (int i = 0; i < m; i++) {
            all_edges_string_array = reader.readLine().split(" ");
            v1 = Integer.parseInt(all_edges_string_array[0]) - 1;
            v2 = Integer.parseInt(all_edges_string_array[1]) - 1;
            w = Integer.parseInt(all_edges_string_array[2]);

            if (v1 != v2){
                if  (w > weight[v1][v2]) {
                    weight[v1][v2] = w;
                    weight[v2][v1] = w;
                }
            }
        }

        myKruskal(weight, parent, V);
    }

    public static int find(int i, int[] parent)
    {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    public static boolean union(int i, int j, int[] parent)
    {
        int a = find(i, parent);
        int b = find(j, parent);
        if (a != b) {
            parent[a] = b;
            return true;
        }
        else return false;
    }

    public static void myKruskal(int weight[][], int[] parent, int V)
    {
        int maxcost = 0;

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int edge_count = 0;
        while (edge_count < V - 1) {
            int min = minus_inf, a = -1, b = -1;

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (find(i, parent) != find(j, parent) && weight[i][j] > min) {
                        min = weight[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            if (union(a, b, parent)) edge_count++;

            maxcost += min;
        }
        if (edge_count < V-1) System.out.println("Oops! I did it again");
        else System.out.println(maxcost);
    }

} */
