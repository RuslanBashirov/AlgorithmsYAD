import java.io.*;
import java.util.Scanner;

public class N {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        final int a = Integer.parseInt(reader.readLine());
        final int b = Integer.parseInt(reader.readLine());
        reader.close();
        final int nod = getNod(a, b);
        int x = 0, y = 0, temp;

        while (1 == 1){
            temp = (nod - y * b);

            if (temp % a == 0)
                break;

            y++;
        }

        System.out.println(temp/a + " " + y + " " + nod);
    }

    static int getNod(int a, int b){
        if (a == b) return a;
        if (a % b == 0) return b;
        if (b % a == 0) return a;
        return getNod(a%b, b%a);
    }

}
