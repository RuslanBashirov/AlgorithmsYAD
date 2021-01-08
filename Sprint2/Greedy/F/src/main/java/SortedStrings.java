import java.io.*;
import java.util.Arrays;

public class SortedStrings {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String s1 = reader.readLine();
        final int n = Integer.parseInt(s1);
        String s2 = reader.readLine();
        final int m = Integer.parseInt(s2);
        String line;
        char[][] chars = new char[m][n];
        char[][] chars_copy = new char[m][n];

        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            for (int j = 0; j < m; j++) {
                chars[j][i] = line.charAt(j);
                chars_copy[j][i] = line.charAt(j);
            }
        }
        reader.close();

        int result = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(chars[i]);
            for (int j = 0; j < n; j++) {
                if (chars[i][j] != chars_copy[i][j]) break;
                if (j == n-1) result++;
            }
        }
        System.out.println(m-result);
    }
}
