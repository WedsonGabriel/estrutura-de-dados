package pilhaRubroNegra;

public class Pilha {
    // ATRIBUTOS
    private int sizeRed;
    private int sizeBlack;
    private int topo_red;
    private int topo_black;
    private int capacidade;
    private int fatorCrescimento;
    private Object[] pilha;

    // CONSTRUTOR
    public Pilha(int capacidade, int crescimento) {
        this.topo_red = 0;
        this.topo_black = capacidade;
        this.capacidade = capacidade;
        pilha = new Object[capacidade];

        if (crescimento <= 0) {
            this.fatorCrescimento = 0;
        }
    }

    // GETTERS AND SETTERS
    public int getSizeRed() {
        return sizeRed;
    }
    public void setSizeRed(int sizeRed) {
        this.sizeRed = sizeRed;
    }
    public int getSizeBlack() {
        return sizeBlack;
    }
    public void setSizeBlack(int sizeBlack) {
        this.sizeBlack = sizeBlack;
    }
    public int getTopo_red() {
        return topo_red;
    }
    public void setTopo_red(int topo_red) {
        this.topo_red = topo_red;
    }
    public int getTopo_black() {
        return topo_black;
    }
    public void setTopo_black(int topo_black) {
        this.topo_black = topo_black;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public int getFatorCrescimento() {
        return fatorCrescimento;
    }
    public void setFatorCrescimento(int fatorCrescimento) {
        this.fatorCrescimento = fatorCrescimento;
    }
    public Object[] getPilha() {
        return pilha;
    }
    public void setPilha(Object[] pilha) {
        this.pilha = pilha;
    }

    // MÉTODOS
    public void push_red(Object value) {
        if ((topo_red >= capacidade - 1) || (topo_red + 1 == topo_black)) {
            if (fatorCrescimento <= 0) {
                this.capacidade *= 2;
            }
            else {
                this.capacidade += fatorCrescimento;
            }
        }
        Object pilhaB[] = new Object[capacidade];
        for (int i = 0; i < pilhaB.length; i++) {
            pilhaB[i] = pilha[i];
            this.sizeRed += 1;
        }
        pilha = pilhaB;
        pilha[++topo_red] = value;
        this.sizeRed += 1;
    }

    public void push_black(Object value) {
        if ((topo_black >= capacidade - 1) || (topo_black - 1 == topo_red)) {
            if (fatorCrescimento <= 0) {
                this.capacidade *= 2;
            }
            else {
                this.capacidade += fatorCrescimento;
            }
        }
        Object pilhaB[] = new Object[capacidade];
        for (int i = pilhaB.length - 1; i >= 0; i--) {
            pilhaB[i] = pilha[i];
            this.sizeBlack += 1;
        }
        pilha = pilhaB;
        pilha[--topo_black] = value;
        this.sizeBlack += 1;
    }

    public void pop_red() {
        pilha[topo_red] = null;
    }
    public void pop_black() {
        pilha[topo_black] = null;
    }
    public int topo_red() {
        return topo_red;
    }
    public int topo_black() {
        return topo_black;
    }
    public int size_red() {
        return sizeRed;
    }
    public int size_black() {
        return sizeBlack;
    }

    public boolean isEmpty() {
        if ((sizeRed == 0) && (sizeBlack == 0)) {
            return true;
        }
        return false;
    }
}
