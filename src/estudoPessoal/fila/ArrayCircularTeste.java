package estudoPessoal.fila;

public class ArrayCircularTeste implements InterfaceFila {
    // ATRIBUTOS
    private int i;
    private int f;
    private int capacity;
    private int size_;
    private Object[] array;

    // CONSTRUTOR
    public ArrayCircularTeste() {
        this.i = 0;
        this.f = 0;
        this.size_ = 0;
        this.capacity = 5;
        this.array = new Object[this.capacity];
    }

    // MÉTODOS
    @Override
    public void enqueue(Object element) {
        array[f] = element;
        f = (f+1) % capacity;
        size_++;
    }

    @Override
    public Object dequeue() {
        Object elementoRemovido = array[i];
        array[i] = null;
        i = (i+1) % capacity;
        size_--;
        return elementoRemovido;
    }

    @Override
    public Object first() {
        return array[i];
    }

    @Override
    public Integer size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }
}
