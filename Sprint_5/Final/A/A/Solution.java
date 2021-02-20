//45829756
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final String POST = "post";
    private static final String GET = "get";
    private static final String PRAKTIKUM_URL = "https://prakti.kum/";
    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int B = 62;

    // hashMap's KEY is BASE62_URL, VALUE is ORIGINAL_URL
    private static final HashMap<String, String> hashMap = new HashMap<>();

    // reversedHashMap's KEY is ORIGINAL_URL, VALUE is BASE62_URL
    private static final HashMap<String, String> reversedHashMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        final String file = "input.txt";
        final Scanner sc = new Scanner(new File(file));
        final BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int q = Integer.parseInt(sc.next());
        final int n = Integer.parseInt(sc.next());
        String method;


        for (int i = 0; i < n; i++) {
            method = sc.next();
            String currURL = sc.next();
            String shortURL;

            if (method.equals(POST)) {
                shortURL = encodeURL(q);

                if (!reversedHashMap.containsKey(currURL))
                    reversedHashMap.put(currURL, shortURL);
                else {
                    writer.write(PRAKTIKUM_URL+reversedHashMap.get(currURL)+'\n');
                    continue;
                }

                q++;

                hashMap.put(shortURL, currURL);

                writer.write(PRAKTIKUM_URL + shortURL+'\n');
            }
            else if (method.equals(GET)) {
                shortURL = getStringAfterLastSlash(currURL);

                if (hashMap.containsKey(shortURL)
                        && (getStringBeforeLastSlash(currURL).equals(PRAKTIKUM_URL))){
                    writer.write(hashMap.get(shortURL)+'\n');
                }
                else writer.write("error"+'\n');
            }
            else {
                writer.write("wrong method"+'\n');
                return;
            }
        }
        writer.close();
    }


    public static String encodeURL(int q) {
        StringBuilder encoded_string = new StringBuilder();

        while (q > 0) {
            int r = q % B;
            q /= B;
            encoded_string.append(BASE.charAt(r));
        }

        return encoded_string.reverse().toString();
    }


    public static String getStringAfterLastSlash(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; (i >= 0) && (str.charAt(i) != '/'); i--) {
            result.append(str.charAt(i));
        }

        return result.reverse().toString();
    }

    public static String getStringBeforeLastSlash(String str){
        int i = str.length() - 1;

        for (; i >=0 && (str.charAt(i) != '/') ; i--){

        }
        return str.substring(0, i+1);
    }

}
