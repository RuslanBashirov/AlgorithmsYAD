import java.util.Scanner;

public class QSort {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final String[] strings = sc.nextLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strings[i]);

        partition(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    static void partition(int[] arr, int begin, int end){
        if (end - begin < 1) return;

        int i = begin;
        int swapTemp;

        for (int j = begin+1; j <= end; j++) {
            if (arr[j] < arr[begin]){
                i++;
                swapTemp = arr[j];
                arr[j] = arr[i];
                arr[i] = swapTemp;
            }
        }

        swapTemp = arr[i];
        arr[i] = arr[begin];
        arr[begin] = swapTemp;

        partition(arr, begin, i - 1);
        partition(arr, i + 1, end);
    }

}
