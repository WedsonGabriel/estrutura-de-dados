package atividades.atividade_Lista.Application;

import atividades.atividade_Lista.Exception.ListaException;
import atividades.atividade_Lista.Util.ListaArray;
import atividades.atividade_Lista.Util.ShowMenu;

import java.util.Locale;
import java.util.Scanner;

public class ProgramListaArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        ListaArray lista = new ListaArray();
        boolean rodando = true;

        while (rodando) {
            ShowMenu.showMenu();
            System.out.print("Digite o número da operação que você deseja realizar: ");
            int option = sc.nextInt();
            sc.nextLine();

            try {
                int position, position2;
                Object element;

                switch (option) {
                    case 1:
                        System.out.println("Tamanho atual: " + lista.size());
                        break;

                    case 2:
                        System.out.println("A lista está vazia? " + lista.isEmpty());
                        break;

                    case 3:
                        System.out.print("Digite a posição: ");
                        position = sc.nextInt();
                        System.out.println("A posição " + position + " é a primeira? " + lista.isFirst(position));
                        break;

                    case 4:
                        System.out.print("Digite a posição: ");
                        position = sc.nextInt();
                        System.out.println("A posição " + position + " é a última? " + lista.isLast(position));
                        break;

                    case 5:
                        System.out.println("Primeiro elemento: " + lista.first());
                        break;

                    case 6:
                        System.out.println("Último elemento: " + lista.last());
                        break;

                    case 7:
                        System.out.print("Digite a posição alvo: ");
                        position = sc.nextInt();
                        System.out.println("Elemento ANTES da posição " + position + ": " + lista.before(position));
                        break;

                    case 8:
                        System.out.print("Digite a posição alvo: ");
                        position = sc.nextInt();
                        System.out.println("Elemento DEPOIS da posição " + position + ": " + lista.after(position));
                        break;

                    case 9:
                        System.out.print("Digite a posição que deseja substituir: ");
                        position = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo elemento: ");
                        element = sc.nextLine();
                        System.out.println("Elemento substituído: " + lista.replaceElement(position, element));
                        break;

                    case 10:
                        System.out.print("Digite a primeira posição: ");
                        position = sc.nextInt();
                        System.out.print("Digite a segunda posição: ");
                        position2 = sc.nextInt();
                        lista.swapElements(position, position2);
                        System.out.println("Elementos trocados com sucesso!");
                        break;

                    case 11:
                        System.out.print("Digite a posição de referência: ");
                        position = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento a ser inserido ANTES: ");
                        element = sc.nextLine();
                        lista.insertBefore(position, element);
                        break;

                    case 12:
                        System.out.print("Digite a posição de referência: ");
                        position = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento a ser inserido DEPOIS: ");
                        element = sc.nextLine();
                        lista.insertAfter(position, element);
                        break;

                    case 13:
                        System.out.print("Digite o elemento que será inserido no INÍCIO: ");
                        element = sc.nextLine();
                        lista.insertFirst(element);
                        break;

                    case 14:
                        System.out.print("Digite o elemento que será inserido no FINAL: ");
                        element = sc.nextLine();
                        lista.insertLast(element);
                        break;

                    case 15:
                        System.out.print("Digite a posição do elemento que deseja remover: ");
                        position = sc.nextInt();
                        System.out.println("Elemento removido: " + lista.remove(position));
                        break;

                    case 16:
                        System.out.println("Lista atual: [" + lista + "]");
                        break;

                    case 17:
                        rodando = false;
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Erro: Opção Inválida!\n");
                        break;
                }
            }
            catch (ListaException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}