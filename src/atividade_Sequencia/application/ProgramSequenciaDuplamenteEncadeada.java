package atividade_Sequencia.application;

import atividade_Sequencia.exceptions.SequenciaException;
import atividade_Sequencia.util.Position;
import atividade_Sequencia.util.SequenciaDuplamenteEncadeada;
import atividade_Sequencia.util.ShowMenu;

import java.util.Locale;
import java.util.Scanner;

public class ProgramSequenciaDuplamenteEncadeada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        SequenciaDuplamenteEncadeada lista = new SequenciaDuplamenteEncadeada();
        boolean rodando = true;

        while (rodando) {
            ShowMenu.showMenu();
            System.out.print("Digite o número da operação que você deseja realizar: ");
            int option = sc.nextInt();
            sc.nextLine();

            try {
                int rank, rank2;
                Object element;
                Position p, p2;

                switch (option) {
                    case 1:
                        System.out.println("Tamanho atual: " + lista.size());
                        break;

                    case 2:
                        System.out.println("A sequência está vazia? " + lista.isEmpty());
                        break;

                    case 3:
                        System.out.print("Digite o rank (índice): ");
                        rank = sc.nextInt();
                        System.out.println("Elemento no rank " + rank + ": " + lista.elemAtRank(rank));
                        break;

                    case 4:
                        System.out.print("Digite o rank que deseja substituir: ");
                        rank = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo elemento: ");
                        element = sc.nextLine();
                        System.out.println("Elemento substituído: " + lista.replaceAtRank(rank, element));
                        break;

                    case 5:
                        System.out.print("Digite o rank de inserção: ");
                        rank = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento: ");
                        element = sc.nextLine();
                        lista.insertAtRank(rank, element);
                        System.out.println("Elemento inserido com sucesso!");
                        break;

                    case 6:
                        System.out.print("Digite o rank de remoção: ");
                        rank = sc.nextInt();
                        System.out.println("Elemento removido: " + lista.removeAtRank(rank));
                        break;

                    case 7:
                        System.out.println("Primeiro elemento: " + lista.first().element());
                        break;

                    case 8:
                        System.out.println("Último elemento: " + lista.last().element());
                        break;

                    case 9:
                        System.out.print("Digite o rank da posição alvo: ");
                        rank = sc.nextInt();
                        p = lista.atRank(rank);
                        System.out.println("Elemento ANTES do rank " + rank + ": " + lista.before(p).element());
                        break;

                    case 10:
                        System.out.print("Digite o rank da posição alvo: ");
                        rank = sc.nextInt();
                        p = lista.atRank(rank);
                        System.out.println("Elemento DEPOIS do rank " + rank + ": " + lista.after(p).element());
                        break;

                    case 11:
                        System.out.print("Digite o rank da posição que deseja substituir: ");
                        rank = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo elemento: ");
                        element = sc.nextLine();
                        p = lista.atRank(rank);
                        System.out.println("Elemento substituído: " + lista.replaceElement(p, element));
                        break;

                    case 12:
                        System.out.print("Digite o rank da primeira posição: ");
                        rank = sc.nextInt();
                        System.out.print("Digite o rank da segunda posição: ");
                        rank2 = sc.nextInt();
                        p = lista.atRank(rank);
                        p2 = lista.atRank(rank2);
                        lista.swapElements(p, p2);
                        System.out.println("Elementos trocados com sucesso!");
                        break;

                    case 13:
                        System.out.print("Digite o rank da posição de referência: ");
                        rank = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento a ser inserido ANTES: ");
                        element = sc.nextLine();
                        p = lista.atRank(rank);
                        lista.insertBefore(p, element);
                        System.out.println("Elemento inserido!");
                        break;

                    case 14:
                        System.out.print("Digite o rank da posição de referência: ");
                        rank = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento a ser inserido DEPOIS: ");
                        element = sc.nextLine();
                        p = lista.atRank(rank);
                        lista.insertAfter(p, element);
                        System.out.println("Elemento inserido!");
                        break;

                    case 15:
                        System.out.print("Digite o elemento que será inserido no INÍCIO: ");
                        element = sc.nextLine();
                        lista.insertFirst(element);
                        System.out.println("Elemento inserido!");
                        break;

                    case 16:
                        System.out.print("Digite o elemento que será inserido no FINAL: ");
                        element = sc.nextLine();
                        lista.insertLast(element);
                        System.out.println("Elemento inserido!");
                        break;

                    case 17:
                        System.out.print("Digite o rank da posição que deseja remover: ");
                        rank = sc.nextInt();
                        p = lista.atRank(rank);
                        System.out.println("Elemento removido: " + lista.remove(p));
                        break;

                    case 18:
                        System.out.print("Digite o rank para obter a posição: ");
                        rank = sc.nextInt();
                        p = lista.atRank(rank);
                        System.out.println("A Posição no rank " + rank + " contém o elemento: " + p.element());
                        break;

                    case 19:
                        System.out.print("Digite o rank da posição alvo para testar o rankOf: ");
                        rank = sc.nextInt();
                        p = lista.atRank(rank);
                        System.out.println("O rank da posição informada é: " + lista.rankOf(p));
                        break;

                    case 20:
                        System.out.println("Sequência atual: " + lista.toString());
                        break;

                    case 21:
                        rodando = false;
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Erro: Opção Inválida!\n");
                        break;
                }
            } catch (SequenciaException e) {
                System.out.println("Exceção da Sequência: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}