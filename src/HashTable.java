import jdk.nashorn.internal.objects.annotations.Optimistic;

/**
 * Generic HashTable structure to hold an associative array.
 * Can be defined like HashTable<String, Object> = new HashTable<>()
 *
 * @param <K>
 * @param <V>
 */

public class HashTable<K, V> implements IDataStore<K, V> {

    private static final int DEFAULT_TABLE_SIZE = 13;
    private int size;
    private HashEntryNode<K, V>[] table;

    static class HashEntryNode<K, V> {
        private K key;
        private V value;
        private HashEntryNode next;

        HashEntryNode(K key_, V value_) {
            key = key_;
            value = value_;
            next = null;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }

        HashEntryNode getNextNode() {
            return next;
        }

        void setNextNode(HashEntryNode node) {
            next = node;
        }
    }

    HashTable() {
        table = (HashEntryNode<K, V>[]) new HashEntryNode[DEFAULT_TABLE_SIZE];
    }

    HashTable(int tableSize) {
        table = (HashEntryNode<K, V>[]) new HashEntryNode[tableSize];
    }

    void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    private int getHashIndex(K key) {
        return key.hashCode() % table.length;
    }


    @Override()
    public int size() {
        return this.size;
    }

    @Override
    public V get(K key) {
        int index = getHashIndex(key);

        if (table[index] != null) {
            HashEntryNode runner = table[index];
            while (runner != null) {
                if (runner.getKey() == key) {
                    return (V)runner.getValue();
                }
                runner = runner.getNextNode();
            }
        }
        return null;
    }

    @Override
    public boolean add(K key, V val) {
        int index = getHashIndex(key);
        if (table[index] == null) {
            table[index] = new HashEntryNode<>(key, val);
            size++;
        } else {
            HashEntryNode runner = table[index];
            while (runner.getNextNode() != null) {
                runner = runner.getNextNode();
                if (runner.getKey() == key) {
                    runner.setValue(val);
                    return true;
                }
            }
            HashEntryNode newNode = new HashEntryNode<>(key, val);
            runner.setNextNode(newNode);
            size++;
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = getHashIndex(key);
        if (table[index] != null) {
            HashEntryNode runner = table[index];
            if (runner.getNextNode() == null) {
                // if the bucket only has one entry
                // clear the bucket entirely
                table[index] = null;
                return null;
            }
            if (runner.getKey() == key) {
                table[index] = runner.getNextNode();
                runner.setNextNode(null);
            }
            while (runner.getNextNode() != null) {
                if (runner.getNextNode().getKey() == key) {
                    V oldValue = (V)runner.getNextNode().getValue();
                    runner.setNextNode(runner.getNextNode().getNextNode());
                    size--;
                    return oldValue;
                }
                runner = runner.getNextNode();
            }
        }
        return null;
    }
}
