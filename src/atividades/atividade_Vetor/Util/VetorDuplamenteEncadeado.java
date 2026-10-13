package atividades.atividade_Vetor.Util;

import atividades.atividade_Vetor.Exception.VectorException;

public class VetorDuplamenteEncadeado implements VetorMedodos {
    // ATRIBUTOS
    private int size_;
    private Node head;
    private Node tail;

    // CONSTRUTOR
    public VetorDuplamenteEncadeado() {
        this.size_ = 0;
        this.head = new Node();
        this.tail = new Node();

        head.setNext(tail);
        tail.setPrev(head);
    }

    // MÉTODOS
    @Override
    public Object elemAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        Node atual = head.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual.getValue();
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        Node atual = head.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        atual.setValue(element);
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        if (position < 0 || position > size_) {
            throw new VectorException("Erro: Posição Inválida");
        }

        Node newNode = new Node();
        newNode.setValue(element);
        Node atual = head.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Node noAnterior = atual.getPrev();
        newNode.setNext(atual);
        newNode.setPrev(noAnterior);
        noAnterior.setNext(newNode);
        atual.setPrev(newNode);
        size_++;
    }

    @Override
    public Object removeAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        Node atual = head.getNext();

        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        Object antigoElemento = atual.getValue();
        Node anterior = atual.getPrev();
        Node posterior = atual.getNext();
        anterior.setNext(posterior);
        posterior.setPrev(anterior);
        size_--;
        return antigoElemento;
    }

    @Override
    public Integer size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        if (head.getNext() == tail) {
            return true;
        }
        return false;
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