import java.util.Scanner;

public class MemoFib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        int[] arr = new int[n+2];

        System.out.println(MemoFib(n,arr));
    }

    static int MemoFib(int n, int[] arr){
        if (n <= 1) return 1;
        else if (arr[n] != 0)
            return arr[n];
        else {
            arr[n] = MemoFib(n-1, arr) + MemoFib(n-2, arr);
            return arr[n];
        }
    }
}
