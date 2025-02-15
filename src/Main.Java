//main codar pra funcionar
import cadastro.*;
import classes.*;
import exceptions.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import view.*;
//compiler: javac -d ../out -sourcepath . Main.java classes/PessoaFisica.java classes/Medico.java NAO APAGUE


public class Main {
    
     

    //Instanciando objs de cadastro
    static CadastroMedico cadMed;
    static CadastroPaciente cadPac;
    static CadastroExame cadEx;
    static CadastroConsulta cadCon;
    
    public static void main(String[] args) {
        //Referenciando objs de cadastro
        cadMed = new CadastroMedico();
        cadPac = new CadastroPaciente();
        cadEx = new CadastroExame();
        cadCon = new CadastroConsulta();
        
        // Declaração de medico1 fora do switch
        Medico medico1 = null;



        Scanner scanner = new Scanner(System.in);
        int opcao;
        while(true){
        opcao = MenuInicial.menuOpcoes();

            switch (opcao) {
                case 1: 
                                     

                    // Menu gerenciamento de médicos
                    MenuMedico.menuMedico(cadMed);
                    break;
                case 2:
                    //Menu gerenciamento de pacientes
                    MenuPaciente.menuPaciente(cadPac);
                    break;
                case 3:
                    MenuConsulta.menuConsulta(cadCon, cadEx);
                    break;
                case 4:
                    //Menu gerenciamento de exames
                    MenuExame.menuExame(cadEx);
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

