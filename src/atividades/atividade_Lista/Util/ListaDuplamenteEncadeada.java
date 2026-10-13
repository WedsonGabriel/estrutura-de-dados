package atividades.atividade_Lista.Util;

import atividades.atividade_Lista.Exception.ListaException;

public class ListaDuplamenteEncadeada implements ListaMetodos{
    // ATRIBUTOS
    private int size_;
    private Node head;
    private Node tail;

    // CONSTRUTOR
    public ListaDuplamenteEncadeada() {
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
    public boolean isFirst(Integer position) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        return position == 0;
    }

    @Override
    public boolean isLast(Integer position) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        return position == size_ - 1;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new ListaException("Erro: Lista vazia!");
        }
        Node first = head.getNext();
        return first.getValue();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new ListaException("Erro: Lista vazia!");
        }
        Node last = tail.getPrev();
        return last.getValue();
    }

    @Override
    public Object before(Integer position) {
        if (position <= 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position - 1; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object after(Integer position) {
        if (position < 0 || position >= size_ - 1) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i <= position; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object replaceElement(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElement = atual.getValue();
        atual.setValue(element);
        return antigoElement;
    }

    @Override
    public void swapElements(Integer position1, Integer position2) {
        if (position1 < 0 || position1 >= size_ || position2 < 0 || position2 >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node p1 = head.getNext();
        Node p2 = tail.getPrev();

        for (int i = 0; i < position1; i++) {
            p1 = p1.getNext();
        }

        for (int i = size_ - 1; i > position2; i--) {
            p2 = p2.getPrev();
        }

        Object p1Value = p1.getValue();
        Object p2Value = p2.getValue();
        p1.setValue(p2Value);
        p2.setValue(p1Value);
    }

    @Override
    public void insertBefore(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        Node newNode = new Node();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();

        newNode.setValue(element);
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);

        atual.setPrev(newNode);
        noAnterior.setNext(newNode);
        size_++;
    }

    @Override
    public void insertAfter(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        Node newNode = new Node();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noPosterior = atual.getNext();

        newNode.setValue(element);
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

        newNode.setValue(element);
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

        newNode.setValue(element);
        newNode.setNext(tail);
        newNode.setPrev(atual);

        tail.setPrev(newNode);
        atual.setNext(newNode);
        size_++;
    }

    @Override
    public Object remove(Integer position) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Node atual = head.getNext();
        for (int i = 0; i < position; i++){
            atual = atual.getNext();
        }

        Node noAnterior = atual.getPrev();
        Node noPosterior = atual.getNext();
        noAnterior.setNext(noPosterior);
        noPosterior.setPrev(noAnterior);

        size_--;
        return atual.getValue();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "O Vetor está vazio!";
        }
        StringBuilder sb = new StringBuilder("NULL <-> ");
        Node atual = head.getNext();

        while (atual != tail) {
            sb.append(atual.getValue());

            if (atual.getNext() != tail) {
                sb.append(" <-> ");
            }

            atual = atual.getNext();
        }
        sb.append(" <-> NULL");
        return sb.toString();
    }
}