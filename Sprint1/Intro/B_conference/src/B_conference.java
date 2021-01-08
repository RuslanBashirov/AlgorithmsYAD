import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class B_conference {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line1 = reader.readLine(); // get info here
            String line2 = reader.readLine();
            reader.close();

            String[] strings = line1.split(" ");
            Integer[] nums = new Integer[strings.length];

            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            Arrays.sort(nums);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                stringBuilder.append(nums[i]).append(".");
                if ((i < nums.length - 1) && (nums[i+1].intValue() != nums[i].intValue()))
                    stringBuilder.append(" ");
            }

            String[] str = stringBuilder.toString().split(" ");

            Arrays.sort(str, new StringLengthComparator());

            for (int i = 0; i < str.length; i++) {
                str[i] = str[i].replaceAll("\\.", " ");
            }

            FileWriter nFile = new FileWriter("output.txt");


            StringBuilder result = new StringBuilder();
            for (int i = 0; i < Integer.parseInt(line2); i++) {
                result.append(str[i].split(" ")[0]);
                result.append(" ");
            }

            nFile.write(result.toString());

            nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}

class StringLengthComparator implements Comparator<String>{
    @Override
    public int compare (String s1, String s2){
        if (s1.length() > s2.length()) return -1;
        else if (s1.length() < s2.length()) return 1;
        else if (s1.charAt(0) < s2.charAt(0)) return -1;
        else return 1;
    }
}
