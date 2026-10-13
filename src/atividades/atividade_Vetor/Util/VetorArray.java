package atividades.atividade_Vetor.Util;

import atividades.atividade_Vetor.Exception.VectorException;

public class VetorArray implements VetorMedodos {
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public VetorArray(){
        this.size_ = 0;
        this.capacity = 5;
        array = new Object[this.capacity];
    }

    // MÉTODOS
    @Override
    public Object elemAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        return array[position];
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        Object antigoElemento = array[position];
        array[position] = element;
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        if (position < 0 || position > size_) {
            throw new VectorException("Erro: Posição Inválida");
        }

        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            newArray[position] = element;
            for (int i = size_; i > position; i--) {
                newArray[i] = array[i-1];
            }
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > position; i--) {
                array[i] = array[i - 1];
            }
            array[position] = element;
            size_++;
        }
    }

    @Override
    public Object removeAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new VectorException("Erro: Posição Inválida");
        }
        Object antigoElemento = array[position];
        for (int i = position + 1; i < size_; i++) {
            array[i-1] = array[i];
        }
        size_--;
        array[size_] = null;
        return antigoElemento;
    }

    @Override
    public Integer size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "O Vetor está vazio!";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size_ - 1; i++) {
            sb.append(array[i]).append(" , ");
        }
        sb.append(array[size_ - 1]).append("");
        return sb.toString();
    }
}