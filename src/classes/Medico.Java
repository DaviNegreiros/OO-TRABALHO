package classes;

import classes.*;
import exceptions.EspecialidadeInvalidaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medico extends PessoaFisica {
    // Atributos
    private String crm;
    private String espec;
    private List<Consulta> consultas; // Histórico de consultas
    private List<Exame> exames; // Histórico de exames

    // Construtor
    public Medico(String nome, String cpf, LocalDate nasc, String crm, String espec) throws EspecialidadeInvalidaException {
        super(nome, cpf, nasc);
        this.crm = crm;
        validarEspecialidade(espec); // Valida a especialidade antes de atribuir
        this.espec = espec;
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    // Métodos de acesso (Getters)
    public String getCrm() {
        return crm;
    }

    public String getEspec() {
        return espec;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Exame> getExames() {
        return exames;
    }

    // Métodos de modificação (Setters)
    public void setEspec(String espec) throws EspecialidadeInvalidaException {
        validarEspecialidade(espec); // Valida a especialidade antes de atribuir
        this.espec = espec;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    // Métodos para adicionar consultas e exames ao histórico
    public void adicionarConsulta(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não pode ser nula.");
        }
        this.consultas.add(consulta);
    }

    public void adicionarExame(Exame exame) {
        if (exame == null) {
            throw new IllegalArgumentException("Exame não pode ser nulo.");
        }
        this.exames.add(exame);
    }

    // Método para validar o formato do CPF
    @Override
    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF deve estar no formato XXX.XXX.XXX-XX.");
        }
        // Verifica se todos os dígitos são iguais (CPF inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        super.setCpf(cpf);
    }

    // Método toString para exibir informações do médico
    @Override
    public String toString() {
        return "Médico:\n" +
               "  Nome: " + getNome() + "\n" +
               "  CPF: " + getCpf() + "\n" +
               "  Data de Nascimento: " + getNasc() + "\n" +
               "  CRM: " + crm + "\n" +
               "  Especialidade: " + espec + "\n" +
               "  Consultas: " + consultas.size() + "\n" +
               "  Exames: " + exames.size() + "\n";
    }

    // Método para validar especialidade
    public void validarEspecialidade(String espec) throws EspecialidadeInvalidaException {
        String[] especialidadesValidas = {"Cardiologia", "Ortopedia", "Dermatologia", "Pediatria", "Neurologia"};

        boolean especialidadeValida = false;
        for (String especialidade : especialidadesValidas) {
            if (especialidade.equalsIgnoreCase(espec)) {
                especialidadeValida = true;
                break;
            }
        }

        if (!especialidadeValida) {
            throw new EspecialidadeInvalidaException("Especialidade inválida: " + espec);
        }
    }

    // Método para verificar se o horário está ocupado
    public boolean horarioOcupado(LocalDate data, String hora) {
        for (Consulta consulta : consultas) {
            if (consulta.getData().equals(data) && consulta.getHora().equals(hora)) {
                return true; // Horário ocupado
            }
        }
        return false; // Horário disponível
    }
}