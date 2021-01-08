import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String ref = sc.nextLine();
        int[] counts = new int[26];
        initCounts(counts, ref);

        if (str.length() < ref.length()){
            System.out.println(0);
            return;
        }
        
        int counter = 0;

        for (int k = 0; k <= str.length() - ref.length(); k++) {
            for (int i = k; i < k + ref.length(); i++)
                    counts[str.charAt(i)-97]--;

            if (ifArrayEmpty(counts)) counter++;

            initCounts(counts, ref);
        }

        System.out.println(counter);
    }

    static void initCounts(int[] counts, String ref){
        Arrays.fill(counts, 0);

        for (int i = 0; i < ref.length(); i++) {
            counts[ref.charAt(i)-97]++;
        }
    }

    static boolean ifArrayEmpty(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

}
