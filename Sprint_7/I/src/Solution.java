import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //Scanner sc = new Scanner(System.in);
        String[] nAndM = reader.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        int v, w;
        String[] vAndW;

        for (int i = 0; i < m; i++) {
            vAndW = reader.readLine().split(" ");
            v = Integer.parseInt(vAndW[0]);
            w = Integer.parseInt(vAndW[1]);

            if (v != w){
                vertices[v-1].adj.add(w-1);
                vertices[w-1].adj.add(v-1);
            }
        }

        reader.close();


        int component_count = 0;

        for (int i = 0; i < n; i++) {
            if (vertices[i].color == -1){
                DFS(vertices, i, component_count);
                component_count++;
            }
        }

        ArrayList<Integer>[] arrayLists = new ArrayList[component_count];
        for (int i = 0; i < component_count; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            arrayLists[vertices[i].color].add(i);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        //System.out.println(component_count);
        writer.write(String.valueOf(component_count));
        writer.write("\n");

        for (int i = 0; i < component_count; i++) {
            for (Integer value: arrayLists[i]) {
                //System.out.print(value+1+" ");
                writer.write(String.valueOf(value+1));
                writer.write(" ");
            }
            //System.out.println();
            writer.write("\n");
        }

        writer.close();

    }

    public static void DFS(Vertex[] vertices, int start, int component_count){
        Vertex u = vertices[start];
        u.color = component_count;

        Iterator<Integer> iterator = u.adj.iterator();

        while (iterator.hasNext()){
            int v = iterator.next();
            if (vertices[v].color == -1){
                DFS(vertices, v, component_count);
            }
        }
    }
}
class Vertex{
    int num;
    int color = -1;
    TreeSet<Integer> adj = new TreeSet<>();

    public Vertex(int num) {
        this.num = num;
    }
}
