//39044275

import java.util.Scanner;

public class BrokenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];

        if (n == 0){
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        System.out.println(bS(nums, 0, n-1, k));
    }

    static int bS(int[] arr, int l, int r, int k){
        int mid = l+ (r - l) / 2;
        if (arr[mid] == k) return mid;
        if (l >= r) return -1;
        int tmp1  = -1, tmp2;

        if (arr[l] < arr[mid]) {
            tmp1 = bS(arr, l, mid - 1, k);
            if (tmp1 != -1) return tmp1;

            tmp2 = bS(arr, mid + 1, r, k);
            if (tmp2 != -1) return tmp2;
        }
        else {
            tmp2 = bS(arr, mid + 1, r, k);
            if (tmp2 != -1) return tmp2;

            tmp1 = bS(arr, l, mid - 1, k);
            if (tmp1 != -1) return tmp1;
        }

        return -1;
    }


}
