public class Phonebook {
    private String storeType;
    private IDataStore<String, Person> store;

    public String getStoreType() {
        return storeType;
    }

    public Phonebook(String storeType) {
        this.storeType = storeType;
        if (this.storeType.equals("HASH_TABLE")) {
            this.store = new HashTable<String, Person>();
        } else if (this.storeType.equals("BST")) {
            this.store = new BST();
        }
    }
}
