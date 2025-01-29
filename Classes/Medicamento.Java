import java.time.LocalDate;


public class Medicamento{
    String nomeMed, uso;
    LocalDate dataPrescricao;
    

    //Métodos
    Exame (String nM, String u, LocalDate dP){
        nomeMed = nM;
        uso = u;
        dataPrescricao = dP;
    }

    //Read
    String getNomeMed(){
        return nomeMed;
    }
    String getUso(){
        return uso;
    }
    LocalDate getDataPrescricao(){
        return dataPrescricao;
    }

    //Update
    void setNomeMed(String a){
        nomeMEd = a;
    }
    void setUso(String a){
        uso = a;
    }
    void setDataPrescricao(LocalDate a){
        dataPrescricao = a;
    }
    }