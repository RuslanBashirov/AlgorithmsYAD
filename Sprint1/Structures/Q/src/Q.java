public class Q {
    class Dequeue{
        Dequeue(int capacity){
            dequeue = new int[capacity*2];
        }

        int[] dequeue;
        int size = 0;

        public void push_back(int num){
            if (size == dequeue.length - 1) System.out.println("error");
        }
        public void push_front(int num){
            if (size == dequeue.length - 1) System.out.println("error");
        }
        public void pop_front(int num){
            if (size == 0) System.out.println("error");
        }
        public void pop_back(int num){
            if (size == 0) System.out.println("error");
        }
    }
    public static void main(String[] args) {

    }
}
