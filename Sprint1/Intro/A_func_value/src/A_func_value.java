import java.io.*;

public class A_func_value {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line1 = reader.readLine(); // get info here
            reader.close();

            String[] strings = line1.split(" ");

            int a = Integer.parseInt(strings[0]);
            int x = Integer.parseInt(strings[1]);
            int b = Integer.parseInt(strings[2]);
            int c = Integer.parseInt(strings[3]);

            Integer y = a * x * x + b * x + c;
           //System.out.println(y);

            FileWriter nFile = new FileWriter("output.txt");
            nFile.write(y.toString()); //return here
            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
