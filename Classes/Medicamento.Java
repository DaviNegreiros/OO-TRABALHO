import java.time.LocalDate;


public class Medicamento{
    String nomeMed, uso;
    Date dataPrescricao;
    

    //Métodos
    Exame (String nM, String u, Date dP){
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
    Date getDataPrescricao(){
        return dataPrescricao;
    }

    //Write
    void setNomeMed(String a){
        nomeMEd = a;
    }
    void setUso(String a){
        uso = a;
    }
    void setDataPrescricao(Date a){
        dataPrescricao = a;
    }
    }