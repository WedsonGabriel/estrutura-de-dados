package atividade_linkedList_pilha.util;
import atividade_linkedList_pilha.exception.PilhaVaziaExcecao;
import java.util.ArrayList;
import java.util.List;

public class Pilha implements InterfacePilha {
    // ATRIBUTOS
    private Node head;
    private int size_;

    // CONSTRUTOR
    public Pilha(){}

    // MÉTODOS
    @Override
    public void push(Object value) {
        Node node = new Node();
        node.setValue(value);
        node.setNext(head);
        head = node;
        this.size_++;
    }

    @Override
    public void pop() {
        if (head == null) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        head = head.getNext();
        size_--;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        if (head == null) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return size_;
    }

    @Override
    public Object top() {
        if (head == null) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return head.getValue();
    }

    @Override
    public String toString() {
        List<Object> pilha = new ArrayList<>();

        Node n = head;
        while (n != null) {
            pilha.add(n.getValue() + " -> ");
            n = n.getNext();
        }
        pilha.add("NULL");
        return pilha.toString().replace("," , "");
    }
}


