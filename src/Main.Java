//main codar pra funcionar
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import exceptions.*;


import classes.*; // Importa todas as classes do pacote "classes"

//compiler: javac -d ../out -sourcepath . Main.java classes/PessoaFisica.java classes/Medico.java NAO APAGUE


public class Main {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);  // Tenta converter para inteiro
            return true;  // Se não lançar exceção, é um inteiro
        } catch (NumberFormatException e) {
            return false;  // Se lançar exceção, não é um inteiro
        }
    }
    public static void main(String[] args) {

        
        // Declaração de medico1 fora do switch
        Medico medico1 = null;



        Scanner scanner = new Scanner(System.in);
        int opcao;

        String msg = "\nMenu Principal" +
                    "\n1. Teste novo Médico" +
                    "\n0. Sair" +
                    "\nEscolha uma opção => ";
        
        while (true) {
            String strOpcao = JOptionPane.showInputDialog(msg);
            if(isInteger(strOpcao)){
                opcao = Integer.parseInt(strOpcao); 
            } else{
                opcao = 1000; //deafault
            }

            switch (opcao) {
                case 1: 
                                     

                    // Criando médico
                    medico1 = new Medico("Dr Joao", "12345678900", LocalDate.parse("1975-02-14"), "CRM12345", "Cardiologista");
                    
                    // Exibindo dados do medico
                    String msgTeste  = medico1.toString();
                    JOptionPane.showMessageDialog(null, msgTeste);   
                    break;
                    case 2:
                    // Criando paciente
                    Paciente paciente1 = new Paciente("Maria Silva", "12345678901", LocalDate.parse("1990-05-22"));

                    // Verificando o pagamento e lançando exceção se necessário
                    try {
                        paciente1.verificarPagamento(); 
                        JOptionPane.showMessageDialog(null, "Paciente " + paciente1.getNome() + " não tem pagamento pendente.");
                    } catch (PagamentoPendenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());  
                    }
                    break;
                case 3:
                    // Testando horário indisponível
                    String horario = "14:00";  

                    try {
                        
                        boolean horarioDisponivel = medico1.isHorarioDisponivel(horario);

                        if (!horarioDisponivel) {
                            throw new HorarioIndisponivelException("O horário " + horario + " não está disponível.");
                        }

                        JOptionPane.showMessageDialog(null, "Horário disponível: " + horario);

                    } catch (HorarioIndisponivelException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());  
                    }
                    break;
                case 4:
                    
                    try {
                        String especialidade = "Oftalmologista";  // Especialidade inválida para testar

                        if (!especialidade.equals("Cardiologista") && !especialidade.equals("Dermatologista")) {
                            throw new EspecialidadeInvalidaException("Especialidade " + especialidade + " não é válida.");
                        }

                        JOptionPane.showMessageDialog(null, "Especialidade válida: " + especialidade);

                    } catch (EspecialidadeInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());  
                    }
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
