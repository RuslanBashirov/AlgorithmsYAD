//41034884
//Сделал с обьединением массивов, без этого сделать задачу не смог
import java.io.*;
import java.text.DecimalFormat;

public class GoldenRatio {
    public static void main(String[] args) throws IOException {
        final File file = new File("input.txt");
        final FileReader fr = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fr);
        final int n = Integer.parseInt(reader.readLine());
        final int m = Integer.parseInt(reader.readLine());
        final String[] stringsFirst = reader.readLine().split(" ");
        final String[] stringsSecond = reader.readLine().split(" ");
        reader.close();

        int[] numsFirst = new int[n];
        int[] numsSecond = new int[m];
        final DecimalFormat df1 = new DecimalFormat( "#.##" );

        for (int i = 0; i < n; i++) {
            numsFirst[i] = Integer.parseInt(stringsFirst[i]);
        }

        for (int i = 0; i < m; i++) {
            numsSecond[i] = Integer.parseInt(stringsSecond[i]);
        }

        int[] result = merge(numsFirst, n, numsSecond, m);
        
        if ((m + n) % 2 == 1) System.out.println(result[(m + n) / 2]);
        else {
            final float f1 = result[(m + n) / 2];
            final float f2 = result[((m + n) / 2) - 1];
            float f3 = (f1+f2)/2;
            System.out.println(df1.format(f3));
        }
    }

    static private int[] merge(int[] array1, int n, int[] array2, int m){
        int[] result = new int[n + m];
        int id1 = 0, id2 = 0, i = 0;

        for (; id1 < n && id2 < m; i++) {
            if (array1[id1] < array2[id2]) {
                result[i] = array1[id1];
                id1++;
            }
            else {
                result[i] = array2[id2];
                id2++;
            }
        }

        if (id1 < n){
            for (; i < n + m; i++, id1++)
                result[i] = array1[id1];
        }
        else {
            for (; i < n + m; i++, id2++)
                result[i] = array2[id2];
        }

        return result;
    }
}
