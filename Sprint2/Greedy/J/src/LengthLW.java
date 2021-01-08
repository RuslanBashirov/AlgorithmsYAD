import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LengthLW {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String s = reader.readLine(); // get info here
        reader.close();
        int len = s.length();
        if (len == 0){
            System.out.println(0);
            return;
        }
        int i = len;

        while (i != 0 && s.charAt(i-1) != ' '){
            i--;
        }

        System.out.println(len-i);
    }
}
