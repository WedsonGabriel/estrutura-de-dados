package estudoPessoal.fila;

public class ArrayCircularFila {
    // ATRIBUTOS
    private int i;
    private int f;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public ArrayCircularFila() {
        this.capacity = 5;
        this.array = new Object[this.capacity];
        this.i = 0;
        this.f = 0;
    }

    public void enqueue(Object element) {
        if (size() == capacity - 1) {
            int newCapacity = capacity * 2;
            Object[] newArray = new Object[newCapacity];

            int n = size();
            for (int k = 0; k < n; k++) {
                newArray[k] = array[(i + k) % capacity];
            }
            f = n;
            i = 0;
            capacity = newCapacity;
            array = newArray;
        }
        array[f] = element;
        f = (f + 1) % capacity;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!");
        }
        Object primeiro = array[i];
        array[i] = null;

        i = (i + 1) % capacity;
        return primeiro;
    }

    public Object first() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!");
        }
        return array[i];
    }

    public Integer size() {
        return (capacity - i + f) % capacity;
    }

    public boolean isEmpty() {
        return i == f;
    }
}
