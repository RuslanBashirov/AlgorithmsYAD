import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String n_string = sc.nextLine();
        final String m_string = sc.nextLine();
        //if (n_string.length() == 0 || m_string.length() == 0) return;
        final int n = Integer.parseInt(n_string);
        final int m = Integer.parseInt(m_string);
        if (n == 0 || m == 0) return;
        String[] strings1 = sc.nextLine().split(" ");
        String[] strings2 = sc.nextLine().split(" ");
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];

        for (int i = 0; i < n; i++)
            nums1[i] = Integer.parseInt(strings1[i]);

        for (int i = 0; i < m; i++)
            nums2[i] = Integer.parseInt(strings2[i]);

        qSort(nums2, 0, m - 1);

        for (int i = 0; i < n; i++) {
            if (bS(nums2, 0, m-1, nums1[i]))
                System.out.print(nums1[i]+" ");
        }
        //System.out.println(bS(nums2, 0, m-1, 4));
    }


    public static void qSort(int[] arr, int begin, int end){
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
        qSort(arr, begin, i-1);
        qSort(arr, i+1, end);
    }

    public static boolean bS(int[] arr, int l, int r, int el){
        if (r < l) return false;
        int mid = l + (r - l) / 2;
        if (arr[mid] == el) {
            arr[mid] = -1;
            return true;
        }
        if (bS(arr, l, mid - 1, el)) return true;
        if (bS(arr, mid + 1, r, el)) return true;
        return false;
    }
}
