import java.time.LocalDate;

public class Medico extends PessoaFisica {
    //nome cpf data hist
    String crm, espec;

    //Metódos 
    //Create
    Medico(String nome,String cpf,LocalDate nasc,String crm,String espec){ //falta h
        //hist = h
        this.crm = crm;
        this.espec = espec;
    }

    //Read
    String getCrm(){
        return crm;
    }
    LocalDate getNasc(){
        return nasc;
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
    public void exibirDados() {
        super.exibirDados(); // Chama o método da classe pai
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + espec);
    }





}



    







