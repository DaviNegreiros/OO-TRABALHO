import java.time.LocalDate;


public class Paciente {
    //nome cpf data hist
    String nome, cpf;
    boolean pagamentoPendente;
    Date nasc; //falta hist


    //Metódos 
    //Create
    Paciente(String n,String c,Date d){ //falta h
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
    Date getNasc(){
        Date nasctxt = nasc;
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
    void setNasc(Date a){
        nasc = a;
    }
    void setPagamentoPendente(boolean a){
        pagamentoPendente = a;
    }
    //setHist()

    

    }



    







