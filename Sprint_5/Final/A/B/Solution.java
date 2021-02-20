//45818606
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String command;
        MyHashTable myHashTable = new MyHashTable();

        for (int i = 0; i < n; i++) {
            command = sc.next();

            switch (command) {
                case "put": myHashTable.put(
                        Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
                        break;

                case "get": System.out.println(myHashTable
                        .get(Integer.parseInt(sc.next())));
                        break;

                case "delete":
                        if (myHashTable.delete(Integer.parseInt(sc.next())))
                         System.out.println("ok");
                        else System.out.println("error");
                        break;
            }

        }


    }


}

class MyHashTable{
    private static final int PRIME = 997;
    final Node[] array = new Node[1000];

    public void put(int key, int value){
        int hash = key % PRIME;

        Node node =  new Node(key, value);

        if (array[hash] != null){
            Node temp = array[hash];

            while (temp != null){
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }

            node.next = array[hash];
            array[hash] = node;
        }
        else array[hash] = node;
    }

    public int get(int key){
        int hash = key % PRIME;

        if (array[hash] != null) {
            Node temp = array[hash];

            while (temp != null){
                if (temp.key == key) return temp.value;
                temp = temp.next;
            }
        }

        return -1;
    }

    public boolean delete(int key){
        int hash = key % PRIME;

        if (array[hash] != null){
            Node temp = array[hash];

            //deleting head
            if (temp.key == key) {
                array[hash] = array[hash].next;
                return true;
            }

            //deleting mid or tail
            while (temp.next != null){
                if (temp.next.key == key){
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next;
            }

        }

        return false;
    }
}

class Node{
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}