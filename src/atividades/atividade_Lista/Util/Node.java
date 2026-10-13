package atividades.atividade_Lista.Util;

public class Node {
    // ATRIBUTOS
    Object value;
    Node next;
    Node prev;

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