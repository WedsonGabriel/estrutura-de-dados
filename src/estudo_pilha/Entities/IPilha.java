package estudo_pilha.Entities;

public interface IPilha {
    public int size();
    public boolean isEmpty();
    public void push(Object item);
    public Object pop();
    public Object top();
}
