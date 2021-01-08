import java.io.*;

public class Matrix {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");//C:\Users\bashi\IdeaProjects\matrix\
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line1 = reader.readLine();
            int m = Integer.parseInt(line1);
            String[] lines = new String[m];

            //считываем
            for (int i = 0; i < m; i++) {
                lines[i] = reader.readLine();
            }
            reader.close();

            int[][] multi = new int[m][m];
            int[] rows = new int[m];
            boolean sign = true;

            //Распарсинг входных строк
            for (int i = 0; i < m; i++) {
                for (int j = 0, k = 0; k < m; k++, j++) {
                        while (j < lines[i].length() && lines[i].charAt(j) != ' ') {
                            if (lines[i].charAt(j) == '-') {
                                sign = false;
                                j++;
                                continue;
                            }
                            multi[i][k] = multi[i][k] * 10 + lines[i].charAt(j) - '0';
                            j++;
                        }
                        if (!sign) multi[i][k] = multi[i][k] * (-1);
                        sign = true;
                }
            }

            //инициализация каунтера
            int[] counter = new int[m*m];
            int counter_sum = 1;
            for (int i = 0; i < m*m; i++) {
                counter[i] = i + 1;
            }


            int i, j;
            StringBuilder result = new StringBuilder("");
            int row = m/2, col = m/2;
            result = result.append(multi[row][col]).append("\n");
            int m_sq = m * m;

            //совершаем обход
            while ((row != 0 ) && (col != 0)) {
                for (int k = 0; k < counter[k] && counter_sum < m_sq; k++) {
                    if (counter[k] % 2 == 1) {
                        for (int l = 0; l < counter[k] && counter_sum < m_sq; l++, counter_sum++) {
                            row--;
                            result = result.append(multi[row][col]).append("\n");
                        }
                        for (int p = 0; p < counter[k] && counter_sum < m_sq; p++, counter_sum++) {
                            col++;
                            result = result.append(multi[row][col]).append("\n");
                        }
                    }
                    else {
                            for (int l = 0; l < counter[k] && counter_sum < m_sq; l++, counter_sum++) {
                                row++;
                                result = result.append(multi[row][col]).append("\n");
                            }
                            for (int p = 0; p < counter[k] && counter_sum < m_sq; p++, counter_sum++) {
                                col--;
                                result = result.append(multi[row][col]).append("\n");
                            }
                    }
                }
            }

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
