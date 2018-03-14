public class Phonebook {
    private DataStoreType storeType;
    private IDataStore<String, Person> store;

    public Phonebook(DataStoreType storeType) {
        this.storeType = storeType;
        switch (storeType) {
            case HASH_TABLE:
                this.store = new HashTable<String, Person>();
                break;
            case TREE:
                this.store = new BST<String, Person>();
                break;
        }
    }

    public DataStoreType getStoreType() {
        return storeType;
    }

    public int size() {
        return this.store.size();
    }

    public Person getContact(String firstName, String lastName) {
        return this.store.get(getKey(firstName, lastName));
    }

    public boolean addContact(Person person) {
        return this.store.add(getKey(person.getFirstName(), person.getLastName()), person);
    }

    public Person removeContact(String firstName, String lastName) {
        return this.store.remove(getKey(firstName, lastName));
    }

    private String getKey(String firstName, String lastName) {
        return firstName.trim().toUpperCase() + '_' + lastName.trim().toUpperCase();
    }
}
