package view;

import javax.swing.JOptionPane;
import classes.Paciente;
import cadastro.CadastroPaciente;
import exceptions.CampoEmBrancoException;
import exceptions.CpfDuplicadoException; // FALTA ESSE
import java.time.LocalDate;

public class MenuPaciente {

    // Coleta dados do usuário e cria um novo objeto Paciente
    public static Paciente dadosNovoPaciente() {
        String nome = lerNome();
        String cpf = lerCPF();
        String nasc = lerNascimento();

        try {
            // Tenta criar um novo paciente e retorna o objeto
            return new Paciente(nome, cpf, LocalDate.parse(nasc));
        } catch (CampoEmBrancoException e) {
            // Exibe mensagem de erro se algum campo estiver em branco
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Solicita o nome do paciente ao usuário
    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do paciente: ");
    }

    // Solicita o CPF do paciente ao usuário
    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do paciente: ");
    }

    // Solicita a data de nascimento do paciente ao usuário
    private static String lerNascimento() {
        return JOptionPane.showInputDialog("Informe a data de nascimento do paciente (yyyy-mm-dd): ");
    }

    // Exibe o menu de opções e realiza ações baseadas na escolha do usuário
    public static void menuPaciente(CadastroPaciente cadPaciente) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar paciente\n"
                + "2 - Pesquisar paciente\n"
                + "3 - Atualizar paciente\n"
                + "4 - Remover paciente\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    // Cadastra um novo paciente
                    Paciente novoPaciente = dadosNovoPaciente();
                    if (novoPaciente != null) {
                        try {
                            cadPaciente.cadastrarPaciente(novoPaciente);
                            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso.");
                        } catch (CampoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (CpfDuplicadoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    // Pesquisa um paciente pelo CPF
                    String cpf = lerCPF();
                    Paciente paciente = cadPaciente.pesquisarPaciente(cpf);
                    if (paciente != null) {
                        JOptionPane.showMessageDialog(null, paciente.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                    }
                    break;

                case 3:
                    // Atualiza os dados de um paciente existente
                    cpf = lerCPF();
                    Paciente novoCadastro = dadosNovoPaciente();
                    if (novoCadastro != null) {
                        try {
                            boolean atualizado = cadPaciente.atualizarPaciente(cpf, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                            }
                        } catch (CampoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 4:
                    // Remove um paciente pelo CPF
                    cpf = lerCPF();
                    Paciente remover = cadPaciente.pesquisarPaciente(cpf);
                    boolean removido = cadPaciente.removerPaciente(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Paciente removido do cadastro.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                    }
                    break;

                default:
                    // Para opções inválidas, apenas sai do switch sem fazer nada
                    break;
            }
        } while (opcao != 0); // Continua executando até que o usuário escolha sair (opção 0)
    }
}