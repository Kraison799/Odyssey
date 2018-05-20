package abstractDataType;

@SuppressWarnings("unchecked")
public class BinarySearchTree<T extends Comparable<T>>  {

    private TreeNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void add(T value){
        this.root = this.add(value, this.root);
    }

    private TreeNode add(T value, TreeNode<T> current){
        if (current == null){
            return new TreeNode<>(value);
        } else if (current.getValue().compareTo(value) > 0){
            current.setLeft(this.add(value, current.getLeft()));
        } else if (current.getValue().compareTo(value) < 0){
            current.setRight(this.add(value, current.getRight()));
        }
        return current;
    }

    public void remove(T data){
        this.root = remove(data, this.root);
    }

    private TreeNode<T> remove(T data, TreeNode<T> current){
        if(current == null){
            return current;
        }
        if(current.getValue().compareTo(data) > 0){
            current.setLeft(remove(data, current.getLeft()));
        } else if(current.getValue().compareTo(data) < 0){
            current.setRight(remove(data, current.getRight()));
        } else if(current.getLeft() != null && current.getValue() != null){
            current.setValue(findMin(current.getRight()).getValue());
            current.setRight(remove(current.getValue(), current.getRight()));
        } else{
            current  = current.getLeft() != null? current.getLeft(): current.getRight();
        }
        return current;
    }

    private TreeNode<T> findMin(TreeNode<T> current){
        if (current == null){
            return null;
        } else if (current.getLeft() == null){
            return current;
        } else{
            return findMin(current.getLeft());
        }
    }

    public void printInorden(){
        printInorden(root);
    }

    private void printInorden(TreeNode<T> current){
        if (current != null){
            printInorden(current.getLeft());
            System.out.println(current.getValue() + "");
            printInorden(current.getRight());
        }
    }

}
