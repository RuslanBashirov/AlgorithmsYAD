import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(getFactorial(n));
    }
    static int getFactorial(int n){
        if (n == 1 || n == 0) return 1;
        return n * getFactorial(n-1);
    }
}
