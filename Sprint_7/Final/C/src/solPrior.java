/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class solPrior {
    public static final String DISCONNECTED_GRAPH = "Oops! I did it again";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] all_edges_string_array = reader.readLine().split(" ");
        final int n = Integer.parseInt(all_edges_string_array[0]);
        final int m = Integer.parseInt(all_edges_string_array[1]);
        final PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(n, new EdgeComparator());
        int v1, v2, w;
        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);

        for (int i = 0; i < m; i++) {
            all_edges_string_array = reader.readLine().split(" ");
            v1 = Integer.parseInt(all_edges_string_array[0]) - 1;
            v2 = Integer.parseInt(all_edges_string_array[1]) - 1;
            w = Integer.parseInt(all_edges_string_array[2]);

            if (v1 != v2) priorityQueue.offer(new Edge(v1, v2, w));
        }

        int num_of_visited_vertices = 0, sum = 0;
        int queue_size = priorityQueue.size();
        Edge curr_edge;

        for (int i = 0; i < queue_size; i++) {
            curr_edge = priorityQueue.poll();

            if (vertices[curr_edge.v1].adj.contains(curr_edge.v2)) continue;

            vertices[curr_edge.v2].color = 'b';

            if (!DFS(vertices, curr_edge.v1, curr_edge.v2)){
                vertices[curr_edge.v1].adj.add(curr_edge.v2);
                vertices[curr_edge.v2].adj.add(curr_edge.v1);
                num_of_visited_vertices++;
                sum += curr_edge.w;
            }

            for (int j = 0; j < n; j++) vertices[j].color = 'w';

            if (num_of_visited_vertices == n - 1) break;
        }

        if (num_of_visited_vertices < n - 1) System.out.println(DISCONNECTED_GRAPH);
        else System.out.println(sum);
    }


    public static boolean DFS(Vertex[] vertices, int vertex, int start_vertex){
        Vertex u = vertices[vertex];
        u.color = 'g';

        for (int v: u.adj){
            if (vertices[v].color == 'w'){
                if (DFS(vertices, v, start_vertex)) return true;
            }
            else if (v == start_vertex)
                return true;
        }

        return false;
    }
}

class Edge{
    public int v1;
    public int v2;
    public int w;

    public Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }
}

class EdgeComparator implements Comparator<Edge>{
    public int compare(Edge a, Edge b){
        if (a.w < b.w) return 1;
        else if (a.w > b.w) return -1;
        else return 0;
    }
}

class Vertex{
    public int num;
    public char color = 'w';
    public  final ArrayList<Integer> adj = new ArrayList<>();

    public Vertex(int num) {
        this.num = num;
    }
}

*/
