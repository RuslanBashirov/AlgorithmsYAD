import java.io.*;

public class CodeNumber {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");//C:\Users\bashi\IdeaProjects\CodeNumber
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String y = reader.readLine();
            reader.close();

            boolean sign;

            if (y.charAt(0) == '-') {
                sign = false;
                y = y.substring(1, y.length());
            }
            else sign = true;

            y = new StringBuilder(y).reverse().toString();

            while (y.charAt(0) == '0' && y.length() > 1)
                y = y.substring(1, y.length());

            if (!sign) y = "-".concat(y);

            FileWriter nFile = new FileWriter("output.txt");
            nFile.write(y);
            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
