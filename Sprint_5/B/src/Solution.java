import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n < 2){
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];

        for (int i = 2; i*i < n; i++) {
            if (arr[i] != -1){
                for (int j = i; i*j < n; j++) {
                    arr[i*j] = -1;
                }
            }
        }

        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] != -1) counter++;
        }

        System.out.println(counter);
    }
}
