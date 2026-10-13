package estudoPessoal.sequencia;

public interface InterfaceSequencia {
    // MÉTODOS GENÉRICOS
    Integer size();
    boolean isEmpty();

    // MÉTODOS DE VETOR
    Object elemAtRank(Integer position);
    Object replaceAtRank(Integer position, Object element);
    void insertAtRank(Integer position, Object element);
    Object removeAtRank(Integer position);

    // MÉTODOS DE FILA
    boolean isFirst(Integer position);
    boolean isLast(Integer position);

    // MÉTODOS PARA ACESSAR (LISTA)
    Object first();
    Object last();
    Object before(Integer position);
    Object after(Integer position);

    // MÉTODOS PARA ATUALIZAR (LISTA)
    Object replaceElement(Integer position, Object element);
    void swapElements(Integer position1, Integer position2);
    void insertBefore(Integer position, Object element);
    void insertAfter(Integer position, Object element);
    void insertFirst(Object element);
    void insertLast(Object element);
    Object remove(Integer position);
}
