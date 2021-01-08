import java.util.Arrays;
import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String[] strings = s2.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(nums);

        if (n==1 || n==2){
            System.out.println(-1);
            return;
        }
        long temp = -1L;
        long max = -1L;
        long x1,x2,x3;
        int n1=0,n2=0,n3=0;

        for (int i = nums.length-1; i >= 2; i--) {
            for (int j = i-1; j >= 1; j--) {
                for (int k = 0; k < j; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 &&
                            signOfMultiplication(nums[i],nums[j],nums[k])){
                        x1 = nums[i];
                        x2 = nums[j];
                        x3 = nums[k];
                        temp = x1*x2*x3;
                        if (temp > max) {
                            //n1 = nums[i];
                           // n2 = nums[j];
                            //n3 = nums[k];
                            max = temp;
                            k = j;
                        }
                    }
                }
            }
        }
        System.out.println(max);
        //System.out.println(n1+" "+n2+" "+n3);
    }

    public static boolean signOfMultiplication(int n1, int n2, int n3){
        n1 = n1 > 0 ? 1 : -1;
        n2 = n2 > 0 ? 1 : -1;
        n3 = n3 > 0 ? 1 : -1;
        if (n1*n2*n3 > 0) return true;
        else return false;
    }
}
