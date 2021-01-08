import java.io.*;
import java.util.HashSet;

public class C {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String s1 = reader.readLine();
        reader.close();
        //HashSet<Character> hs = new HashSet<>();
        char curr_char;
        int result = 0;
        int[] letters = new int[26];

        for (int j = 0; j < s1.length(); j++) {
            for (int i = j, counter = 0; i < s1.length(); i++) {
                curr_char = s1.charAt(i);
                if (letters[curr_char - 97] != 1) {
                    letters[curr_char - 97] = 1;
                    counter++;
                } else {
                    counter = 0;
                    break;
                }
                if (counter > result) result = counter;
            }
            for (int i = 0; i < 26; i++) {
                letters[i] = 0;
            }
        }
        System.out.println(result);
    }
}
