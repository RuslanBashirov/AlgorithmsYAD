import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        if (n < 4){
            System.out.println(0);
            return;
        }

        long S = Integer.parseInt(sc.nextLine());
        long[] nums = new long[n];
        int i = 0;



        while (i < n){
            nums[i] = Long.parseLong(sc.next());
            i++;
        }

        Arrays.sort(nums);

        for (int j = 0; j < n; j++) {
            System.out.print(nums[j]+" ");
        }
        System.out.println('\n'+"---------------------");

        long t1, t2, t3, t4;
        //List<String> list = new ArrayList<>();
        Map<Long, List<Long[]>> hashMap = new HashMap<>();
        long currHash = 0;
        List<Long[]> currObjInHashMap = null;

        for (int j = 0; j < n-3; j++) {

            for (int k = j+1; k < n-2; k++) {
                t2 = nums[j] + nums[k];

                for (int l = k+1; l < n-1; l++) {
                    t3 = t2 + nums[l];

                    for (int m = l+1; m < n; m++) {
                        if (t3 + nums[m] == S) {
                            /*System.out.print(nums[j] + " " + nums[k] + " " + nums[l] + " " + nums[m]);
                            System.out.println();*/
                            currHash = nums[j] + nums[k] + nums[l] + nums[m];

                            if (hashMap.containsKey(currHash)){
                                for (int g = 0; g < hashMap.get(currHash).size(); g++) {
                                    for (int p = 0; p < ; p++) {

                                    }
                                }
                            }
                            else {
                                Long[] arrOf4 = new Long[4];
                                arrOf4[0] = nums[j];
                                arrOf4[1] = nums[k];
                                arrOf4[2] = nums[l];
                                arrOf4[3] = nums[m];
                                hashMap.put(currHash, new ArrayList<>());
                                hashMap.get(currHash).add(arrOf4);
                            }
                            currHash = 0;
                        }
                    }
                }
            }
        }


    }
}
