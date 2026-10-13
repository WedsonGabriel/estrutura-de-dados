package estudoPessoal.pilha;

public class PilhaEncadeada implements InterfacePilha{
    // ATRIBUTOS
    private int size_;
    private Node header;

    // CONSTRUTOR
    public PilhaEncadeada() {
        this.size_ = 0;
        this.header = new Node();
        header.setNext(null);
    }

    // MÉTODOS (Sem tratamento de exceções)
    @Override
    public void push(Object element) {
        Node atual = header.getNext();
        Node newNode = new Node();
        newNode.setValue(element);

        header.setNext(newNode);
        newNode.setNext(atual);
        size_++;
    }

    @Override
    public Object pop() {
        Node atual = header.getNext();
        Node noPosterior = atual.getNext();
        header.setNext(noPosterior);
        size_--;
        return atual.getValue();
    }

    @Override
    public Object top() {
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
