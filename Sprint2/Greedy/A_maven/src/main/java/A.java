import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        /*String str = args[0];
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.setIn(bais);*/
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.length() == 0) return;
        int n = Integer.parseInt(input);
        float[] start = new float[n];
        float[] end = new float[n];
        int curr_min_index;
        float temp_end, temp_start;
        String[] curr_lines;

        for (int i = 0; i < n; i++) {
            curr_lines = sc.nextLine().split(" ");
            start[i] = Float.parseFloat(curr_lines[0]);
            end[i] = Float.parseFloat(curr_lines[1]);
        }

        for (int i = 0; i < n; i++) {
            curr_min_index = i;
            for (int j = i; j < n; j++) {
                if (end[j] < end[curr_min_index]) curr_min_index = j;
            }
            temp_end = end[curr_min_index];
            temp_start = start[curr_min_index];
            end[curr_min_index] = end[i];
            start[curr_min_index] = start[i];
            end[i] = temp_end;
            start[i] = temp_start;
        }

        for (int j = 0; j < n-1; j++) {
            if (end[j] == -1) continue;
            //if (end[j] == start[j]) continue;
            for (int i = j+1; i < n; i++) {
                if (end[j] == start[j] && (end[j] == start[i] || end[j] == end[i])) continue;
                if (start[i] < end[j]){
                    start[i] = -1;
                    end[i] = -1;
                }
                //else break;
            }
        }

        int res_len = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] != -1) res_len++;
        }

        for (int i = 0; i < n; i++) {
            curr_min_index = i;
            for (int j = i; j < n; j++) {
                if (end[j] == end[curr_min_index] && start[j] < start[curr_min_index]) {
                    curr_min_index = j;
                }
            }
            temp_end = end[curr_min_index];
            temp_start = start[curr_min_index];
            end[curr_min_index] = end[i];
            start[curr_min_index] = start[i];
            end[i] = temp_end;
            start[i] = temp_start;
        }

        System.out.printf("%s", res_len + "\n");

        NumberFormat nf = new DecimalFormat("#.##");

        for (int i = 0; i < n; i++) {
            if (start[i] != -1) {
                System.out.printf(nf.format(start[i]) + " ");
                System.out.printf(nf.format(end[i]) + "\n");
            }
        }
    }
}
