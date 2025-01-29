import java.time.LocalDate;


public class Paciente {
    //nome cpf data hist
    String nome, cpf;
    boolean pagamentoPendente;
    LocalDate nasc; //falta hist


    //Metódos 
    //Create
    Paciente(String n,String c,LocalDate d){ //falta h
        nome = n;
        cpf = c;
        nasc = d;
        pagamentoPendente = false;
    }

    //Read
    String getNome(){
        String nometxt = nome;
        return nometxt;

    }
    String getCpf(){

        String cpftxt = cpf;
        return cpftxt;

    }
    LocalDate getNasc(){
        LocalDate nasctxt = nasc;
        return nasctxt;
    }
    boolean getPagamentoPendente(){
        return pagamentoPendente;
    }
    //getHist()


    //Write
    void setNome(String a){
        nome = a;
    }
    void setCpf(String a){
        cpf = a;
    }
    void setNasc(LocalDate a){
        nasc = a;
    }
    void setPagamentoPendente(boolean a){
        pagamentoPendente = a;
    }
    //setHist()

    

    }



    







