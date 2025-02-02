//main codar pra funcionar
import classes.*;
import exceptions.*;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
import view.*;
import cadastro.*;
//compiler: javac -d ../out -sourcepath . Main.java classes/PessoaFisica.java classes/Medico.java NAO APAGUE


public class Main {

    //Instanciando objs de cadastro
    static CadastroMedico cadMed;
    static CadastroPaciente cadPac;
    
    public static void main(String[] args) {
        //Referenciando objs de cadastro
        cadMed = new CadastroMedico();
        cadPac = new CadastroPaciente();
        
        // Declaração de medico1 fora do switch
        Medico medico1 = null;



        Scanner scanner = new Scanner(System.in);
        int opcao;
        while(true){
        opcao = MenuInicial.menuOpcoes();

            switch (opcao) {
                case 1: 
                                     

                    // Menu gerenciamento de alunos
                    MenuMedico.menuMedico(cadMed);
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
        }}
    }

