package cadastro;

import classes.*;
import exceptions.*;
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
    public int cadastrarMedico(Medico m) throws CampoEmBrancoException, CpfDuplicadoException, CrmDuplicadoException, EspecialidadeInvalidaException {
        if (m == null) {
            throw new CampoEmBrancoException("médico");
        }
        verificarCamposEmBranco(m);
        if (cpfJaCadastrado(m.getCpf())) {
            throw new CpfDuplicadoException("CPF já cadastrado.");
        }
        if (crmJaCadastrado(m.getCrm())) {
            throw new CrmDuplicadoException("CRM já cadastrado.");
        }
        m.validarEspecialidade(m.getEspec()); // Validação da especialidade antes do cadastro
        
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
    public boolean atualizarMedico(String crm, Medico novoMedico) throws CampoEmBrancoException, EspecialidadeInvalidaException {
        if (novoMedico == null) {
            throw new CampoEmBrancoException("médico");
        }
        verificarCamposEmBranco(novoMedico);
        novoMedico.validarEspecialidade(novoMedico.getEspec());

        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(crm)) {
                medicos.set(medicos.indexOf(m), novoMedico);
                return true;
            }
        }
        return false;
    }

    // Método para verificar se o CPF já está cadastrado
    private boolean cpfJaCadastrado(String cpf) {
        for (Medico m : medicos) {
            if (m.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar se o CRM já está cadastrado
    private boolean crmJaCadastrado(String crm) {
        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(crm)) {
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
        if (m.getNasc() == null) {
            throw new CampoEmBrancoException("data de nascimento");
        }
        if (m.getCrm() == null || m.getCrm().trim().isEmpty()) {
            throw new CampoEmBrancoException("CRM");
        }
        if (m.getEspec() == null || m.getEspec().trim().isEmpty()) {
            throw new CampoEmBrancoException("especialidade");
        }
    }
}