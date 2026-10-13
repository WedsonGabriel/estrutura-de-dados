package atividades.arvoreBinariaPesquisa;

public class Node {
    // ATRIBUTOS
    Object value;
    Node left;
    Node right;

    // GETTERS AND SETTERS
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}