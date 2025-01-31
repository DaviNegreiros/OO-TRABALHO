package classes;
import java.time.LocalDate;
import exceptions.EspecialidadeInvalidaException;

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
        validarEspecialidade(espec);
        
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
        "CRM: " + crm + "\n"
        + "Especialidade: " + espec +"\n";
    }
    public void validarEspecialidade(String espec) throws EspecialidadeInvalidaException {
        String[] especialidadesValidas = {"Cardiologia", "Ortopedia", "Dermatologia", "Pediatria", "Neurologia"};
    
        boolean especialidadeValida = false;
        for (String especialidade : especialidadesValidas) {
            if (especialidade.equalsIgnoreCase(espec)) {
                especialidadeValida = true;
                break;
            }
        }
    
        if (!especialidadeValida) {
            throw new EspecialidadeInvalidaException("Especialidade inválida: " + espec);
        }
    


    }

}



    







