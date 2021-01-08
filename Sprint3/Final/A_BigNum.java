//41034786
import java.util.Scanner;

public class BigNum {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        if (n == 0) return;

        String[] strings = sc.nextLine().split(" ");

        myQSort(strings, 0, n-1);

        for (int i = 0; i < n; i++)
            System.out.print(strings[i]);
    }

    static void myQSort(String[] arr, int begin, int end){
        if (end - begin < 1) return;

        int i = begin;
        String swapTemp;

        for (int j = begin+1; j <= end; j++) {
            if (ifFirstBigger(arr[j], arr[begin])){ //the sole row differs from the original qSort
                i++;
                swapTemp = arr[j];
                arr[j] = arr[i];
                arr[i] = swapTemp;
            }
        }

        swapTemp = arr[i];
        arr[i] = arr[begin];
        arr[begin] = swapTemp;

        myQSort(arr, begin, i - 1);
        myQSort(arr, i + 1, end);
    }

    static boolean ifFirstBigger(String str1, String str2){
        int val1 = Integer.parseInt(str1.concat(str2));
        int val2 = Integer.parseInt(str2.concat(str1));

        if (val1 > val2) return true;
        else return false;
    }

}
