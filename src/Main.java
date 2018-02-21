import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Phonebook hash_table = new Phonebook(DataStoreType.HASH_TABLE);
        Phonebook tree = new Phonebook(DataStoreType.TREE);

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

        ArrayList<Person> people = new ArrayList<>();
        people.add(kabir);
        people.add(cole);
        people.add(scott);
        people.add(kevin);


        runTests(hash_table, people);
    }

    private static void runTests(Phonebook phonebook, ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            phonebook.addContact(people.get(i));
        }
        Person scott = people.get(2);

        assert scott.equals(phonebook.getContact(scott.getFirstName(), scott.getLastName()));
        phonebook.removeContact(scott.getFirstName(), scott.getLastName());
        Person checkRemove = phonebook.getContact(scott.getFirstName(), scott.getLastName());
        assert checkRemove == null;
    }
}
