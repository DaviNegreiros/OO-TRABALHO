public class Exame{
    String tipo, resultado;
    LocalDate dataPrescricao, dataRealizacao;
    float valor;


    //Métodos
    Exame (String t, String r, LocalDate dP, LocalDate dR,float v){
        tipo = t;
        resultado = r;
        dataPrescricao = dP;
        dataRealizacao = dR;
        valor = v;
    }

    //Read
    String getTipo(){
        return tipo;
    }
    String getResultado(){
        return resultado;
    }
    LocalDate getDataPrescricao(){
        return dataPrescricao;
    }
    LocalDate getRealizacao(){
        return dataRealizacao;
    }
    float getValor(){
        return valor;
    }

    //Update
    void setTipo(String a){
        tipo = a;
    }
    void setResultado(String a){
        resultado = a;
    }
    void setDataPrescricao(LocalDate a){
        dataPrescricao = a;
    }
    void setDataRealizacao(LocalDate dataRealizacao){
        dataRealizacao = a;
    }
    void setValor(float a){
        valor = a; 
    }




}