import java.io.*;

public class Ladder {
    static private String TRUE = "True";
    static private String FALSE = "False";
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String s1 = reader.readLine();
        String[] s2 = reader.readLine().split(" ");
        reader.close();
        int n = Integer.parseInt(s1);
        int[] steps = new int[n];
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            cnt--;
            steps[i] = Integer.parseInt(s2[i]);
            if (steps[i] > cnt) cnt = steps[i];
            if (cnt == 0) {
                System.out.println(FALSE);
                return;
            }
        }

        System.out.println(TRUE);
    }
}
