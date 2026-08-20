package atividade_linkedList_pilha.application;
import atividade_linkedList_pilha.util.Pilha;
import atividade_linkedList_pilha.util.ShowMenu;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean rodando = true;
        Pilha pilha =  new Pilha();

        while (rodando) {
            ShowMenu.showMenu();
            System.out.print("Digite o número da operação: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Digite o nome do elemento que deseja adicionar: ");
                    pilha.push(sc.nextLine());
                    break;
                case 2:
                    pilha.pop();
                    break;
                case 3:
                    System.out.println(pilha.isEmpty());
                    break;
                case 4:
                    System.out.println(pilha.size());
                    break;
                case 5:
                    System.out.println(pilha.top());
                    break;
                case 6:
                    System.out.println(pilha);
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
