import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) return;
        String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        int evens[] = new int[n/2];
        int index_evens = 0;
        int odds[] = new int[n/2];
        int index_odds = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0){
                evens[index_evens] = nums[i];
                index_evens++;
            }
            else {
                odds[index_odds] = nums[i];
                index_odds++;
            }
        }

        index_evens = 0;
        index_odds = 0;

        for (int i = 0; i < n; i++) {
            if (i%2 == 0){
                System.out.print(evens[index_evens]+" ");
                index_evens++;
            }
            else{
                System.out.print(odds[index_odds]+" ");
                index_odds++;
            }
        }
    }

}
