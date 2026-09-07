package atividade_Vetor.Util;

public class Node {
    // ATRIBUTOS
    private Object value;
    private Node next;
    private Node prev;

    // GETTERS AND SETTERS
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
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