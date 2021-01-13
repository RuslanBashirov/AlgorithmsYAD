import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        int m = 0;

        String[] strings = reader.readLine().split(" ");
        reader.close();

        for (int i = 0; i < n; i++) {
            m += Integer.parseInt(strings[i]);
        }

        if ((n-1)*2 == m) System.out.println("YES");
        else System.out.println("NO");
    }

    /*public static int readNext(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();


        if (reader.read() != )
    }*/
}