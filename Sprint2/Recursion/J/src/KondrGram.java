import java.util.Scanner;

public class KondrGram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        System.out.println(printNum(n, k));

    }
    static int printNum(int n, int k){
        if (n == 1) return 0;
        int half = (int) (Math.pow(2, (n-1))/2);
        if (k <= half) return printNum(n-1, k);
        else return 1 - printNum(n-1, k - half);
    }
}
