import java.io.*;

import java.util.TreeSet;

public class Solution {
    public static int[] tin;
    public static int[] tout;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //Scanner sc = new Scanner(System.in);
        String[] twoVal = reader.readLine().split(" ");
        int n = Integer.parseInt(twoVal[0]);
        int m = Integer.parseInt(twoVal[1]);

        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        int v,w;

        tin = new int[n];
        tout = new int[n];

        for (int i = 0; i < m; i++) {
            twoVal = reader.readLine().split(" ");
            v = Integer.parseInt(twoVal[0]);
            w = Integer.parseInt(twoVal[1]);

            if (v != w){
                vertices[v-1].adj.add(w-1);
            }
        }

        reader.close();

        DFS(vertices, 0, 0);

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < n; i++) {
            writer.append(String.valueOf(tin[i])).append(' ').append(String.valueOf(tout[i])).append('\n');
            /*writer.write(" ");
            writer.write(String.valueOf(tout[i]));
            writer.write("\n");*/
        }

        writer.close();
    }

    public static int DFS(Vertex[] vertices, int start, int t){
        Vertex u = vertices[start];
        u.color = 'g';
        tin[start] = t;

        for (int v: u.adj){
            if (vertices[v].color == 'w'){
                t++;
                t = DFS(vertices, v, t);
            }
        }

        t++;
        tout[start] = t;
        return t;
    }
}
class Vertex{
    int num;
    char color = 'w';
    TreeSet<Integer> adj = new TreeSet<>();

    public Vertex(int num) {
        this.num = num;
    }
}