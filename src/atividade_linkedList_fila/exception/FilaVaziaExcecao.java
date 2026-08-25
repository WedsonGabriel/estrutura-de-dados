package atividade_linkedList_fila.exception;

public class FilaVaziaExcecao extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public FilaVaziaExcecao(String message) {
        super(message);
    }
}
