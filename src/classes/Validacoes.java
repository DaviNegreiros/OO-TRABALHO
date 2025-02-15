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

        while (true) { 
            String entrada = JOptionPane.showInputDialog(null, "Insira o CPF: (xxx.xxx.xxx-xx)", "CPF", JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) { // "Cancelar"
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

            // Define o padrão regex para o formato xxx.xxx.xxx-xx
            String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

            // Compila o padrão
            Pattern pattern = Pattern.compile(regex);

            // Cria um matcher para comparar a string com o padrão
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) { 
                cpfTemp = entrada; 
                break; 
            } else {
                JOptionPane.showMessageDialog(null, "Formato inválido! Use o formato xxx.xxx.xxx-xx.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cpfTemp;
    }
    
    public static String obterHorarioValido() {
        String horarioTemp = "";
    
        while (true) { 
            String entrada = JOptionPane.showInputDialog(null, "Insira o horário: (xx:xx)", "Horário", JOptionPane.QUESTION_MESSAGE);
    
            if (entrada == null) { // "Cancelar"
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
    
            // Define o padrão regex para o formato XX:XX
            String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    
            // Compila o padrão
            Pattern pattern = Pattern.compile(regex);
    
            // Cria um matcher para comparar a string com o padrão
            Matcher matcher = pattern.matcher(entrada);
    
            if (matcher.matches()) { 
                horarioTemp = entrada; 
                break; 
            } else {
                JOptionPane.showMessageDialog(null, "Formato inválido! Use o formato XX:XX, onde XX (horas) < 24 e XX (minutos) < 60.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return horarioTemp; 
    }
   
    
    public static float obterValorValido() {
        float valorTemp;
    
        while (true) { 
            String entrada = JOptionPane.showInputDialog(null, "Insira o valor em reais: (X,XX)", "Valor Decimal", JOptionPane.QUESTION_MESSAGE);
    
            if (entrada == null) { 
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }
    
            // Define o padrão regex para o formato nX,XX 
            String regex = "\\d+,\\d{2}";
    
            // Compila o padrão
            Pattern pattern = Pattern.compile(regex);
    
            // Cria um matcher para comparar a string com o padrão
            Matcher matcher = pattern.matcher(entrada);
    
            if (matcher.matches()) { 
                // Substitui a vírgula por ponto
              String valorFormatado = entrada.replace(",", ".");

                 // Converte a String para float
                valorTemp = Float.parseFloat(valorFormatado);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Formato inválido! Use o formato X,XX, onde X são números e a vírgula separa duas casas decimais.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valorTemp; 
    }














}
