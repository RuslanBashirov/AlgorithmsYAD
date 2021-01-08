import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.nextLine().charAt(0);
        //System.out.println((int)'a');
        getPrev(ch);
    }

    static void getPrev(char ch){
        if (ch == 'a') {
            System.out.print('a'+" ");
            return;
        }
        else {
            getPrev((char)(ch-1));
            System.out.print(ch + " ");
        }
    }
}
