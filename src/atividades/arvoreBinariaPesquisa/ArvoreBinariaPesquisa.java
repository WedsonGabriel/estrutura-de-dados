package atividades.arvoreBinariaPesquisa;

public class ArvoreBinariaPesquisa {
    // ATRIBUTOS
    private int size_;
    private int coluna;
    private Node root;

    // CONSTRUTOR
    public ArvoreBinariaPesquisa() {
        this.size_ = 0;
        this.coluna = 0;
        this.root = null;
    }

    // MÉTODOS
    public Integer size() {
        return size_;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Integer height() {
        return height(root);
    }

    private int height(Node atual) {
        if (atual == null) {
            return 0;
        }
        int alturaEsquerda = height(atual.getLeft());
        int alturaDireita = height(atual.getRight());

        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        }
        return alturaDireita + 1;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private int comparar(Object a, Object b) {
        if (!(a instanceof Comparable)) {
            throw new RuntimeException("Erro: O valor precisa ser comparável!");
        }
        try {
            return ((Comparable) a).compareTo(b);
        } catch (ClassCastException e) {
            throw new RuntimeException("Erro: Tipos incompatíveis na comparação!");
        }
    }

    public Object min() {
        if (isEmpty()) {
            throw new RuntimeException("Erro: A árvore está vazia!");
        }
        Node atual = root;
        while (atual.getLeft() != null) {
            atual = atual.getLeft();
        }
        return atual.getValue();
    }

    public Object max() {
        if (isEmpty()) {
            throw new RuntimeException("Erro: A árvore está vazia!");
        }
        Node atual = root;
        while (atual.getRight() != null) {
            atual = atual.getRight();
        }
        return atual.getValue();
    }

    public Node search(Object value) {
        Node atual = root;

        while (atual != null) {
            int resultado = comparar(value, atual.getValue());

            if (resultado < 0) {
                atual = atual.getLeft();
            }
            else if (resultado > 0) {
                atual = atual.getRight();
            }
            else {
                return atual;
            }
        }
        return null;
    }

    public void insert(Object value) {
        if (value == null) {
            throw new RuntimeException("Erro: O valor não pode ser nulo!");
        }
        if (!(value instanceof Comparable)) {
            throw new RuntimeException("Erro: O valor precisa ser comparável!");
        }
        Node newNode = new Node();
        newNode.setValue(value);

        if (isEmpty()) {
            root = newNode;
            size_++;
            return;
        }
        Node atual = root;
        Node pai = null;
        int resultado = 0;

        while (atual != null) {
            pai = atual;
            resultado = comparar(value, atual.getValue());

            if (resultado < 0) {
                atual = atual.getLeft();
            }
            else if (resultado > 0) {
                atual = atual.getRight();
            }
            else {
                throw new RuntimeException("Erro: O valor " + value + " já existe na árvore!");
            }
        }

        if (resultado < 0) {
            pai.setLeft(newNode);
        }
        else {
            pai.setRight(newNode);
        }
        size_++;
    }

    public Object remove(Object value) {
        if (isEmpty()) {
            throw new RuntimeException("Erro: A árvore está vazia!");
        }
        Node atual = root;
        Node pai = null;

        while (atual != null && comparar(value, atual.getValue()) != 0) {
            pai = atual;
            if (comparar(value, atual.getValue()) < 0) {
                atual = atual.getLeft();
            }
            else {
                atual = atual.getRight();
            }
        }

        if (atual == null) {
            throw new RuntimeException("Erro: O valor " + value + " não foi encontrado!");
        }
        Object antigoValor = atual.getValue();

        if (atual.getLeft() != null && atual.getRight() != null) {
            Node paiSucessor = atual;
            Node sucessor = atual.getRight();

            while (sucessor.getLeft() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getLeft();
            }
            atual.setValue(sucessor.getValue());
            atual = sucessor;
            pai = paiSucessor;
        }

        Node filho = atual.getLeft();
        if (filho == null) {
            filho = atual.getRight();
        }

        if (pai == null) {
            root = filho;
        }
        else if (pai.getLeft() == atual) {
            pai.setLeft(filho);
        }
        else {
            pai.setRight(filho);
        }
        size_--;
        return antigoValor;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("A árvore está vazia!");
            return;
        }
        int altura = height();
        StringBuilder[] linhas = new StringBuilder[altura];

        for (int i = 0; i < altura; i++) {
            linhas[i] = new StringBuilder();
        }
        coluna = 0;
        preencherLinhas(root, 0, linhas);

        for (int i = 0; i < altura; i++) {
            System.out.println(linhas[i]);
        }
    }

    private void preencherLinhas(Node atual, int nivel, StringBuilder[] linhas) {
        if (atual == null) {
            return;
        }
        preencherLinhas(atual.getLeft(), nivel + 1, linhas);

        String texto = String.valueOf(atual.getValue());
        while (linhas[nivel].length() < coluna) {
            linhas[nivel].append(" ");
        }
        linhas[nivel].append(texto);
        coluna += texto.length() + 2;

        preencherLinhas(atual.getRight(), nivel + 1, linhas);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "A árvore está vazia!";
        }
        StringBuilder sb = new StringBuilder();
        emOrdem(root, sb);
        return sb.toString();
    }

    private void emOrdem(Node atual, StringBuilder sb) {
        if (atual == null) {
            return;
        }
        emOrdem(atual.getLeft(), sb);
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(atual.getValue());
        emOrdem(atual.getRight(), sb);
    }
}