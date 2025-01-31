package cadastro;


import javax.swing.JOptionPane;
import java.time.LocalDate;

import classes.Medico;
//import exceptions.???;

public class CadastroMedico {
    //Atributos
    int numMedicos;
    Medico[] medicos;


    //Métodos
    CadastroMedico(){
        numMedicos = 0;
        medicos = newMedico[0];
    }

    //Metodo para cadastro falta: throws EXECPTION
    public int cadastrarMedico(Medico m) {

        String msgNome = "Informe o nome do médico: "; 
        String nome = JOptionPane.showInputDialog(msgNome);

        String msgCpf = "Informe o CPF do médico: " ;
        String cpf = JOptionPane.showInputDialog(msgCpf);

        String msgNasc = "Informe a data de nascimento do médico: (yyyy-mm-dd)"; 
        String nasc = JOptionPane.showInputDialog(msgNasc);

        String msgCrm = "Informe o CRM do médico: ";
        String crm = JOptionPane.showInputDialog(msgCrm);

        String msgEspec = "Informe a especialidade do médico: " ;
        String espec = JOptionPane.showInputDialog(msgEspec);

        // Criando médico
        Medico medico1;
        medico1 = new Medico(nome, cpf, LocalDate.parse(nasc), crm, espec);
        
        // Exibindo dados do medico
        String msgShow  = medico1.toString();
        JOptionPane.showMessageDialog(null, msgShow);   




        








    }








}