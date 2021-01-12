import java.util.*;

public class Solution {
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
            if (v != w) {
                vertices[v-1].adj.add(w-1);
                vertices[w-1].adj.add(v-1);
            }
        }

        int start = Integer.parseInt(sc.next());

        BFS(vertices, vertices[start-1]);

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (vertices[i].dist > max) max = vertices[i].dist;
        }

        System.out.println(max);

    }

    public static void BFS(Vertex[] vertices, Vertex start){
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(start);
        start.color = 'g';
        start.dist = 0;

        while (!queue.isEmpty()){
            Vertex u = queue.poll();

            Iterator<Integer> iterator = u.adj.iterator();

            while (iterator.hasNext()){
                Vertex v = vertices[iterator.next()];
                if (v.color == 'w'){
                    v.dist = u.dist + 1;
                    queue.offer(v);
                    v.color = 'g';
                }
            }

            u.color = 'b';
        }
    }
}
class Vertex{
    int num;
    char color = 'w';
    int dist = Integer.MAX_VALUE;
    TreeSet<Integer> adj = new TreeSet<>();

    public Vertex(int num) {
        this.num = num;
    }
}
