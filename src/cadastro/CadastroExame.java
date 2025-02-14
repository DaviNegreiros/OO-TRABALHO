package cadastro;

import classes.*;
import exceptions.*;

public class CadastroExame {

    // Variáveis de instância
    private int numExames;
    private Exame[] exames;

    // Construtor
    public CadastroExame() {
        numExames = 0;
        exames = new Exame[0];
    }

    // Método para cadastrar um novo exame
    public int cadastrarExame(Exame e) throws CampoEmBrancoException {
        if (e == null) {
            throw new CampoEmBrancoException("exame");
        }
        verificarCamposEmBranco(e);
        
        // Aumenta o array dinamicamente
        Exame[] temp = new Exame[numExames + 1];
        for (int i = 0; i < exames.length; i++) {
            temp[i] = exames[i];
        }
        temp[temp.length - 1] = e;
        exames = temp;
        numExames++;
        return numExames;
    }

    // Método para pesquisar um exame pelo tipo
    public Exame pesquisarExame(String tipo) {
        for (Exame e : exames) {
            if (e.getTipo().equalsIgnoreCase(tipo)) {
                return e;
            }
        }
        return null;
    }

    // Método para remover um exame
    public boolean removerExame(Exame e) {
        if (e == null) {
            return false;
        }
        
        // Verifica se o exame existe
        Exame exame = pesquisarExame(e.getTipo());
        if (exame == null) {
            return false;
        }
        
        // Remove o exame e ajusta o array
        Exame[] temp = new Exame[numExames - 1];
        int j = 0;
        for (int i = 0; i < numExames; i++) {
            if (exames[i] != exame) {
                temp[j] = exames[i];
                j++;
            }
        }
        exames = temp;
        numExames--;
        return true;
    }

    // Método para atualizar um exame existente
    public boolean atualizarExame(String tipo, Exame e) throws CampoEmBrancoException {
        if (e == null) {
            throw new CampoEmBrancoException("exame");
        }
        verificarCamposEmBranco(e);
        
        // Busca pelo exame para atualização
        int i;
        for (i = 0; i < exames.length; i++) {
            if (exames[i].getTipo().equalsIgnoreCase(tipo)) {
                break;
            }
        }
        if (i >= numExames) {
            return false;
        } else {
            exames[i] = e;
        }
        return true;
    }

    // Método para verificar se os campos do exame estão preenchidos corretamente
    private void verificarCamposEmBranco(Exame e) throws CampoEmBrancoException {
        if (e.getTipo() == null || e.getTipo().trim().isEmpty()) {
            throw new CampoEmBrancoException("tipo");
        }
        if (e.getDataPrescricao() == null) {
            throw new CampoEmBrancoException("data de prescrição");
        }
        if (e.getRealizacao() == null) {
            throw new CampoEmBrancoException("data de realização");
        }
        if (e.getValor() <= 0) {
            throw new CampoEmBrancoException("valor");
        }
    }
}

