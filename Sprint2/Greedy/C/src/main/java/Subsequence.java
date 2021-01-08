import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Subsequence {
    static String TRUE = "True";
    static String FALSE = "False";
    public static void main(String[] args) throws IOException {
        /*ByteArrayInputStream bais = new ByteArrayInputStream(args[0].getBytes());
        System.setIn(bais);*/
        //StringTokenizer token = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        //String s = token.nextToken();
        //String t = token.nextToken();
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String s = reader.readLine(); // get info here
        String t = reader.readLine();
        reader.close();
        if (s.length() == 0){
            System.out.println(TRUE);
            return;
        }
        if (t.length() == 0){
            System.out.println(FALSE);
            return;
        }
        char curr_from_s;
        int index_s = 0;
        int index_t = 0;

        for (; index_s < s.length(); index_s++) {
            curr_from_s = s.charAt(index_s);
            for (;  index_t < t.length(); index_t++) {
                if (curr_from_s == t.charAt(index_t)) {
                    if (index_s == s.length()-1){
                        System.out.println(TRUE);
                        return;
                    }
                    if (index_t == t.length()-1) {
                        System.out.println(FALSE);
                        return;
                    }
                    index_t++;
                    break;
                }
            }
        }
        System.out.println(FALSE);
    }
}
