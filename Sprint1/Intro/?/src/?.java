import java.io.*;

public class С {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line1 = reader.readLine(); // get info here
            String line2 = reader.readLine();
            String line3 = reader.readLine();
            reader.close();

            String[] str = line2.split(" ");

            int X = 0;

            for (int i = 0; i < Integer.parseInt(line1); i++) {
                X = X * 10 + Integer.parseInt(str[i]);
            }

            int K = Integer.parseInt(line3);

            X += K;
            String res = Integer.toString(X);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < res.length(); i++) {
                stringBuilder.append(res.charAt(i)).append(" ");
            }

            FileWriter nFile = new FileWriter("output.txt");
            nFile.write(stringBuilder.toString()); //return here
            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
