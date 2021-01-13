import java.io.*;
import java.util.ArrayList;
//import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //Scanner sc = new Scanner(System.in);
        String[] twoVal = reader.readLine().split(" ");

        int n = Integer.parseInt(twoVal[0]);
        int m = Integer.parseInt(twoVal[1]);

        /*if (n == 1){
            System.out.println("YES");
            return;
        }

        if (m < n){
            System.out.println("NO");
            return;
        }*/

        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);

        int v,w;

        for (int i = 0; i < m; i++) {
            twoVal = reader.readLine().split(" ");
            v = Integer.parseInt(twoVal[0]);
            w = Integer.parseInt(twoVal[1]);

            vertices[v - 1].adj.add(w-1);
        }

        reader.close();

        int visitedVertexes = 0;

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < n; i++) {
            if (DFS(vertices, i, visitedVertexes) != n){
                writer.write("NO");
                writer.close();
                return;
            }

            visitedVertexes = 0;

            for (int j = 0; j < n; j++)
                vertices[j].color = 'w';
        }
        writer.write("YES");

        writer.close();
    }

    public static int DFS(Vertex[] vertices, int start, int visitedVertexes){
        Vertex u = vertices[start];
        u.color = 'g';
        visitedVertexes++;

        for (int v : u.adj) {
            if (vertices[v].color == 'w')
                visitedVertexes = DFS(vertices, v, visitedVertexes);
        }

        return visitedVertexes;
    }
}

class Vertex{
    int num;
    char color = 'w';
    ArrayList<Integer> adj = new ArrayList<>();

    public Vertex(int num) {
        this.num = num;
    }
}
