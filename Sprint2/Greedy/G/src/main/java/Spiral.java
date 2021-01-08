import java.util.Scanner;

public class Spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        String[] strings = new String[n];
        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++)
            strings[i] = sc.nextLine();

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = strings[i].split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(temp[j]);
            }
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println("");
        }*/
    }
}
