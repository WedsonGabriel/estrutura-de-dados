package atividade_Sequencia.util;

import atividade_Sequencia.exceptions.SequenciaException;

public class SequenciaDuplamenteEncadeada implements MetodosSequencia {
    // ATRIBUTOS
    private int size_;
    private Node head;
    private Node tail;

    // CONSTRUTOR
    public SequenciaDuplamenteEncadeada() {
        this.size_ = 0;
        this.head = new Node();
        this.tail = new Node();

        head.setNext(tail);
        tail.setPrev(head);
    }

    // MÉTODOS
    @Override
    public Integer size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object elemAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual.element();
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.element();
        atual.setElement(element);
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        if (position < 0 || position > size_) {
            throw new SequenciaException("Erro: Posição inválida!");
        }
        if (position == 0) {
            insertFirst(element);
            return;
        }
        if (position == size_) {
            insertLast(element);
            return;
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();
        Node newNode = new Node();

        newNode.setElement(element);
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);

        noAnterior.setNext(newNode);
        atual.setPrev(newNode);
        size_++;
    }

    @Override
    public Object removeAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();
        Node noPosterior = atual.getNext();

        noAnterior.setNext(noPosterior);
        noPosterior.setPrev(noAnterior);
        size_--;
        return atual.element();
    }

    @Override
    public Position first() {
        if (isEmpty()) {
            throw new SequenciaException("Erro: Sequência vazia!");
        }
        return head.getNext();
    }

    @Override
    public Position last() {
        if (isEmpty()) {
            throw new SequenciaException("Erro: Sequência vazia!");
        }
        return tail.getPrev();
    }

    @Override
    public Position before(Position position) {
        Node atual = (Node) position;
        if (atual == head.getNext()) {
            throw new SequenciaException("Erro: Não existe posição anterior!");
        }
        return atual.getPrev();
    }

    @Override
    public Position after(Position position) {
        Node atual = (Node) position;
        if (atual == tail.getPrev()) {
            throw new SequenciaException("Erro: Não existe posição posterior!");
        }
        return atual.getNext();
    }

    @Override
    public Object replaceElement(Position position, Object element) {
        Node atual = (Node) position;
        Object antigoElemento = atual.element();
        atual.setElement(element);
        return antigoElemento;
    }

    @Override
    public void swapElements(Position position1, Position position2) {
        Node p1 = (Node) position1;
        Node p2 = (Node) position2;
        Object p1Element = p1.element();
        Object p2Element = p2.element();
        p1.setElement(p2Element);
        p2.setElement(p1Element);
    }

    @Override
    public void insertBefore(Position position, Object element) {
        Node atual = (Node) position;
        Node noAnterior = atual.getPrev();
        Node newNode = new Node();

        newNode.setElement(element);
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);

        atual.setPrev(newNode);
        noAnterior.setNext(newNode);
        size_++;
    }

    @Override
    public void insertAfter(Position position, Object element) {
        Node atual = (Node) position;
        Node noPosterior = atual.getNext();
        Node newNode = new Node();

        newNode.setElement(element);
        newNode.setNext(noPosterior);
        newNode.setPrev(atual);

        atual.setNext(newNode);
        noPosterior.setPrev(newNode);
        size_++;
    }

    @Override
    public void insertFirst(Object element) {
        Node atual = head.getNext();
        Node newNode = new Node();

        newNode.setElement(element);
        newNode.setNext(atual);
        newNode.setPrev(head);

        head.setNext(newNode);
        atual.setPrev(newNode);
        size_++;
    }

    @Override
    public void insertLast(Object element) {
        Node atual = tail.getPrev();
        Node newNode = new Node();

        newNode.setElement(element);
        newNode.setNext(tail);
        newNode.setPrev(atual);

        tail.setPrev(newNode);
        atual.setNext(newNode);
        size_++;
    }

    @Override
    public Object remove(Position position) {
        Node atual = (Node) position;
        Node noAnterior = atual.getPrev();
        Node noPosterior = atual.getNext();

        noAnterior.setNext(noPosterior);
        noPosterior.setPrev(noAnterior);

        size_--;

        return atual.element();
    }

    @Override
    public Position atRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual;
    }

    @Override
    public Integer rankOf(Position position) {
        Node procurado = (Node) position;
        Node atual = head.getNext();
        int rank = 0;

        while (atual != tail) {
            if (atual == procurado) {
                return rank;
            }
            atual = atual.getNext();
            rank++;
        }
        throw new SequenciaException("Erro: Posição não encontrada!");
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "A Sequência está vazia!";
        }
        StringBuilder sb = new StringBuilder("NULL <-> ");
        Node atual = head.getNext();

        while (atual != tail) {
            sb.append(atual.element());
            if (atual.getNext() != tail) {
                sb.append(" <-> ");
            }
            atual = atual.getNext();
        }
        sb.append(" <-> NULL");
        return sb.toString();
    }
}