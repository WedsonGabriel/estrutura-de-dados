package atividades.atividade_Lista.Util;

public interface ListaMetodos {
    // MÉTODOS GENÉRICOS
    Integer size();
    boolean isEmpty();

    // MÉTODOS DE FILA
    boolean isFirst(Integer position);
    boolean isLast(Integer position);

    // MÉTODOS PARA ACESSAR
    Object first();
    Object last();
    Object before(Integer position);
    Object after(Integer position);

    // MÉTODOS PARA ATUALIZAR
    Object replaceElement(Integer position, Object element);
    void swapElements(Integer position1, Integer position2);
    void insertBefore(Integer position, Object element);
    void insertAfter(Integer position, Object element);
    void insertFirst(Object element);
    void insertLast(Object element);
    Object remove(Integer position);
}
