import java.util.Scanner;

public class Solution {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keys = sc.nextLine();
        String[] values = sc.nextLine().split(" ");
        String[] myHashTable = new String[26];
        int closestPrime = getClosestPrime(values.length*10);
        Character[] mySecondHashTable = new Character[closestPrime];
        int currIndex;

        if (keys.length()==0 && values[0].equals("")){
            System.out.println(YES);
            return;
        }

        if (keys.length() != 0 && values[0].equals("")){
            System.out.println(NO);
            return;
        }

        if (keys.length() != values.length){
            System.out.println(NO);
            return;
        }

        for (int i = 0; i < keys.length(); i++) {
            currIndex = keys.charAt(i) - 97;

            if (myHashTable[currIndex] != null){
                if (!myHashTable[currIndex].equals(values[i])){
                    System.out.println(NO);
                    return;
                }
            }
            else myHashTable[currIndex] = values[i];
        }

        //reverse check

        for (int i = 0; i < values.length; i++) {
            currIndex = 0;

            for (int j = 0; j < values[i].length(); j++) {
                currIndex = currIndex + (values[i].charAt(j) - 97)*(j+1);
            }
            currIndex %= closestPrime;

            if (mySecondHashTable[currIndex] != null){
                if (mySecondHashTable[currIndex] != keys.charAt(i)){
                    System.out.println(NO);
                    return;
                }
            }
            else mySecondHashTable[currIndex] = keys.charAt(i);
        }

        System.out.println(YES);


    }

    public static int getClosestPrime(int n){
        int[] arr = new int[n];
        if (n == 3) return 3;
        if (n == 2) return 2;

        for (int i = 2; i*i < n; i++) {
            if (arr[i] != -1){
                for (int j = i; i*j < n; j++) {
                    arr[i*j] = -1;
                }
            }
        }

        int result = 1;

        for (int i = n-1; i >= 2; i--) {
            if (arr[i] != -1) {
                result = i;
                break;
            }
        }

        return  result;
    }
}
