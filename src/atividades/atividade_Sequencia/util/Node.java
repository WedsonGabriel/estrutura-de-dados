package atividades.atividade_Sequencia.util;

public class Node implements Position {
    // ATRIBUTOS
    private Object element;
    private Node next;
    private Node prev;

    // GETTERS AND SETTERS
    @Override
    public Object element() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
}