import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();

        int num = Integer.parseInt(s1);
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (num == 0){
            System.out.println("0");
            return;
        }

        while (num != 0){
            arrayList.add(num % 2);
            num /= 2;
        }

        for (int i = arrayList.size()-1; i >= 0; i--) {
            System.out.print(arrayList.get(i));
        }
    }
}
