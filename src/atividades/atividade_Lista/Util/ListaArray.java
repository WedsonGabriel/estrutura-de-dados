package atividades.atividade_Lista.Util;

import atividades.atividade_Lista.Exception.ListaException;

public class ListaArray implements ListaMetodos {
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public ListaArray() {
        this.size_ = 0;
        this.capacity = 5;
        this.array = new Object[capacity];
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
        if (position == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isLast(Integer position) {
        if (position == size_ - 1) {
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new ListaException("Erro: A lista está vazia!");
        }
        return array[0];
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new ListaException("Erro: A lista está vazia!");
        }
        return array[size_ - 1];
    }

    @Override
    public Object before(Integer position) {
        if (position <= 0 || position >= size_) {
            throw new ListaException("Erro: Não há elemento antes desta posição!");
        }
        return array[position - 1];
    }

    @Override
    public Object after(Integer position) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Não há elemento depois desta posição!");
        }
        return array[position + 1];
    }

    @Override
    public Object replaceElement(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Object antigoElemento = array[position];
        array[position] = element;
        return antigoElemento;
    }

    @Override
    public void swapElements(Integer position1, Integer position2) {
        if (isEmpty()) {
            throw new ListaException("Erro: Não há elementos suficientes na lista.");
        }
        if (position1 >= size_ || position2 >= size_ || position1 < 0 || position2 < 0) {
            throw new ListaException("Erro: Posição inválida!");
        }
        Object p1 = array[position1];
        Object p2 = array[position2];
        array[position1] = p2;
        array[position2] = p1;
    }

    @Override
    public void insertBefore(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = position + 1; i <= size_; i++) {
                newArray[i] = array[i-1];
            }
            newArray[position] = element;
            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > position; i--) {
                array[i] = array[i-1];
            }
            array[position] = element;
            size_++;
        }
    }

    @Override
    public void insertAfter(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = size_; i > position + 1; i--) {
                newArray[i] = array[i-1];
            }
            newArray[position+1] = element;
            for (int i = 0; i <= position; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > position + 1; i--) {
                array[i] = array[i-1];
            }
            array[position+1] = element;
            size_++;
        }
    }

    @Override
    public void insertFirst(Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];
            newArray[0] = element;

            for (int i = 1; i <= size_; i++) {
                newArray[i] = array[i - 1];
            }
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = element;
            size_++;
        }
    }

    @Override
    public void insertLast(Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = 0; i < size_; i++) {
                newArray[i] = array[i];
            }
            newArray[size_] = element;
            array = newArray;
            size_++;
        }
        else {
            array[size_] = element;
            size_++;
        }
    }

    @Override
    public Object remove(Integer position) {
        if (position < 0 || position >= size_) {
            throw new ListaException("Erro: Posição inválida!");
        }

        Object antigoElemento = array[position];
        for (int i = position; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        size_--;
        array[size_] = null;
        return antigoElemento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size_; i++) {
            sb.append(array[i]);
            if (i+1 < size_) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}