package cadastro;

import classes.Medico;
import exceptions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroMedico {

    // Atributos
    private List<Medico> medicos;

    // Construtor
    public CadastroMedico() {
        medicos = new ArrayList<>();
    }

    // Método para cadastrar médicos
    public int cadastrarMedico(Medico m) throws CampoEmBrancoException, CpfDuplicadoException, CrmDuplicadoException {
        if (m == null) {
            throw new CampoEmBrancoException("médico");
        }
        verificarCamposEmBranco(m);
        verificarCpfDuplicado(m.getCpf());
        verificarCrmDuplicado(m.getCrm());
        medicos.add(m);
        return medicos.size();
    }

    // Método para pesquisar médicos pelo CRM
    public Medico pesquisarMedico(String crm) {
        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(crm)) {
                return m;
            }
        }
        return null;
    }

    // Método para remover médicos
    public boolean removerMedico(Medico m) {
        if (m == null) {
            return false;
        }
        return medicos.remove(m);
    }

    // Método para atualizar médicos
    public boolean atualizarMedico(String crm, Medico m) throws CampoEmBrancoException, CpfDuplicadoException, CrmDuplicadoException {
    if (m == null) {
        throw new CampoEmBrancoException("médico");
    }
    verificarCamposEmBranco(m);
    verificarCpfDuplicado(m.getCpf());
    verificarCrmDuplicado(m.getCrm());
    for (int i = 0; i < medicos.size(); i++) {
        if (medicos.get(i).getCrm().equalsIgnoreCase(crm)) {
            medicos.set(i, m);
            return true;
        }
    }
    return false;
}

    // Método para verificar campos em branco
    private void verificarCamposEmBranco(Medico m) throws CampoEmBrancoException {
        if (m.getNome() == null || m.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("nome");
        }
        if (m.getCpf() == null || m.getCpf().trim().isEmpty()) {
            throw new CampoEmBrancoException("CPF");
        }
        if (!m.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new CampoEmBrancoException("CPF deve estar no formato XXX.XXX.XXX-XX.");
        }
        if (m.getCrm() == null || m.getCrm().trim().isEmpty()) {
            throw new CampoEmBrancoException("CRM");
        }
        if (m.getEspec() == null || m.getEspec().trim().isEmpty()) {
            throw new CampoEmBrancoException("especialização");
        }
    }

    // Método para verificar CPF duplicado
    private void verificarCpfDuplicado(String cpf) throws CpfDuplicadoException {
        for (Medico m : medicos) {
            if (m.getCpf().equals(cpf)) {
                throw new CpfDuplicadoException("CPF já cadastrado.");
            }
        }
    }

    // Método para verificar CRM duplicado
    private void verificarCrmDuplicado(String crm) throws CrmDuplicadoException {
        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(crm)) {
                throw new CrmDuplicadoException("CRM já cadastrado.");
            }
        }
    }
}
