package cadastro;

import classes.*;
import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroPaciente {

    // Atributos
    private List<Paciente> pacientes; // Usando List para armazenar os pacientes

    // Construtor
    public CadastroPaciente() {
        pacientes = new ArrayList<>();
    }
    // Método para adicionar uma consulta a um paciente
    public boolean adicionarConsultaAoPaciente(String cpf, Consulta consulta) {
        Paciente paciente = pesquisarPaciente(cpf);
        if (paciente != null) {
            // Verifica se o paciente já tem uma lista de consultas
            if (paciente.getConsultas() == null) {
                paciente.setConsultas(new ArrayList<>());
            }
            paciente.getConsultas().add(consulta);
            return true;
        }
        return false;
    }
    // Método para cadastrar pacientes
    public int cadastrarPaciente(Paciente p) throws CampoEmBrancoException, CpfDuplicadoException {
        if (p == null) {
            throw new CampoEmBrancoException("paciente");
        }
        verificarCamposEmBranco(p);
        if (cpfJaCadastrado(p.getCpf())) {
            throw new CpfDuplicadoException("CPF já cadastrado."); // Lança a exceção CpfDuplicadoException
        }
        // Inicializa o histórico médico como uma lista vazia no momento do cadastro
        //p.setHistoricoMedico(new ArrayList<>());

        pacientes.add(p);
        return pacientes.size();
    }

    // Método para pesquisar pacientes pelo CPF
    public Paciente pesquisarPaciente(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                return p;
            }
        }
        return null;
    }

    // Método para remover pacientes
    public boolean removerPaciente(Paciente p) {
        if (p == null) {
            return false;
        }
        return pacientes.remove(p);
    }

    // Método para atualizar pacientes
    public boolean atualizarPaciente(String cpf, Paciente novoPaciente) throws CampoEmBrancoException {
        if (novoPaciente == null) {
            throw new CampoEmBrancoException("paciente");
        }
        verificarCamposEmBranco(novoPaciente);

       /* for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                // Mantém o histórico do paciente antes de substituir os dados
                List<Object> historico = p.getHistoricoMedico();
                novoPaciente.setHistoricoMedico(historico);

                // Atualiza os dados do paciente sem perder o histórico médico
                pacientes.set(pacientes.indexOf(p), novoPaciente);
                return true;
            }
        }*/
        return false;
    }

    /* Novo método para adicionar uma consulta ao histórico de um paciente
    public boolean adicionarConsulta(String cpf, Consulta consulta) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                p.getHistoricoMedico().add(consulta);
                return true;
            }
        }
        return false;
    }

    // Novo método para adicionar um exame ao histórico de um paciente
    public boolean adicionarExame(String cpf, Exame exame) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                p.getHistoricoMedico().add(exame);
                return true;
            }
        }
        return false;
    }*/
    // Método para verificar se o CPF já está cadastrado
    private boolean cpfJaCadastrado(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar campos em branco
    private void verificarCamposEmBranco(Paciente p) throws CampoEmBrancoException {
        if (p.getNome() == null || p.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("nome");
        }
        if (p.getCpf() == null || p.getCpf().trim().isEmpty()) {
            throw new CampoEmBrancoException("CPF");
        }
        if (!p.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new CampoEmBrancoException("CPF deve estar no formato XXX.XXX.XXX-XX.");
        }
        if (p.getNasc() == null) {
            throw new CampoEmBrancoException("data de nascimento");
        }
    }
}