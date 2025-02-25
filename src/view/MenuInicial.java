package view;

import javax.swing.JOptionPane;

public class MenuInicial {

    //Método para testar se a string é inteiro
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);  // Tenta converter para inteiro
            return true;  // Se não lançar exceção, é um inteiro
        } catch (NumberFormatException e) {
            return false;  // Se lançar exceção, não é um inteiro
        }
    }

    public static int menuOpcoes() {
        int opcao;
        String msg = "\n===>Menu Principal<===" +
                     "\n1. Gerenciar Médicos" +
                     "\n2. Gerenciar Pacientes" +
                     "\n3. Gerenciar Consultas" +
                     "\n4. Gerenciar Exames" +
                     "\n0. Sair" +
                     "\nEscolha uma opção => ";

        String strOpcao = JOptionPane.showInputDialog(msg);
            if(isInteger(strOpcao)){
                opcao = Integer.parseInt(strOpcao); 
            } else{
                opcao = 1000; //deafault
            }
        opcao = Integer.parseInt(strOpcao);

        return opcao;
    }
}
