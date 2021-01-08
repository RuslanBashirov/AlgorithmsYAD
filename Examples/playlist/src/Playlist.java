import java.io.*;



public class Playlist {
    public static void main(String[] args) {
        int n, r, e;
        int temp;
        try {
            File file = new File("input.txt");//C:\Users\bashi\IdeaProjects\playlist\
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String line3 = reader.readLine();
            reader.close();
            n = Integer.parseInt(line1);
            if (n <= 0) return;
            int length1 = line2.length();
            int length2 = line3.length();



            int row1[] = new int[n];
            int row2[] = new int[n];
            int result[] = new int[2*n];
            for (int i = 0; i < n; i++) {
                row1[i] = 0;
                row2[i] = 0;
            }
            int j1 = 0, j2 = 0;

            for (int i = 0; i < n; i++) {
                while ((j1 < length1) &&  (line2.charAt(j1) != ' ')){
                            row1[i] = row1[i] * 10 + line2.charAt(j1) - '0';
                            j1++;
                }
                j1++;
            }

            temp = 0;
            for (int i = 0; i < n; i++) {
                while ((j2 < length2) &&  (line3.charAt(j2) != ' ')){
                    temp = line3.charAt(j2) - '0';
                    row2[i] = row2[i] * 10 + temp;
                    j2++;
                }
                j2++;
            }

            for (int i = 0, j = 0; i < 2*n; i++, j++) {
                result[i] = row1[j];
                i++;
                result[i] = row2[j];
            }

            StringBuilder sbr = new StringBuilder();
            for (int i = 0; i < 2*n; i++) {
                sbr.append(result[i]);
                sbr.append(' ');
            }

            FileWriter nFile = new FileWriter("output.txt");

                nFile.write(sbr.toString());

                nFile.close();

        } catch (FileNotFoundException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }
}
