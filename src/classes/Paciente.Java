package classes;

import java.util.List;
import java.util.ArrayList;
import exceptions.PagamentoPendenteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente extends PessoaFisica {
    boolean pagamentoPendente;
    private List<Consulta> consultas; // Lista de consultas do paciente

    // Construtor
    public Paciente(String nome, String cpf, LocalDate nasc) {
        super(nome, cpf, nasc);
        this.pagamentoPendente = false;
        this.consultas = new ArrayList<>();
    }

    // Métodos get e set para a lista de consultas
    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    // Read
    boolean getPagamentoPendente() {
        return pagamentoPendente;
    }

    // Update
    public void setPagamentoPendente(boolean a) {
        pagamentoPendente = a;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(getNome()).append("\n")
          .append("CPF: ").append(getCpf()).append("\n")
          .append("Data de Nascimento: ").append(getNasc().format(formatter)).append("\n")
          .append("Pagamento Pendente: ").append(pagamentoPendente).append("\n");

        // Adiciona informações sobre os exames
        if (!consultas.isEmpty()) {
            sb.append("Exames:\n");
            for (Consulta consulta : consultas) {
                Exame[] exames = consulta.getExames();
                if (exames != null && exames.length > 0) {
                    for (Exame exame : exames) {
                        sb.append("  - Tipo: ").append(exame.getTipo())
                          .append(", Valor: ").append(exame.getValor()).append("\n");
                    }
                }
            }
        } else {
            sb.append("Exames: Nenhum exame cadastrado.\n");
        }

        return sb.toString();
    }

    public void verificarPagamento() throws PagamentoPendenteException {
        if (pagamentoPendente) {
            throw new PagamentoPendenteException("O pagamento do paciente " + getNome() + " está pendente.");
        }
    }
}