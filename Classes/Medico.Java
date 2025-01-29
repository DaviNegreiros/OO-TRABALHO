import java.time.LocalDate;

public class Medico {
    //nome cpf data hist
    String nome, cpf, crm, espec;

    LocalDate nasc; //falta hist


    //Metódos 
    //Create
    Medico(String n,String c,LocalDate d,String cc,String e){ //falta h
        nome = n;
        cpf = c;
        nasc = d;
        //hist = h
        crm = cc;
        espec = e;
    }

    //Read
    String getNome(){
        return nome;

    }
    String getCpf(){

        return cpf;

    }
    String getEspec(){
        return espec;
    }
    String getCrm(){
        return crm;
    }
    LocalDate getNasc(){
        return nasc;
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
    void setEspec(String a){
        espec = a;
    }
    void setCrm(String a){
        crm = a;
    }
    //setHist()





}



    







