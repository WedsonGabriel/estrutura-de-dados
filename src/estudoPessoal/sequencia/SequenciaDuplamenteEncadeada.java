package estudoPessoal.sequencia;

public class SequenciaDuplamenteEncadeada implements InterfaceSequencia{
    // ATRIBUTOS
    private int size_;
    private Node header;
    private Node trailer;

    // CONSTRUTOR
    public SequenciaDuplamenteEncadeada() {
        this.size_ = 0;
        this.header = new Node();
        this.trailer = new Node();

        header.setNext(trailer);
        trailer.setPrev(header);
    }

    // MÉTODOS (Sem tratamento de exceções)
    @Override
    public Integer size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }

    @Override
    public Object elemAtRank(Integer position) {
        Node atual = header.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        Node atual = header.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        atual.setValue(element);
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        Node atual = header.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();
        Node newNode = new Node();

        newNode.setValue(element);
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);

        atual.setPrev(newNode);
        noAnterior.setNext(newNode);
        size_++;
    }

    @Override
    public Object removeAtRank(Integer position) {
        Node atual = header.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        Node noPosterior = atual.getNext();
        Node noAnterior = atual.getPrev();

        noAnterior.setNext(noPosterior);
        noPosterior.setPrev(noAnterior);
        size_--;
        return antigoElemento;
    }

    @Override
    public boolean isFirst(Integer position) {
        return position == 0;
    }

    @Override
    public boolean isLast(Integer position) {
        return position == size_ - 1;
    }

    @Override
    public Object first() {
        Node atual = header.getNext();
        return atual.getValue();
    }

    @Override
    public Object last() {
        Node atual = trailer.getPrev();
        return atual.getValue();
    }

    @Override
    public Object before(Integer position) {
        Node atual = header.getNext();

        for (int i = 0; i < position - 1; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object after(Integer position) {
        Node atual = header.getNext();
        for (int i = 0; i <= position; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object replaceElement(Integer position, Object element) {
        Node atual = header.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        atual.setValue(element);
        return antigoElemento;
    }

    @Override
    public void swapElements(Integer position1, Integer position2) {
        Node atual1 = header.getNext();
        Node atual2 = header.getNext();

        for (int i = 0; i < position1; i++) {
            atual1 = atual1.getNext();
        }
        for (int i = 0; i < position2; i++) {
            atual2 = atual2.getNext();
        }
        Object p1 = atual1.getValue();
        Object p2 = atual2.getValue();

        atual1.setValue(p2);
        atual2.setValue(p1);
    }

    @Override
    public void insertBefore(Integer position, Object element) {
        Node atual = header.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();
        Node newNode = new Node();

        newNode.setValue(element);
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);

        noAnterior.setNext(newNode);
        atual.setPrev(newNode);
        size_++;
    }

    @Override
    public void insertAfter(Integer position, Object element) {
        Node atual = header.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noPosterior = atual.getNext();
        Node newNode = new Node();

        newNode.setValue(element);
        newNode.setPrev(atual);
        newNode.setNext(noPosterior);

        noPosterior.setPrev(newNode);
        atual.setNext(newNode);
        size_++;
    }

    @Override
    public void insertFirst(Object element) {
        Node atual = header.getNext();
        Node newNode = new Node();

        newNode.setValue(element);
        newNode.setNext(atual);
        newNode.setPrev(header);

        header.setNext(newNode);
        atual.setPrev(newNode);
        size_++;
    }

    @Override
    public void insertLast(Object element) {
        Node atual = trailer.getPrev();
        Node newNode = new Node();

        newNode.setValue(element);
        newNode.setNext(trailer);
        newNode.setPrev(atual);

        atual.setNext(newNode);
        trailer.setPrev(newNode);
        size_++;
    }

    @Override
    public Object remove(Integer position) {
        Node atual = header.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        Node noPosterior = atual.getNext();
        Node noAnterior = atual.getPrev();

        noAnterior.setNext(noPosterior);
        noPosterior.setPrev(noAnterior);
        size_--;
        return antigoElemento;
    }

    public Node atRank(Integer position) {
        Node atual = header.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual;
    }

    public Integer rankOf(Node node) {
        Node atual = header.getNext();

        for (int i = 0; i < size_; i++) {
            if (atual == node) {
                return i;
            }
            atual = atual.getNext();
        }
        return -1;
    }
}