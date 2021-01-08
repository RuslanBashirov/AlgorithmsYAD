import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        mergeSort(nums, result, 0, n-1);


        for (int i = n-1; i > 1; i--)
            if (result[i] < result[i-1] + result[i-2]){
                System.out.println(result[i]+result[i-1]+result[i-2]);
                break;
            }
    }

    static void mergeSort(int[] arr, int[] result, int begin, int end){
        if (end - begin < 1) return;
        if (end - begin == 1){
            if (arr[end] < arr[begin]){
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
                return;
            }
            else return;
        }
        int mid = (begin + end)/2;
        int i,j;
        int res_counter = begin;

        mergeSort(arr, result, begin, mid);
        mergeSort(arr, result, mid+1, end);

        for (i = begin, j = mid+1; i <= mid && j <= end; res_counter++) {
            if (arr[i] < arr[j]){
                result[res_counter] = arr[i];
                i++;
            }
            else {
                result[res_counter] = arr[j];
                j++;
            }
        }

        if (end - j >= 0){
            for (; j <= end; j++, res_counter++) {
                result[res_counter] = arr[j];
            }
        }
        else if (mid-i >= 0){
            for (; i <= mid; i++, res_counter++)
                result[res_counter] = arr[i];
        }

        for (int k = begin; k <= end; k++)
            arr[k] = result[k];

    }

}
