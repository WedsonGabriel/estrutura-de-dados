package atividades.estudo_pilha.Exception;

public class PilhaVaziaExcecao extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PilhaVaziaExcecao(String message) {
        super(message);
    }
}
