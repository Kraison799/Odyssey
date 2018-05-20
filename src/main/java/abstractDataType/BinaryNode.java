package abstractDataType;

public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    // CONSTRUCTORS
    public BinaryNode() {
        this.value = null;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // GETTERS AND SETTERS
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public BinaryNode<T> getLeft() {
        return left;
    }
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }
    public BinaryNode<T> getRight() {
        return right;
    }
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
