package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validacoes {

    

    //verifica e retorna uma data valida
    public static LocalDate obterDataValida(String mensagemData) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataDeNasc = null;
        
        while (dataDeNasc == null) {
            String entrada = JOptionPane.showInputDialog(null, mensagemData + " (dd-mm-aaaa): ", "Data de nascimento", JOptionPane.QUESTION_MESSAGE);
            
            if (entrada == null) { // Usuário clicou em "Cancelar"
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

            try {
                dataDeNasc = LocalDate.parse(entrada, inputFormatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return dataDeNasc;
    }
    
    public static String obterCpfValido() {
        String cpfTemp = "";

        while (true) { // Loop até que um CPF válido seja inserido ou o usuário cancele
            String entrada = JOptionPane.showInputDialog(null, "Insira o CPF: (xxx.xxx.xxx-xx)", "CPF", JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) { // Usuário clicou em "Cancelar"
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

            // Define o padrão regex para o formato xxx.xxx.xxx-xx
            String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

            // Compila o padrão
            Pattern pattern = Pattern.compile(regex);

            // Cria um matcher para comparar a string com o padrão
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) { // Verifica se a entrada corresponde ao padrão
                cpfTemp = entrada; // Armazena o CPF válido
                break; // Sai do loop
            } else {
                JOptionPane.showMessageDialog(null, "Formato inválido! Use o formato xxx.xxx.xxx-xx.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cpfTemp; // Retorna o CPF válido
    }
}
