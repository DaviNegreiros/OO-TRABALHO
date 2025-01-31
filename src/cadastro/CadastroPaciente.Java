package cadastros;

import classes.Paciente;
import exceptions.CampoEmBrancoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroPaciente {

    //Nesse CadastroPaciente eu fiz pensando em um view que coloquei em outra pasta, não sei se vcs vao querer
    //fazer desse jeito, o CadastroMedico esta com o chamado do recurso grafico no proprio codigo
    //qlqr coisa faco o MenuMedico tb ou adapto esse do mesmo jeito do CadastroMedico com JOptionPane

    // Atributos
    private List<Paciente> pacientes; // Usando List para armazenar os pacientes

    // Construtor
    public CadastroPaciente() {
        pacientes = new ArrayList<>();
    }

    // Método para cadastrar pacientes
    public int cadastrarPaciente(Paciente p) throws CampoEmBrancoException {
        if (p == null) {
            throw new CampoEmBrancoException("paciente");
        }
        verificarCamposEmBranco(p);
        if (cpfJaCadastrado(p.getCpf())) {
            throw new CampoEmBrancoException("CPF já cadastrado.");
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