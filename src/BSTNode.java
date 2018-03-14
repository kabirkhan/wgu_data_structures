class BSTNode<K, V> {

    private K key;
    private V data;
    private BSTNode<K, V> left;
    private BSTNode<K, V> right;

    public BSTNode(K key, V data, BSTNode<K, V> left, BSTNode<K, V> right) {
        this.key = key;
        this.data = data;
        this.setLeft(left);
        this.setRight(right);
    }

    public BSTNode(K key, V data) {
        this(key, data, null, null);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getData() {
        return data;
    }

    public BSTNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    public BSTNode<K, V> getRight() {
        return right;
    }

    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }
}
