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

        int v1;
        int v2;

        for (int i = 0; i < m; i++) {
            v1 = Integer.parseInt(sc.next());
            v2 = Integer.parseInt(sc.next());

            if (v1 != v2) {
                vertices[v1-1].treeSet.add(v2-1);
                vertices[v2-1].treeSet.add(v1-1);
            }
        }

        int start_id = Integer.parseInt(sc.next());

        BFS(vertices, vertices[start_id-1]);

    }

    public static void BFS(Vertex[] vertices, Vertex start){
        Queue<Vertex> queue = new ArrayDeque<>();
        start.color = 'g';
        //start.dist = 0;
        queue.add(start);

        while (!queue.isEmpty()){
            Vertex u = queue.poll();
            //u.sortAdjVertices();
            Iterator<Integer> value = u.treeSet.iterator();

            while(value.hasNext()) {
                Vertex v = vertices[value.next()];

                if (v.color == 'w') {
                    //v.dist = u.dist + 1;
                    queue.offer(v);
                    v.color = 'g';
                }
            }

            u.color = 'b';
            System.out.print(u.num+1+" ");
        }
    }
}

class Vertex{
    int num;
    //int dist = Integer.MAX_VALUE;
    char color = 'w';
    TreeSet<Integer> treeSet = new TreeSet<>();

    public Vertex(int num) {
        this.num = num;
    }
}
