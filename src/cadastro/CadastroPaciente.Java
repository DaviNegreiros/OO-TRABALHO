package cadastros;

import classes.Paciente;
import exceptions.CampoEmBrancoException;
import exceptions.CpfDuplicadoException; // FALTA ESSE
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroPaciente {

    // Atributos
    private List<Paciente> pacientes; // Usando List para armazenar os pacientes

    // Construtor
    public CadastroPaciente() {
        pacientes = new ArrayList<>();
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
    public boolean atualizarPaciente(String cpf, Paciente p) throws CampoEmBrancoException {
        if (p == null) {
            throw new CampoEmBrancoException("paciente");
        }
        verificarCamposEmBranco(p);
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equalsIgnoreCase(cpf)) {
                pacientes.set(i, p);
                return true;
            }
        }
        return false;
    }

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
        if (p.getNasc() == null) {
            throw new CampoEmBrancoException("data de nascimento");
        }
    }
}