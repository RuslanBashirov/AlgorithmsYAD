import java.util.HashSet;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n_string = sc.nextLine();
        int n = Integer.parseInt(n_string);
        String[] visited = new String[n];
        HashSet<String> hs = new HashSet<>();
        String curr;
        int j = 0;
        for (int i = 0; i < n; i++) {
            curr = sc.nextLine();
            if (!hs.contains(curr)){
                visited[j] = curr;
                j++;
            }
            hs.add(curr);
        }
        for (int i = 0; i < j; i++) {
            System.out.println(visited[i]);
        }
    }
}
/*String curr;
        boolean isFound;

        for (int i = 0; i < n; i++) {
            isFound = false;
            curr = sc.nextLine();
            for (int j = 0; j < visited.length; j++) {
                if (visited[j].equals(curr)) {
                    isFound = true;
                }
            }
            if (!isFound) visited[i] = curr;
        }

        int finish = removeTarget(visited, "");
        for (int i = 0; i < finish; i++) {
            System.out.println(visited[i]);
        }

    }
    public static int removeTarget(String[] visited, String targ){
        int start = 0, mid = 0;
        int end = visited.length-1;
        String temp;
        while (mid <= end){
            if (!visited[mid].equals(targ)){
                temp = visited[start];
                visited[start] = visited[mid];
                visited[mid] = temp;
                start++;
                mid++;
            }
            else mid++;
        }
        return start;
    }

 */
