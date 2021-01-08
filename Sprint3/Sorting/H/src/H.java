import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][3];
        int[][] result = new int[n][3];
        String[] strings;

        for (int i = 0; i < n; i++) {
            strings = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(strings[0]);
            arr[i][1] = Integer.parseInt(strings[1]);
            arr[i][2] = arr[i][1] - arr[i][0];
        }

        mergeSort(arr, result);

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++)
                ifIntersect(result, i, result, j);
        }

        int[][] finish = new int[n][2];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (result[i][0] != -1) {
                finish[counter] = result[i];
                counter++;
            }
        }

        int[][] last = new int[counter][2];

        for (int i = 0; i < counter; i++) {
            last[i][0] = finish[i][0];
            last[i][1] = finish[i][1];
        }


        bubbleSort(last, last.length);

        for (int i = 0; i < last.length; i++) {
            System.out.println(last[i][0]+" "+last[i][1]);
        }
    }

    static void ifIntersect(int[][] base, int i, int[][] extra, int k){
        if (base[i][0] == -1 || extra[k][0] == -1) return;
        if (( extra[k][0] <= base[i][0] && extra[k][1] >= base[i][0] )
                || ( extra[k][0] <= base[i][1] && extra[k][1] >= base[i][1] )){
            base[i][0] = minOf2(base[i][0], extra[k][0]);
            base[i][1] = maxOf2(base[i][1], extra[k][1]);
            extra[k][0] = -1;
            extra[k][1] = -1;
            extra[k][2] = -1;
        }
        else if (extra[k][0] >= base[i][0] && extra[k][1] <= base[i][1]){
            extra[k][0] = -1;
            extra[k][1] = -1;
            extra[k][2] = -1;
        }
    }

    static void mergeSort(int[][] arr, int[][] result){
        if (arr.length == 1) result[0] = arr[0];
        else if (arr.length == 2){
            if (arr[arr.length-1][0] < arr[0][0]){
                int[] temp = arr[arr.length-1];
                arr[arr.length-1] = arr[0];
                arr[0] = temp;
            }
            result[0] = arr[0];
            result[1] = arr[1];
        }
        else mergeSortSub(arr, result, 0, arr.length-1);
    }
    static void mergeSortSub(int[][] arr, int[][] result, int begin, int end){
        if (end - begin < 1) return;
        if (end - begin == 1){
            if (arr[end][2] > arr[begin][2]){
                int[][] temp = new int[1][3];
                copyEl(temp, 0, arr, end);
                copyEl(arr, end, arr, begin);
                copyEl(arr, begin, temp, 0);
                return;
            }
            else return;
        }
        int mid = (begin + end)/2;
        int i,j;
        int res_counter = begin;

        mergeSortSub(arr, result, begin, mid);
        mergeSortSub(arr, result, mid+1, end);

        for (i = begin, j = mid+1; i <= mid && j <= end; res_counter++) {
            if (arr[i][2] > arr[j][2]){
                copyEl(result, res_counter, arr, i);
                i++;
            }
            else {
                copyEl(result, res_counter, arr, j);
                j++;
            }
        }

        if (end - j >= 0){
            for (; j <= end; j++, res_counter++)
                copyEl(result, res_counter, arr, j);
        }
        else if (mid-i >= 0){
            for (; i <= mid; i++, res_counter++)
                copyEl(result, res_counter, arr, i);
        }

        for (int k = begin; k <= end; k++)
            copyEl(arr, k, result, k);

    }


    static void bubbleSort(int[][] nums, int n){
        boolean hadExchange = false;
        int[][] temp = new int[1][2];

        for (int i = 0; i < n - 1; i++) {
            hadExchange = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j][0] > nums[j + 1][0]) {
                    hadExchange = true;
                    temp[0] = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp[0];
                }
            }

            if (!hadExchange) break;
        }

    }


    static void copyEl(int[][] to, int index_to, int[][] from, int index_from){
        to[index_to][2] = from[index_from][2];
        to[index_to][1] = from[index_from][1];
        to[index_to][0] = from[index_from][0];
    }


    static int maxOf2(int num1, int num2){
        if (num1 > num2) return num1;
        else return num2;
    }

    static int minOf2(int num1, int num2){
        if (num1 < num2) return num1;
        else return num2;
    }

}
