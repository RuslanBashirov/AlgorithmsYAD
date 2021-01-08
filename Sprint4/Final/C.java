//42799342
import java.util.Scanner;

public class Pyramid{
    private Person[] arr;
    private int size = 0;

    Pyramid(int n){
        arr = new Person[n+1];
    }

    public Person getPerson(){
        Person peak = arr[1];
        arr[1] = arr[size];
        arr[size] = null;
        size--;

        swapWithChildRecursively(arr[1], 1);

        return peak;
    }

    private void swapWithChildRecursively(Person parent, int i){
        int morePriorChild;
        if ((2 * i) > size) return;
        if ((2 * i + 1) > size) morePriorChild = 2*i;
        else morePriorChild = Person.comparePersons(arr[2*i], arr[2*i+1]) > 0 ? (2*i) : (2*i+1); //compare two children and assign
                                                                                                // one of them to variable morePriorChild

        if (Person.comparePersons(arr[morePriorChild], parent) > 0) {
            arr[i] = arr[morePriorChild];
            arr[morePriorChild] = parent;
            swapWithChildRecursively(parent, morePriorChild);
        }

    }

    public void addPerson(Person child){
        size++;
        arr[size] = child;
        swapWithParentRecursively(child, size);
    }

    private void swapWithParentRecursively(Person child, int i){
        if (i == 1) return;
        if (Person.comparePersons(child, arr[i/2]) < 0) return; //base case - parent has bigger priority than a child
        
        Person temp = arr[i/2]; //arr[size/2] is a parent
        arr[i/2] = child;
        arr[i] = temp;
        swapWithParentRecursively(child, i/2);
    }



    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        String line;

        Pyramid pyramid = new Pyramid(n);
        
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            int firstSpaceId = 0;

            while (line.charAt(firstSpaceId) != ' ') firstSpaceId++;

            Person person = new Person(line.substring(0, firstSpaceId));
            person.setId(i);
            person.setListOfPoints(line.substring(firstSpaceId+1));
            pyramid.addPerson(person);
        }

        Person currPerson;

        for (int i = 0; i < n; i++) {
            currPerson = pyramid.getPerson();
            System.out.println(currPerson.getName() + " " + currPerson.getListOfPoints());
        }

    }
}



class Person{
    private final String name;
    private int points = 0;
    private String listOfPoints;
    private int id;
    private boolean ifKondratiy = true;
    private static final String KONDRATIY = "kondratiy";

    Person(String str){
        name = str;
        checkIfKondratiy();
    }


    public void setListOfPoints(String str) {
        listOfPoints = str;
        setPoints();
    }
    public void setPoints() { //method-parser to fit into memory limits
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < listOfPoints.length(); i++) {
            if (listOfPoints.charAt(i) == '-'){
                do i++;
                while (i < listOfPoints.length() && listOfPoints.charAt(i) != ' ');
                if (i == listOfPoints.length()) break;
                continue;
            }
            if (listOfPoints.charAt(i) == ' '){
                points += Integer.parseInt(sb.toString());
                sb.delete(0,listOfPoints.length());
            }
            else sb.append(listOfPoints.charAt(i));
        }
        if (sb.length() > 0) points += Integer.parseInt(sb.toString());
    }

    public void setId(int val) {id = val;}
    public String getName(){return name;}
    public int getPoints(){return points;}
    public String getListOfPoints(){return listOfPoints;}
    public int getId(){return id;}
    public boolean getIfKondratiy(){return ifKondratiy;}

    public void checkIfKondratiy(){
        int[] letters = new int[26];

        for (int i = 0; i < name.length(); i++)
            letters[name.charAt(i)-97]++;

        for (int i = 0; i < KONDRATIY.length(); i++)
            if (letters[KONDRATIY.charAt(i) - 97] == 0) ifKondratiy = false;
    }

    public static int comparePersons(Person p1, Person p2){
        //take into account only a sign of a return value
        //return positive when p1 has bigger priority than p2 else return negative
        if (p1.getIfKondratiy() && p2.getIfKondratiy()) return p1.getId() - p2.getId();
        else if (p1.getIfKondratiy()) return 1;
        else if (p2.getIfKondratiy()) return -1;

        int diff_points = p1.getPoints() - p2.getPoints();
        if (diff_points != 0) return diff_points;

        int comparison = p1.getName().compareTo(p2.getName());
        if (comparison != 0) return comparison*(-1);
        else return p1.getId() - p2.getId();
    }

}
