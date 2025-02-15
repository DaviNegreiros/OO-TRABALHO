package view;

import cadastro.*;
import classes.*;
import exceptions.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import exceptions.EspecialidadeInvalidaException;

public class MenuMedico {

    public static Medico dadosNovoMedico() {
        try {
            String nome = lerNome();
            String cpf = lerCPF();
            LocalDate nasc = lerNascimento();
            String crm = lerCRM();
            String espec = lerEspecialidade();
            return new Medico(nome, cpf, nasc, crm, espec);
        } catch (CampoEmBrancoException | EspecialidadeInvalidaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private static String lerNome() throws CampoEmBrancoException {
        String nome = JOptionPane.showInputDialog("Informe o nome do médico: ");
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("O nome não pode estar em branco!");
        }
        return nome;
    }

    private static String lerCPF() {
        return Validacoes.obterCpfValido();
    }

    private static LocalDate lerNascimento() {
        return Validacoes.obterDataValida("Informe a data de nascimento");
    }

    private static String lerCRM() {
        return JOptionPane.showInputDialog("Informe o CRM do médico: ");
    }

    private static String lerEspecialidade() {
        return JOptionPane.showInputDialog("Informe a especialidade do médico: ");
    }

    public static void menuMedico(CadastroMedico cadMedico) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar médico\n"
                + "2 - Pesquisar médico\n"
                + "3 - Atualizar médico\n"
                + "4 - Remover médico\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Medico novoMedico = dadosNovoMedico();
                    if (novoMedico != null) {
                        try {
                            cadMedico.cadastrarMedico(novoMedico);
                            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso.");
                        } catch (CampoEmBrancoException | CpfDuplicadoException | CrmDuplicadoException | EspecialidadeInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 2:
                    String crm = lerCRM();
                    Medico medico = cadMedico.pesquisarMedico(crm);
                    if (medico != null) {
                        JOptionPane.showMessageDialog(null, medico.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;
                case 3:
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
                        } catch (CampoEmBrancoException | EspecialidadeInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 4:
                    crm = lerCRM();
                    Medico remover = cadMedico.pesquisarMedico(crm);
                    boolean removido = cadMedico.removerMedico(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Médico removido do cadastro.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
}