/**
 * Kabir Khan
 * Data Structures must implement this interface
 * to store Person records
 */
public interface IDataStore<K, V> {

    /**
     * Number of entries in the data structure
     *
     * @return (int) size of data store
     */
    int size();

    /**
     * Return the value associated with a specified key
     *
     * @param key - Key to search for
     * @return (V) the value at key, otherwise null
     */
    V get(K key);

    /**
     * Insert a new value into the data store
     *
     * @param key - identifier for new entry
     * @param value - value to add at key
     * @return (boolean) returns true if successful
     *
     */
    boolean add(K key, V value);

    /**
     * Remove the value at given key
     *
     * @param key the key to remove from data structure
     * @return (V) the value removed if it existed, otherwise null
     */
    V remove(K key);
}
