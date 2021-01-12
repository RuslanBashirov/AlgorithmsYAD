import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] nAndM = reader.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        int v1, v2;
        HashSet<Integer>[] vertices = new HashSet[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new HashSet<>();
        }

        String[] v1Andv2;
        for (int i = 0; i < m; i++) {
            v1Andv2 = reader.readLine().split(" ");
            v1 = Integer.parseInt(v1Andv2[0]);
            v2 = Integer.parseInt(v1Andv2[1]);

            if (v1 != v2) {
                vertices[v1 - 1].add(v2 - 1);
                vertices[v2 - 1].add(v1 - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (vertices[i].size() != n-1){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
