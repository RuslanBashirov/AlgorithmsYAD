import java.math.BigInteger;
import java.util.Scanner;

public class CyclicFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BigInteger result = new BigInteger("1");

        for (Integer i = 2; i <= n; i++) {
            result = result.multiply(new BigInteger(i.toString()));
        }

        System.out.println(result);
    }
}
