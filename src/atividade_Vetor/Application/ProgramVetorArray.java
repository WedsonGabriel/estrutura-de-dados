package atividade_Vetor.Application;

import atividade_Vetor.Exception.VectorException;
import atividade_Vetor.Util.ShowMenu;
import atividade_Vetor.Util.VetorArray;

import java.util.Locale;
import java.util.Scanner;

public class ProgramVetorArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        VetorArray array = new VetorArray();
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
                        System.out.println(array.elemAtRank(index));
                        break;

                    case 2:
                        System.out.print("Digite o índice que deseja substituir: ");
                        index = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo elemento: ");
                        Object element = sc.nextLine();
                        System.out.println(array.replaceAtRank(index, element));
                        break;

                    case 3:
                        System.out.print("Digite o índice onde deseja inserir: ");
                        index = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o elemento que será inserido: ");
                        element = sc.nextLine();
                        array.insertAtRank(index, element);
                        break;

                    case 4:
                        System.out.print("Digite o índice do elemento que deseja remover: ");
                        index = sc.nextInt();
                        System.out.println(array.removeAtRank(index));
                        break;

                    case 5:
                        System.out.println(array.size());
                        break;

                    case 6:
                        System.out.println(array.isEmpty());
                        break;

                    case 7:
                        System.out.println(array);
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
