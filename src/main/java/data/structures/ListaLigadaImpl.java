package data.structures;

public class ListaLigadaImpl<T> implements ListaLigada<T> {

    private Node<T> first;

    public ListaLigadaImpl() {
    }

    public ListaLigadaImpl(T data) {
        this.first = new Node<T>(data);
    }

    @Override
    public void inserirInicio(T data) {
        var newNode = new Node<>(data);
        newNode.next = first;
        first = newNode;
    }

    @Override
    public void inserirFinal(T data) {
        var newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            return;
        }

        var lastElement = first;

        while (lastElement.getNext() != null) {
            lastElement = lastElement.getNext();
        }
        lastElement.setNext(newNode);
    }

    @Override
    public T removerInicio() {
        if (first != null) {
            var removed = first;
            first = first.getNext();
            return removed.getData();
        }
        return null;
    }

    @Override
    public T removerFinal() {
        Node<T> removedElement = null;
        if (first != null) {
            Node<T> lastElement = first;
            while (lastElement.getNext().getNext() != null) {
                lastElement = lastElement.getNext();
            }
            removedElement = lastElement.getNext();
            lastElement.setNext(null);
        }
        return removedElement != null ? removedElement.getData() : null;
    }

    @Override
    public void imprimir() {
        var element = first;
        if (element != null) {
            do {
                System.out.println(element.getData());
                element = element.getNext();
            } while (element != null);
        }
    }

    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public static void main(String[] args) {
        ListaLigadaImpl<String> ligada = new ListaLigadaImpl<>();

        ligada.inserirInicio("oi");
        ligada.inserirInicio("tchau");
        ligada.inserirFinal("fim");

        ligada.imprimir();

        ligada.removerFinal();
        ligada.removerInicio();
        ligada.imprimir();
    }
}


