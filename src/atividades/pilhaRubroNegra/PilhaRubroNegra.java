package atividades.pilhaRubroNegra;

public class PilhaRubroNegra {
    // ATRIBUTOS
    private int t_red;
    private int t_black;
    private int sizeRed;
    private int sizeBlack;
    private int capacidade;
    private Object[] pilha;

    // CONSTRUTOR
    public PilhaRubroNegra(int capacidade) {
        this.t_red = -1;
        this.t_black = capacidade;
        this.capacidade = capacidade;
        pilha = new Object[capacidade];
    }

    // MÉTODOS
    public void reducesOrDoubles() {
        int capacidadeAntiga = this.capacidade;

        if (t_red + 1 == t_black) {
            this.capacidade *= 2;
        }
        else if (((sizeBlack + sizeRed) <= capacidade / 3) && (this.capacidade > 4)) {
            this.capacidade /= 2;
        }

        if (capacidadeAntiga != this.capacidade) {
            Object pilhaB[] = new Object[capacidade];
            int indiceNovo = pilhaB.length - 1;

            for (int i = 0; i <= t_red; i++) {
                pilhaB[i] = pilha[i];
            }
            for (int j = pilha.length - 1; j >= t_black; j--) {
                pilhaB[indiceNovo] = pilha[j];
                indiceNovo--;
            }
            this.t_black = indiceNovo + 1;
            this.pilha = pilhaB;
        }
    }

    public void pushRed(Object value) {
        reducesOrDoubles();
        pilha[++t_red] = value;
        sizeRed++;
    }

    public void pushBlack(Object value) {
        reducesOrDoubles();
        pilha[--t_black] = value;
        sizeBlack++;
    }

    public int sizeRed() {
        return this.sizeRed;
    }

    public int sizeBlack() {
        return this.sizeBlack;
    }

    public int size() {
        return sizeRed + sizeBlack;
    }

    public boolean isEmptyRed() {
        return sizeRed == 0;
    }

    public boolean isEmptyBlack() {
        return sizeBlack == 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object topRed() {
        if (isEmptyRed()) {
            throw new RubroNegraVazia("A estudoPessoal.pilha vermelha está vazia!");
        }
        return pilha[t_red];
    }

    public Object topBlack() {
        if (isEmptyBlack()) {
            throw new RubroNegraVazia("A estudoPessoal.pilha preta está vazia!");
        }
        return pilha[t_black];
    }

    public Object popRed() {
        if (isEmptyRed()) {
            throw new RubroNegraVazia("A estudoPessoal.pilha está vazia!");
        }
        Object itemRemovido = pilha[t_red];
        pilha[t_red] = null;
        t_red--;
        sizeRed--;
        reducesOrDoubles();
        return itemRemovido;
    }

    public Object popBlack() {
        if (isEmptyBlack()) {
            throw new RubroNegraVazia("A estudoPessoal.pilha está vazia!");
        }
        Object itemRemovido = pilha[t_black];
        pilha[t_black] = null;
        t_black++;
        sizeBlack--;
        reducesOrDoubles();
        return itemRemovido;
    }
}