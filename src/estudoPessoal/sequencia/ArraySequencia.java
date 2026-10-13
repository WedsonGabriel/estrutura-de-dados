package estudoPessoal.sequencia;

public class ArraySequencia implements InterfaceSequencia {
    // ATRIBUTOS
    private int size_;
    private int capacity;
    private Object[] array;

    // CONSTRUTOR
    public ArraySequencia() {
        this.size_ = 0;
        this.capacity = 5;
        array = new Object[this.capacity];
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
        return array[position];
    }

    @Override
    public Object replaceAtRank(Integer position, Object element) {
        Object antigoElemento = array[position];
        array[position] = element;
        return antigoElemento;
    }

    @Override
    public void insertAtRank(Integer position, Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = size_; i > position; i--) {
                newArray[i] = array[i - 1];
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
                array[i] = array[i - 1];
            }
            array[position] = element;
            size_++;
        }
    }

    @Override
    public Object removeAtRank(Integer position) {
        Object antigoElemento = array[position];
        for (int i = position; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        array[size_ - 1] = null;
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
        return array[0];
    }

    @Override
    public Object last() {
        return array[size_ - 1];
    }

    @Override
    public Object before(Integer position) {
        return array[position - 1];
    }

    @Override
    public Object after(Integer position) {
        return array[position + 1];
    }

    @Override
    public Object replaceElement(Integer position, Object element) {
        Object antigoElemento = array[position];
        array[position] = element;
        return antigoElemento;
    }

    @Override
    public void swapElements(Integer position1, Integer position2) {
        Object p1 = array[position1];
        Object p2 = array[position2];

        array[position1] = p2;
        array[position2] = p1;
    }

    @Override
    public void insertBefore(Integer position, Object element) {
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray =  new Object[this.capacity];

            for (int i = 0; i < position; i++) {
                newArray[i] = array[i];
            }
            newArray[position] = element;
            for (int i = size_; i > position; i--) {
                newArray [i] = array[i-1];
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
        if (size_ == capacity) {
            this.capacity *= 2;
            Object[] newArray = new Object[this.capacity];

            for (int i = 0; i < size_; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = size_; i > position + 1; i--) {
            array[i] = array[i-1];
        }
        array[position + 1] = element;
        size_++;
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
            array[0] =  element;
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
        Object antigoElemento = array[position];
        for (int i = position; i < size_ - 1; i++) {
            array[i] = array[i+1];
        }
        array[size_ - 1] = null;
        size_--;
        return antigoElemento;
    }
}
