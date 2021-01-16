import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        ///--------------READING SECTOR--------------------------
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //Scanner sc = new Scanner(System.in);
        String[] twoVal = reader.readLine().split(" ");

        int n = Integer.parseInt(twoVal[0]);
        int m = Integer.parseInt(twoVal[1]);

        int[] order_array = new int[n];

        Vertex[] vertices = new Vertex[n];
        Vertex[] transposed_vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
            transposed_vertices[i] = new Vertex(i);
        }

        int v, w;

        for (int i = 0; i < m; i++) {
            twoVal = reader.readLine().split(" ");

            v = Integer.parseInt(twoVal[0]);
            w = Integer.parseInt(twoVal[1]);

            if (v != w){
                vertices[v-1].adj.add(w-1);
                transposed_vertices[w-1].adj.add(v-1);
            }
        }
        reader.close();
        //--------READING SECTOR CLOSES-------------------------


        //--------DRIVER SECTOR--------------------------------------------------------
        int order = 0;
        boolean[] visited = new boolean[n];

        //traverse graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                order = DFS_order(transposed_vertices, i, order_array, order, visited);
            }
        }

        Arrays.fill(visited, false);

        int component = 0;

        for (int i = n-1; i >= 0; i--) {
            if (!visited[order_array[i]]) {
                DFS(vertices, order_array[i], component, visited);
                component++;
            }
        }

        ArrayList<Integer>[] components_alist = new ArrayList[component];

        for (int i = 0; i < component; i++) {
            components_alist[i] = new ArrayList<>();
        }

        ArrayList<Integer> component_ascending_order = new ArrayList<>(component);

        for (int i = 0; i < n; i++) {
            if (component_ascending_order.size() == component) break;
            if(!component_ascending_order.contains(vertices[i].component))
                component_ascending_order.add(vertices[i].component);
        }

        for (int i = 0; i < n; i++) {
            components_alist[vertices[i].component].add(i);
        }
        //------------DRIVER SECTOR CLOSES------------------------------------------------------


        //------------WRITING SECTOR------------------------------------------------------------
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        writer.write(String.valueOf(component));
        writer.write("\n");

        for (int i: component_ascending_order) {
            for (int val: components_alist[i]){
                writer.write(String.valueOf(val+1));
                writer.write(" ");
            }
            writer.write("\n");
        }
        writer.close();
        //--------------WRITING SECTOR CLOSES--------------------------------------------------------
    }



    public static int DFS_order(Vertex[] vertices, int start, int[] order_array, int order, boolean[] visited){
        Vertex u = vertices[start];
        visited[start] = true;

        for (int v : u.adj) {
            if (!visited[v]) {
                order = DFS_order(vertices, v, order_array, order, visited);
            }
        }

        order_array[order] = start;
        order++;

        return order;
    }

    public static void DFS(Vertex[] vertices, int start, int component, boolean[] visited){
        Vertex u = vertices[start];
        u.component = component;
        visited[start] = true;

        for (int v : u.adj) {
            if (!visited[v]) {
                DFS(vertices, v, component, visited);
            }
        }
    }
}

class Vertex{
    int num;
    int component = -1;
    ArrayList<Integer> adj = new ArrayList<>();

    public Vertex(int num) {
        this.num = num;
    }
}

/*TESTS FROM PRESENTATION
        10 12
        3 2
        2 5
        5 4
        4 3
        6 5
        8 6
        7 8
        0 7
        0 1
        1 2
        5 9
        9 6*/
