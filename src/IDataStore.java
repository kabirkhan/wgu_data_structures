public interface IDataStore<K, V> {
    V add(K key, V value);
    V remove(K key);
    V get(K key);
}
