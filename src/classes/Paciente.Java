package classes;

import java.time.LocalDate;

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
    public void exibirDados() {
        super.exibirDados(); // Chama o método da classe pai
        System.out.println("Pagamento Pendente: " + pagamentoPendente);
    }
    

    }



    







