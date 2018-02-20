import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class BST<K, V> implements IDataStore<K, V> {
    private BSTNode root;

    BSTNode getRoot() {
        return root;
    }

    BST(String rootData) {
        this.root = new BSTNode(rootData);
    }

    V add(String data) {
        BSTNode current = this.root;
        BSTNode newNode = new BSTNode(data);

        while (current.getLeft() != null && current.getRight() != null) {
            if (data.hashCode() < current.getData().hashCode()) {
                current = current.getLeft();
            } else if (data.hashCode() > current.getData().hashCode()) {
                current = current.getRight();
            } else {
                return null;
            }
        }

        if (data.hashCode() < current.getData().hashCode()) {
            current.setLeft(newNode);
        } else if (data.hashCode() > current.getData().hashCode()) {
            current.setRight(newNode);
        }
        return null;
    }

    V get(K key) {

    }

    void inOrderTraversal(BSTNode current) {
        if (current == null) {
            return;
        }
        inOrderTraversal(current.getLeft());
        System.out.print(current.getData());
        inOrderTraversal(current.getRight());
    }
}