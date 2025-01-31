package classes;

import java.time.LocalDate;
import exceptions.PagamentoPendenteException;

public class Paciente extends PessoaFisica{
    //nome cpf data hist
    boolean pagamentoPendente;
    //falta hist


    //Metódos 
    //Create
    Paciente(String nome,String cpf,LocalDate nasc){ //falta h
        super(nome, cpf, nasc);
        pagamentoPendente = false;
    }

    //Read
    boolean getPagamentoPendente(){
        return pagamentoPendente;
    }
    //getHist()


    //Update
    void setPagamentoPendente(boolean a){
        pagamentoPendente = a;
    }
    //setHist()

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"+
        "CPF: " + getCpf() + "\n" +
        "Data de Nascimento: " + getNasc() + " \n" 
        + "Pagamento Pendente: " + pagamentoPendente + "\n";
    }
    public void verificarPagamento() throws PagamentoPendenteException {
        if (pagamentoPendente) {
            throw new PagamentoPendenteException("O pagamento do paciente " + getNome() + " está pendente.");
        }
    }

    }



    







