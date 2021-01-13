import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        int v, w;

        for (int i = 0; i < m; i++) {
            v = Integer.parseInt(sc.next());
            w = Integer.parseInt(sc.next());

            if (v != w){
                vertices[v-1].adj.add(w-1);
                vertices[w-1].adj.add(v-1);
            }
        }

        int start = Integer.parseInt(sc.next());

        DFS(vertices, start-1);
    }

    public static void DFS(Vertex[] vertices, int start){
        Vertex u = vertices[start];
        System.out.print(u.num+1+" ");
        u.color = 'o';
        Iterator<Integer> iterator = u.adj.iterator();

        while (iterator.hasNext()){
            Integer curr = iterator.next();
            if (vertices[curr].color == 'g') {
                DFS(vertices, curr);
            }
        }

        u.color = 'b';
    }
}

class Vertex{
    int num;
    char color = 'g';
    TreeSet<Integer> adj = new TreeSet<>();

    public Vertex(int num) {
        this.num = num;
    }
}
