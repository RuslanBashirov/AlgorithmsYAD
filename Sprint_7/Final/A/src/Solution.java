import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (reader.read() == 82) vertices[i].add(j);
                else vertices[j].add(i);
            }

            reader.read();
        }

        reader.close();

        char[] visited = new char[n]; //3 cond-s: 'v' - visited, 'n' - not visited, 'a' - acyclic
        Arrays.fill(visited, 'n');

        for (int i = 0; i < n; i++) {
            if (visited[i] == 'n' && DFS(i, vertices, visited)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean DFS(int vertex, Vertex[] vertices, char[] visited){
        Vertex u = vertices[vertex];
        visited[u.num] = 'v';

        for (int i = 0; i < u.size; i++) {
            int p = u.adj[i];

            if (visited[p] == 'n') {
                if (DFS(p, vertices, visited)) return true;
                else visited[p] = 'a';
            }
            else if (visited[p] == 'v') return true;
        }
        visited[u.num] = 'a';

        return false;
    }
}

class Vertex{
    final public int num;
    int[] adj = new int[2500];
    int size = 0;

    public void add(int num){
        if (size == adj.length - 10){
            int[] temp = new int[5000];

            for (int i = 0; i < adj.length; i++) {
                temp[i] = adj[i];
            }

            adj = temp;
        }
        adj[size] = num;
        size++;
    }

    public Vertex(int num) {
        this.num = num;
    }

}
