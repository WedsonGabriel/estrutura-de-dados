package atividades.atividade_Sequencia.util;

import atividades.atividade_Sequencia.exceptions.SequenciaException;

public class ArraySequencia implements MetodosSequencia {
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Position[] array;

    // CONSTRUTOR
    public ArraySequencia() {
        this.size_ = 0;
        this.capacity = 5;
        this.array = new Position[capacity];
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
            throw new SequenciaException("Posição inválida ou sequência vazia!");
        }
        return array[position].element();
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Posição inválida ou sequência vazia!");
        }
        Object antigoElemento = array[position].element();
        array[position] = new ArrayPosition(element);
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        if (position < 0 || position > size_) {
            throw new SequenciaException("Posição de inserção inválida!");
        }
        if (size_ == capacity) {
            this.capacity *= 2;
            Position[] newArray = new Position[this.capacity];

            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            newArray[position] = new ArrayPosition(element);
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
            array[position] = new ArrayPosition(element);
            size_++;
        }
    }

    @Override
    public Object removeAtRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Posição de remoção inválida!");
        }
        Object antigoElemento = array[position].element();
        for (int i = position; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        array[size_ - 1] = null;
        size_--;
        return antigoElemento;
    }

    @Override
    public Position first() {
        if (size_ == 0) {
            throw new SequenciaException("A sequência está vazia!");
        }
        return array[0];
    }

    @Override
    public Position last() {
        if (size_ == 0) {
            throw new SequenciaException("A sequência está vazia!");
        }
        return array[size_ - 1];
    }

    @Override
    public Position before(Position position) {
        int rank = rankOf(position);
        if (rank == 0) {
            throw new SequenciaException("Não há elemento antes dessa posição!");
        }
        return array[rank - 1];
    }

    @Override
    public Position after(Position position) {
        int rank = rankOf(position);
        if (rank == size_ - 1) {
            throw new SequenciaException("Não há elemento depois dessa posição!");
        }
        return array[rank + 1];
    }

    @Override
    public Object replaceElement(Position position, Object element) {
        int rank = rankOf(position);
        Object antigoElemento = array[rank].element();
        array[rank] = new ArrayPosition(element);
        return antigoElemento;
    }

    @Override
    public void swapElements(Position position1, Position position2) {
        int rank1 = rankOf(position1);
        int rank2 = rankOf(position2);

        Position p1 = array[rank1];
        Position p2 = array[rank2];
        array[rank1] = p2;
        array[rank2] = p1;
    }

    @Override
    public void insertBefore(Position position, Object element) {
        int rank = rankOf(position);

        if (size_ == capacity) {
            this.capacity *= 2;
            Position[] newArray = new Position[this.capacity];

            for (int i = size_; i > rank; i--) {
                newArray[i] = array[i-1];
            }
            newArray[rank] = new ArrayPosition(element);
            for (int i = 0; i < rank; i++) {
                newArray[i] = array[i];
            }
            array =  newArray;
            size_++;
        }
        else {
            for (int i = size_; i > rank; i--) {
                array[i] = array[i-1];
            }
            array[rank] = new ArrayPosition(element);
            size_++;
        }
    }

    @Override
    public void insertAfter(Position position, Object element) {
        int rank = rankOf(position);

        if (size_ == capacity) {
            this.capacity *= 2;
            Position[] newArray = new Position[this.capacity];

            for (int i = size_; i > rank + 1; i--) {
                newArray[i] = array[i-1];
            }
            newArray[rank+1] = new ArrayPosition(element);
            for (int i = 0; i <= rank; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > rank + 1; i--) {
                array[i] = array[i-1];
            }
            array[rank+1] = new ArrayPosition(element);
            size_++;
        }
    }

    @Override
    public void insertFirst(Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Position[] newArray = new Position[this.capacity];

            for (int i = size_; i > 0; i--) {
                newArray[i] = array[i-1];
            }
            newArray[0] = new ArrayPosition(element);
            array = newArray;
            size_++;
        }
        else {
            for (int i = size_; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = new ArrayPosition(element);
            size_++;
        }
    }

    @Override
    public void insertLast(Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Position[] newArray = new Position[this.capacity];

            for (int i = 0; i < size_; i++) {
                newArray[i] = array[i];
            }
            newArray[size_] = new ArrayPosition(element);
            array = newArray;
            size_++;
        }
        else {
            array[size_] = new ArrayPosition(element);
            size_++;
        }
    }

    @Override
    public Object remove(Position position) {
        int rank = rankOf(position);
        Object antigoElemento = array[rank].element();
        for (int i = rank; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        array[size_ - 1] = null;
        size_--;
        return antigoElemento;
    }

    @Override
    public Position atRank(Integer position) {
        if (position < 0 || position >= size_) {
            throw new SequenciaException("Posição inválida!");
        }
        return array[position];
    }

    @Override
    public Integer rankOf(Position position) {
        for (int i = 0; i < size_; i++) {
            if (array[i] == position) {
                return i;
            }
        }
        throw new SequenciaException("Posição não encontrada!");
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "A Sequência está vazia!";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size_; i++) {
            sb.append(array[i].element());
            if (i < size_ - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
