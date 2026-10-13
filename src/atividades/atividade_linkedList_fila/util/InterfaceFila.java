package atividades.atividade_linkedList_fila.util;

public interface InterfaceFila {
    public void enqueue(Object value);
    public boolean isEmpty();
    public int size();
    public Object dequeue();
    public Object first();
}