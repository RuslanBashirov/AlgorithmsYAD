import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static ArrayList<Integer>[] returnCorrectVertices(int n, Pair[] pairs){
        Arrays.sort(pairs);

        ArrayList<Integer>[] correctVertices = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            correctVertices[i] = new ArrayList<>();
        }

        if (pairs[0].small != pairs[0].big){
            correctVertices[pairs[0].small].add(pairs[0].big);
            correctVertices[pairs[0].big].add(pairs[0].small);
        }

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].small == pairs[i-1].small && pairs[i].big == pairs[i-1].big
                    || pairs[i].small == pairs[i].big) continue;
            else {
                correctVertices[pairs[i].small].add(pairs[i].big);
                correctVertices[pairs[i].big].add(pairs[i].small);
            }
        }
        return correctVertices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());

        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            pairs[i] = new Pair(Integer.parseInt(sc.next()) - 1, Integer.parseInt(sc.next()) - 1);
        }

        int mustBeEdges = (n * (n-1) / 2);
        if (m < mustBeEdges){
            System.out.println("NO");
            return;
        }

        ArrayList<Integer>[] correctVertices = returnCorrectVertices(n, pairs);

        for (int i = 0; i < n; i++) {
            if (correctVertices[i].size() != n-1){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}

class Pair implements Comparable<Pair>{
    int small;
    int big;

    public Pair(int num1, int num2) {
        if (num1 < num2){
            this.small = num1;
            this.big = num2;
        }
        else {
            this.small = num2;
            this.big = num1;
        }

    }

    @Override
    public int compareTo(Pair o) {
        if (this.small < o.small) return -1;
        else if (this.small > o.small) return 1;
        return 0;
    }
}