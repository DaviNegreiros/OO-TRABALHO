public class Exame{
    String tipo, resultado;
    Date dataPrescricao, dataRealizacao;
    float valor;


    //Métodos
    Exame (String t, String r, Date dP, Date dR,float v){
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
    Date getDataPrescricao(){
        return dataPrescricao;
    }
    Date getRealizacao(){
        return dataRealizacao;
    }
    float getValor(){
        return valor;
    }

    //Write
    void setTipo(String a){
        tipo = a;
    }
    void setResultado(String a){
        resultado = a;
    }
    void setDataPrescricao(Date a){
        dataPrescricao = a;
    }
    void setDataRealizacao(Date dataRealizacao){
        dataRealizacao = a;
    }
    void setValor(float a){
        valor = a; 
    }




}