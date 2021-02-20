import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] twoVal = reader.readLine().split(" ");

        int n = Integer.parseInt(twoVal[0]);
        int m = Integer.parseInt(twoVal[1]);

        int[][] field = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = reader.read() - 48;
            }
            reader.read();
        }

        reader.close();

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= m-1; j++) {
                if (i != n-1 && j != 0)
                    field[i][j] += Math.max(field[i + 1][j], field[i][j - 1]);
                else if (i == n-1 && j == 0);
                else if (i == n-1) field[i][j] += field[i][j - 1];
                else field[i][j] += field[i + 1][j];
            }
        }

        System.out.println(field[0][m-1]);
    }
}
