package data.structures;

public class FilaImpl<T> implements Fila<T> {

    private final T[] elements;
    private int front;
    private int rear;

    public FilaImpl(int size) {
        if (size <= 0) throw new RuntimeException("Tamanho invalido: " + size);
        this.elements = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) throw new RuntimeException("Lista Cheia");
        if (isEmpty()) this.front++;

        this.elements[getNextRear()] = data;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Fila Vazia");
        if (this.front == this.rear) {
            var response = this.elements[this.front];
            this.front = -1;
            this.rear = -1;
            return response;
        }
        return this.elements[getFrontAndAfterAdd()];
    }

    @Override
    public T front() {
        return this.elements[this.front];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    @Override
    public boolean isFull() {
        return this.rear - this.front == 4 || this.rear - this.front == -1;
    }

    private int getFrontAndAfterAdd() {
        int response = this.front;
        this.front = this.front == 4 ? 0 : ++this.front;
        return response;
    }

    private int getNextRear() {
        return this.rear == 4 ? this.rear = 0 : ++this.rear;
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new FilaImpl<>(5);

        fila.enqueue(5);
        fila.enqueue(4);
        fila.enqueue(3);
        fila.enqueue(2);
        fila.enqueue(1);

        System.out.println(fila.dequeue());
        fila.enqueue(5);

        System.out.println(fila.dequeue());
        fila.enqueue(4);

        System.out.println(fila.dequeue());
        fila.enqueue(3);

        System.out.println(fila.dequeue());
        fila.enqueue(2);

        System.out.println(fila.dequeue());
        fila.enqueue(1);

        System.out.println(fila.dequeue());
        fila.enqueue(5);

        System.out.println(fila.dequeue());
        fila.enqueue(4);

        System.out.println(fila.dequeue());
        fila.enqueue(3);
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
    }


}
