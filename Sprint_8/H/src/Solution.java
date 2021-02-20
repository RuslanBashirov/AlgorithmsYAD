import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        int[] seq1 = new int[n];
        String[] input1 = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) seq1[i] = Integer.parseInt(input1[i]);

        int m = Integer.parseInt(reader.readLine());
        int[] seq2 = new int[m];

        String[] input2 = reader.readLine().split(" ");

        for (int i = 0; i < m; i++) seq2[i] = Integer.parseInt(input2[i]);

        reader.close();

        ArrayList<Integer>[] res1 = getResult(n, m, seq1, seq2);
        ArrayList<Integer>[] res2 = getResult(m, n, seq2, seq1);

        ArrayList<Integer> list1;
        ArrayList<Integer> list2;

        if (res1[0].size() > res2[0].size()){
            list1 = res1[0];
            list2 = res1[1];
        }
        else{
            list1 = res2[0];
            list2 = res2[1];
        }


        System.out.println(list1.size());
        if (list1.size() == 0) return;

        for (Integer integer : list1) System.out.print((integer+1) + " ");

        System.out.println();

        for (Integer integer : list2) System.out.print((integer+1) + " ");
    }

    public static ArrayList<Integer>[] getResult(int n, int m, int[] seq1, int[] seq2){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer>[] res = new ArrayList[2];
        res[0] = list1;
        res[1] = list2;

        int last_j = 0;

        for (int i = 0; i < n; i++) {

            for (int j = last_j + 1; j < m; j++) {

                if (seq1[i] == seq2[j]) {
                    list1.add(i);
                    list2.add(j);
                    last_j = j;
                    break;
                }
            }

        }

        return res;
    }
}
