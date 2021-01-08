import java.util.Scanner;

public class lastNumFib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int x = 1, y = 1;
        int tmp;
        for (int i = 2; i <= n; i++) {
            tmp = getLast(y);
            y = getLast(x+y);
            x = tmp;
        }
        System.out.println(y);
    }
    static int getLast(int n){
        while (n >= 10){
            n %= 10;
        }
        return n;
    }
}
