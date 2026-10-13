package atividades.atividade_Vetor.Util;

public interface VetorMedodos {
    Object elemAtRank(Integer position);
    Object replaceAtRank(Integer position, Object element);
    void insertAtRank(Integer position, Object element);
    Object removeAtRank(Integer position);
    Integer size();
    boolean isEmpty();
}