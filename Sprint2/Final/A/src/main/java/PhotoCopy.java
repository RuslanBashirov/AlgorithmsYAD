//38997976
import java.io.*;
import java.util.Arrays;

public class PhotoCopy {
    public static void main(String[] args) throws IOException {
        final File file = new File("input.txt");
        final FileReader fr = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fr);
        int n = Integer.parseInt(reader.readLine());
        n = n + 1; // i need to add 0 value at the beginning of array;
        final String[] strings = reader.readLine().split(" ");
        reader.close();

        final int[] amounts = new int[n];
        int not_zero_id = 0; //index of a first not zero element of array
        int result = 0;

        for (int i = 1; i < n; i++)
            amounts[i] = Integer.parseInt(strings[i-1]);

        Arrays.sort(amounts);

        for (int i = 0; i < n; i++) {
            if (amounts[i] != 0){
                not_zero_id = i;
                break;
            }
        }

        while (not_zero_id < (n-1)) {
            amounts[n - 1]--;
            amounts[not_zero_id]--;
            result++;

            if (amounts[not_zero_id] == 0)
                not_zero_id++;

            if (amounts[n - 1] < amounts[n - 2])
                MySort(amounts, n, not_zero_id);

            if (amounts[not_zero_id] == 0)
                not_zero_id++;
        }

        System.out.println(result);
    }

    static void MySort(int[] amounts, int n, int not_zero_id){
        int temp;

        for (int i = n - 2; i >= not_zero_id - 1; i--) {
            if (amounts[n - 1] >= amounts[i]) {
                temp = amounts[n - 1];
                amounts[n - 1] = amounts[i + 1];
                amounts[i + 1] = temp;
                break;
            }
        }
    }

}