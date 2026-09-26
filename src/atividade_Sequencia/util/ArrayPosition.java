package atividade_Sequencia.util;

public class ArrayPosition implements Position {
    // ATRIBUTO
    private Object element;

    // CONSTRUTOR
    public ArrayPosition(Object element) {
        this.element = element;
    }

    // MÉTODOS
    @Override
    public Object element() {
        return this.element;
    }
}