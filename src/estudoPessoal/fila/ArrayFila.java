package estudoPessoal.fila;
// O primeiro a entrar é o primeiro a sair

public class ArrayFila implements InterfaceFila{
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public ArrayFila() {
        this.size_ = 0;
        this.capacity = 5;
        array = new Object[this.capacity];
    }

    // MÉTODOS (Sem tratamento de exceções)
    @Override
    public void enqueue(Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = 0; i < size_; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size_] = element;
        size_++;
    }

    @Override
    public Object dequeue() {
        Object elementoRemovido = array[0];
        for (int i = 0; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        array[size_ - 1] = null;
        size_--;
        return elementoRemovido;
    }

    @Override
    public Object first() {
        return array[0];
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
