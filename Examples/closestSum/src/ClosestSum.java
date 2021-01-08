import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class ClosestSum {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");//C:\Users\bashi\IdeaProjects\playlist\
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line1 = reader.readLine();
            int aim = Integer.parseInt(line1);
            String line2 = reader.readLine();
            reader.close();

            String[] strings = line2.split(" ");
            int num_of_el = strings.length;

            Integer[] nums = new Integer[num_of_el];
            for (int i = 0; i < num_of_el; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            Arrays.sort(nums, Collections.reverseOrder());
            for (int i = 0; i < num_of_el; i++) {
                System.out.println(nums[i]);
            }

            int res_i = 0, res_j = 1, res_k = 2;
            for (int i = 0, rem = 0, k = 0; i < num_of_el - 2; i++) {
                for (int j = 1; j < num_of_el - 1; j++) {
                    rem = aim - (nums[i] + nums[j]);
                }
            }

            String result = "";
            FileWriter nFile = new FileWriter("output.txt");

            nFile.write(result.toString());

            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
