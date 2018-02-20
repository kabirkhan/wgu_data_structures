class BSTNode<V> {
    private String data;
    private BSTNode left;
    private BSTNode right;

    BSTNode(String data) {
        this.data = data;
    }

    String getData() {
        return data;
    }

    void setData(String data) {
        this.data = data;
    }

    BSTNode getLeft() {
        return left;
    }

    void setLeft(BSTNode left) {
        this.left = left;
    }

    BSTNode getRight() {
        return right;
    }

    void setRight(BSTNode right) {
        this.right = right;
    }
}
