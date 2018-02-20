import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println("A".hashCode() + " " + "B".hashCode());
//
//        BST tree = new BST("Kabir");
//
//        tree.add("Cole");
//        tree.add("Scott");
//        tree.add("Kabir");
//        tree.inOrderTraversal(tree.getRoot());

        Person kabir = new Person(
                "Kabir", "Khan", "kabirkhan1137@gmail.com", 2065558101
        );
        Person cole = new Person(
                "Cole", "Smith", "cole@gmail.com", 2065558102
        );
        Person scott = new Person(
                "Scott", "Smith", "scott@gmail.com", 2065558103
        );
        Person kevin = new Person(
                "Kevin", "Smith", "kevin@gmail.com", 2065558104
        );

        HashTable<String, Person> map = new HashTable<>(1);


        Person val = map.getValue("Kabir");

        System.out.println(val.getFullName());

        Person removed = map.remove("Cole");
        System.out.println(val.getFullName());

        val = map.getValue("Cole");
        System.out.println(val);

    }
}
