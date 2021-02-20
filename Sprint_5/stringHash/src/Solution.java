public class Solution {
    public static void main(String[] args) {
        String kndr = "Kondratiy";
        int hash = 0;
        int a = 5, m = 113;

        for (int i = 0; i < kndr.length(); i++) {
            int charCode = kndr.charAt(i);
            hash += charCode * Math.pow(a, kndr.length()-1-i);
        }

        System.out.println(hash%m);
    }
}
