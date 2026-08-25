package atividade_linkedList_fila.application;
import atividade_linkedList_fila.util.Fila;
import atividade_linkedList_pilha.util.ShowMenu;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        boolean rodando = true;
        Fila fila = new Fila();

        while (rodando) {
            ShowMenu.showMenu();
            System.out.print("Digite o número da operação: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Digite o nome do elemento que deseja adicionar: ");
                    fila.enqueue(sc.nextLine());
                    break;
                case 2:
                    fila.dequeue();
                    break;
                case 3:
                    System.out.println(fila.isEmpty());
                    break;
                case 4:
                    System.out.println(fila.size());
                    break;
                case 5:
                    System.out.println(fila.first());
                    break;
                case 6:
                    System.out.println(fila);
                    break;
                case 7:
                    rodando = false;
                    break;
                default:
                    System.out.println("Erro: Opção Inválida!" + "\n");
                    break;
            }
        }
        sc.close();
    }
}
