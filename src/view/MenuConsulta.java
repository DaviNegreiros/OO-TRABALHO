package view;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import classes.*;
import cadastro.*;
import exceptions.*;
import java.util.List;

public class MenuConsulta {


    // Coleta dados do usuário e cria um novo objeto Consulta
    public static Consulta dadosNovaConsulta() {
        try {
            LocalDate data = Validacoes.obterDataValida("Informe a data da consulta");
            String hora = Validacoes.obterHorarioValido();
            String status = JOptionPane.showInputDialog("Informe o status da consulta: ");
            int min = Integer.parseInt(JOptionPane.showInputDialog("Informe a duração da consulta em minutos: "));
            float valor = Validacoes.obterValorValido();

            // Paciente e Médico associados (simplificado para o exemplo)
            Paciente paciente = new Paciente("Paciente Exemplo", "123.456.789-00", LocalDate.now());
            paciente.setPagamentoPendente(false); // Define o status de pagamento pendente

            Medico medico;
            try {
                medico = new Medico("Dr. Exemplo", "987.654.321-00", LocalDate.now(), "CRM123", "Cardiologia");
            } catch (EspecialidadeInvalidaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return null; // Retorna null se a especialidade for inválida
            }

            return new Consulta(data, hora, status, min, valor, paciente, medico);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Exibe o menu de opções e realiza ações baseadas na escolha do usuário
    public static void menuConsulta(CadastroConsulta cadConsulta, CadastroExame cadExame) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar consulta\n"
                + "2 - Pesquisar consulta\n"
                + "3 - Atualizar consulta\n"
                + "4 - Remover consulta\n"
                + "5 - Adicionar exame à consulta\n"
                + "6 - Adicionar medicamento à consulta\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1; // Inicializa a variável com um valor padrão
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            try {
                opcao = Integer.parseInt(strOpcao);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    Consulta novaConsulta = dadosNovaConsulta();
                    if (novaConsulta != null) {
                        try {
                            cadConsulta.adicionarConsulta(novaConsulta);
                            JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso.");
                        } catch (HorarioIndisponivelException | PagamentoPendenteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    LocalDate dataConsulta = Validacoes.obterDataValida("Informe a data da consulta para pesquisa");
                    String horaConsulta = Validacoes.obterHorarioValido();
                    List<Consulta> consultasEncontradas = cadConsulta.buscarConsultasPorDataHora(dataConsulta, horaConsulta);
                    if (!consultasEncontradas.isEmpty()) {
                        StringBuilder consultasStr = new StringBuilder();
                        for (Consulta c : consultasEncontradas) {
                            consultasStr.append(c.toString()).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, consultasStr.toString(), "Consultas Encontradas", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada.", "Consulta não encontrada", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 3:
                    LocalDate dataAtualizar = Validacoes.obterDataValida("Informe a data da consulta para atualização");
                    String horaAtualizar = JOptionPane.showInputDialog("Informe o horário da consulta: ");
                    Consulta consultaAtualizar = cadConsulta.buscarConsultaPorDataHora(dataAtualizar, horaAtualizar);
                    if (consultaAtualizar != null) {
                        Consulta novaConsultaAtualizada = dadosNovaConsulta();
                        if (novaConsultaAtualizada != null) {
                            try {
                                cadConsulta.atualizarConsulta(consultaAtualizar, novaConsultaAtualizada);
                                JOptionPane.showMessageDialog(null, "Consulta atualizada com sucesso.");
                            } catch (HorarioIndisponivelException | PagamentoPendenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Consulta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:
                    LocalDate dataRemover = Validacoes.obterDataValida("Informe a data da consulta para remoção");
                    String horaRemover = Validacoes.obterHorarioValido();
                    Consulta consultaRemover = cadConsulta.buscarConsultaPorDataHora(dataRemover, horaRemover);
                    if (consultaRemover != null) {
                        cadConsulta.removerConsulta(consultaRemover);
                        JOptionPane.showMessageDialog(null, "Consulta removida com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Consulta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:
                // Adicionar exame à consulta
                LocalDate dataExame = Validacoes.obterDataValida("Informe a data da consulta para adicionar exame");
                String horaExame = Validacoes.obterHorarioValido();
                Consulta consultaExame = cadConsulta.buscarConsultaPorDataHora(dataExame, horaExame);
                if (consultaExame != null) {
                    String tipo = JOptionPane.showInputDialog("Informe o tipo do exame para pesquisa: ");
                    Exame novoExame = cadExame.pesquisarExame(tipo); // Usa a instância de CadastroExame
                    if (novoExame != null) {
                        Exame[] exames = consultaExame.getExames();
                        Exame[] novosExames = new Exame[exames.length + 1];
                        System.arraycopy(exames, 0, novosExames, 0, exames.length);
                        novosExames[exames.length] = novoExame;
                        consultaExame.setExames(novosExames);

                        // Atualiza a consulta no sistema
                        try {
                            cadConsulta.atualizarConsulta(consultaExame, consultaExame);
                            JOptionPane.showMessageDialog(null, "Exame adicionado à consulta com sucesso.");
                        } catch (HorarioIndisponivelException | PagamentoPendenteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Exame não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Consulta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;

                case 6:
                    // Adicionar medicamento à consulta
                    LocalDate dataMedicamento = Validacoes.obterDataValida("Informe a data da consulta para adicionar medicamento");
                    String horaMedicamento = Validacoes.obterHorarioValido();
                    Consulta consultaMedicamento = cadConsulta.buscarConsultaPorDataHora(dataMedicamento, horaMedicamento);
                    if (consultaMedicamento != null) {
                        String nomeMedicamento = JOptionPane.showInputDialog("Informe o nome do medicamento: ");
                        String dosagem = JOptionPane.showInputDialog("Informe a dosagem do medicamento: ");
                        Medicamento novoMedicamento = new Medicamento(nomeMedicamento, dosagem, LocalDate.now());
                        Medicamento[] medicamentos = consultaMedicamento.getMedicamentos();
                        Medicamento[] novosMedicamentos = new Medicamento[medicamentos.length + 1];
                        System.arraycopy(medicamentos, 0, novosMedicamentos, 0, medicamentos.length);
                        novosMedicamentos[medicamentos.length] = novoMedicamento;
                        consultaMedicamento.setMedicamentos(novosMedicamentos);
                        JOptionPane.showMessageDialog(null, "Medicamento adicionado à consulta com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Consulta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}