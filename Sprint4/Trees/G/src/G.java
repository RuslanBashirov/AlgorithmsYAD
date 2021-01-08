import java.util.Scanner;

public class G {
    public static void addValue(int[][] arr, int[] sum, int id){
        arr[0][0]++;
        int id_parent = id / 2;

        while (id_parent >= 1) {
            if (sum[2] < arr[id_parent][2]) {
                arr[id] = arr[id_parent];
                arr[id_parent] = sum;
            }
            else {
                arr[id] = sum;
                break;
            }

            id = id_parent;
            id_parent /= 2;
        }
    }

    public static int[] getPeak(int[][] arr){
        int[] min = arr[1];

        arr[1] = arr[arr[0][0]];
        arr[0][0]--;

        int id = 1;
        int min_id;

        while (id*2+1 <= arr[0][0]){
            if (arr[id*2][2] < arr[id*2+1][2]) min_id = id*2;
            else min_id = id*2+1;

            if (arr[id][2] >= arr[min_id][2]){
                int[] temp = new int[3];
                initArrayOf3FromPairNums(temp, arr[id][0], arr[id][1]);

                arr[id] = arr[min_id];
                arr[min_id] = temp;

                id = min_id;
            }
            else break;
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = Integer.parseInt(sc.nextLine());
        String[] s1 = sc.nextLine().split(" ");
        int n2 = Integer.parseInt(sc.nextLine());
        String[] s2 = sc.nextLine().split(" ");
        int k = Integer.parseInt(sc.nextLine());
        int[] nums1 = new int[n1+1];
        int[] nums2 = new int[n2+1];
        int[][] arr = new int[n1*n2+1][3];
        arr[0][0] = 0;
        //arr[0][0] is a size of the heap

        for (int i = 1; i <= n1; i++)
            nums1[i] = Integer.parseInt(s1[i-1]);

        for (int i = 1; i <= n2; i++)
            nums2[i] = Integer.parseInt(s2[i-1]);

        initArrayOf3FromPairNums(arr[1], nums1[1], nums2[1]);
        arr[0][0]++;

        for (int i = 1, arr_counter = 2; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (i == 1 && j == 1) continue;
                int[] curr_sum = new int[3];

                initArrayOf3FromPairNums(curr_sum, nums1[i], nums2[j]);
                addValue(arr, curr_sum, arr_counter);

                arr_counter++;
            }
        }

        for (int i = 1; i <= k; i++) {
            int[] temp = getPeak(arr);
            if (temp[0] <= temp[1]) {
                System.out.print(temp[0]+" ");
                System.out.print(temp[1]);
            }
            else {
                System.out.print(temp[1]+" ");
                System.out.print(temp[0]);
            }

            //System.out.print(temp[2]+" ");
            System.out.println();
        }

    }

    public static int[] initArrayOf3FromPairNums(int[] res, int num1, int num2){
        res[0] = num1;
        res[1] = num2;
        res[2] = num1 + num2;

        return res;
    }

}
