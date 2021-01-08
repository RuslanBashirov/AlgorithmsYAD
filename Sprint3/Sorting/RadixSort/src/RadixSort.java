
class RadixSort{
    public static void main(String[] args) {
        int[] arr = {170, 45, 75,90, 802, 24, 2, 66};

        for (int rank = 1; rank <= 100; rank*=10) {
            radixSort(arr, arr.length, rank);
        }

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void radixSort(int[] arr, int n, int rank){
        int[] out = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i]/rank) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i-1];

        //for (int i = 0; i < n; i++) {
        for (int i = n - 1; i >= 0; i--) {
            out[count[(arr[i]/rank) % 10]-1] = arr[i];
            count[(arr[i]/rank) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = out[i];
    }
}