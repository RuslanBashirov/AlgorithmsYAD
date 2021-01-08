//41034962
import java.io.*;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        final File file = new File("input.txt");
        final FileReader fr = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fr);
        final int n = Integer.parseInt(reader.readLine());
        if (n == 0) return;

        final String[] strings = reader.readLine().split(" ");
        reader.close();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        radixSort(nums, n);

        final FileWriter nFile = new FileWriter("output.txt");

        for (int i = 0; i < n; i++)
            nFile.write(nums[i]+" ");

        nFile.close();

    }


    static private void radixSort(int[] arr, int n){
        final int maxNum = maxNum(arr);

        for (int rank = 1; rank <= maxNum; rank *= 10)
            countSort(arr, n, rank);
    }

    static private void countSort(int[] arr, int n, int rank){
        int[] counts = new int[10];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            counts[(arr[i] / rank) % 10]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            sorted[counts[(arr[i]/rank) % 10] - 1] = arr[i];
            counts[(arr[i]/rank) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i];
        }
    }

    static private int maxNum(int[] arr){
        int maxNum = arr[0];

        for (int i = 0; i < arr.length; i++)
            if (arr[i] > maxNum) maxNum = arr[i];

        return maxNum;
    }

}
