//main codar pra funcionar
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1: 
                    System.out.println("1 escolhido:")
                    // Criando um médico
                    Medico medico1 = new Medico("Dr. João", "123.456.789-00", "14-02-1975", "CRM12345", "Cardiologista");
                    
                    // Exibindo os dados
                    medico1.exibirDados();

                case 0:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
