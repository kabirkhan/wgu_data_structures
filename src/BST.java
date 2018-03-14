import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BST<K, V> implements IDataStore<K, V> {
    private BSTNode<K, V> root;
    private int size;

    public BSTNode<K, V> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public V get(K key) {
        BSTNode<K, V> foundNode = this.doSearch(key);
        V out = null;
        if (foundNode != null) {
            out = foundNode.getData();
        }
        return out;
    }

    private BSTNode<K, V> doSearch(K key) {
        BSTNode<K, V> current = this.getRoot();
        if (current == null) {
            return null;
        }

        while (current != null && current.getKey() != key) {
            if (key.hashCode() < current.getKey().hashCode()) {
                current = current.getLeft();
            } else if (key.hashCode() > current.getKey().hashCode()) {
                current = current.getRight();
            } else {
                // We found the key here
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean add(K key, V val) {
        BSTNode<K, V> current = this.getRoot();
        BSTNode<K, V> newNode = new BSTNode<>(key, val);

        if (current == null) {
            this.root = newNode;
            return true;
        }

        while (current.getLeft() != null && current.getRight() != null) {
            if (key.hashCode() < current.getKey().hashCode()) {
                current = current.getLeft();
            } else if (key.hashCode() > current.getKey().hashCode()) {
                current = current.getRight();
            } else {
                // TODO: handle duplicate keys
                return false;
            }
        }

        if (newNode.getKey().hashCode() < current.getKey().hashCode()) {
            current.setLeft(newNode);
        } else if (newNode.getKey().hashCode() > current.getKey().hashCode()) {
            current.setRight(newNode);
        }
        size++;
        return true;
    }

    @Override
    public V remove(K key) {
        return this._remove(key, this.getRoot());
    }

    private V _remove(K key, BSTNode current) {
        if (current == null) {
            return null;
        }
        if (key.hashCode() < current.getKey().hashCode()) {
            _remove(key, current.getLeft());
        } else if (key.hashCode() > current.getKey().hashCode()) {
            _remove(key, current.getRight());
        } else {
            // Remove the current node
            if (current.getLeft() != null && current.getRight() != null) {
                BSTNode<K, V> maxLeft = findMax(current.getLeft());
                current.setKey(maxLeft.getKey());
                _remove(maxLeft.getKey(), current.getLeft());
            } else if (current.getLeft() != null) {
                BSTNode<K, V> trash = current;
                current = current.getLeft();
                current = null;
                return trash.getData();
            } else if (current.getRight() != null) {
                BSTNode<K, V> trash = current;
                current = current.getRight();
                current = null;
                return trash.getData();
            } else {
                current = null;
            }
        }
        return null;
    }

    private BSTNode<K, V> findMax(BSTNode<K, V> from) {
        if (from == null) {
            return from;
        } else {
            return findMax(from.getRight());
        }
    }
}