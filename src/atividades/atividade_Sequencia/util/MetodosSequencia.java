package atividades.atividade_Sequencia.util;

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
    Position first();
    Position last();
    Position before(Position position);
    Position after(Position position);
    Object replaceElement(Position position, Object element);
    void swapElements(Position position1, Position position2);
    void insertBefore(Position position, Object element);
    void insertAfter(Position position, Object element);
    void insertFirst(Object element);
    void insertLast(Object element);
    Object remove(Position position);

    // Métodos Ponte
    Position atRank(Integer position);
    Integer rankOf(Position position);
}