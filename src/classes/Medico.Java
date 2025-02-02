package classes;

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
    public Medico(String nome, String cpf, LocalDate nasc, String crm, String espec) {
        
        super(nome, cpf, nasc);
        this.crm = crm;
        this.espec = espec;
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
        //validarEspecialidade(espec); isso não deve ser chamado aqui, mas sim antes do construtor
        
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
    public void setEspec(String espec) {
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
        super.setCpf(cpf);
    }

    // Método toString para exibir informações do médico
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
               "CPF: " + getCpf() + "\n" +
               "Data de Nascimento: " + getNasc() + "\n" +
               "CRM: " + crm + "\n" +
               "Especialidade: " + espec + "\n" +
               "Consultas: " + consultas.size() + "\n" +
               "Exames: " + exames.size() + "\n";
    }
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






    public boolean horarioOcupado(LocalDate data, String hora) {
        // Lógica para verificar se o horário está ocupado
        return false; // Modifique conforme necessário
    }
    // Método para verificar disponibilidade do horário
    public boolean isHorarioDisponivel(String horario) {
        // Lógica para verificar se o horário está disponível
        // Aqui é apenas um exemplo. Implemente conforme o necessário.
        // Por exemplo, verificar se o médico já tem consulta marcada no horário.
        return !horario.equals("14:00");  // Exemplo simples: horário 14:00 não disponível
    }
}



    







