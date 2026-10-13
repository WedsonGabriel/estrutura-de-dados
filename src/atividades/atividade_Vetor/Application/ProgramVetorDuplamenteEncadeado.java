package atividades.atividade_Vetor.Application;

import atividades.atividade_Vetor.Exception.VectorException;
import atividades.atividade_Vetor.Util.ShowMenu;
import atividades.atividade_Vetor.Util.VetorDuplamenteEncadeado;

import java.util.Locale;
import java.util.Scanner;

public class ProgramVetorDuplamenteEncadeado {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        VetorDuplamenteEncadeado VDL = new VetorDuplamenteEncadeado();
        boolean rodando = true;

        while (rodando) {
            ShowMenu.showMenu();
            System.out.print("Digite o número da operação que você deseja realizar: ");
            int option = sc.nextInt();
            sc.nextLine();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Digite o número do índice: ");
                        int index = sc.nextInt();
                        System.out.println(VDL.elemAtRank(index));
                        break;

                    case 2:
                        System.out.print("Digite o índice que deseja substituir: ");
                        index = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo elemento: ");
                        Object element = sc.nextLine();
                        System.out.println(VDL.replaceAtRank(index, element));
                        break;

                    case 3:
                        System.out.print("Digite o índice onde deseja inserir: ");
                        index = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento que será inserido: ");
                        element = sc.nextLine();
                        VDL.insertAtRank(index, element);
                        break;

                    case 4:
                        System.out.print("Digite o índice do elemento que deseja remover: ");
                        index = sc.nextInt();
                        System.out.println(VDL.removeAtRank(index));
                        break;

                    case 5:
                        System.out.println(VDL.size());
                        break;

                    case 6:
                        System.out.println(VDL.isEmpty());
                        break;

                    case 7:
                        System.out.println(VDL);
                        break;

                    case 8:
                        rodando = false;
                        break;

                    default:
                        System.out.println("Erro: Opção Inválida!" + "\n");
                        break;
                }
            }
            catch (VectorException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}