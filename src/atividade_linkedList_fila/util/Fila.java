package atividade_linkedList_fila.util;
import atividade_linkedList_fila.exception.FilaVaziaExcecao;
import java.util.ArrayList;
import java.util.List;

public class Fila implements InterfaceFila{
    // ATRIBUTOS
    private Node head;
    private Node tail;
    private int size_;

    // CONSTRUTOR
    public Fila() {}

    // GETTERS AND SETTERS
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getTail() {
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }

    // MÉTODOS
    @Override
    public void push(Object value) {
        Node newNode = new Node();
        newNode.setValue(value);
        newNode.setNext(null);
        size_++;

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public void pop() {
        if (head == null) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        head = head.getNext();
        size_--;

        if (head == null) {
            tail = null;
        }
    }

    @Override
    public Object top() {
        if (head == null) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return tail.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node f = head;
        while (f != null) {
            sb.append(f.getValue()).append(" -> ");
            f = f.getNext();
        }
        sb.append("NULL");
        return sb.toString();
    }
}