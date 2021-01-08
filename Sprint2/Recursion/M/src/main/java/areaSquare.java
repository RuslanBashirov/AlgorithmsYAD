import java.util.Scanner;

public class areaSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        System.out.println(getSize(a, b));
    }

    static int getSize(int a, int b){
        if (a == 0) return b;
        else if (b == 0) return a;
        else if (a == b) return a;
        return getSize(a%b, b%a);
    }
}
