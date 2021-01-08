import java.io.*;

public class FindId {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");//C:\Users\bashi\IdeaProjects\FindId\
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            reader.close();
            int line2_length = line2.length();
            int all = Integer.parseInt(line1);
            int[] arr = new int[all+1];
            for (int i = 0; i <= all; i++) {
                arr[i] = -1;
            }

            for (int i = 0, j = 0, temp = 0; i < all-2; i++, j++) {
                while (j < line2_length && line2.charAt(j) != ' ') {
                    temp = temp * 10 + (line2.charAt(j) - '0');
                    j++;
                }
                arr[temp] = 1;
                temp = 0;
            }

            String result = "";
            String i_int;

            for (int i = 1; i <= all; i++) {
                if (arr[i] == -1) {
                    i_int = Integer.toString(i);
                    result = result.concat(i_int);
                    result = result.concat(" ");
                }
            }

            FileWriter nFile = new FileWriter("output.txt");
            nFile.write(result);
            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
