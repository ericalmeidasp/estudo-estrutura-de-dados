package data.structures;

public class ArvoreDeBuscaBinariaImpl<T extends Comparable<T>> implements ArvoreDeBuscaBinaria<T> {

    private final T data;
    private ArvoreDeBuscaBinariaImpl<T> left;
    private ArvoreDeBuscaBinariaImpl<T> right;

    public ArvoreDeBuscaBinariaImpl(T data) {
        this.data = data;
    }

    @Override
    public void insert(T data) {
        insert(this, data);
    }

    private void insert(ArvoreDeBuscaBinariaImpl<T> tree, T data) {
        if (data.compareTo(tree.data) > 0) {
            if (tree.right == null) {
                tree.right = new ArvoreDeBuscaBinariaImpl<>(data);
            } else {
                tree.right.insert(data);
            }
        } else {
            if (tree.left == null) {
                tree.left = new ArvoreDeBuscaBinariaImpl<>(data);
            } else {
                tree.left.insert(data);
            }
        }
    }

    @Override
    public boolean exists(T data) {
        return false;
    }

    @Override
    public ArvoreDeBuscaBinaria<T> retrieve(T data) {
        return null;
    }

    @Override
    public void preOrder() {
        preOrder(this);
    }

    private void preOrder(ArvoreDeBuscaBinariaImpl<T> tree) {
        System.out.println(tree.data);
        if (tree.left != null) {
            tree.left.preOrder();
        }
        if (tree.right != null) {
            tree.right.preOrder();
        }
    }

    @Override
    public void inOrder() {
        inOrder(this);
    }

    private void inOrder(ArvoreDeBuscaBinariaImpl<T> tree) {
        if (tree.left != null) {
            tree.left.inOrder();
        }
        System.out.println(tree.data);
        if (tree.right != null) {
            tree.right.inOrder();
        }
    }

    @Override
    public void posOrder() {
        posOrder(this);
    }

    private void posOrder(ArvoreDeBuscaBinariaImpl<T> tree) {
        if (tree.left != null) {
            tree.left.posOrder();
        }
        if (tree.right != null) {
            tree.right.posOrder();
        }
        System.out.println(tree.data);
    }

    @Override
    public void bfs() {

    }

    public static void main(String[] args) {
        ArvoreDeBuscaBinariaImpl<Integer> arvore = new ArvoreDeBuscaBinariaImpl<>(30);
        arvore.insert(25);
        arvore.insert(35);
        arvore.insert(20);
        arvore.insert(40);
        arvore.insert(10);
        arvore.insert(50);
        arvore.insert(27);
        arvore.insert(32);
        arvore.insert(23);
        arvore.insert(42);

        System.out.println("--- InOrder ---");
        arvore.inOrder();
        System.out.println("--- PreOrder ---");
        arvore.preOrder();
        System.out.println("--- PosOrder ---");
        arvore.posOrder();

        ArvoreDeBuscaBinariaImpl<String> stringTree = new ArvoreDeBuscaBinariaImpl<>("meu");
        stringTree.insert("top");
        stringTree.insert("abc");
        stringTree.insert("teste");
        stringTree.insert("vamos");

        System.out.println("--- InOrder ---");
        stringTree.inOrder();
        System.out.println("--- PreOrder ---");
        stringTree.preOrder();
        System.out.println("--- PosOrder ---");
        stringTree.posOrder();

    }
}

