import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sandbox {
    public static void main(String[] args) {
        Integer[] arr = {6, 5 , 4, 3, 2, 1};
        int n = arr.length;
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    sorted = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
