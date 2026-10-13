package estudoPessoal.pilha;
// O último a entrar é o primeiro a sair

public class ArrayPilha implements InterfacePilha{
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public ArrayPilha() {
        this.size_ = 0;
        this.capacity = 5;
        array = new Object[this.capacity];
    }

    // MÉTODOS (Sem tratamento de exceções)
    @Override
    public void push(Object element) {
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
    public Object pop() {
        Object elementoRemovido = array[size_ - 1];
        array[size_ - 1] = null;
        size_--;
        return elementoRemovido;
    }

    @Override
    public Object top() {
        return array[size_ - 1];
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
