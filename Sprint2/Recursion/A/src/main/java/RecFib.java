import java.util.Scanner;

public class RecFib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(Fib(n));
    }

    public static int Fib(int n){
        if (n <= 1) return 1;
        else return Fib(n-1) + Fib(n-2);
    }
}
