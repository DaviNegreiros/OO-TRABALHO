//main codar pra funcionar
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import javax.swing.JOptionPane;


import classes.*; // Importa todas as classes do pacote "classes"

//compiler: javac -d ../out -sourcepath . Main.java classes/PessoaFisica.java classes/Medico.java NAO APAGUE


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String msg = "\nMenu Principal" +
                    "\n1. Teste novo Médico" +
                    "\n0. Sair" +
                    "\nEscolha uma opção => ";
        
        while (true) {
            String strOpcao = JOptionPane.showInputDialog(msg);
            int opcao = Integer.parseInt(strOpcao); 

            switch (opcao) {
                case 1: 
                                     

                    // Criando médico
                    Medico medico1;
                    medico1 = new Medico("Dr Joao", "12345678900", LocalDate.parse("1975-02-14"), "CRM12345", "Cardiologista");
                    
                    // Exibindo dados do medico
                    String msgTeste  = medico1.toString();
                    JOptionPane.showMessageDialog(null, msgTeste);   
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");   
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
