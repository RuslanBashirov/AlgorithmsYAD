import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Scanner;

public class D_maven {
    public static void main(String[] args) {
        /*String str = args[0];
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.setIn(bais);*/
        Scanner sc = new Scanner(System.in);
        String n_string = sc.nextLine();
        String m_string = sc.nextLine();
        int n = Integer.parseInt(n_string);
        int m = Integer.parseInt(m_string);
        String[] strings1 = null;
        String[] strings2 = null;


        if (n != 0) strings1 = sc.nextLine().split(" ");
        if (m!= 0) strings2 = sc.nextLine().split(" ");
        if (n == 0 || m == 0) return;
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++)
            nums1[i] = Integer.parseInt(strings1[i]);

        for (int i = 0; i < m; i++)
            nums2[i] = Integer.parseInt(strings2[i]);

        for (int i = 0; i < m; i++)
            hashSet.add(nums2[i]);

        for (int i = 0; i < n; i++) {
            if (hashSet.contains(nums1[i]))
                System.out.print(nums1[i]+" ");
        }
    }
}
