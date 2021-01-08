import java.util.Scanner;

public class N{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 =  sc.nextLine();
        int num = Integer.parseInt(s1);

        while (num != 1){
            if (num % 4 != 0){
                System.out.println("False");
                return;
            }
            num /= 4;
            if (num == 1) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("True");
    }
}
