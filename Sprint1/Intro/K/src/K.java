import java.util.ArrayList;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int num = Integer.parseInt(s1);
        ArrayList<Integer> al = new ArrayList<>();
        int res = 0;

        while (num != 0){
            if (num % 2 == 1) res++;
            num /= 2;
        }

        System.out.println(res);
    }
}
