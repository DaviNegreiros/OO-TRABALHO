package classes;
import java.time.LocalDate;

public class Medico extends PessoaFisica {
    //nome cpf data hist
    String crm, espec;

    //Metódos 
    //Create
    public Medico(String nome,String cpf,LocalDate nasc,String crm,String espec){ //falta h
        super(nome, cpf, nasc);
        //hist = h
        this.crm = crm;
        this.espec = espec;
    }

    //Read
    String getCrm(){
        return crm;
    }
    String getEspec(){
        return espec;
    }

    //getHist()


    //Update
    void setEspec(String a){
        espec = a;
    }
    void setCrm(String a){
        crm = a;
    }
    //setHist()

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"+
        "CPF: " + getCpf() + "\n" +
        "Data de Nascimento: " + getNasc() + " \n" +
        "CRM: " + crm
        + "Especialidade: " + espec;
    }
    





}



    







