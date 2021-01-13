import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
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

        for (int i = 0; i < m; i++) {
            twoVal = reader.readLine().split(" ");

            v = Integer.parseInt(twoVal[0]);
            w = Integer.parseInt(twoVal[1]);

            if (v != w){
                vertices[v-1].adj.add(w-1);
            }
        }

        reader.close();

        Stack<Integer> topol_sorted = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (vertices[i].color == 'w'){
                DFS(vertices, i, topol_sorted);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < n; i++) {
            writer.write(String.valueOf(topol_sorted.pop()+1));
            writer.write(" ");
        }

        writer.close();

    }

    public static void DFS(Vertex[] vertices, int start, Stack<Integer> topol_sorted){
        Vertex u = vertices[start];
        u.color = 'g';

        for(int v: u.adj){
            if (vertices[v].color == 'w'){
                DFS(vertices, v, topol_sorted);
            }
        }

        u.color = 'b';
        topol_sorted.push(u.num);
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
