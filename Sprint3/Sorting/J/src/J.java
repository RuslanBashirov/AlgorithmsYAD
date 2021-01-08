import java.util.HashSet;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final String[] strings_n = sc.nextLine().split(" ");
        final int m = Integer.parseInt(sc.nextLine());
        String[] strings_m = {""};
        if (m != 0) {
            strings_m = sc.nextLine().split(" ");
        }

        final int[] nums = new int[n];
        final int[] reference = new int[m];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings_n[i]);

        for (int i = 0; i < m; i++)
            reference[i] = Integer.parseInt(strings_m[i]);

        int[] arrCounts = new int[1500];
        int[] sub = new int[1000];
        int index_sub = 0;
        HashSet<Integer> unique = new HashSet<>(m);

        for (int i = 0; i < m; i++) {
            unique.add(reference[i]);
        }

        for (int i = 0; i < n; i++) {
            if (unique.contains(nums[i]))
                arrCounts[nums[i]]++;
            else{
                sub[index_sub] = nums[i];
                index_sub++;
            }
        }

        qSort(sub, 0, index_sub - 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < arrCounts[reference[i]]; j++)
                System.out.print(reference[i]+" ");
        }

        for (int i = 0; i < index_sub; i++)
            System.out.print(sub[i]+" ");
    }

    static void qSort(int[] arr, int begin, int end){
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

        qSort(arr, begin, i - 1);
        qSort(arr, i + 1, end);
    }

}
