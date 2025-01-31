package cadastro;

import classes.Medico;
import exceptions.CampoEmBrancoException;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class CadastroMedico {

    // Atributos
    private int numMedicos;
    private Medico[] medicos;

    // Construtor
    public CadastroMedico() {
        numMedicos = 0;
        medicos = new Medico[0];
    }

    // Método para cadastrar médicos
    public int cadastrarMedico(Medico m) throws CampoEmBrancoException {
        if (m == null) {
            throw new CampoEmBrancoException("médico");
        }
        verificarCamposEmBranco(m);
        Medico[] temp = new Medico[numMedicos + 1];
        for (int i = 0; i < medicos.length; i++) {
            temp[i] = medicos[i];
        }
        temp[temp.length - 1] = m;
        medicos = temp;
        numMedicos++;
        return numMedicos;
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

        Medico medico = pesquisarMedico(m.getCrm());
        if (medico == null) {
            return false;
        }

        Medico[] temp = new Medico[numMedicos - 1];
        int j = 0;
        for (int i = 0; i < numMedicos; i++) {
            if (medicos[i] != medico) {
                temp[j] = medicos[i];
                j++;
            }
        }
        medicos = temp;
        numMedicos--;
        return true;
    }

    // Método para atualizar médicos
    public boolean atualizarMedico(String crm, Medico m) throws CampoEmBrancoException {
        if (m == null) {
            throw new CampoEmBrancoException("médico");
        }
        verificarCamposEmBranco(m);
        int i;
        for (i = 0; i < medicos.length; i++) {
            if (medicos[i].getCrm().equalsIgnoreCase(crm)) {
                break;
            }
        }
        if (i >= numMedicos) {
            return false;
        } else {
            medicos[i] = m;
        }
        return true;
    }

    // Método para verificar campos em branco
    private void verificarCamposEmBranco(Medico m) throws CampoEmBrancoException {
        if (m.getNome() == null || m.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("nome");
        }
        if (m.getCpf() == null || m.getCpf().trim().isEmpty()) {
            throw new CampoEmBrancoException("CPF");
        }
        if (m.getCrm() == null || m.getCrm().trim().isEmpty()) {
            throw new CampoEmBrancoException("CRM");
        }
        if (m.getEspec() == null || m.getEspec().trim().isEmpty()) {
            throw new CampoEmBrancoException("especialização");
        }
    }

    // Método para interação com o usuário
    public void cadastrarMedicoInterface() {
        try {
            String nome = JOptionPane.showInputDialog("Informe o nome do médico:");
            String cpf = JOptionPane.showInputDialog("Informe o CPF do médico:");
            String nasc = JOptionPane.showInputDialog("Informe a data de nascimento do médico (yyyy-mm-dd):");
            String crm = JOptionPane.showInputDialog("Informe o CRM do médico:");
            String espec = JOptionPane.showInputDialog("Informe a especialidade do médico:");

            Medico medico = new Medico(nome, cpf, LocalDate.parse(nasc), crm, espec);
            cadastrarMedico(medico);

            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!\n" + medico.toString());
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }
}