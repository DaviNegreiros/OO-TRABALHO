package view;

import javax.swing.JOptionPane;
import classes.Medico;
import classes.Consulta;
import classes.Exame;
import cadastro.CadastroMedico;
import exceptions.CampoEmBrancoException;
import exceptions.CpfDuplicadoException;
import exceptions.CrmDuplicadoException;
import java.time.LocalDate;

public class MenuMedico {

    // Coleta dados do usuário e cria um novo objeto Medico
    public static Medico dadosNovoMedico() {
        String nome = lerNome();
        String cpf = lerCPF();
        String nasc = lerNascimento();
        String crm = lerCRM();
        String espec = lerEspecialidade();

        try {
            // Tenta criar um novo médico e retorna o objeto
            return new Medico(nome, cpf, LocalDate.parse(nasc), crm, espec);
        } catch (CampoEmBrancoException e) {
            // Exibe mensagem de erro se algum campo estiver em branco
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Solicita o nome do médico ao usuário
    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do médico: ");
    }

    // Solicita o CPF do médico ao usuário
    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do médico (XXX.XXX.XXX-XX): ");
    }

    // Solicita a data de nascimento do médico ao usuário
    private static String lerNascimento() {
        return JOptionPane.showInputDialog("Informe a data de nascimento do médico (yyyy-mm-dd): ");
    }

    // Solicita o CRM do médico ao usuário
    private static String lerCRM() {
        return JOptionPane.showInputDialog("Informe o CRM do médico: ");
    }

    // Solicita a especialidade do médico ao usuário
    private static String lerEspecialidade() {
        return JOptionPane.showInputDialog("Informe a especialidade do médico: ");
    }

    // Exibe o menu de opções e realiza ações baseadas na escolha do usuário
    public static void menuMedico(CadastroMedico cadMedico) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar médico\n"
                + "2 - Pesquisar médico\n"
                + "3 - Atualizar médico\n"
                + "4 - Remover médico\n"
                + "5 - Adicionar consulta ao histórico\n"
                + "6 - Adicionar exame ao histórico\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    // Cadastra um novo médico
                    Medico novoMedico = dadosNovoMedico();
                    if (novoMedico != null) {
                        try {
                            cadMedico.cadastrarMedico(novoMedico);
                            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso.");
                        } catch (CampoEmBrancoException | CpfDuplicadoException | CrmDuplicadoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    // Pesquisa um médico pelo CRM
                    String crm = lerCRM();
                    Medico medico = cadMedico.pesquisarMedico(crm);
                    if (medico != null) {
                        JOptionPane.showMessageDialog(null, medico.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;

                case 3:
                    // Atualiza os dados de um médico existente
                    crm = lerCRM();
                    Medico novoCadastro = dadosNovoMedico();
                    if (novoCadastro != null) {
                        try {
                            boolean atualizado = cadMedico.atualizarMedico(crm, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                            }
                        } catch (CampoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 4:
                    // Remove um médico pelo CRM
                    crm = lerCRM();
                    Medico remover = cadMedico.pesquisarMedico(crm);
                    boolean removido = cadMedico.removerMedico(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Médico removido do cadastro.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;

                case 5:
                    // Adiciona uma consulta ao histórico do médico
                    crm = lerCRM();
                    Medico medicoConsulta = cadMedico.pesquisarMedico(crm);
                    if (medicoConsulta != null) {
                        String dataConsulta = JOptionPane.showInputDialog("Informe a data da consulta (yyyy-mm-dd): ");
                        String descricaoConsulta = JOptionPane.showInputDialog("Informe a descrição da consulta: ");
                        Consulta consulta = new Consulta(dataConsulta, descricaoConsulta);
                        medicoConsulta.adicionarConsulta(consulta);
                        JOptionPane.showMessageDialog(null, "Consulta adicionada ao histórico.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;

                case 6:
                    // Adiciona um exame ao histórico do médico
                    crm = lerCRM();
                    Medico medicoExame = cadMedico.pesquisarMedico(crm);
                    if (medicoExame != null) {
                        String dataExame = JOptionPane.showInputDialog("Informe a data do exame (yyyy-mm-dd): ");
                        String tipoExame = JOptionPane.showInputDialog("Informe o tipo do exame: ");
                        Exame exame = new Exame(dataExame, tipoExame);
                        medicoExame.adicionarExame(exame);
                        JOptionPane.showMessageDialog(null, "Exame adicionado ao histórico.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;

                default:
                    // Para opções inválidas, apenas sai do switch sem fazer nada
                    break;
            }
        } while (opcao != 0); // Continua executando até que o usuário escolha sair (opção 0)
    }
}