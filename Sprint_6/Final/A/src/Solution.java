import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++)
            strings[i] = reader.readLine();

        reader.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (are2StringsPalyndroms(strings[i], strings[j])) {
                    String result = new String((i + 1) + " " + (j + 1) + "\n");
                    writer.write(result);
                }
            }
        }

        writer.close();


    }

    /*public static boolean are2StringsPalyndroms(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int mid1 = (Math.abs(l2 - l1) - 1) / 2;

        if (l1 < l2){
            for (int i = 0; i < l1; i++)
                if (s1.charAt(i) != s2.charAt(l2 - 1 - i)) return false;

            for (int i = 0; i <= mid1; i++)
                if (s2.charAt(i) != s2.charAt(l2 - 1 - l1 - i)) return false;
        }

        else if (l1 > l2){
            for (int i = 0; i < l2; i++)
                if (s1.charAt(i) != s2.charAt(l2 - 1 - i)) return false;

            for (int i = 0; i <= mid1; i++)
                if (s1.charAt(i + l2) != s1.charAt(l1 - 1 - i)) return false;
        }

        else {
            for (int i = 0; i < l2; i++)
                if (s1.charAt(i) != s2.charAt(l2 - 1 - i)) return false;
        }

        return true;
    }*/
    public static boolean are2StringsPalyndroms(String s1, String s2){
        String s = s1.concat(s2);
        int mid = s.length() % 2 == 0 ? s.length()/2 - 1 : s.length()/2;

        for (int i = 0; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}
