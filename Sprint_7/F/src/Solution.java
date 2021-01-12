import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
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

            if (v != w) {
                vertices[v-1].adj.add(w-1);
                vertices[w-1].adj.add(v-1);
            }
        }

        String[] startAndFinish = reader.readLine().split(" ");
        reader.close();

        int start = Integer.parseInt(startAndFinish[0]);
        int finish = Integer.parseInt(startAndFinish[1]);

        BFS(vertices, start-1, finish-1);

        System.out.println(vertices[finish-1].dist);


    }

    public static void BFS(Vertex[] vertices, int start, int finish){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        vertices[start].color = 'g';
        vertices[start].dist = 0;

        while (!queue.isEmpty()){
            Vertex u = vertices[queue.poll()];

            for (Integer integer : u.adj) {
                Vertex v = vertices[integer];
                if (v.color == 'w') {
                    v.color = 'g';
                    v.dist = u.dist + 1;
                    if (integer == finish) return;
                    queue.add(integer);
                }
            }

            u.color = 'b';
        }
    }
}

class Vertex{
    int num;
    char color = 'w';
    int dist = -1;
    ArrayList<Integer> adj = new ArrayList<>();

    public Vertex(int num) {
        this.num = num;
    }
}
/*
class MyQueue{
    int[] container = new int[50000];
    int size = 0;

    public void add(int num){
        if (size == container.length - 1){
            int[] newCont = new int[container.length * 10];
            for (int i = 0; i < container.length; i++) {
                newCont[i] = container[i];
            }
            container = newCont;

        }
        container[size] = num;
        size++;
    }

    public int poll(){
        size--;
        return container[size];
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        else return false;
    }
}*/
