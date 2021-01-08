import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {//helloworld
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        if (s1.length() == 1){
            System.out.println(s1);
            return;
        }
        char[] chars = new char[s1.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s1.charAt(i);
        }
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();

        for (int i = 1, counter = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) counter++;
            else {
                sb.append(chars[i-1]).append(counter);
                counter = 1;
            }
        }
        StringBuilder[] array_sbs = new StringBuilder[sb.length()/2];
        for (int i = 0; i < array_sbs.length; i++) {
            array_sbs[i] = new StringBuilder("");
        }
        for (int i = 0; i < sb.length()/2; i++) {
            for (int j = 0; j < sb.charAt(2*i+1)-'0'; j++) {
                array_sbs[i] = array_sbs[i].append(sb.charAt(2*i));
            }
        }

        Arrays.sort(array_sbs, new MyComparator());

        for (int i = array_sbs.length - 1; i >= 0; i--) {
            System.out.print(array_sbs[i]);
        }
    }

}
class MyComparator implements Comparator<StringBuilder> {
    @Override
    public int compare(StringBuilder o1, StringBuilder o2) {
        if (o1.length()>o2.length()) return 1;
        else if ((o1.length()<o2.length())) return -1;
        else if (o1.charAt(0)<o2.charAt(0)) return 1;
        else if (o1.charAt(0)>o2.charAt(0)) return -1;
        return 0;
    }
}


