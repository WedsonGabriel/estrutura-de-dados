package estudoPessoal.fila;

public class FilaEncadeada implements InterfaceFila {
    // ATRIBUTOS
    private int size_;
    private Node header;
    private Node tail;

    // CONSTRUTOR
    public FilaEncadeada() {
        this.size_ = 0;
        this.header = new Node();
        header.setNext(null);
        this.tail = this.header;
    }

    // MÉTODOS (Sem tratamento de exceções)
    @Override
    public void enqueue(Object element) {
        Node newNode = new Node();
        newNode.setValue(element);
        newNode.setNext(null);

        tail.setNext(newNode);
        tail = newNode;
        size_++;
    }

    @Override
    public Object dequeue() {
        Node atual = header.getNext();
        Node noPosterior = atual.getNext();
        Object noRemovido = atual.getValue();

        header.setNext(noPosterior);
        size_--;

        if (size_ == 0) {
            tail = header;
        }
        return noRemovido;
    }

    @Override
    public Object first() {
        Node atual = header.getNext();
        return atual.getValue();
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