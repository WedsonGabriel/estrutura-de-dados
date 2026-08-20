package estudo_pilha.Entities;
import estudo_pilha.Exception.PilhaVaziaExcecao;

public class Pilha implements IPilha {
    // ATRIBUTOS
    public int topo;
    public int fatorCrescimento;
    public int capacidade;
    public Object[] elementos;

    // CONSTRUTOR
    public Pilha(int capacidade, int fatorCrescimento) {
        this.topo = -1;
        this.setCapacidade(capacidade);
        this.setFatorCrescimento(fatorCrescimento);
        elementos = new Object[this.capacidade];
    }

    // GETTERS & SETTERS
    public int getTopo() {
        return topo;
    }
    public void setTopo(int topo) {
        this.topo = topo;
    }
    public int getFatorCrescimento() {
        return fatorCrescimento;
    }
    public void setFatorCrescimento(int fatorCrescimento) {
        this.fatorCrescimento = fatorCrescimento;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        if (capacidade < 1) {
            throw new PilhaVaziaExcecao("A capacidade não pode ser menor do que 1");
        }
        this.capacidade = capacidade;
    }
    public Object[] getElementos() {
        return elementos;
    }
    public void setElementos(Object[] elementos) {
        this.elementos = elementos;
    }

    // MÉTODOS
    @Override
    public int size() {
        return topo + 1;
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @Override
    public void push(Object item) {
        if (capacidade == size()) {
            if (fatorCrescimento == 0) {
                this.capacidade *= 2;
            }
            else {
                this.capacidade += fatorCrescimento;
            }
            Object b[] = new Object[capacidade];
            for (int i = 0; i < elementos.length; i++) {
                b[i] = elementos[i];
            }
            elementos = b;
        }
        elementos[++topo] = item;
    }

    @Override
    public Object pop() {
        if (topo == -1) {
            throw new PilhaVaziaExcecao("Não foi possível remover o último elemento, pois a pilha estar vazia");
        }
        Object rmv = elementos[topo - 1];
        return rmv;
    }

    @Override
    public Object top() {
        if (topo == -1) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return elementos[topo];
    }
}




