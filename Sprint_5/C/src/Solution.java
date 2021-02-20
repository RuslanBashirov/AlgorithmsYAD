
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static boolean check2ForAnagrams(String a, String b, int[] count){
        for (int i = 0; i < a.length(); i++)
            count[a.charAt(i)-65]++;

        for (int i = 0; i < b.length(); i++) {
            if (count[b.charAt(i)-65] == 0) {
                Arrays.fill(count, 0);
                return false;
            }

            count[b.charAt(i)-65]--;
        }

        Arrays.fill(count, 0);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        if (n == 0) return;

        String[] strings = sc.nextLine().split(" ");
        Set<Integer> setOfN = new HashSet<>(n);
        int[] hashValues = new int[n];
        int[] countArrOfAlphabet = new int[58];

        for (int i = 0; i < n; i++) setOfN.add(i);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strings[i].length(); j++)
                hashValues[i] += strings[i].charAt(j) - 65;

           // hashValues[i] %= 5897;
        }

        for (int i = 0; i < n; i++) {
            if (!setOfN.contains(i)) continue;
            System.out.print(i);

            setOfN.remove(i);

            for (int j = i+1; j < n; j++) {
                if (hashValues[i] == hashValues[j]
                        && strings[i].length() == strings[j].length()
                        && check2ForAnagrams(strings[i], strings[j], countArrOfAlphabet)){
                    System.out.print(" "+j);
                    setOfN.remove(j);
                }
            }
            System.out.println();
        }

        //System.out.println(check2ForAnagrams(strings[0], strings[1],countArrOfAlphabet));
    }
}
