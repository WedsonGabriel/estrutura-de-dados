package atividades.arvoreBinariaPesquisa;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();

        System.out.println("=== ÁRVORE VAZIA ===");
        System.out.println("Vazia? " + arvore.isEmpty());
        arvore.mostrar();

        System.out.println("\n=== INTEGER: INSERINDO 10, 5, 15, 2, 8, 22 ===");
        arvore.insert(10);
        arvore.insert(5);
        arvore.insert(15);
        arvore.insert(2);
        arvore.insert(8);
        arvore.insert(22);
        arvore.mostrar();

        System.out.println("\n=== INSERINDO: 25 ===");
        arvore.insert(25);
        arvore.mostrar();

        System.out.println("\n=== REMOVENDO: 5 (dois filhos) ===");
        System.out.println("Removido: " + arvore.remove(5));
        arvore.mostrar();

        System.out.println("\n=== REMOVENDO: 25 (folha) ===");
        System.out.println("Removido: " + arvore.remove(25));
        arvore.mostrar();

        System.out.println("\n=== REMOVENDO: 15 (um filho) ===");
        System.out.println("Removido: " + arvore.remove(15));
        arvore.mostrar();

        System.out.println("\n=== REMOVENDO: 10 (raiz) ===");
        System.out.println("Removido: " + arvore.remove(10));
        arvore.mostrar();

        System.out.println("\n=== BUSCA ===");
        System.out.println("Buscar 22: " + (arvore.search(22) != null ? "encontrado" : "não encontrado"));
        System.out.println("Buscar 99: " + (arvore.search(99) != null ? "encontrado" : "não encontrado"));

        System.out.println("\n=== INFORMAÇÕES ===");
        System.out.println("Tamanho: " + arvore.size());
        System.out.println("Altura: " + arvore.height());
        System.out.println("Menor: " + arvore.min());
        System.out.println("Maior: " + arvore.max());
        System.out.println("Em ordem: " + arvore);

        System.out.println("\n=== STRING: INSERINDO maria, joao, pedro, ana, lucas ===");
        ArvoreBinariaPesquisa arvoreString = new ArvoreBinariaPesquisa();
        arvoreString.insert("maria");
        arvoreString.insert("joao");
        arvoreString.insert("pedro");
        arvoreString.insert("ana");
        arvoreString.insert("lucas");
        arvoreString.mostrar();
        System.out.println("Em ordem: " + arvoreString);

        System.out.println("\n=== DOUBLE: INSERINDO 5.5, 2.1, 9.9, 3.3 ===");
        ArvoreBinariaPesquisa arvoreDouble = new ArvoreBinariaPesquisa();
        arvoreDouble.insert(5.5);
        arvoreDouble.insert(2.1);
        arvoreDouble.insert(9.9);
        arvoreDouble.insert(3.3);
        arvoreDouble.mostrar();
        System.out.println("Menor: " + arvoreDouble.min());
        System.out.println("Maior: " + arvoreDouble.max());

        System.out.println("\n=== TESTANDO ERROS ===");
        try {
            arvore.insert(8);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            arvore.remove(99);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            arvore.insert("texto");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            arvore.insert(null);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            arvore.insert(new Object());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}