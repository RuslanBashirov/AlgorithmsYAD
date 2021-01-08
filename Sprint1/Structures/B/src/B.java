import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String[][] strings = new String[m][n];
        String[] curr_line;

        for (int i = 0; i < n; i++) {
            curr_line = mySplit(reader.readLine(), m);

            for (int j = 0; j < m; j++) {
                strings[j][i] = curr_line[j];
            }
        }
        reader.close();

        FileWriter nFile = new FileWriter("output.txt");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nFile.write(strings[i][j]+" ");
            }
            nFile.write("\n");
        }

        nFile.close();
    }

    static String[] mySplit(String line, int m){
        String[] out = new String[m];
        int out_id = 0;
        StringBuilder sb = new StringBuilder();
        char currChar;

        for (int i = 0; i < line.length(); i++) {
            currChar = line.charAt(i);
            if (currChar != ' '){
                sb.append(currChar);
                if (i == line.length()-1) out[out_id] = sb.toString();
            }
            else {
                out[out_id] = sb.toString();
                out_id++;
                sb.delete(0, sb.length());
            }
        }

        return out;
    }
}
