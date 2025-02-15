package view;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import classes.*;
import cadastro.*;
import exceptions.*;

public class MenuExame {
    
   
    // Coleta dados do usuário e cria um novo objeto Exame
    public static Exame dadosNovoExame() {
        try {
            String tipo = lerTipo();
            String resultado = lerResultado();
            LocalDate dataPrescricao = Validacoes.obterDataValida("Informe a data de prescrição");
            LocalDate dataRealizacao = Validacoes.obterDataValida("Informe a data de realização");
            float valor = Validacoes.obterValorValido();
            return new Exame(tipo, resultado, dataPrescricao, dataRealizacao, valor);
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Solicita o tipo do exame ao usuário
    private static String lerTipo() throws CampoEmBrancoException {
        String tipo = JOptionPane.showInputDialog("Informe o tipo do exame: ");
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new CampoEmBrancoException("O tipo do exame não pode estar em branco!");
        }
        return tipo;
    }

    // Solicita o resultado do exame ao usuário
    private static String lerResultado() {
        return JOptionPane.showInputDialog("Informe o resultado do exame: ");
    }


    // Exibe o menu de opções e realiza ações baseadas na escolha do usuário
    public static void menuExame(CadastroExame cadExame) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar exame\n"
                + "2 - Pesquisar exame\n"
                + "3 - Atualizar exame\n"
                + "4 - Remover exame\n"
                + "0 - Voltar para menu anterior";

        int opcao;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Exame novoExame = dadosNovoExame();
                    if (novoExame != null) {
                        try {
                            cadExame.cadastrarExame(novoExame);
                            JOptionPane.showMessageDialog(null, "Exame cadastrado com sucesso.");
                        } catch (CampoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                
                case 2:
                    String tipo = JOptionPane.showInputDialog("Informe o tipo do exame para pesquisa: ");
                    Exame exame = cadExame.pesquisarExame(tipo);
                    if (exame != null) {
                        JOptionPane.showMessageDialog(null, exame.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Exame não encontrado.");
                    }
                    break;
                
                case 3:
                    tipo = JOptionPane.showInputDialog("Informe o tipo do exame que deseja atualizar: ");
                    Exame exameAtualizado = dadosNovoExame();
                    if (exameAtualizado != null) {
                        try {
                            boolean atualizado = cadExame.atualizarExame(tipo, exameAtualizado);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Exame atualizado.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Exame não encontrado.");
                            }
                        } catch (CampoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                
                case 4:
                    tipo = JOptionPane.showInputDialog("Informe o tipo do exame que deseja remover: ");
                    Exame exameParaRemover = cadExame.pesquisarExame(tipo);
                    boolean removido = cadExame.removerExame(exameParaRemover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Exame removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exame não encontrado.");
                    }
                    break;
                
                default:
                    break;
            }
        } while (opcao != 0);
    }
}
