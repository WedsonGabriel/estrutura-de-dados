package atividade_Sequencia.util;

public interface MetodosSequencia {
    // Métodos genéricos
    Integer size();
    boolean isEmpty();

    // Métodos de Vetor
    Object elemAtRank(Integer position);
    Object replaceAtRank(Integer position, Object element);
    void insertAtRank(Integer position, Object element);
    Object removeAtRank(Integer position);

    // Métodos de Lista
    Object first();
    Object last();
    Object before(Integer position);
    Object after(Integer position);
    Object replaceElement(Integer position, Object element);
    void swapElements(Integer position1, Integer position2);
    void insertBefore(Integer position, Object element);
    void insertAfter(Integer position, Object element);
    void insertFirst(Object element);
    void insertLast(Object element);
    Object remove(Integer position);

    // Métodos Ponte
    Object atRank(Integer position);
    Integer rankOf(Object element);
}
