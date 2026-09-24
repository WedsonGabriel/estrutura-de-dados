package atividade_Sequencia.util;

public class Node {
    // ATRIBUTOS
    private Object value;
    private Node header;
    private Node trailer;

    // GETTERS AND SETTERS
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Node getHeader() {
        return header;
    }
    public void setHeader(Node header) {
        this.header = header;
    }
    public Node getTrailer() {
        return trailer;
    }
    public void setTrailer(Node trailer) {
        this.trailer = trailer;
    }
}
