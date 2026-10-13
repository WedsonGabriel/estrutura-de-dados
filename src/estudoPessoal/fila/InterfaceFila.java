package estudoPessoal.fila;

public interface InterfaceFila {
    void enqueue(Object element);
    Object dequeue();
    Object first();
    Integer size();
    boolean isEmpty();
}
