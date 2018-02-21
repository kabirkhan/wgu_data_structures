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

        while (current.getKey() != key) {
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
        BSTNode<K, V> foundNode = this.doSearch(key);

        if (foundNode == null) {
            return null;
        }

        System.out.println("Working on it");
        return null;
    }

//    void inOrderTraversal(BSTNode current) {
//        if (current == null) {
//            return;
//        }
//        inOrderTraversal(current.getLeft());
//        System.out.print(current.getKey());
//        inOrderTraversal(current.getRight());
//    }
}