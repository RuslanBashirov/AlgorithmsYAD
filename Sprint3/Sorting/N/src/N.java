import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.HashMap;

public class N {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[][] nums = new int[n][m];
        String[] strings = new String[n];
        String[] tempStr;
        HashMap<Integer, MyStack> hm = new HashMap<>();

        for (int i = 0; i < n; i++)
            strings[i] = reader.readLine();
        reader.close();

        for (int i = 0; i < n; i++) {
            tempStr = strings[i].split(" ");

            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(tempStr[j]);
                if (!hm.containsKey(i-j)){
                    MyStack mystack = new MyStack();
                    mystack.push(nums[i][j]);
                    hm.put(i - j, mystack);
                }
                else hm.get(i-j).push(nums[i][j]);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!hm.get(i - j).ifSorted())
                    hm.get(i - j).sortDesc();
                System.out.print(hm.get(i - j).pop() + " ");
            }
            System.out.println();
        }
    }

}

class MyStack{
    int[] arr = new int[13];
    int size = 0;
    boolean ifSorted = false;

    void push(int el){
        if (size == arr.length){
            int[] arrBigger = new int[arr.length*3];

            for (int i = 0; i < size; i++)
                arrBigger[i] = arr[i];

            arr = arrBigger;
        }
        arr[size] = el;
        size++;
    }

    int pop(){
        if (hasNext()) {
            size--;
            return arr[size];
        }
        else return -1;
    }

    void sortDesc(){
        qSort(arr, 0, size-1);
        ifSorted = true;
    }

    boolean ifSorted(){
        return ifSorted;
    }

    boolean hasNext(){
        if (size == 0) return false;
        else return true;
    }

    static void qSort(int[] arr, int begin, int end){
        if (end - begin < 1) return;

        int i = begin;
        int swapTemp;

        for (int j = begin+1; j <= end; j++) {
            if (arr[j] > arr[begin]){
                i++;
                swapTemp = arr[j];
                arr[j] = arr[i];
                arr[i] = swapTemp;
            }
        }

        swapTemp = arr[i];
        arr[i] = arr[begin];
        arr[begin] = swapTemp;

        qSort(arr, begin, i - 1);
        qSort(arr, i + 1, end);
    }
}
